package br.concrete.bootcampabril2020

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitial_shouldShowEmailAndPasswordEmpty(){
        loginAssert{
            checkIsEmpty(R.id.email)
            checkIsEmpty(R.id.password)
        }
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError(){
        loginAct{
            type("!@34Dc08", R.id.password)
            click(R.id.login)
        }
        loginAssert{
            checkMessageShown("E-mail is empty")
        }
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowEmptyPasswordError(){
        loginAct{
            type("daivid.v.leal@concrete.com.br", R.id.email)
            click(R.id.login)
        }
        loginAssert{
            checkMessageShown("Password is empty")
        }
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowPasswordIsInvalidError(){
        loginAct{
            type("daivid.v.leal@concrete.com.br", R.id.email)
            type("!@348", R.id.password)
            click(R.id.login)
        }
        loginAssert{
            checkMessageShown("Password is invalid")
        }
    }

    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomeActivity(){
        loginArrange{
            mockHomeActivityIntent()
        }
        loginAct{
            type("daivid.v.leal@concrete.com.br", R.id.email)
            type("!@34DDcc8", R.id.password)
            click(R.id.login)
        }
        loginAssert{
            checkActivityWasCalled(HomeActivity::class.java.name)
        }
    }

}