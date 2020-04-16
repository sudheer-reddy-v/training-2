package com.example.mypay.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TransactinResDao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;
private long to;
private String status;
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
