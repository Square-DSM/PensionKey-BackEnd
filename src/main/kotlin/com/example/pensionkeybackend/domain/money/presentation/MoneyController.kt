package com.example.pensionkeybackend.domain.money.presentation

import com.example.pensionkeybackend.domain.money.presentation.dto.HouseElement
import com.example.pensionkeybackend.domain.money.presentation.dto.IndividualElement
import com.example.pensionkeybackend.domain.money.presentation.dto.PensionElement
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryHouseDetailsResponse
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryIndividualDetailsResponse
import com.example.pensionkeybackend.domain.money.presentation.dto.QueryPensionDetailsResponse
import com.example.pensionkeybackend.domain.money.service.QueryHouseDetailsService
import com.example.pensionkeybackend.domain.money.service.QueryHouseListService
import com.example.pensionkeybackend.domain.money.service.QueryIndividualDetailsService
import com.example.pensionkeybackend.domain.money.service.QueryIndividualListService
import com.example.pensionkeybackend.domain.money.service.QueryPensionDetailsService
import com.example.pensionkeybackend.domain.money.service.QueryPensionListService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "연금")
@RequestMapping("/money")
@RestController
class MoneyController(
    private val queryHouseListService: QueryHouseListService,
    private val queryIndividualListService: QueryIndividualListService,
    private val queryPensionListService: QueryPensionListService,
    private val queryPensionDetailsService: QueryPensionDetailsService,
    private val queryHouseDetailsService: QueryHouseDetailsService,
    private val queryIndividualDetailsService: QueryIndividualDetailsService
) {

    @Operation(summary = "주택 연금 리스트")
    @GetMapping("/house")
    fun getHouseList(): List<HouseElement> = queryHouseListService.execute()

    @Operation(summary = "개인 연금 리스트")
    @GetMapping("/individual")
    fun getIndividualList(): List<IndividualElement> = queryIndividualListService.execute()

    @Operation(summary = "국민 연금 리스트")
    @GetMapping("/pension")
    fun getPensionList(): List<PensionElement> = queryPensionListService.execute()

    @Operation(summary = "국민 연금 상세조회")
    @GetMapping("/detail")
    fun getPensionDetails(): QueryPensionDetailsResponse = queryPensionDetailsService.execute()

    @Operation(summary = "주택 연금 상세 조회")
    @GetMapping("/house/{house-id}")
    fun getHouseDetail(@PathVariable("house-id") houseId: UUID): QueryHouseDetailsResponse =
        queryHouseDetailsService.execute(houseId)

    @Operation(summary = "개인 연금 상세 조회")
    @GetMapping("/individual/{individual-id}")
    fun getIndividualDetail(@PathVariable("individual-id") individualId: UUID): QueryIndividualDetailsResponse =
        queryIndividualDetailsService.execute(individualId)
}