package entities;

public class FaixaEtaria implements IEntity{
	
	private int id;
	private int idadeIni;
	private int idadeFim;
	private int planoId;	
	private float valor;
	
	public FaixaEtaria(int planoId, int idadeIni, int idadeFim, int valor) {
		this.planoId = planoId;
		this.idadeIni = idadeIni;
		this.idadeFim = idadeFim;
		this.valor = valor;
	}
	public FaixaEtaria() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdadeIni() {
		return idadeIni;
	}
	public void setIdadeIni(int idadeIni) {
		this.idadeIni = idadeIni;
	}
	public int getIdadeFim() {
		return idadeFim;
	}
	public void setIdadeFim(int idadeFim) {
		this.idadeFim = idadeFim;
	}
	public int getPlanoId() {
		return planoId;
	}
	public void setPlanoId(int planoId) {
		this.planoId = planoId;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public void update(IEntity other) {
		if(other instanceof FaixaEtaria){
			FaixaEtaria f = (FaixaEtaria) other;
			this.id = f.id;
			this.idadeFim = f.idadeFim;
			this.idadeIni = f.idadeIni;
			this.planoId = f.planoId;
			this.valor = f.valor;			
		}
		
	}
}
