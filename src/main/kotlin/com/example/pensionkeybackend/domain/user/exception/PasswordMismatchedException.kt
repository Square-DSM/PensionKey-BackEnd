package com.example.pensionkeybackend.domain.user.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object PasswordMismatchedException: GlobalException(GlobalErrorCode.PASSWORD_MISMATCH)