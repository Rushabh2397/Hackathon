package com.app.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Users;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Users validateUser(String email, String password) {
		String jpql="select u from Users u where u.email:=email and u.passwd:=password";
		return sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("email", email).setParameter("password", password).getSingleResult();
	}

}
