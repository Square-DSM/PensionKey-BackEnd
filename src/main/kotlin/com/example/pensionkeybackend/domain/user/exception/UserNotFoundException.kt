package com.example.pensionkeybackend.domain.user.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object UserNotFoundException: GlobalException(GlobalErrorCode.USER_NOT_FOUND)