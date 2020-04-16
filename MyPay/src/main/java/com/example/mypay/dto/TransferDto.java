package com.example.mypay.dto;

public class TransferDto {
	private long fromphone;
	private long tophone;
	private double amount;
	public long getFromphone() {
		return fromphone;
	}
	public void setFromphone(long fromphone) {
		this.fromphone = fromphone;
	}
	public long getTophone() {
		return tophone;
	}
	public void setTophone(long tophone) {
		this.tophone = tophone;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
