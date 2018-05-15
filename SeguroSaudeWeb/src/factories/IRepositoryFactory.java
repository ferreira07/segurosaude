package factories;

import repository.IFaixaEtariaRepository;
import repository.IPlanoRepository;

public interface IRepositoryFactory {
	IPlanoRepository createPlanoRepository();
	IFaixaEtariaRepository createFaixaEtariaRepository();
}
