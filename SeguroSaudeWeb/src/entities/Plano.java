package entities;

public class Plano implements IEntity{
	
	private int id;
	private String nome;
	
	public Plano(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public void update(IEntity other) {
		if(other instanceof Plano){
			Plano f = (Plano) other;
			this.id = f.id;
			this.nome = f.nome;	
		}
	}
	
}
