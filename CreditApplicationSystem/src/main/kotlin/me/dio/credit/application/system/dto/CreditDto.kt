package me.dio.credit.application.system.dto


import me.dio.credit.application.system.entity.Credit
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
){
    fun toEntity(): Credit= Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments



    )

}
