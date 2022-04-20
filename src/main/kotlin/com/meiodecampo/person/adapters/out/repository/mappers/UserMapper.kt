package com.meiodecampo.person.adapters.out.repository.mappers

import com.meiodecampo.person.adapters.out.repository.entities.UserEntity
import com.meiodecampo.person.core.domain.models.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toUserEntity(user: User) = UserEntity(
        id = user.id,
        firstName = user.firstName,
        document = user.document,
        lastName = user.lastName,
        nickname = user.nickname,
    )

    fun toUser(userEntity: UserEntity) = User(
        id = userEntity.id,
        firstName = userEntity.firstName,
        document = userEntity.document,
        lastName = userEntity.lastName,
        nickname = userEntity.nickname,
    )
}