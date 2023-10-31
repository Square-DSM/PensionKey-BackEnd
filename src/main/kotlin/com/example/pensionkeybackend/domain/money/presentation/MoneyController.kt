package com.example.pensionkeybackend.domain.money.presentation

import com.example.pensionkeybackend.domain.money.presentation.dto.HouseElement
import com.example.pensionkeybackend.domain.money.presentation.dto.IndividualElement
import com.example.pensionkeybackend.domain.money.presentation.dto.PensionElement
import com.example.pensionkeybackend.domain.money.service.QueryHouseListService
import com.example.pensionkeybackend.domain.money.service.QueryIndividualListService
import com.example.pensionkeybackend.domain.money.service.QueryPensionListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/money")
@RestController
class MoneyController(
    private val queryHouseListService: QueryHouseListService,
    private val queryIndividualListService: QueryIndividualListService,
    private val queryPensionListService: QueryPensionListService,
) {
    @GetMapping("/house")
    fun getHouseList(): List<HouseElement> = queryHouseListService.execute()

    @GetMapping("/individual")
    fun getIndividualList(): List<IndividualElement> = queryIndividualListService.execute()

    @GetMapping("/pension")
    fun getPensionList(): List<PensionElement> = queryPensionListService.execute()
}