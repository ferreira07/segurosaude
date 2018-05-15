package service;

import java.util.List;

import entities.Plano;
import repository.IPlanoRepository;

public class PlanoService implements IPlanoService{

	private IPlanoRepository repository;
	
	public IPlanoRepository getRepository() {
		return repository;
	}

	public void setRepository(IPlanoRepository repository) {
		this.repository = repository;
	}

	@Override
	public int save(Plano p) {
		if(p.getId()!= 0 && repository.get(p.getId()) == null){
			throw new RuntimeException("Tentativa de atualizar plano não existente");
		}
		if(p.getNome()==null || p.getNome().equals("")){
			throw new RuntimeException("Tentativa de salvar um plano sem nome");
		}
		int id = repository.save(p);
		return id;
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public Plano get(int id) {
		return repository.get(id);
	}

	@Override
	public List<Plano> list() {
		return repository.list();
	}
}
