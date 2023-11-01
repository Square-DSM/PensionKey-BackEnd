package com.example.pensionkeybackend.domain.money.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object PensionNotFoundException: GlobalException(GlobalErrorCode.PENSION_NOT_FOUND)