package eu.romanhan.springtodoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.romanhan.springtodoapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
