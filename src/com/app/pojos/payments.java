package com.app.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class payments {
	private Integer id;
	private double amount;
	private String type;
	private Date transaction_time;
	private Date nextpayment_duedate;
	private Users usr;
	
	
	public payments() {
		// TODO Auto-generated constructor stub
	}

     
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

     @Temporal(TemporalType.DATE)
	public Date getTransaction_time() {
		return transaction_time;
	}


	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}

    @Temporal(TemporalType.DATE)
	public Date getNextpayment_duedate() {
		return nextpayment_duedate;
	}


	public void setNextpayment_duedate(Date nextpayment_duedate) {
		this.nextpayment_duedate = nextpayment_duedate;
	}
	
	

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid")
	public Users getUsr() {
		return usr;
	}



	public void setUsr(Users usr) {
		this.usr = usr;
	}



	@Override
	public String toString() {
		return "payments [id=" + id + ", amount=" + amount + ", type=" + type + ", transaction_time=" + transaction_time
				+ ", nextpayment_duedate=" + nextpayment_duedate + "]";
	}
	
	

}
