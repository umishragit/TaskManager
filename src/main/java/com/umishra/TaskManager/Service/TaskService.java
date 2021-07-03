package com.umishra.TaskManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umishra.TaskManager.DAO.TaskRepository;
import com.umishra.TaskManager.entity.Task;
import com.umishra.TaskManager.entity.Todo;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public TaskService() {
	}
	
	public List<Task> getAllTask() {
		return  taskRepository.findAll();
	}
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}

	public void updateTodo(Todo todo) {
//		Todo tempTodo = taskRepository.findById(todo.getId());
//		tempTodo.setStatus(todo.isStatus());
//		tempTodo.setTargetDate(todo.getTargetDate());
//		tempTodo.setDescription(todo.getDescription());
//		todoRepository.save(tempTodo);
	}

	public List<Task> getTodoByYear(int year) {
		return taskRepository.findByYear(year);
	}
	
	public List<Task> getTodoByMonth(int month) {
		return taskRepository.findByYear(month);
	}
	
	public List<Integer> getUniqueYear(){
		return taskRepository.getUniqueYear();
	}
	
	public List<Task> findByYearAndfindByMonth(int year, String month) {
		return taskRepository.findByYearAndMonth(year, month);
	}
	
	public Optional<Task> getTask(int id) {
		return taskRepository.findById(id);
	}

	public void deleteTask(int id) {
		Optional<Task> tempTodo = getTask(id);
		taskRepository.deleteById(id);
	}

}
