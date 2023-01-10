package com.emlakcepte.question1A.Repository;

import com.emlakcepte.question1A.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
	
	private static List<User> userList = new ArrayList<>();


	public void createUser(User user) {	
		userList.add(user);

		user.getOldPassword().add(user.getPassword());
	}

	
	public List<User> findAllUsers() {	
		return userList;
	}


}
