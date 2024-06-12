package org.example.testendmodule4.repository;

import org.example.testendmodule4.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.temporal.ChronoUnit;
@Repository
public interface ICustomersRepository extends JpaRepository<Customers, Long> {
}
