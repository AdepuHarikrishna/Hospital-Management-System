package com.model.Intr;

import java.util.List;
import java.util.Map;

import com.model.User;

public interface UserIntr {
	

	public void insertUser(User user);
	public Map selectUser(int id);
	public List getAllUsers();
	public void updateUser(User user);
	public void deleteUser(int id);
}

