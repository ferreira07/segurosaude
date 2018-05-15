package entities;

public interface IEntity extends Cloneable{
	int getId();
	void setId(int id);
	void update(IEntity other);
}
