package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.Feed
import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {
        val user = userFacade.getCurrentUser()

        feedRepository.save(
            Feed(
                title = request.title,
                content = request.content,
                createdAt = LocalDate.now(),
                user = user,
                userAccountId = user.accountId,
            )
        )
    }
}