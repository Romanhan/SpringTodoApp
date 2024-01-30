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

	public List<Todo> getTodosByUser(String name) {
		return todoRepository.findByUserName(name);
	}

	public void addTodo(String userName, String description, LocalDate targetDate, boolean completed) {
		Todo todo = new Todo(userName, description, targetDate, completed);
		todoRepository.save(todo);
	}

	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).get();
	}

	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}

}
