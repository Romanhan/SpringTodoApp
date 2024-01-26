package eu.romanhan.springtodoapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.romanhan.springtodoapp.model.Todo;
import eu.romanhan.springtodoapp.service.TodoService;
import jakarta.validation.Valid;

@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping("/")
	public String welcomePage(ModelMap model) {
		model.addAttribute("name", getLoggedInUsername(model));
		return "welcome";
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUsername(model);
		model.put("todos", todoService.getTodosByUser(name));
		return "list-todos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUserName(getLoggedInUsername(model));
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam Long id, ModelMap model) {
		Todo todo = todoService.getTodoById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping("/update-todo")
	public String getTodoById(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getLoggedInUsername(model));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam Long id) {
		todoService.deleteTodoById(id);
		return "redirect:/list-todos";
	}

}
