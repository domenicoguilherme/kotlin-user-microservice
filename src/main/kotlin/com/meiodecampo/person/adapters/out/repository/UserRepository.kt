package com.meiodecampo.person.adapters.out.repository

import com.meiodecampo.person.adapters.out.repository.mappers.UserMapper
import com.meiodecampo.person.adapters.out.repository.mongoRepository.UserMongoRepository
import com.meiodecampo.person.core.domain.models.User
import com.meiodecampo.person.core.ports.out.DeleteUserOutputPort
import com.meiodecampo.person.core.ports.out.FindUserByDocumentOutputPort
import com.meiodecampo.person.core.ports.out.FindUsersOutputPort
import com.meiodecampo.person.core.ports.out.RegisterUserOutputPort
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository(
    private val userMongoRepository: UserMongoRepository,
    private val userMapper: UserMapper):
        RegisterUserOutputPort,
        FindUsersOutputPort,
        FindUserByDocumentOutputPort,
        DeleteUserOutputPort
{
    override fun get() = userMongoRepository.findAll()
        .map { userMapper.toUser(it) }

    override fun getByDocument(document: String) = userMongoRepository.getByDocument(document)
        .map { user -> userMapper.toUser(user) }

    override fun save(user: User) = userMongoRepository.insert(userMapper.toUserEntity(user))
        .map { user -> userMapper.toUser(user) }

    override fun delete(id: UUID) = userMongoRepository.deleteById(id)
}