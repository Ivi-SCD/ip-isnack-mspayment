package br.com.ip.isnack.payments.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_ms_payment", sequenceName = "seq_isnack_payment", allocationSize = 1)
    @Column(name = "payment_id")
    private Long id;

    @NotNull
    @Positive
    @Column(name = "payment_value")
    private BigDecimal value;

    @NotBlank
    @Size(max = 100)
    @Column(name = "payment_name")
    private String name;

    @NotBlank
    @Size(max = 19)
    @Column(name = "payment_number")
    private String number;

    @NotBlank
    @Size(max = 7)
    private String expiration;

    @NotBlank
    @Size(min=3, max=3)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;

}
