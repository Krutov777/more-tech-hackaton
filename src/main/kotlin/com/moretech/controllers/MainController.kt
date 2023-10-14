package com.moretech.controllers

import com.api.ApiApi
import com.model.AtmInfoResponseDto
import com.model.DepartmentInfoResponseDto
import com.model.FilterDto
import com.model.FilterListDto
import com.model.ObjectsInfoResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController : ApiApi {
    override fun apiV1AtmsAtmIdGet(atmId: Long): ResponseEntity<AtmInfoResponseDto> {
        return super.apiV1AtmsAtmIdGet(atmId)
    }

    override fun apiV1DepartmentsDepartmentIdGet(departmentId: Long): ResponseEntity<DepartmentInfoResponseDto> {
        return super.apiV1DepartmentsDepartmentIdGet(departmentId)
    }

    override fun apiV1ListPost(filterDto: FilterDto): ResponseEntity<ObjectsInfoResponseDto> {
        return super.apiV1ListPost(filterDto)
    }

    override fun apiV1FilterClientsGet(): ResponseEntity<MutableList<FilterListDto>> {
        return super.apiV1FilterClientsGet()
    }

    override fun apiV1FilterOfficesGet(): ResponseEntity<MutableList<FilterListDto>> {
        return super.apiV1FilterOfficesGet()
    }

    override fun apiV1FilterServicesGet(): ResponseEntity<MutableList<FilterListDto>> {
        return super.apiV1FilterServicesGet()
    }
}