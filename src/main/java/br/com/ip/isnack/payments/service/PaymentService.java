package br.com.ip.isnack.payments.service;

import br.com.ip.isnack.payments.dto.PaymentDTO;
import br.com.ip.isnack.payments.model.Payment;
import br.com.ip.isnack.payments.model.Status;
import br.com.ip.isnack.payments.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentDTO> getAll(Pageable pagination) {
        return paymentRepository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, PaymentDTO.class));
    }

    public PaymentDTO getById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO requestPayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setStatus(Status.REQUESTED);
        paymentRepository.save(payment);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setId(id);
        payment = paymentRepository.save(payment);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
