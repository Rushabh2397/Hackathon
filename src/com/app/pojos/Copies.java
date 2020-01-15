package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "copies" ) 
public class Copies {
	
private Integer copies_id;
private int rack;
private String status;
private  List<IssueRecord> issue=new ArrayList<IssueRecord>();
private Books book;

public Copies() {
	// TODO Auto-generated constructor stub
}


public Copies(int rack, String status) {
	super();
	this.rack = rack;
	this.status = status;
}


@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY) 
@Column(name = "id")
public Integer getCopies_id() {
	return copies_id;
}


public void setCopies_id(Integer copies_id) {
	this.copies_id = copies_id;
}


public int getRack() {
	return rack;
}


public void setRack(int rack) {
	this.rack = rack;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}





@OneToMany(mappedBy = "copy",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@Fetch(FetchMode.SUBSELECT)
public List<IssueRecord> getIssue() {
	return issue;
}


public void setIssue(List<IssueRecord> issue) {
	this.issue = issue;
}



@ManyToOne
@JoinColumn(name = "bookid")
@JsonIgnore
public Books getBook() {
	return book;
}


public void setBook(Books book) {
	this.book = book;
}


@Override
public String toString() {
	return "Copies [copies_id=" + copies_id + ", rack=" + rack + ", status=" + status + "]";
}
 


}
