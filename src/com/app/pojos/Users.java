package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	private Integer u_id;
	private String name,email,passwd;
	private int phone;
	private Role role;
	private   List<payments >pay;
	private  List<IssueRecord> issue;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}


	public Users( String name, String email, String passwd, int phone, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.phone = phone;
		this.role = role;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public Integer getU_id() {
		return u_id;
	}


	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

    @Column(unique = true,nullable = false)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    @Column(nullable = false,length = 15)
	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

    @Column(length = 10)
	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}

    @Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	
	
	@OneToMany(mappedBy ="usr",cascade = CascadeType.ALL)
    public List<payments> getPay() {
		return pay;
	}


	public void setPay(List<payments> pay) {
		this.pay = pay;
	}

	@OneToMany(mappedBy = "usr",cascade =CascadeType.ALL ) 
	public List<IssueRecord> getIssue() {
		return issue;
	}


	public void setIssue(List<IssueRecord> issue) {
		this.issue = issue;
	}


	
	
	
	
	

}
