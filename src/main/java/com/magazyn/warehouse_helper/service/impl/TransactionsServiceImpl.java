package com.magazyn.warehouse_helper.service.impl;

import com.magazyn.warehouse_helper.Exception.ResourceNotFoundException;
import com.magazyn.warehouse_helper.model.Transactions;
import com.magazyn.warehouse_helper.repository.TransactionsRepository;
import com.magazyn.warehouse_helper.service.TransactionsService;
import org.junit.internal.Checks;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionsServiceImpl implements TransactionsService {

 private TransactionsRepository transactionsRepository;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public Transactions saveTransaction(Transactions transactions ) {


        return transactionsRepository.save(transactions);
    }
    // lista wszystkich  Transactions w całej apce
    @Override
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }
    // jedna Transaction po id
    @Override
    public Transactions getTransactionById(Long id) {

//      List <Transactions> transactionsById = transactionsRepository.findAll().stream().filter((transactions)->transactions.getUserGroupId() == idUserGroup)
//              .filter((transactions)->transactions.getId()==id)
//              .collect(Collectors.toList());
//
//         Optional<Transactions> existingTransactions =  transactionsById.stream().findFirst();
//
//        return existingTransactions;
      return   transactionsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Transaction","id", id ) );
    }
    // usuwanie Transactions
    @Override
    public void deleteTransaction(Long id) {
        transactionsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction","id", id ));
        transactionsRepository.deleteById(id);
    }

    // aktualizacja Transaction
    @Override
    public Transactions updateTransactions(Transactions transactions, Long id) {
        Transactions existingTransaction = transactionsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Transaction","id", id ));
       existingTransaction.setNameBuyer(transactions.getNameBuyer());
       existingTransaction.setProductsList(transactions.getProductsList());
       existingTransaction.setPrice(transactions.getPrice());
       existingTransaction.setUserGroupId(transactions.getUserGroupId());
       existingTransaction.setUserId(transactions.getUserId());
       existingTransaction.setNote(transactions.getNote());
       transactionsRepository.save(existingTransaction);

        return existingTransaction;
    }


}
