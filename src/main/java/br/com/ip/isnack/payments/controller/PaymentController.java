package br.com.ip.isnack.payments.controller;

import br.com.ip.isnack.payments.dto.PaymentDTO;
import br.com.ip.isnack.payments.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping
    public Page<PaymentDTO> listAllPayments(@PageableDefault(size = 10)Pageable pagination) {
        return paymentService.getAll(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable @NotNull Long id) {
        PaymentDTO paymentDTO = paymentService.getById(id);

        return ResponseEntity.ok(paymentDTO);
    }

    @PostMapping
   public ResponseEntity<PaymentDTO> registerPayment(@RequestBody @Valid PaymentDTO paymentDTO, UriComponentsBuilder uriComponentsBuilder) {
        PaymentDTO payment = paymentService.requestPayment(paymentDTO);

        URI address = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(payment.id()).toUri();

        return ResponseEntity.created(address).body(payment);
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable @NotNull Long id, @RequestBody @Valid PaymentDTO paymentDTO) {
        PaymentDTO paymentUpdated = paymentService.updatePayment(id, paymentDTO);

        return ResponseEntity.ok(paymentUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PaymentDTO> deletePayment(@PathVariable @NotNull Long id) {
        paymentService.deletePayment(id);

        return ResponseEntity.noContent().build();
    }
}
