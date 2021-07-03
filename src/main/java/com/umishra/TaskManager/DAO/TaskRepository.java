package com.umishra.TaskManager.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.umishra.TaskManager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	List<Task> findByYear(int year);
	List<Task> findByMonth(int month);
	List<Task> findByYearAndMonth(int year,String month);
	
	@Query("SELECT DISTINCT t.year FROM Task t")
	List<Integer> getUniqueYear();
	
}
