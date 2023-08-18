package br.com.ip.isnack.payments.dto;

import br.com.ip.isnack.payments.model.Status;

import java.math.BigDecimal;

public record PaymentDTO(
    Long id,
    BigDecimal value,
    String name,
    String number,
    String expiration,
    String code,
    Status status,
    Long orderId,
    Long paymentMethodId
) {
}
