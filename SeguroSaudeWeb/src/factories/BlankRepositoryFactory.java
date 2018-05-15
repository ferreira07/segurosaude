package factories;

import repository.IFaixaEtariaRepository;
import repository.IPlanoRepository;
import repository.array.FaixaEtariaRepository;
import repository.array.PlanoRepository;

public class BlankRepositoryFactory implements IRepositoryFactory{

	@Override
	public IPlanoRepository createPlanoRepository() {
		return new PlanoRepository();
	}

	@Override
	public IFaixaEtariaRepository createFaixaEtariaRepository() {
		return new FaixaEtariaRepository();
	}

}
