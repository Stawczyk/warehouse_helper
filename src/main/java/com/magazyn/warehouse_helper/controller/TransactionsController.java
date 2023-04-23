package com.magazyn.warehouse_helper.controller;

import com.magazyn.warehouse_helper.model.Transactions;
import com.magazyn.warehouse_helper.service.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionsController {
   private TransactionsService transactionsService;

// REST API to save transaction
    @PostMapping
    public ResponseEntity<Transactions> saveTransaction(@RequestBody Transactions transactions){
        return new ResponseEntity(transactionsService.saveTransaction(transactions), HttpStatus.CREATED);
    }

// REST API that take all transactions in app

    @GetMapping
    public List<Transactions> getAllTransactions(){
        return transactionsService.getAllTransactions();
    }

// REST API that take one transaction by ID

    @GetMapping("{id}")
public ResponseEntity<Transactions> getTransactionById (@PathVariable ("id") long id){
        return new ResponseEntity<>(transactionsService.getTransactionById(id),HttpStatus.OK);
    }
//REST API that  update transaction    by ID
    @PutMapping("{id")
    public ResponseEntity<Transactions> updateTransactions (@PathVariable("id") long id,
                                                            @RequestBody Transactions transactions){
        return new ResponseEntity<>(transactionsService.updateTransactions(transactions,id),HttpStatus.OK);
    }
// REST API that delete transaction by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") long id){
        transactionsService.deleteTransaction(id);
        return new ResponseEntity<>("Transaction is delete",HttpStatus.OK);
    }
}
