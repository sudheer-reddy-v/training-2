package com.example.mypay.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypay.dao.RegisterDao;
import com.example.mypay.dao.TransferResponseDao;
import com.example.mypay.dto.AmountTransferDto;
import com.example.mypay.dto.RegisterDto;
import com.example.mypay.dto.TransferResponseDto;
import com.example.mypay.feign.DemoFeign;
import com.example.mypay.service.RegisterServiceImpl;

@RestController
public class MyPayController {
	@Autowired
	private RegisterServiceImpl service;
	@Autowired
	private DemoFeign feignser;
	
	@RequestMapping(value="register",method = RequestMethod.POST,consumes = "application/json")
public TransferResponseDto doRegister(@RequestBody RegisterDto dto )
{
		RegisterDao dao= new RegisterDao();
		BeanUtils.copyProperties(dto, dao);
		 TransferResponseDao resdao =service.doRigegister(dao);
		 TransferResponseDto resdto=new TransferResponseDto();
		 BeanUtils.copyProperties(resdao, resdto);
		
		 
	return resdto;
	
}
	
	
	public boolean checkStatus(long phone)
	{
		boolean b=service.checkStatusService(phone);
				if(b)
					return true;
				else 
					return false;
	}
	
	
	
	@RequestMapping(value="/transfer",method = RequestMethod.POST,consumes = "application/json")
	public TransferResponseDto  anountTransfer(@RequestBody AmountTransferDto dto)
	{
		TransferResponseDto resdto= new TransferResponseDto();
		if(checkStatus(dto.getTono()))
		{
			
		TransferResponseDao resdao= feignser.amountTransfer(dto);
		BeanUtils.copyProperties(resdao,resdto);
			return resdto;
		}else
		{
			resdto.setMsg("Fund Transfer Failed");
		return resdto;
		}	
	}
		@GetMapping("/{phome}")
		public double getBalance(@PathVariable("phome") long phone)
		{
		return	feignser.checkBalance(phone);
		}
		
		@GetMapping("/list")	
	public List transactionList()
	{
		return null;
		
	}
		
	
	}
	
	




