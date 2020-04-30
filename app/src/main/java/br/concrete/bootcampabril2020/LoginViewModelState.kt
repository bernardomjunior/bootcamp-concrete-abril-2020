package br.concrete.bootcampabril2020

sealed class LoginViewModelState {
    data class Error(val stringId: Int) : LoginViewModelState()
    object NavigateToHome : LoginViewModelState()
}
