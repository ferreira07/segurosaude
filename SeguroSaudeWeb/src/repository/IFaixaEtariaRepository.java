package repository;

import java.util.List;

import entities.FaixaEtaria;

public interface IFaixaEtariaRepository extends IRepository<FaixaEtaria> {

	List<FaixaEtaria> listByPlano(int planoId);
	
	List<FaixaEtaria> listByIdade(int idade);
}
