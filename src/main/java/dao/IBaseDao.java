package dao;

import java.util.List;

public interface IBaseDao <T, ID> {
	
	List<T> findAll();
	T findById(ID id);
	void persist(T elemento);
	T merge(T elemento);
	void remove(T daCancellare);

}
