package com.moretech.repositories

import com.moretech.entities.Atm
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface AtmRepository : JpaRepository<Atm, Long> {
    @Query(
        "SELECT a " +
            "FROM Atm a " +
            "WHERE a.id IN :ids " +
            "   AND a.latitude >= :bottomLatitude " +
            "   AND a.latitude <=  :topLatitude " +
            "   AND a.longitude >= :leftLongitude " +
            "   AND a.longitude <= :rightLongitude"
    )
    fun findByAtmIdsAndCoordinates(
        @Param("ids") ids: List<Long>,
        @Param("topLatitude") topLatitude: BigDecimal,
        @Param("bottomLatitude") bottomLatitude: BigDecimal,
        @Param("leftLongitude") leftLongitude: BigDecimal,
        @Param("rightLongitude") rightLongitude: BigDecimal
    ): List<Atm>

    @Query(
        "SELECT a " +
            "FROM Atm a " +
            "WHERE a.latitude >= :bottomLatitude " +
            "   AND a.latitude <=  :topLatitude " +
            "   AND a.longitude >= :leftLongitude " +
            "   AND a.longitude <= :rightLongitude"
    )
    fun findByCoordinates(
        @Param("topLatitude") topLatitude: BigDecimal,
        @Param("bottomLatitude") bottomLatitude: BigDecimal,
        @Param("leftLongitude") leftLongitude: BigDecimal,
        @Param("rightLongitude") rightLongitude: BigDecimal
    ): List<Atm>
}