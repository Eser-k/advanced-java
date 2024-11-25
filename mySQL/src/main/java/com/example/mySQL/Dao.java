package com.example.mySQL;

import java.util.Optional;

public interface Dao<T> {
	void save(T t);
	Optional<T> findByID(int id);
	void update(T t);
}
