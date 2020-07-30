package com.mkr.login_oc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.mkr.base_oc.config.ARouterPaths

/**
 * 上传头像
 */
@Route(path = ARouterPaths.UploadAvatarActivity)
class UploadAvatarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_avatar)

    }
}