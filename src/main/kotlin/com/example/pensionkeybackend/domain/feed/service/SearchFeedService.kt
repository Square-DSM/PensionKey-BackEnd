package com.example.pensionkeybackend.domain.feed.service

import com.example.pensionkeybackend.domain.comment.domain.repository.CommentRepository
import com.example.pensionkeybackend.domain.feed.domain.SearchWord
import com.example.pensionkeybackend.domain.feed.domain.repository.FeedRepository
import com.example.pensionkeybackend.domain.feed.domain.repository.SearchWordRepository
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedVo
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedListResponse
import com.example.pensionkeybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchFeedService(
    private val feedRepository: FeedRepository,
    private val commentRepository: CommentRepository,
    private val searchWordRepository: SearchWordRepository,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(keyword: String): QueryFeedListResponse {
        val user = userFacade.getCurrentUser()
        val feedList = feedRepository.findAllByTitleContaining(keyword)

        if(!searchWordRepository.existsByKeywordContains(keyword)) {
            searchWordRepository.save(SearchWord(keyword,user))
        }
        
        return QueryFeedListResponse(feedList.map {
            FeedVo(
                id = it.id,
                title = it.title,
                createdAt = it.createdAt,
                commentCount = commentRepository.countCommentByFeedId(it.id),
                userAccountId = it.userAccountId
            )
        }
        )
    }
}