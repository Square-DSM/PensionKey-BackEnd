package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.repository.SearchWordRepository
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.SearchKeyElement
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuerySearchWordService(
    private val searchWordRepository: SearchWordRepository,
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(): List<SearchKeyElement> {
        val user = userFacade.getCurrentUser()
        return searchWordRepository.findAllByUser(user)
    }
}