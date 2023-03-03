package com.magazyn.warehouse_helper.repository;

import com.magazyn.warehouse_helper.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> { }
