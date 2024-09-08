package com.workintech.s18d4_part.dto;

public record AccountResponse(long id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}
