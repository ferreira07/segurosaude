package factories;

import service.FaixaEtariaService;
import service.IFaixaEtariaService;
import service.IPlanoService;
import service.PlanoService;

public class Context {
	private static Context instance;
	private PlanoService planoService;
	private FaixaEtariaService faixaEtariaService;
	public static IPlanoService getPlanoService(){
		if(instance == null) initialize();
		return instance.planoService;
	}
	public static IFaixaEtariaService getFaixaEtariaService(){
		if(instance == null) initialize();
		return instance.faixaEtariaService;
	}
	private static void initialize() {
		instance = new Context();
		
		IRepositoryFactory factory = new DBRepositoryFactory();
		instance.planoService = new PlanoService();
		instance.planoService.setRepository(factory.createPlanoRepository());
		instance.faixaEtariaService = new FaixaEtariaService();
		instance.faixaEtariaService.setRepository(factory.createFaixaEtariaRepository());

	}
	
}
