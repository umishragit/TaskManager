package com.umishra.TaskManager.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umishra.TaskManager.entity.Quotes;
import com.umishra.TaskManager.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	Todo findById(int id);
	
}
