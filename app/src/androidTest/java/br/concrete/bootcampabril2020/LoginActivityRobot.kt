package br.concrete.bootcampabril2020

import android.app.Activity
import android.app.Instrumentation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers

class loginArrange(action: loginArrange.() -> Unit){

    init {
        action.invoke(this)
    }

    fun mockHomeActivityIntent(){
        Intents.intending(IntentMatchers.hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }

}

class loginAct(action: loginAct.() -> Unit){

    init {
        action.invoke(this)
    }

    fun type(text: String, id: Int){
        Espresso.onView(
            ViewMatchers.withId(id)
        ).perform(
            ViewActions.typeText(
                text)
        )
    }

    fun click(id: Int){
        Espresso.onView(
            ViewMatchers.withId(id)
        ).perform(ViewActions.click())
    }

}

class loginAssert(action: loginAssert.() -> Unit){

    init {
        action.invoke(this)
    }

    fun checkIsEmpty(id: Int){
        Espresso.onView(
            ViewMatchers.withId(id)
        ).check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkMessageShown(text: String){
        Espresso.onView(ViewMatchers.withText(text)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    fun checkActivityWasCalled(activityName: String){
        intended(hasComponent(activityName))
    }

}