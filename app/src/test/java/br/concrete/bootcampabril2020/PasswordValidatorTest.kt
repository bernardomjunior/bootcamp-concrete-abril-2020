package br.concrete.bootcampabril2020

import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class PasswordValidatorTest {

    lateinit var passwordValidator: PasswordValidator

    @Before
    fun setUp() {
        //arrange
        passwordValidator = PasswordValidator()
    }

    @Test
    fun givenPasswordWithShorterThanEight_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("!Aa123b")
        //assert
        Assert.assertFalse(result)
    }


    @Test
    fun givenPasswordWithoutUpperLetter_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("!ad123b8")
        //assert
        Assert.assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutLowLetter_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("!AA123B9")
        //assert
        Assert.assertFalse(result)
    }


    @Test
    fun givenPasswordWithoutNumber_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("!AAAAAsad")
        //assert
        Assert.assertFalse(result)
    }

    @Test
    fun givenPasswordWithoutSpecialChar_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("AAAbc1234")
        //assert
        Assert.assertFalse(result)
    }

    @Test
    fun givenEmptyPassword_whenValidate_shouldReturnFalse() {
        //act
        val result = passwordValidator.validate("")
        //assert
        Assert.assertFalse(result)
    }

    @Test
    fun givenCorrectPassword_whenValidate_shouldReturnTrue() {
        //act
        val result = passwordValidator.validate("!Av1234y")
        //assert
        Assert.assertTrue(result)
    }
}