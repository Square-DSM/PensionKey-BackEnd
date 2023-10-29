package com.example.pensionkeybackend.domain.feed.domain.repository

import com.example.pensionkeybackend.domain.feed.domain.Feed
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface FeedRepository : CrudRepository<Feed, UUID>