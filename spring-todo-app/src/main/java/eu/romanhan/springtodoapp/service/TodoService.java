package eu.romanhan.springtodoapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import eu.romanhan.springtodoapp.model.Todo;
import eu.romanhan.springtodoapp.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> getAllTodos() {
		List<Todo> todos = todoRepository.findAll();
		return todos;
	}

	public void addTodo(String description, LocalDate targetDate, boolean completed) {
		Todo todo = new Todo(description, targetDate, completed);
		todoRepository.save(todo);
	}

	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}

}
