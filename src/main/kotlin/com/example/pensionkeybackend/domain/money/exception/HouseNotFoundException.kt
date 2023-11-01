package com.example.pensionkeybackend.domain.money.exception

import com.example.pensionkeybackend.global.error.GlobalErrorCode
import com.example.pensionkeybackend.global.error.GlobalException

object HouseNotFoundException: GlobalException(GlobalErrorCode.HOUSE_NOT_FOUND)