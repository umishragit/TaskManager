package com.umishra.TaskManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.SystemPropertyUtils;

import com.umishra.TaskManager.entity.Month;

@SpringBootTest
class TaskManagerApplicationTests {

	@Test
	void CheckEnum() {
		
		Month[] mon = Month.values();
		
		for(Month m : mon) {
			System.out.println(m);
		}
		
	}
	
	

}
