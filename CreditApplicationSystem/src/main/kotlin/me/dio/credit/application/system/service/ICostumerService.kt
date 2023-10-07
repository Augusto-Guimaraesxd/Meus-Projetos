package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Customer

interface ICostumerService {

    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}