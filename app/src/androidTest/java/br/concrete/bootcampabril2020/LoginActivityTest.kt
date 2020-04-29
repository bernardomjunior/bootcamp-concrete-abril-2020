package br.concrete.bootcampabril2020

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    //arange
    @get:Rule
    val activityTest = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun givenInitial_shouldShowEmailAndPasswordEmpty(){
        //action
        //assert
        Espresso.onView(
            withId(R.id.email)
        ).check(ViewAssertions.matches(withText("")))
        Espresso.onView(
            withId(R.id.password)
        ).check(ViewAssertions.matches(withText("")))
    }

}