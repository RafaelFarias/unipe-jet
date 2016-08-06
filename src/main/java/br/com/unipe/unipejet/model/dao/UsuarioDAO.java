package br.com.unipe.unipejet.model.dao;

import br.com.unipe.unipejet.model.vo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Long>{
	
	public Usuario login(String login, String senha);

}
