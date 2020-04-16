package com.example.mybank.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mybank.dao.AmountTransferDao;
import com.example.mybank.dao.GetAccountDetailsEntity;
import com.example.mybank.dao.TransferResponseDao;
import com.example.mybank.repo.AccountRepo;

@Service
public class AccountDetailsImpl implements AccountDetais {
	@Autowired
	private AccountRepo repo;
/*
	@Override
	public GetAccountDetailsEntity getAccount( long phone) {
		boolean l=repo.findAccByPhone(phone);
	GetAccountDetailsEntity entity= new GetAccountDetailsEntity();
		entity.setAcno(l);
		return entity;*
	}
*/
	@Override
	public TransferResponseDao amountTransferService(AmountTransferDao dao) {
		
		TransferResponseDao tdao= new TransferResponseDao();
		boolean l=repo.findAccByPhone(dao.getTono());
		double avlbal=repo.checkAccountBal(dao.getFromno());
		if(l) {
		if(avlbal>=dao.getBal())
		{
			tdao.setMsg("trasaction successfully complited");
			tdao.setTcode(200);
			return tdao;
		}
		else
		{
			tdao.setMsg("insufficient founds");
			tdao.setTcode(702);
		return tdao;	
		}
		}
		else
		{
		tdao.setMsg("reciver dont have account");
		tdao.setTcode(701);
		return tdao;
		}
		
	}
	@Override
	public void upDateBalFromSer(AmountTransferDao dao) {
		long fno=dao.getFromno();
		
		double fbal=calFromFinalBal(dao);
		
		repo.upDateBalFrom(fno, fbal);
	}
		
public double calFromFinalBal(AmountTransferDao dao)
{
	double fromfinal= repo.checkAccountBal(dao.getFromno());
	fromfinal =fromfinal-dao.getBal();
	return fromfinal;
	
	
}
public double caltoFinalBal(AmountTransferDao dao)
{
	double tofinal= repo.checkAccountBal(dao.getTono());
	tofinal =tofinal+dao.getBal();
	return tofinal;
	
}

public void upDateBalToSer(AmountTransferDao dao) {
	
	long tno=dao.getTono();
	
	double tobal=caltoFinalBal(dao);
	repo.upDateBalFrom(tno, tobal);
}
public double findBal(long phone)
{
	return repo.checkAccountBal(phone);
	
}
}
