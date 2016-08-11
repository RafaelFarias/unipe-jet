package br.com.unipe.unipejet.model.dao;

import java.util.List;

import br.com.unipe.unipejet.model.vo.Voo;

public interface VooDAO extends GenericDAO<Voo, Long>{

	public List<Voo> searchVoo(Voo voo);
	
}
