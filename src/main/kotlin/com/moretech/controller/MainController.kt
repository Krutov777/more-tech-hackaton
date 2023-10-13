package com.moretech.controller

import com.api.ApiApi
import com.model.AtmInfoResponseDto
import com.model.CoordinateDto
import com.model.DepartmentInfoResponseDto
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

    override fun apiV1ObjectsGet(
        leftTopCoordinate: CoordinateDto,
        rightBottomCoordinate: CoordinateDto
    ): ResponseEntity<ObjectsInfoResponseDto> {
        return super.apiV1ObjectsGet(leftTopCoordinate, rightBottomCoordinate)
    }
}