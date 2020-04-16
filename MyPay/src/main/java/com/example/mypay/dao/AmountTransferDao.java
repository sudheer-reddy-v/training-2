package com.example.mypay.dao;

public class AmountTransferDao {
	private long fromno;
	private  long tono;
	private double bal;
	public long getFromno() {
		return fromno;
	}
	public void setFromno(long fromno) {
		this.fromno = fromno;
	}
	public long getTono() {
		return tono;
	}
	public void setTono(long tono) {
		this.tono = tono;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}

}
