package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field:NotEmpty(message = "Invalid ")  val firstName: String,
    @field:NotEmpty(message = "Invalid ")  val lastName: String,
    @field:NotEmpty(message = "Invalid ")  val income: BigDecimal,
    @field:NotEmpty(message = "Invalid ")  val zipCode: String,
    @field:NotEmpty(message = "Invalid ") val street: String
){
    fun toEntity(customer: Customer):Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income =  this.income
        customer.adress.street = this.street
        customer.adress.zipCode = this.zipCode
        return customer
    }

}
