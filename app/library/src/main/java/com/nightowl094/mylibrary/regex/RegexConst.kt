package com.nightowl094.mylibrary.regex

object RegexConst {

    const val EMAIL_REGEX = """[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}"""
    fun checkEmailValid(email: CharSequence) =
        Regex(pattern = EMAIL_REGEX).containsMatchIn(email)

    // 숫자, 영문 대소문자, 특수문자 !@#$%^&*() 8자이상 가능
    const val PASSWORD_REGEX = """^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#${'$'}%^&*()])[A-Za-z\d!@#${'$'}%^&*()]{8,}${'$'}"""
    fun checkPwRegex(pw: String) =
        Regex(pattern = PASSWORD_REGEX).containsMatchIn(pw)
}