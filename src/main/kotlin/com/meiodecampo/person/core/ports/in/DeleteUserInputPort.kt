package com.meiodecampo.person.core.ports.`in`

import reactor.core.publisher.Mono
import java.util.*

interface DeleteUserInputPort {
    fun delete(id: UUID): Mono<Void>
}