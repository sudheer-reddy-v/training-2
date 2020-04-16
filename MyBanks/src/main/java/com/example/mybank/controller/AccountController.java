package com.example.mybank.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybank.dao.AmountTransferDao;
import com.example.mybank.dao.GetAccountDetailsEntity;
import com.example.mybank.dao.TransferResponseDao;
import com.example.mybank.dto.AmountTransferDto;
import com.example.mybank.dto.GetAccountDetailsDto;
import com.example.mybank.dto.TransferResponseDto;
import com.example.mybank.service.AccountDetailsImpl;

@RestController
public class AccountController {
	@Autowired
	private AccountDetailsImpl account;
	
	/*@RequestMapping(value="/{phone}",method = RequestMethod.GET)
	GetAccountDetailsDto FindDetails(@PathVariable("phone")long phone)
	{
	GetAccountDetailsEntity entity= account.getAccount(phone);
	GetAccountDetailsDto dto= new GetAccountDetailsDto();
	BeanUtils.copyProperties(entity, dto);
		return dto;
		
	}*/
@RequestMapping(value="/transfer",method = RequestMethod.POST,consumes = "application/json")
public TransferResponseDao  amountTransfer(@RequestBody AmountTransferDto dto)
{
	AmountTransferDao dao= new AmountTransferDao();
	BeanUtils.copyProperties(dto, dao);
	TransferResponseDao daores= account.amountTransferService(dao);
	TransferResponseDto dtores= new TransferResponseDto();
	BeanUtils.copyProperties(daores, dtores);
	return daores;
}
@RequestMapping(value="/{phone}")
double checkBalance(@PathVariable("phone")long phone)
{
	return account.findBal(phone);
}
}
