package br.com.Univercode.WebStudy.controller;
import java.util.ArrayList;

import br.com.Univercode.WebStudy.dao.UserDAO;
import br.com.Univercode.WebStudy.domain.*;

public class UserController {
	
	public ArrayList<User> listAll(){
		ArrayList<Domain> domains = new UserDAO().list();
		ArrayList<User> users = new ArrayList<User>();
		for (Domain d : domains) {
			users.add((User)d);
		}
		return users;
	}
	
	public void remove(int id){
		new UserDAO().delete(id);
	}
	
	public User findById(int id){
		return (User)new UserDAO().findById(id);
	}

	public void save(User user) {
		new UserDAO().save(user);
		
	}

	public void update(User user) {
		new UserDAO().update(user);
		
	}

}
