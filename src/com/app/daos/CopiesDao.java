package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Copies;

@Repository
@Transactional
public class CopiesDao {
	
	@Autowired
	private SessionFactory sf;
	public CopiesDao() {
		// TODO Auto-generated constructor stub
	}

   public Copies addcopies(Copies c)
	{
		 sf.getCurrentSession().persist(c);
			return c;	
	}
   
   public List<Copies> bookAvailability(int book_id)
   {
	   String jpql="select c from Copies c where c.book.id=:book_id";
	   return sf.getCurrentSession().createQuery(jpql, Copies.class).setParameter("book_id", book_id).getResultList();
   }
}
