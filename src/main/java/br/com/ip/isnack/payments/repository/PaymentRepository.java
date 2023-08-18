package br.com.ip.isnack.payments.repository;

import br.com.ip.isnack.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
