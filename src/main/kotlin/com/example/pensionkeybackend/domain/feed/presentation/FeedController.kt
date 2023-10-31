package com.example.pensionkeybackend.domain.feed.presentation

import com.example.pensionkeybackend.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.pensionkeybackend.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedElement
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedDetailsResponse
import com.example.pensionkeybackend.domain.feed.service.CreateFeedService
import com.example.pensionkeybackend.domain.feed.service.DeleteFeedService
import com.example.pensionkeybackend.domain.feed.service.QueryFeedDetailsService
import com.example.pensionkeybackend.domain.feed.service.QueryFeedListService
import com.example.pensionkeybackend.domain.feed.service.UpdateFeedService
import com.example.pensionkeybackend.domain.user.presentation.dto.QueryUserInfoResponse
import com.example.pensionkeybackend.domain.user.service.QueryUserInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val queryFeedDetailsService: QueryFeedDetailsService,
    private val queryFeedListService: QueryFeedListService,
    private val deleteFeedService: DeleteFeedService,
    private val queryUserInfoService: QueryUserInfoService,
    private val updateFeedService: UpdateFeedService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @GetMapping("/{feed_id}")
    fun getFeedDetails(@PathVariable(name = "feed_id") feedId: UUID) : QueryFeedDetailsResponse {
        return queryFeedDetailsService.execute(feedId)
    }

    @GetMapping("/list")
    fun getFeedList(): List<FeedElement> {
        return queryFeedListService.execute()
    }

    @DeleteMapping("/delete/{feed_id}")
    fun deleteFeed(@PathVariable(name = "feed_id") feedId: UUID) {
        deleteFeedService.execute(feedId)
    }

    @PatchMapping("/update/{feed_id}")
    fun updateFeed(@PathVariable(name = "feed_id") feedId: UUID, request: UpdateFeedRequest) =
        updateFeedService.updateFeed(feedId, request)
}