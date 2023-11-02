package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.exception.NotDeleteFeedException
import com.example.pensionkeybackend.domain.feed.facade.FeedFacade
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(feedId: UUID) {
        val userId = userFacade.getCurrentUser()
        val feed = feedFacade.getFeedById(feedId)

        if(userId != feed.user) throw NotDeleteFeedException

        feedRepository.deleteById(feed.id)
    }
}