package com.meiodecampo.person.core.domain.configuration

import com.meiodecampo.person.core.ports.`in`.DeleteUserInputPort
import com.meiodecampo.person.core.ports.`in`.FindUserByDocumentInputPort
import com.meiodecampo.person.core.ports.`in`.FindUsersInputPort
import com.meiodecampo.person.core.ports.`in`.RegisterUserInputPort
import com.meiodecampo.person.core.ports.out.DeleteUserOutputPort
import com.meiodecampo.person.core.ports.out.FindUserByDocumentOutputPort
import com.meiodecampo.person.core.ports.out.FindUsersOutputPort
import com.meiodecampo.person.core.ports.out.RegisterUserOutputPort
import com.meiodecampo.person.core.usecases.DeleteUserUseCase
import com.meiodecampo.person.core.usecases.FindUserByDocumentUseCase
import com.meiodecampo.person.core.usecases.FindUsersUseCase
import com.meiodecampo.person.core.usecases.RegisterUserUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreInjection {
    @Bean
    fun registerUser(saveUserOutputPort: RegisterUserOutputPort): RegisterUserInputPort {
        return RegisterUserUseCase(saveUserOutputPort);
    }

    @Bean
    fun findUserByDocument(findUserByDocumentOutputPort: FindUserByDocumentOutputPort): FindUserByDocumentInputPort {
        return FindUserByDocumentUseCase(findUserByDocumentOutputPort)
    }

    @Bean
    fun findUsers(findUsersOutputPort: FindUsersOutputPort): FindUsersInputPort {
        return FindUsersUseCase(findUsersOutputPort)
    }

    @Bean
    fun deleteUser(deleteUserOutputPort: DeleteUserOutputPort): DeleteUserInputPort {
        return DeleteUserUseCase(deleteUserOutputPort)
    }
}