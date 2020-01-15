package com.app.daos;

import com.app.pojos.Users;

public interface IUserDao {
	Users validateUser(String email,String password);

}
