package br.concrete.bootcampabril2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(PasswordValidator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel.getViewState().observe(this, {
            when (it) {
                is LoginViewModelState.Error -> showError(it.stringId)
                is LoginViewModelState.NavigateToHome -> navigateToHome()
            }
        })

        login.setOnClickListener {
            if (email.text.isEmpty()) {
                showError(R.string.email_empty)
            } else {
                loginViewModel.validateLogin(
                    email.text.toString(),
                    password.text.toString()
                )
            }
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    private fun showError(@StringRes error: Int) {
        AlertDialog.Builder(this)
            .setMessage(error)
            .show()
    }
}
