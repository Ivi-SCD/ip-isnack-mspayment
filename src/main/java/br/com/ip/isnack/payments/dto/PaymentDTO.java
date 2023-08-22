package br.com.ip.isnack.payments.dto;

import br.com.ip.isnack.payments.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    @NotNull @Positive
    private BigDecimal value;
    @NotBlank
    private String name;
    @NotBlank
    private String number;
    @NotBlank
    private String expiration;
    @NotBlank
    private String code;
    private Status status;
    @NotNull
    private Long orderId;
    @NotNull
    private Long paymentMethodId;
}
