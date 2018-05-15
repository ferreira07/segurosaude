package service;

import java.util.List;

import entities.Plano;

public interface IPlanoService {
	int save(Plano p);
	void delete(int id);
	Plano get(int id);
	List<Plano> list();	
}
