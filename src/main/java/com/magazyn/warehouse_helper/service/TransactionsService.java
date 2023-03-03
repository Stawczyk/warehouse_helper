package com.magazyn.warehouse_helper.service;

import com.magazyn.warehouse_helper.model.Transactions;

import java.util.List;
import java.util.Optional;

public interface TransactionsService {

   Transactions saveTransaction(Transactions transactions);

    List<Transactions> getAllTransactions ();

    Transactions getTransactionById (Long id);

  void deleteTransaction(Long id);

 Transactions updateTransactions (Transactions transactions, Long id);
}
