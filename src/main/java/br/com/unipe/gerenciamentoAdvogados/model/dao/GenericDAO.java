package br.com.unipe.gerenciamentoAdvogados.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, I extends Serializable> {
	public void create(T a);

	public void update(T a);

	public void delete(T a);

	public T findById(I id);

	public List<T> listAll();
}
