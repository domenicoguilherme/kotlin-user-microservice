package com.meiodecampo.person.adapters.`in`.api

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.domain.models.request.UserRegisterRequest
import com.meiodecampo.person.core.ports.`in`.DeleteUserInputPort
import com.meiodecampo.person.core.ports.`in`.FindUserByDocumentInputPort
import com.meiodecampo.person.core.ports.`in`.FindUsersInputPort
import com.meiodecampo.person.core.ports.`in`.RegisterUserInputPort
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(
    private val findUsersInputPort: FindUsersInputPort,
    private val deleteUserInputPort: DeleteUserInputPort,
    private val registerUserInputPort: RegisterUserInputPort,
    private val findUserByDocumentInputPort: FindUserByDocumentInputPort
) {
    @GetMapping
    fun getAll() = findUsersInputPort.get()

    @GetMapping("/{document}")
    fun getByDocument(@PathVariable document: String) = findUserByDocumentInputPort.get(document)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) = deleteUserInputPort.delete(id)

    @PostMapping
    fun register(@RequestBody @Validated userRegisterRequest: UserRegisterRequest): Mono<ResponseEntity<User>> {
        val user = registerUserInputPort.register(userRegisterRequest)

        return user
            .map{ResponseEntity.ok(it)}
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}