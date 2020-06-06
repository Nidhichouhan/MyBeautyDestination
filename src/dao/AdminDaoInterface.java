package dao;

import model.Admin;

public interface AdminDaoInterface {
	int signUp(Admin add);
	boolean loginUser(Admin add);
}
