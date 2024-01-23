package eu.romanhan.springtodoapp.service;

import org.springframework.stereotype.Service;

import eu.romanhan.springtodoapp.model.Todo;
import eu.romanhan.springtodoapp.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}
}
