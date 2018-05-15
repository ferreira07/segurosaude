package repository.array;

import java.util.ArrayList;
import java.util.List;

import entities.IEntity;
import repository.IRepository;

public abstract class AbstractRepository<T extends IEntity> implements IRepository<T>{
	private List<T> data;
	
	public AbstractRepository() {
		data = new ArrayList<>();
	}
	
	@Override
	public int save(T entity) {
		int id = 0;
		if(entity.getId()>0){
			get(entity.getId()).update(entity);
		}
		else{
			id = nextId();
			entity.setId(id);
			data.add(entity);
		}		
		return id;
	}

	@Override
	public void delete(int id) {
		data.remove(get(id));
	}

	@Override
	public T get(int id) {
		for (T entity : data) {
			if(entity.getId() == id){
				return entity;
			}
		}
		return null;
	}

	@Override
	public List<T> list() {
		List<T> ret = new ArrayList<>(this.data);
		return ret;
	}

	private int nextId() {
		int id = 1;
		for (T entity : data) {
			if(entity.getId() == id){
				id = entity.getId() + 1;
			}
		}
		return id;
	}
}
