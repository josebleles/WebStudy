package br.com.Univercode.WebStudy.dao;

import java.util.List;

import br.com.Univercode.WebStudy.domain.Domain;

public interface IDAO {
	
	public void save(Domain obj);
	public void update(Domain obj);
	public void delete(int id);
	public Domain findById(int id);
	public List<Domain> list();

}
