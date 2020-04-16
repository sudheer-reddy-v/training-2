package com.example.mypay.dto;

public class TransactinDto {
private int id;
private long from;

private long to;
private String status;
public long getFrom() {
	return from;
}
public void setFrom(long from) {
	this.from = from;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getTo() {
	return to;
}
public void setTo(long to) {
	this.to = to;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
