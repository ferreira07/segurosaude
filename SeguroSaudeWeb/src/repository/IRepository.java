package repository;

import java.util.List;

import entities.IEntity;

public interface IRepository <T extends IEntity>{
	//criar e atualizar
	int save(T entity);
	void delete(int id);
	T get(int id);
	List<T> list();	
}
