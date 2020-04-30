package br.concrete.bootcampabril2020

class PasswordValidator {

    private val regexList = listOf(
        Regex("\\d+"),
        Regex("[^a-z0-9]", RegexOption.IGNORE_CASE),
        Regex("[a-z]"),
        Regex("[A-Z]"),
        Regex(".{8,}")
    )

    fun validate(password: String): Boolean {
        regexList.forEach {
            if (!password.contains(it)) return false
        }

        if (password.isEmpty()) return false

        return true
    }

}