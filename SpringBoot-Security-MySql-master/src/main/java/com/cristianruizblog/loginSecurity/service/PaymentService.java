package com.cristianruizblog.loginSecurity.service;

import com.cristianruizblog.loginSecurity.entity.Payment;
import com.cristianruizblog.loginSecurity.entity.State;
import com.cristianruizblog.loginSecurity.repository.PaymentRepository;
import com.cristianruizblog.loginSecurity.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;


    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id).orElse(null);
    }
    public Payment saveOrUpdate(Payment payment){
        return paymentRepository.save(payment);
    }
}
