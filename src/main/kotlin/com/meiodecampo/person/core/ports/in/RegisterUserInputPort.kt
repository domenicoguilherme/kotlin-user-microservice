package com.meiodecampo.person.core.ports.`in`

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.domain.models.request.UserRegisterRequest
import reactor.core.publisher.Mono

interface RegisterUserInputPort {
    fun register(userRegisterRequest: UserRegisterRequest): Mono<User>
}