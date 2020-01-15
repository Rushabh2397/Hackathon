package com.app.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.IssueRecord;

public class IssueRecordDao {
	@Autowired
	private SessionFactory sf;
	public IssueRecordDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<IssueRecord> searchById( int u_id)
	{
		String jpql="select i from IssueRecord i where i.usr.u_id=:u_id";
		return sf.getCurrentSession().createQuery(jpql, IssueRecord.class).setParameter("u_id", u_id).getResultList();
	}

}
