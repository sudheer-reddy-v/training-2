package com.example.mypay.service;

import com.example.mypay.dao.RegisterDao;
import com.example.mypay.dao.TransactinDao;
import com.example.mypay.dao.TransferResponseDao;

public interface RegiserService {
	 TransferResponseDao doRigegister(RegisterDao dao);
	// void updateTransaction(TransactinDao dao);
	
}