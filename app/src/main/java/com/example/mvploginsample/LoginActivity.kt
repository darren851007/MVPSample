package com.example.mvploginsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.core.content.getSystemService
import com.example.mvploginsample.databinding.LoginActivityBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), LoginContract.ILoginView{

    private lateinit var presenter: LoginContract.ILoginPresenter
    private lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter(this)

        binding.loginButton.setOnClickListener {
            presenter.login(binding.loginId.text.toString(), binding.password.text.toString())
            //關鍵盤
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.loginButton.windowToken, 0)
        }

    }

    override fun onLoginSuccess(msg: String) {
        Snackbar.make(binding.layoutView, msg, Snackbar.LENGTH_LONG).show()

    }

    override fun onLoginFailed(msg: String) {
        Snackbar.make(binding.layoutView, msg, Snackbar.LENGTH_LONG).show()
    }


}