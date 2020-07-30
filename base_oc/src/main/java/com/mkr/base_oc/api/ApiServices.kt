package com.mkr.base_oc.api

import com.mkr.base_oc.bean.login.LoginBean
import retrofit2.http.GET
import retrofit2.http.Query
import com.mkr.base_oc.bean.Result
import kotlinx.coroutines.Deferred

interface ApiServices {
    /**
     * 用户登录
     */
    @GET("login?key=00d91e8e0cca2b76f515926a36db68f5")
    fun requestLoginOut(@Query("phone") phone: String,
                        @Query("passwd") passwd: String): Deferred<Result<LoginBean>>
}