package com.umishra.TaskManager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.umishra.TaskManager.Service.TodoService;
import com.umishra.TaskManager.entity.Todo;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	public TodoController() {
	}
	
	 
	 @InitBinder
		public void initBinder(WebDataBinder binder) {
			// Date - dd/MM/yyyy
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(
					dateFormat, false));
		}
	 
	 
	
	@RequestMapping(value = "/listTodo", method = RequestMethod.GET )
	public String listTodo(ModelMap model) {
		List<Todo> listTodo = todoService.getAllTodos();
		model.put("listTodo", listTodo);
		return "listTodo";
	}
	
	@RequestMapping(value = "/addTodo", method = RequestMethod.GET )
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(0,"",new Date(),false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/addTodo", method = RequestMethod.POST )
	public String addTodoDAO(Todo todo,ModelMap model) {
		todoService.addTodo(todo);
		return "redirect:/listTodo";
	}
	
	@RequestMapping(value = "/updateTodo", method = RequestMethod.GET )
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.getTodo(id);
		model.put("todo", todo);
		return "updateTodo";
	}
	
	@RequestMapping(value = "/updateTodo", method = RequestMethod.POST )
	public String updateTodo(Todo todo,ModelMap model) {
		todoService.updateTodo(todo);
		return "redirect:/listTodo";
	}
	
	@RequestMapping(value = "/deleteTodo", method = RequestMethod.GET )
	public String deleteTodo(@RequestParam int id,ModelMap model) {
		todoService.deleteTodo(id);
		return "redirect:/listTodo";
	}

}

