package com.msaheri.springbootfeaturedemo.firstMadule.repository;

import com.msaheri.springbootfeaturedemo.firstMadule.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    @Query(value = "select at from AccountTransaction at", nativeQuery = false)
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    List<AccountTransaction> getBalanceAndLock();


    @Query(value = "select sum(credit-debit) from account_transaction ", nativeQuery = true)
    Float getSum();
}
