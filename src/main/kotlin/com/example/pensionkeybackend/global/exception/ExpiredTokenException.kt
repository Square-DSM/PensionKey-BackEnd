package com.example.pensionkeybackend.global.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object ExpiredTokenException: GlobalException(GlobalErrorCode.EXPIRED_TOKEN)