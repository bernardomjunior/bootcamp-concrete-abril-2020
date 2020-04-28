package br.concrete.bootcampabril2020

import org.junit.Assert
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun givenPasswordWithLength7_whenValidate_shouldReturnErrorLength(){
        //arrange
        val passwordValidator = PasswordValidator()
        //act
        val result = passwordValidator.validate("1234 ")
        //assert
        Assert.assertFalse(result)
    }

}