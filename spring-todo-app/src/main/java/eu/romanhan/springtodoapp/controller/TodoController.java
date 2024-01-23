package eu.romanhan.springtodoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.romanhan.springtodoapp.model.Todo;
import eu.romanhan.springtodoapp.service.TodoService;

@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping("/todos")
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.saveTodo(todo);
	}

	@RequestMapping("")
	public String welcomePage() {
		return "welcome";
	}

}
