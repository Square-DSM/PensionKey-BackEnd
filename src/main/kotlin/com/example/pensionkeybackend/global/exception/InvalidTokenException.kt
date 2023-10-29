package com.example.pensionkeybackend.global.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object InvalidTokenException: GlobalException(GlobalErrorCode.INVALID_TOKEN)