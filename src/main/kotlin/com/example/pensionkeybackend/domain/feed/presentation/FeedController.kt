package com.example.pensionkeybackend.domain.feed.presentation

import com.example.pensionkeybackend.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.pensionkeybackend.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.FeedElement
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedDetailsResponse
import com.example.pensionkeybackend.domain.feed.presentation.dto.response.QueryFeedListResponse
import com.example.pensionkeybackend.domain.feed.service.CreateFeedService
import com.example.pensionkeybackend.domain.feed.service.DeleteFeedService
import com.example.pensionkeybackend.domain.feed.service.QueryFeedDetailsService
import com.example.pensionkeybackend.domain.feed.service.QueryFeedListService
import com.example.pensionkeybackend.domain.feed.service.QueryMyFeedListService
import com.example.pensionkeybackend.domain.feed.service.UpdateFeedService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
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

@Tag(name = "게시글")
@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val queryFeedDetailsService: QueryFeedDetailsService,
    private val queryFeedListService: QueryFeedListService,
    private val deleteFeedService: DeleteFeedService,
    private val updateFeedService: UpdateFeedService,
    private val queryMyFeedListService: QueryMyFeedListService,
) {

    @Operation(summary = "작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @Operation(summary = "상세조회")
    @GetMapping("/{feed_id}")
    fun getFeedDetails(@PathVariable(name = "feed_id") feedId: UUID) : QueryFeedDetailsResponse {
        return queryFeedDetailsService.execute(feedId)
    }

    @Operation(summary = "리스트")
    @GetMapping("/list")
    fun getFeedList(): QueryFeedListResponse {
        return queryFeedListService.execute()
    }

    @Operation(summary = "삭제")
    @DeleteMapping("/delete/{feed_id}")
    fun deleteFeed(@PathVariable(name = "feed_id") feedId: UUID) {
        deleteFeedService.execute(feedId)
    }

    @Operation(summary = "수정")
    @PatchMapping("/update/{feed_id}")
    fun updateFeed(@PathVariable(name = "feed_id") feedId: UUID, request: UpdateFeedRequest) =
        updateFeedService.updateFeed(feedId, request)

    @Operation(summary = "내 게시글 조회")
    @GetMapping
    fun getMyFeedList(): QueryFeedListResponse = queryMyFeedListService.execute()
}