package com.app.daos;

import java.util.List;

import com.app.pojos.Users;

public interface IUserDao {
	Users validateUser(String email,String password);
	Users addUserDetails(Users u);
	List<Users> getAllUsers();
	void editProfile(Users u);
	Users getbyId(int u_id);
	
	

}
