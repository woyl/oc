package com.mkr.base_oc.config

/**
 * @Author Novan
 * @create 2020/7/28 11:05
 * @desc: 路由路径
 */
class ARouterPaths {

    companion object {  //==java static

        /**
         * login register
         */
        //登录
        const val loginActivity = "/login_oc/login/loginActivity"      //const == java public
        //输入验证码
        const val inputVerificationCodeActivity = "/login_oc/login/inputCode"
        //注册上传头像
        const val UploadAvatarActivity = "/login_oc/register/UploadAvatarActivity"
        //设置用户资料
        const val SetUpUserInfoActivity = "/login_oc/register/SetUpUserInfoActivity"

        //app home
        const val home = "/home/oc"
        const val dynamic = "/dynamic/oc"
        const val message = "/message/oc"
        const val mine = "/mine/oc"

    }
}