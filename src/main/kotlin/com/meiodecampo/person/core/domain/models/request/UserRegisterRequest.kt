package com.meiodecampo.person.core.domain.models.request

import java.time.LocalDate

class UserRegisterRequest(
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val document: String
)