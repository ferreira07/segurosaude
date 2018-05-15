package factories;

import entities.FaixaEtaria;
import entities.Plano;
import repository.IFaixaEtariaRepository;
import repository.IPlanoRepository;
import repository.array.FaixaEtariaRepository;
import repository.array.PlanoRepository;

public class SeedRepositoryFactory implements IRepositoryFactory {

	@Override
	public IPlanoRepository createPlanoRepository() {
		IPlanoRepository ret = new PlanoRepository();
		ret.save(new Plano ("Plano 1"));
		ret.save(new Plano ("Plano 2"));
		return ret;
	}

	@Override
	public IFaixaEtariaRepository createFaixaEtariaRepository() {
		IFaixaEtariaRepository ret = new FaixaEtariaRepository();
		ret.save(new FaixaEtaria(1,  0, 10, 100));
		ret.save(new FaixaEtaria(1, 11, 20, 120));
		ret.save(new FaixaEtaria(1, 21, 30, 150));
		ret.save(new FaixaEtaria(1, 31, 40, 250));
		ret.save(new FaixaEtaria(1, 41, 50, 280));
		

		ret.save(new FaixaEtaria(2,  0, 30, 130));
		ret.save(new FaixaEtaria(2, 31, 50, 200));
		ret.save(new FaixaEtaria(2, 51, 70, 350));
		
		return ret;
	}

}
