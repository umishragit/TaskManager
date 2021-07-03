package com.umishra.TaskManager.Service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umishra.TaskManager.DAO.QuotesRepository;
import com.umishra.TaskManager.Exception.QuoteNotfoundException;
import com.umishra.TaskManager.entity.Quotes;  

@Service
public class TaskManagementService {
	
	TaskManagementService(){
	}
	
	@Autowired
	QuotesRepository quotesRepository;
	
	public Quotes getRandomQuotes() {
		long count = quotesRepository.count();
		if (count == 0) {
			throw new QuoteNotfoundException("no quotes in database");
		}
		long id = ThreadLocalRandom.current().nextLong(1, count + 1);
		return quotesRepository.findById(id);
	}
	
	
	
	
	
	
}
