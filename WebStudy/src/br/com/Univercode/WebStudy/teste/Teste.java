package br.com.Univercode.WebStudy.teste;

import java.sql.Connection;

import br.com.Univercode.WebStudy.dao.MyConnection;
import br.com.Univercode.WebStudy.dao.UserDAO;
import br.com.Univercode.WebStudy.domain.TypeUser;
import br.com.Univercode.WebStudy.domain.User;

public class Teste {
	public static void main(String[] args) {
		User user = new User("lilia", "1234");
		new UserDAO().save(user);
	}
}
