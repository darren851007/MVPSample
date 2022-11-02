package com.example.mvploginsample

interface LoginContract {
    interface ILoginPresenter {
        fun login(id: String, pwd: String)
    }

    interface ILoginView {
        fun onLoginSuccess(msg: String)
        fun onLoginFailed(msg: String)
    }
}