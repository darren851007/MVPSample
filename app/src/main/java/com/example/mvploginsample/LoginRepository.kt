package com.example.mvploginsample

import android.os.Handler
import android.os.Looper


class LoginRepository : ILoginRepository {

    interface LoginCallBack {
        fun loginResult(isLoginSuccess : Boolean)
    }

    override fun login(loginId: String, password: String, listener: LoginCallBack) {
        // 模擬1.5秒後回傳結果
        Handler(Looper.getMainLooper()).postDelayed({
            if (loginId == "abc" && password == "123") {
                listener.loginResult(true)
            } else {
                listener.loginResult(false)
            }
        }, 1500)
    }


}