package com.mkr.base_oc.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mkr.base_oc.http.HttpConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object  ApiHelper {
    private var api: ApiServices? = null

    fun api(): ApiServices? {
        if (api == null)
            initApi()
        return api
    }

    /**
     * 初始化api
     */
    fun initApi() {
        // Header
        val headerInter = Interceptor { chain ->
            val builder = chain.request()
                .newBuilder()
            chain.proceed(builder.build())
        }

        val mOkHttpClient = OkHttpClient()
            .newBuilder()
            .readTimeout(HttpConfig.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(HttpConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(HttpConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(headerInter)
            .addInterceptor(LoggingInterceptor())
            .build()
        //网络接口配置
        api = null
        api = Retrofit.Builder()
            .baseUrl(HttpConfig.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())       //添加字符串的转换器
            .addConverterFactory(GsonConverterFactory.create())          //添加gson的转换器
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())   //添加协程的请求适配器            .client(mOkHttpClient)
            .client(mOkHttpClient)
            .build()
            .create(ApiServices::class.java)
    }
}