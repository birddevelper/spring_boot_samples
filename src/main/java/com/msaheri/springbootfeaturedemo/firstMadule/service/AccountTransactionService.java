package com.msaheri.springbootfeaturedemo.firstMadule.service;

import com.msaheri.springbootfeaturedemo.firstMadule.repository.AccountTransactionRepository;
import com.msaheri.springbootfeaturedemo.firstMadule.model.AccountTransaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;


@Service
@Slf4j
public class AccountTransactionService {

    private EntityManager entityManager;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addAmount(float amount, String description) throws InterruptedException {

       // accountTransactionRepository.getBalanceAndLock();
        accountTransactionRepository.getSum();
        AccountTransaction accountTransaction1 = new AccountTransaction(0,50,"Description 1");
        accountTransactionRepository.save(accountTransaction1);
        log.info("I am here hooo");
        Thread.sleep(8000);
        AccountTransaction accountTransaction = new AccountTransaction(10,0,"Description 1");
        accountTransactionRepository.save(accountTransaction);

        //entityManager.persist(accountTransaction);

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public long getCount() throws InterruptedException {
        //accountTransactionRepository.getBalanceAndLock();
        accountTransactionRepository.getSum();
        return  accountTransactionRepository.count();
    }
}
