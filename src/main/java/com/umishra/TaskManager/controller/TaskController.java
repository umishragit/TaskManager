package com.umishra.TaskManager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umishra.TaskManager.Service.TaskManagementService;
import com.umishra.TaskManager.Service.TaskService;
import com.umishra.TaskManager.entity.Month;
import com.umishra.TaskManager.entity.Task;
import java.text.DateFormatSymbols;

@Controller
public class TaskController {
	
	TaskController(){
	}

	@Autowired
	TaskManagementService taskManagementService;
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/")
	String homePage(ModelMap map) throws Exception {
		map.put("randomQuote", taskManagementService.getRandomQuotes());
		return "index";
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.GET )
	public String addTask(ModelMap model) {
		String temp = new DateFormatSymbols().getMonths()[LocalDate.now().getMonthValue() - 1];
		System.out.println("Month = " + temp);
		Task task = new Task("",LocalDate.now().getYear(),temp,LocalDate.now().getDayOfMonth());
		model.put("task", task);
		return "addTask";
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST )
	public String addTaskPost(Task task,ModelMap model) {
		System.out.println(task);
		model.put("year", task.getYear());
		taskService.addTask(task);
		model.put("month", task.getMonth().toString());
		return "listTask";
	}
	
	@GetMapping(value = "/listYear")
	public String listYear(ModelMap model){
		List<Integer> years = taskService.getUniqueYear();
		Collections.sort(years);
		model.put("years", years);
		return "listYear";
	}
	
	@RequestMapping(value = "/listMonth", method = RequestMethod.GET )
	public String listMonth(@RequestParam int year,ModelMap model) {
		Month[] months = Month.values();
		model.put("year", year);
		model.put("months", months);
		return "listMonth";
	}
	
	@RequestMapping(value = "/listTask", method = RequestMethod.GET )
	public String listTask(@RequestParam Month month,@RequestParam int year,ModelMap model) {
		List<Task> tasks = taskService.findByYearAndfindByMonth(year, month.toString());
		model.put("tasks", tasks);
		return "listTask";
	}
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET )
	public String deleteTask(@RequestParam int id,ModelMap model) {
		taskService.deleteTask(id);
		return "redirect:/listYear";
	}
	
}
