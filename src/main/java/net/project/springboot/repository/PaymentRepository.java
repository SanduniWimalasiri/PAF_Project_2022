package net.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.project.springboot.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository< Payment, Long> {

}
