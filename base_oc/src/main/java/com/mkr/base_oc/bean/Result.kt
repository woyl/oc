package com.mkr.base_oc.bean

class Result <T> {
    /**
    * code : 200
    * message :
    * data : {"status":"open"}
    */

    var code: Int = 0
    var msg: String? = null
    private var data: T? = null


    fun getMessage(): String? {
        return msg
    }

    fun setMessage(message: String) {
        this.msg = message
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

}