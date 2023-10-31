package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.exception.NotValidUserException
import com.example.pensionkeybackend.domain.feed.facade.FeedFacade
import com.example.pensionkeybackend.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UpdateFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun updateFeed(feedId: UUID, request: UpdateFeedRequest) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeedById(feedId)

        val matchWriterUser = !(user.id.equals(feed.user.id))
        if(matchWriterUser) throw NotValidUserException

        feed.updateFeed(request.title, request.content)
    }
}