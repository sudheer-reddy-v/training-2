package com.example.mypay.repo;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mypay.dao.TransactinDao;

public interface TransactionRepo  extends JpaRepository<TransactinDao, Integer>
{

}
