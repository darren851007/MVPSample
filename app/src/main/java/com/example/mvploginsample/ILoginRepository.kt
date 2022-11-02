package com.example.mvploginsample

interface ILoginRepository {
    fun login(loginId: String, password: String, listener:LoginRepository.LoginCallBack)
}