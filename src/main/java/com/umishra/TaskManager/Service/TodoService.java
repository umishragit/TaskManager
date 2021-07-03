package com.umishra.TaskManager.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umishra.TaskManager.DAO.TodoRepository;
import com.umishra.TaskManager.entity.Todo;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public TodoService() {
	}
	
	public List<Todo> getAllTodos() {
		return  todoRepository.findAll();
	}
	
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void updateTodo(Todo todo) {
		Todo tempTodo = todoRepository.findById(todo.getId());
		tempTodo.setStatus(todo.isStatus());
		tempTodo.setTargetDate(todo.getTargetDate());
		tempTodo.setDescription(todo.getDescription());
		todoRepository.save(tempTodo);
	}

	public Todo getTodo(int id) {
		return todoRepository.findById(id);
	}

	public void deleteTodo(int id) {
		Todo tempTodo = getTodo(id);
		todoRepository.deleteById(id);
	}

}
