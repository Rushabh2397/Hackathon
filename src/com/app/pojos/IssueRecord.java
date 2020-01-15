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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "issuerecord")
public class IssueRecord {
	private Integer issue_id;
	private Date issue_date,return_duedate,return_date;
	private double fine_amount;
	private Users usr;
	private Copies copy;
	
	public IssueRecord() {
		// TODO Auto-generated constructor stub
	}
	
	

	public IssueRecord(Date issue_date, Date return_duedate, Date return_date, double fine_amount) {
		super();
		this.issue_date = issue_date;
		this.return_duedate = return_duedate;
		this.return_date = return_date;
		this.fine_amount = fine_amount;
	}



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}
     
	@Temporal(TemporalType.DATE)
	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
    
	@Temporal(TemporalType.DATE)
	public Date getReturn_duedate() {
		return return_duedate;
	}

	public void setReturn_duedate(Date return_duedate) {
		this.return_duedate = return_duedate;
	}

	public double getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}


	@Temporal(TemporalType.DATE) 
	public Date getReturn_date() {
		return return_date;
	}



	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}


    @ManyToOne
    @JoinColumn(name ="memberid")
    @JsonIgnore
	public Users getUsr() {
		return usr;
	}



	public void setUsr(Users usr) {
		this.usr = usr;
	}

	

    @ManyToOne
    @JoinColumn(name = "copyid" )
	public Copies getCopy() {
		return copy;
	}



	public void setCopy(Copies copy) {
		this.copy = copy;
	}



	@Override
	public String toString() {
		return "IssueRecord [issue_id=" + issue_id + ", issue_date=" + issue_date + ", return_duedate=" + return_duedate
				+ ", return_date=" + return_date + ", fine_amount=" + fine_amount + "]";
	}
	
	
	
	
	

}
