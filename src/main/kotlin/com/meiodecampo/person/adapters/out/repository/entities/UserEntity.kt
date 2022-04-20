package com.meiodecampo.person.adapters.out.repository.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document
class UserEntity(
    @Id
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val document: String)