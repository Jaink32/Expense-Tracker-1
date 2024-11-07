package com.expensetracker.expensetracker.services;

import com.expensetracker.expensetracker.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE " +
            "(:description IS NULL OR t.description LIKE %:description%) AND " +
            "(:amount IS NULL OR " +
            " ( :amountFilter = '=' AND t.amount = :amount ) OR " +
            " ( :amountFilter = '<=' AND t.amount <= :amount ) OR " +
            " ( :amountFilter = '>=' AND t.amount >= :amount )) AND " +
            "(:startDate IS NULL OR t.date >= :startDate) AND " +
            "(:endDate IS NULL OR t.date <= :endDate)")
    Page<Transaction> findFilteredTransactions(
            @Param("description") String description,
            @Param("amount") BigDecimal amount,
            @Param("amountFilter") String amountFilter,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);
}
