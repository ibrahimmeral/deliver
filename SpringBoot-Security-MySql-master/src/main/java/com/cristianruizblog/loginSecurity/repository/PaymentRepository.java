package com.cristianruizblog.loginSecurity.repository;

import com.cristianruizblog.loginSecurity.entity.Payment;
import com.cristianruizblog.loginSecurity.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
