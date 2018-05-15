package service;

import java.util.List;

import entities.FaixaEtaria;

public interface IFaixaEtariaService {
	int save(FaixaEtaria f);
	void delete(int id);
	FaixaEtaria get(int id);
	List<FaixaEtaria> list();
	
	List<FaixaEtaria> listByPlano(int planoId);
	List<FaixaEtaria> listByIdade(int idade);
}
