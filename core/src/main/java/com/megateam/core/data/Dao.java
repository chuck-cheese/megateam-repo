package com.megateam.core.data;

import java.util.List;
import java.util.Optional;

public interface Dao <T>
{

	void add(T item);
	Optional<T> get(long id);
	List<T> getAll();
	void update(long id, T item);
	void delete(long id);
	void clear();
	void removeFirst();
	void removeLast();

}
