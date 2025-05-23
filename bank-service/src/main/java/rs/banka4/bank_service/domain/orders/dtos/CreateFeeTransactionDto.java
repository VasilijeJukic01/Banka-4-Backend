package rs.banka4.bank_service.domain.orders.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import rs.banka4.rafeisen.common.currency.CurrencyCode;

public record CreateFeeTransactionDto(
    @Schema(
        description = "User ID",
        example = "1fad2c01-f82f-41a6-822c-8ca1b3232575"
    ) String userId,
    @Schema(
        description = "From account number",
        example = "11111111-2222-3333-4444-555555555555"
    ) String fromAccount,
    @Schema(
        description = "From amount",
        example = "100.00"
    ) BigDecimal fromAmount,
    @Schema(
        description = "Currency code",
        example = "RSD"
    ) CurrencyCode currencyCode
) {
}
