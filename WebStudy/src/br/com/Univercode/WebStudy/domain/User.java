package br.com.Univercode.WebStudy.domain;

public class User implements Domain{
	
	private int id;
	private String login;
	private String name;
	private String password;
	private TypeUser type;
	
	//instancia de validacao
	public User(String login, String pass) {
		setLogin(login);
		setPassword(pass);
	}
	// instancia de consulta
	public User(int id, String name, String login, String pass, TypeUser type) {
		setId(id);
		setName(name);
		setLogin(login);
		setPassword(pass);
		setType(type);
	}
	// instancia de cadastro
	public User(String name, String login, String pass, TypeUser type) {
		setId(id);
		setName(name);
		setLogin(login);
		setPassword(pass);
		setType(type);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TypeUser getType() {
		return type;
	}
	public void setType(TypeUser type) {
		this.type = type;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
		
	}
	public boolean isSame(User user) {
		return (user.getLogin().equals(login) && user.getPassword().equals(password));
	}
	
	
}
