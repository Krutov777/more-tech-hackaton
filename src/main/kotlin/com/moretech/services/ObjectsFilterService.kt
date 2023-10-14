package com.moretech.services

import com.model.CoordinateDto
import com.model.FilterDto
import com.moretech.entities.Atm
import com.moretech.entities.Department
import com.moretech.repositories.AtmRepository
import com.moretech.repositories.ClientTypeDepartmentRepository
import com.moretech.repositories.DepartmentRepository
import com.moretech.repositories.ServiceAtmRepository
import com.moretech.repositories.ServiceDepartmentRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.cos

@Service
class ObjectsFilterService(
    private val serviceAtmRepository: ServiceAtmRepository,
    private val serviceDepartmentRepository: ServiceDepartmentRepository,
    private val clientTypeDepartmentRepository: ClientTypeDepartmentRepository,
    private val departmentRepository: DepartmentRepository,
    private val atmRepository: AtmRepository

) {
    private val OFFSET: Long = 75
    private val ONE_LATITUDE_IN_DEGREE: Double = 111.111
    private val LATITUDE: BigDecimal = BigDecimal(OFFSET / ONE_LATITUDE_IN_DEGREE)
        .setScale(6, RoundingMode.UP)

    fun findAtmsBy(filterDto: FilterDto): List<Atm> {
        // если выбирается тип отделения, то ничего не возвращаем, так как ищем только по департаментам
        if (filterDto.hasRamp == true ||
            filterDto.clientTypes != null && filterDto.clientTypes.isNotEmpty() ||
            filterDto.officeTypes != null && filterDto.officeTypes.isNotEmpty()
        ) {
            return listOf()
        }

        // проставить все координаты для определения границ, если они не стоят
        enrichFilterWithCoordinates(filterDto)

        // найти ИД только тех банкоматов, у которых есть все переданные сервисы
        if (filterDto.services != null && filterDto.services.isNotEmpty()) {
            val atmIds: Set<Long> =
                serviceAtmRepository.findAtmIdsBy(filterDto.services, filterDto.services.size.toLong())

            if (atmIds.isEmpty()) {
                return listOf()
            }

            return atmRepository.findByAtmIdsAndCoordinates(
                atmIds.toList(),
                filterDto.leftTopCoordinate.latitude,
                filterDto.rightBottomCoordinate.latitude,
                filterDto.leftTopCoordinate.longitude,
                filterDto.rightBottomCoordinate.longitude
            )
        }

        // найти только все банкоматы по ИД и по координатам
        return atmRepository.findByCoordinates(
            filterDto.leftTopCoordinate.latitude,
            filterDto.rightBottomCoordinate.latitude,
            filterDto.leftTopCoordinate.longitude,
            filterDto.rightBottomCoordinate.longitude
        )
    }

    fun findDepartmentsBy(filterDto: FilterDto): List<Department> {
        enrichFilterWithCoordinates(filterDto)

        // найти ИД только тех департаментов, у которых есть все переданные сервисы
        val departmentIdsWithServices: Set<Long> =
            if (filterDto.services != null && filterDto.services.isNotEmpty()) {
                val ids = serviceDepartmentRepository.findDepartmentIdsBy(filterDto.services, filterDto.services.size.toLong())
                ids.ifEmpty { return listOf() }
            } else {
                setOf()
            }

        // найти ИД только тех департаментов, у которых есть нужные типы клиентов
        val departmentIdsWithClients: Set<Long> =
            if (filterDto.clientTypes != null && filterDto.clientTypes.isNotEmpty()) {
                val ids = clientTypeDepartmentRepository.findDepartmentIdsBy(filterDto.clientTypes, filterDto.clientTypes.size.toLong())
                ids.ifEmpty { return listOf() }
            } else {
                setOf()
            }

        // найти ИД только тех департаментов, у которых есть нужные типы департаментов


        val depIds: Set<Long> =
            if (departmentIdsWithServices.isEmpty() || departmentIdsWithClients.isEmpty()) {
                departmentIdsWithServices.union(departmentIdsWithClients)
            } else {
                val ids = departmentIdsWithServices.intersect(departmentIdsWithClients)
                ids.ifEmpty { return listOf() }
            }


        // найти только все департаменты по ИД и по координатам
        return if (depIds.isNotEmpty()) {
            departmentRepository.findByDepartmentIdsAndCoordinates(
                depIds.toList(),
                filterDto.leftTopCoordinate.latitude,
                filterDto.rightBottomCoordinate.latitude,
                filterDto.leftTopCoordinate.longitude,
                filterDto.rightBottomCoordinate.longitude
            )
        } else {
            departmentRepository.findByCoordinates(
                filterDto.leftTopCoordinate.latitude,
                filterDto.rightBottomCoordinate.latitude,
                filterDto.leftTopCoordinate.longitude,
                filterDto.rightBottomCoordinate.longitude
            )
        }
    }

    fun enrichFilterWithCoordinates(filterDto: FilterDto) {
        if (filterDto.leftTopCoordinate == null) {
            // заполняем координату широты для Севера
            val topLatitude: BigDecimal = (filterDto.curUserCoordinate.latitude + LATITUDE)

            // заполняем координату широты для Востока
            val degreePerKm =
                1 / (111.32 * cos(topLatitude.toDouble() * Math.PI / 180)) // коэффициент перевода км в градусы для долготы
            val degrees = OFFSET * degreePerKm // перевод км в градусы для долготы
            val leftLongitude: BigDecimal = (filterDto.curUserCoordinate.longitude + degrees.toBigDecimal())
                .setScale(6, RoundingMode.UP)

            filterDto.leftTopCoordinate = CoordinateDto()
                .latitude(topLatitude)
                .longitude(leftLongitude)
        }

        if (filterDto.rightBottomCoordinate == null) {
            // заполняем координату широты для Юга
            val bottomLatitude: BigDecimal = (filterDto.curUserCoordinate.latitude - LATITUDE)

            // заполняем координату широты для Запада
            val degreePerKm =
                1 / (111.32 * cos(bottomLatitude.toDouble() * Math.PI / 180)) // коэффициент перевода км в градусы для долготы
            val degrees = OFFSET * degreePerKm // перевод км в градусы для долготы
            val rightLongitude: BigDecimal = (filterDto.curUserCoordinate.longitude - degrees.toBigDecimal())
                .setScale(6, RoundingMode.UP)

            filterDto.rightBottomCoordinate = CoordinateDto()
                .latitude(bottomLatitude)
                .longitude(rightLongitude)
        }
    }
}