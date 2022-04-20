package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.domain.models.request.UserRegisterRequest
import com.meiodecampo.person.core.ports.`in`.RegisterUserInputPort
import com.meiodecampo.person.core.ports.out.RegisterUserOutputPort
import reactor.core.publisher.Mono
import java.util.*

class RegisterUserUseCase(private val saveUserOutputPort: RegisterUserOutputPort): RegisterUserInputPort {
    override fun register(request: UserRegisterRequest): Mono<User> {
        val user = User(
            UUID.randomUUID(),
            request.firstName,
            request.lastName,
            request.nickname,
            request.document
        )

        return saveUserOutputPort.save(user)
    }
}