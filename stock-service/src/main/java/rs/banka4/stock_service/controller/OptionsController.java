package rs.banka4.stock_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import rs.banka4.rafeisen.common.security.AuthenticatedBankUserAuthentication;
import rs.banka4.stock_service.domain.options.dtos.BuyOptionRequestDto;
import rs.banka4.stock_service.domain.options.dtos.UseOptionRequest;
import rs.banka4.stock_service.service.abstraction.OptionService;

import java.util.UUID;

@RestController
@RequestMapping("/options")
@RequiredArgsConstructor
public class OptionsController {
    private final OptionService optionService;

    @GetMapping("/buy")
    public void buyOption (@RequestBody BuyOptionRequestDto buyOptionRequestDto, Authentication auth){
        UUID userId = ((AuthenticatedBankUserAuthentication) auth).getPrincipal().userId();
        optionService.buyOption(buyOptionRequestDto.optionId(), userId, buyOptionRequestDto.accountNumber(), buyOptionRequestDto.amount());
    }

    @GetMapping("/use")
    public void useOption (@RequestBody UseOptionRequest useOptionRequest, Authentication auth){
        UUID userId = ((AuthenticatedBankUserAuthentication) auth).getPrincipal().userId();
        optionService.useOption(useOptionRequest.optionId(), userId, useOptionRequest.accountNumber());
    }
}
