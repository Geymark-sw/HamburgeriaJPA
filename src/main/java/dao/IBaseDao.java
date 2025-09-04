package dao;

import java.util.List;

public interface IBaseDao <T, Id> {
	
	List<T> findAll();
	T findById(Id id);
	boolean persist(T elemento);
	T merge(T elemento);
	boolean delete(T daCancellare);

}
