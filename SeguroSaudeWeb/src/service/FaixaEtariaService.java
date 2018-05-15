package service;

import java.util.List;

import entities.FaixaEtaria;
import repository.IFaixaEtariaRepository;

public class FaixaEtariaService implements IFaixaEtariaService{
	private IFaixaEtariaRepository repository;
	
	public IFaixaEtariaRepository getRepository() {
		return repository;
	}

	public void setRepository(IFaixaEtariaRepository repository) {
		this.repository = repository;
	}

	@Override
	public int save(FaixaEtaria f) {
		if(f.getId()!= 0 && repository.get(f.getId()) == null){
			throw new RuntimeException("Tentativa de atualizar FaixaEtaria não existente");
		}
		if(f.getIdadeIni()> f.getIdadeFim()){
			throw new RuntimeException("Tentativa de salvar uma FaixaEtaria com idade inicial maior que final");
		}
		if(f.getValor()<=0){
			throw new RuntimeException("Tentativa de salvar uma FaixaEtaria com valor inválido");
		}
		int id = repository.save(f);
		return id;
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public FaixaEtaria get(int id) {
		return repository.get(id);
	}

	@Override
	public List<FaixaEtaria> list() {
		return repository.list();
	}

	@Override
	public List<FaixaEtaria> listByPlano(int planoId) {
		return repository.listByPlano(planoId);
	}

	@Override
	public List<FaixaEtaria> listByIdade(int idade) {
		return repository.listByIdade(idade);
	}

}
