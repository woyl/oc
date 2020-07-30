package com.mkr.base_oc.mvp

import com.mkr.base_oc.utils.EmptyUtils
import kotlinx.coroutines.*
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import com.mkr.base_oc.bean.Result

abstract  class KotlinPresenter<V :BaseMvpView> :BaseMvpPresenter<V>() {
    private val presenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    /**
     * 当页面被销户时协程要取消
     */
    @ExperimentalCoroutinesApi
    override fun detachView() {
        presenterScope.cancel()
    }

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        presenterScope.launch { block() }
    }

    suspend fun <T> launchIO(block: suspend CoroutineScope.() -> T) {
        withContext(Dispatchers.IO) {
            block
        }
    }

    fun launch(tryBlock: suspend CoroutineScope.() -> Unit) {
        launchOnUI {
            tryCatch(tryBlock, {}, {})
        }
    }

    fun launchWithTryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        launchOnUI {
            tryCatch(tryBlock, catchBlock, finallyBlock)
        }
    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                catchBlock(e.message)
            } finally {
                finallyBlock()
            }
        }
    }

    /**
     * 网络请求
     *
     */
    fun <T> launchRequest(
        tryBlock: suspend CoroutineScope.() -> Result<T>?,
        successBlock: suspend CoroutineScope.(T?) -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    )
    {
        launchOnUI {
            requestTryCatch(tryBlock, successBlock, catchBlock, finallyBlock)
        }
    }


    private suspend fun <T> requestTryCatch(
        tryBlock: suspend CoroutineScope.() -> Result<T>?,
        successBlock: suspend CoroutineScope.(T?) -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                val response = tryBlock()
                callResponse(
                    response,
                    {
                        successBlock(response?.getData())
                    },
                    {
                        catchBlock(response?.getMessage())
                    }
                )
            } catch (e: Throwable) {
                var errMsg = ""
                errMsg = when (e) {
                    is UnknownHostException -> {
                        "No network..."
                    }
                    is SocketTimeoutException -> {
                        "Request timeout..."
                    }
                    is NumberFormatException -> {
                        "Request failed, type conversion exception"
                    }
                    else ->
                        e.message.toString()
                }
                catchBlock(errMsg)
            } finally {
                finallyBlock()
            }
        }
    }

    /**
     * 主要用于处理返回的response是否请求成功
     */
    private suspend fun <T> callResponse(
        response: Result<T>?,
        successBlock: suspend CoroutineScope.() -> Unit,
        errorBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            when {
                response == null || EmptyUtils.isEmpty(response) -> errorBlock()
                response.code == 200 -> successBlock()
                else -> errorBlock()
            }
        }
    }
}