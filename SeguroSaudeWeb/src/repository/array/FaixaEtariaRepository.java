package repository.array;

import java.util.List;

import entities.FaixaEtaria;
import repository.IFaixaEtariaRepository;

public class FaixaEtariaRepository extends AbstractRepository<FaixaEtaria> implements IFaixaEtariaRepository{

	public List<FaixaEtaria> listByPlano(int planoId) {
		List<FaixaEtaria> ret = this.list();
		
		ret.removeIf((f) -> f.getPlanoId() != planoId);
		
		return ret;
	}

	public List<FaixaEtaria> listByIdade(int idade) {
		List<FaixaEtaria> ret = this.list();
		ret.removeIf((f) -> !intercessao(f, idade));
		return ret;
	}

	private boolean intercessao(FaixaEtaria f, int idade) {		
		return idade >= f.getIdadeIni() && idade <= f.getIdadeFim();
	}

}
