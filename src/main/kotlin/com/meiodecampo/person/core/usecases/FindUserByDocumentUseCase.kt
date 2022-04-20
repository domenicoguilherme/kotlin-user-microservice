package com.meiodecampo.person.core.usecases

import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.`in`.FindUserByDocumentInputPort
import com.meiodecampo.person.core.ports.out.FindUserByDocumentOutputPort
import reactor.core.publisher.Mono

class FindUserByDocumentUseCase(private val findUserByDocumentOutputPort: FindUserByDocumentOutputPort): FindUserByDocumentInputPort {
    override fun get(document: String): Mono<User> {
        return findUserByDocumentOutputPort.getByDocument(document)
    }
}