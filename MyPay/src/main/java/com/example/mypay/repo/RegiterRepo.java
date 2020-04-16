package com.example.mypay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mypay.dao.RegisterDao;

public interface RegiterRepo extends JpaRepository<RegisterDao, Long>{

}
