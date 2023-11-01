package com.example.pensionkeybackend.domain.money.presentation

import com.example.pensionkeybackend.domain.money.presentation.dto.HouseElement
import com.example.pensionkeybackend.domain.money.presentation.dto.IndividualElement
import com.example.pensionkeybackend.domain.money.presentation.dto.PensionElement
import com.example.pensionkeybackend.domain.money.service.QueryHouseListService
import com.example.pensionkeybackend.domain.money.service.QueryIndividualListService
import com.example.pensionkeybackend.domain.money.service.QueryPensionListService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "연금")
@RequestMapping("/money")
@RestController
class MoneyController(
    private val queryHouseListService: QueryHouseListService,
    private val queryIndividualListService: QueryIndividualListService,
    private val queryPensionListService: QueryPensionListService,
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
}