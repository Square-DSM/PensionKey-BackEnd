package com.example.pensionkeybackend.domain.feed.facade

import com.example.pensionkeybackend.domain.feed.domain.Feed
import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.exception.FeedNotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import java.util.*

@RequiredArgsConstructor
@Component
class FeedFacade(
    private val feedRepository: FeedRepository
) {

    fun getFeedById(feedId: UUID): Feed {
        return feedRepository.findById(feedId).orElseThrow {FeedNotFoundException}
    }

    fun existByFeedId(feedId: UUID): Boolean {
        return feedRepository.existsById(feedId)
    }
}