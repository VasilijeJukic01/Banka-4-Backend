package rs.banka4.user_service.domain.exchange.dtos;

import rs.banka4.user_service.domain.currency.db.Currency;

import java.util.Map;

public record ExchangeRateDto(
        String lastUpdatedISO8061withTimezone,
        long lastUpdatedUnix,
        String nextUpdateISO8061withTimezone,
        long nextUpdateUnix,
        long lastLocalUpdate,
        Map<Currency.Code, ExchangeRate>exchanges
) {
}
