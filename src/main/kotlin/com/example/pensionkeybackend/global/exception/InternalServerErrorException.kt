package com.example.pensionkeybackend.global.exception

import com.example.pensionkeybackend.global.error.GlobalException
import com.example.pensionkeybackend.global.error.GlobalErrorCode

object InternalServerErrorException : GlobalException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)