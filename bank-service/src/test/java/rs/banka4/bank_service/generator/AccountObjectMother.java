package rs.banka4.bank_service.generator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.UUID;
import rs.banka4.bank_service.domain.account.db.Account;
import rs.banka4.bank_service.domain.account.db.AccountType;
import rs.banka4.bank_service.domain.account.dtos.*;
import rs.banka4.bank_service.domain.company.dtos.CompanyDto;
import rs.banka4.bank_service.domain.user.client.dtos.ClientDto;
import rs.banka4.bank_service.domain.user.employee.dtos.EmployeeDto;
import rs.banka4.rafeisen.common.currency.CurrencyCode;
import rs.banka4.rafeisen.common.dto.Gender;
import rs.banka4.rafeisen.common.security.Privilege;

public class AccountObjectMother {

    public static CreateAccountDto generateBasicCreateAccountDto() {
        return new CreateAccountDto(
            new AccountClientIdDto(
                UUID.randomUUID(),
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                Gender.MALE,
                "john.doe@example.com",
                "+381690123456",
                "123 Grove Street, City, Country",
                EnumSet.noneOf(Privilege.class)
            ),
            null,
            BigDecimal.valueOf(1000.00),
            CurrencyCode.RSD,
            false
        );
    }

    public static CreateAccountDto generateBusinessAccount() {
        return new CreateAccountDto(
            new AccountClientIdDto(
                UUID.randomUUID(),
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                Gender.MALE,
                "john.doe@example.com",
                "+381690123450",
                "123 Grove Street, City, Country",
                EnumSet.noneOf(Privilege.class)
            ),
            new CompanyDto(
                "1231313131213123312",
                "Test Plumbing",
                "12312312",
                "12312313",
                "testAdresss",
                "testACode"
            ),
            BigDecimal.ZERO,
            CurrencyCode.EUR,
            false
        );
    }

    public static AccountDto generateBasicAccountDto() {
        return new AccountDto(
            UUID.randomUUID()
                .toString(),
            "444394438340549",
            BigDecimal.valueOf(1000.00),
            BigDecimal.valueOf(800.00),
            BigDecimal.valueOf(100.00),
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2028, 1, 1),
            true,
            AccountTypeDto.CheckingPersonal,
            BigDecimal.valueOf(100.00),
            BigDecimal.valueOf(1000.00),
            new CurrencyDto(CurrencyCode.RSD),
            new EmployeeDto(
                UUID.randomUUID(),
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                Gender.MALE,
                "mehmedalija.doe@example.com",
                "+381689012345",
                "123 Main St",
                "Mahd",
                "Developer",
                "IT",
                true
            ),
            new ClientDto(
                UUID.randomUUID(),
                "Jane",
                "Doe",
                LocalDate.of(1990, 1, 1),
                Gender.FEMALE,
                "jane.doe@example.com",
                "+381678901234",
                "123 Main St",
                EnumSet.noneOf(Privilege.class),
                false
            ),
            null
        );
    }

    public static Account generateBasicFromAccount() {
        Account account = new Account();
        account.setAccountNumber("444394438340549");
        account.setBalance(BigDecimal.valueOf(10000.00));
        account.setAvailableBalance(BigDecimal.valueOf(8000.00));
        account.setActive(true);
        account.setAccountType(AccountType.STANDARD);
        account.setDailyLimit(BigDecimal.valueOf(1000.00));
        account.setMonthlyLimit(BigDecimal.valueOf(10000.00));
        account.setCurrency(CurrencyCode.RSD);
        account.setEmployee(EmployeeObjectMother.generateBasicEmployee());
        account.setClient(
            ClientObjectMother.generateClient(
                UUID.fromString("9df5e618-f21d-48a7-a7a4-ac55ea8bec97"),
                "markezaa@example.com"
            )
        );
        return account;
    }

    public static Account generateBasicEURFromAccount() {
        Account account = new Account();
        account.setAccountNumber("444394438340549");
        account.setBalance(BigDecimal.valueOf(10000.00));
        account.setAvailableBalance(BigDecimal.valueOf(8000.00));
        account.setActive(true);
        account.setAccountType(AccountType.STANDARD);
        account.setDailyLimit(BigDecimal.valueOf(1000.00));
        account.setMonthlyLimit(BigDecimal.valueOf(10000.00));
        account.setCurrency(CurrencyCode.EUR);
        account.setEmployee(EmployeeObjectMother.generateBasicEmployee());
        account.setClient(
            ClientObjectMother.generateClient(
                UUID.fromString("9df5e618-f21d-48a7-a7a4-ac55ea8bec97"),
                "markezaa@example.com"
            )
        );
        return account;
    }

    public static Account generateBasicToAccount() {
        Account account = new Account();
        account.setAccountNumber("444394438340523");
        account.setBalance(BigDecimal.valueOf(10000.00));
        account.setAvailableBalance(BigDecimal.valueOf(8000.00));
        account.setActive(true);
        account.setAccountType(AccountType.STANDARD);
        account.setDailyLimit(BigDecimal.valueOf(1000.00));
        account.setMonthlyLimit(BigDecimal.valueOf(10000.00));
        account.setCurrency(CurrencyCode.RSD);
        account.setEmployee(EmployeeObjectMother.generateBasicEmployee());
        account.setClient(
            ClientObjectMother.generateClient(
                UUID.fromString("9df5e618-f21d-48a7-a7a4-ac55ea8bec93"),
                "zorz@example.com"
            )
        );
        return account;
    }

}
