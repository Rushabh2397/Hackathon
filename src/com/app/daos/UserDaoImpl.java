package com.app.daos;

import java.util.List;

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

	@Override
	public Users addUserDetails(Users u) {
		
	 sf.getCurrentSession().persist(u);
		return u;
	}
	
	
	
//	@GetMapping
//	public ResponseEntity<?> listEmps() {
//		System.out.println("in list emps");
//		List<Employee> allEmps = service.getAllEmps();
//		if (allEmps.size() == 0)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
//	}

	@Override
	public List<Users> getAllUsers() {
		
		String jpql = "select u from Users u ";
		return sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
		
		
	}

	@Override
	public void editProfile(Users u ) {
		
		 sf.getCurrentSession().saveOrUpdate(u);
		
	}

	@Override
	public Users getbyId(int u_id) {
		// TODO Auto-generated method stub
		
		return sf.getCurrentSession().get(Users.class, u_id);
	}
	

}
