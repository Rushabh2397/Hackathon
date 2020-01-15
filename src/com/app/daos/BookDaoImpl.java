package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Books;
import com.app.pojos.Users;
@Repository
@Transactional 
public class BookDaoImpl implements IBookDao{

	@Autowired
	private SessionFactory sf;
	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
		
		
	}
	@Override
	public Books addBooks(Books u) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(u);
		return u;
	}
	@Override
	public List<Books> findByName(String subject) {
		// TODO Auto-generated method stub
		String jpql="select b from Books b where b.subject=:subject ";
		
		
		return sf.getCurrentSession().createQuery(jpql, Books.class).setParameter("subject", subject).getResultList();
	}
	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		String jpql = "select b from Books b ";
		List<Books> c=sf.getCurrentSession().createQuery(jpql, Books.class).getResultList();
		System.out.println("cbgcbf"+c);
		return c;
		
	}
}
