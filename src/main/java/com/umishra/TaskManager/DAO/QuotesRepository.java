package com.umishra.TaskManager.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umishra.TaskManager.entity.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

	Quotes findById(long id);
	
}
