package me.dio.credit.application.system.service.repository

import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CreditRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month
import java.util.UUID

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditRepositoryTest {
    @Autowired lateinit var creditRepository: CreditRepository
    @Autowired lateinit var testEntityManager: TestEntityManager

    private lateinit var customer: Customer
    private lateinit var credit1: Credit
    private lateinit var credit2: Credit


    @BeforeEach fun setup(){
        customer = testEntityManager.persist(buildCustomer())
        credit1 = testEntityManager.persist(buildCredit(customer = customer))
        credit2 = testEntityManager.persist(buildCredit(customer = customer))

    }
    @Test
    fun `should find credit by credit code`(){
        val creditCode1 = UUID.fromString("aa547c0f-9a6a-451f-8c89-afddce916a29")
        val creditCode2 = UUID.fromString("49f740be-46a7-449b-84e7-ff5b7986d7ef")
        credit1.creditCode = creditCode1
        credit2.creditCode = creditCode2

        val fakeCredit1: Credit = creditRepository.findByCreditCode(creditCode1)!!
        val fakeCredit2: Credit = creditRepository.findByCreditCode(creditCode2)!!

        Assertions.assertThat(fakeCredit1).isNotNull
        Assertions.assertThat(fakeCredit2).isNotNull
        Assertions.assertThat(fakeCredit1).isSameAs(credit1)
        Assertions.assertThat(fakeCredit2).isSameAs(credit2)


    }

}

private fun buildCredit(
    creditValue: BigDecimal = BigDecimal.valueOf(500),
    dayFirstInstallment: LocalDate = LocalDate.of(2023,Month.APRIL,22),
    numberOfStallmentes: Int = 10,
    customer: Customer
): Credit = Credit(
    creditValue = creditValue,
    dayFirstInstallment = dayFirstInstallment,
    numberOfInstallments = numberOfStallmentes,
    customer = customer
)
private fun buildCustomer(
    firstName: String = "Augusto",
    lastName: String = "Guimarães",
    cpf: String = "1234478923",
    email: String ="augusto15guimaraes@gmail.com",
    password :String = "12345",
    zipCode: String = "12345",
    street : String = "rua Augusto",
    income : BigDecimal = BigDecimal.valueOf(1000.0),
    id : Long = 1L,

    ) = Customer(
    firstName = firstName,
    lastName = lastName,
    cpf = cpf,
    email = email,
    password = password,
    address = Address(
        zipCode = zipCode,
        street = street),
    income = income,
    id = id

)