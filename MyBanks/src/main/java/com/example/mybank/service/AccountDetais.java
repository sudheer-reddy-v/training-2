package com.example.mybank.service;

import com.example.mybank.dao.AmountTransferDao;
import com.example.mybank.dao.TransferResponseDao;

public interface AccountDetais {
//public	GetAccountDetailsEntity getAccount(long phone) ;
	TransferResponseDao amountTransferService(AmountTransferDao dto);
 public void upDateBalFromSer(AmountTransferDao dao);
}
