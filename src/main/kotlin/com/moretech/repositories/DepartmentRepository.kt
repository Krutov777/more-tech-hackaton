package com.moretech.repositories

import com.moretech.entities.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {

    @Query(
        "SELECT d " +
            "FROM Department d " +
            "WHERE d.id IN :ids " +
            "   AND d.latitude >= :bottomLatitude " +
            "   AND d.latitude <=  :topLatitude " +
            "   AND d.longitude >= :leftLongitude " +
            "   AND d.longitude <= :rightLongitude"
    )
    fun findByDepartmentIdsAndCoordinates(
        @Param("ids") ids: List<Long>,
        @Param("topLatitude") topLatitude: BigDecimal,
        @Param("bottomLatitude") bottomLatitude: BigDecimal,
        @Param("leftLongitude") leftLongitude: BigDecimal,
        @Param("rightLongitude") rightLongitude: BigDecimal
    ): List<Department>

    @Query(
        "SELECT d " +
            "FROM Department d " +
            "WHERE d.latitude >= :bottomLatitude " +
            "   AND d.latitude <=  :topLatitude " +
            "   AND d.longitude >= :leftLongitude " +
            "   AND d.longitude <= :rightLongitude"
    )
    fun findByCoordinates(
        @Param("topLatitude") topLatitude: BigDecimal,
        @Param("bottomLatitude") bottomLatitude: BigDecimal,
        @Param("leftLongitude") leftLongitude: BigDecimal,
        @Param("rightLongitude") rightLongitude: BigDecimal
    ): List<Department>

}