package com.example.pensionkeybackend.domain.feed.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object FeedNotFoundException: GlobalException(GlobalErrorCode.FEED_NOT_FOUND)