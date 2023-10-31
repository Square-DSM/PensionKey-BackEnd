package com.example.pensionkeybackend.domain.feed.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object NotValidUserException : GlobalException(GlobalErrorCode.NOT_VALID_USER)