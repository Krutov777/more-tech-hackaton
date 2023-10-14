package com.moretech.controllers

import com.api.ApiApi
import com.model.AtmInfoResponseDto
import com.model.DepartmentInfoResponseDto
import com.model.FilterDto
import com.model.FilterListDto
import com.model.ObjectsInfoResponseDto
import com.moretech.controllers.mappers.AtmDtoMapper
import com.moretech.controllers.mappers.DepartmentInfoDtoMapper
import com.moretech.controllers.mappers.FilterListDtoMapper
import com.moretech.entities.Atm
import com.moretech.entities.Department
import com.moretech.services.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val atmService: AtmService,
    private val serviceService: ServiceService,
    private val departmentService: DepartmentService,
    private val objectsFilterService: ObjectsFilterService,
    private val clientTypeService: ClientTypeService,
    private val departmentTypeService: DepartmentTypeService
) : ApiApi {
    override fun apiV1AtmsAtmIdGet(atmId: Long): ResponseEntity<AtmInfoResponseDto> {
        return ResponseEntity(
            atmService.getAtmById(atmId),
            HttpStatus.OK
        )
    }

    override fun apiV1DepartmentsDepartmentIdGet(departmentId: Long): ResponseEntity<DepartmentInfoResponseDto> {
        return ResponseEntity(
            departmentService.getDepartmentById(departmentId),
            HttpStatus.OK
        )
    }

    override fun apiV1FilterClientsGet(): ResponseEntity<List<FilterListDto>> {
        return ResponseEntity(
            FilterListDtoMapper.mapClientTypeEntityToFilterListDto(clientTypeService.findAllClientTypes()),
            HttpStatus.OK
        )
    }

    override fun apiV1FilterOfficesGet(): ResponseEntity<List<FilterListDto>> {
        return ResponseEntity(
            FilterListDtoMapper.mapDepartmentTypeEntityToFilterListDto(departmentTypeService.findAllDepartmentTypes()),
            HttpStatus.OK
        )
    }

    override fun apiV1FilterServicesGet(): ResponseEntity<List<FilterListDto>> {
        return ResponseEntity(
            FilterListDtoMapper.mapServiceEntityToFilterListDto(serviceService.findAllServices()),
            HttpStatus.OK
        )
    }

    override fun apiV1ListPost(filterDto: FilterDto): ResponseEntity<ObjectsInfoResponseDto> {
        val atms: List<Atm> = objectsFilterService.findAtmsBy(filterDto)
        val departments: List<Department> = objectsFilterService.findDepartmentsBy(filterDto)

        return ResponseEntity(
            ObjectsInfoResponseDto()
                .atms(atms.map { AtmDtoMapper.mapAtmToAtmDto(it) })
                .departments(departments.map {
                    DepartmentInfoDtoMapper.mapDepartmentEntityToDepartmentInfoDto(
                        it,
                        listOf(),
                        listOf(),
                        listOf()
                    )
                }),
            HttpStatus.OK
        )
    }
}