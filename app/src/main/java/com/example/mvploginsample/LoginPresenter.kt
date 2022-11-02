package com.example.mvploginsample

class LoginPresenter constructor(private val view: LoginContract.ILoginView): LoginContract.ILoginPresenter{

    override fun login(id: String, pwd: String) {
        val loginRepository= LoginRepository()

        loginRepository.login(id, pwd, object : LoginRepository.LoginCallBack{
            override fun loginResult(isLoginSuccess: Boolean) {
                if (isLoginSuccess) {
                    view.onLoginSuccess("Success")
                }
                else {
                    view.onLoginFailed("Failed")
                }
            }
        })
    }
}