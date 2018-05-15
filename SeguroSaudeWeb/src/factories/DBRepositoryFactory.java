package factories;

import repository.IFaixaEtariaRepository;
import repository.IPlanoRepository;
import repository.db.DBFaixaEtariaRepository;
import repository.db.DBPlanoRepository;

public class DBRepositoryFactory implements IRepositoryFactory{

	@Override
	public IPlanoRepository createPlanoRepository() {
		return new DBPlanoRepository();
	}

	@Override
	public IFaixaEtariaRepository createFaixaEtariaRepository() {
		return new DBFaixaEtariaRepository();
	}

}
