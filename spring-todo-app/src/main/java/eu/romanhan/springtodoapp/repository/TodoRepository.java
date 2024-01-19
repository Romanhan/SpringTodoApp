package eu.romanhan.springtodoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.romanhan.springtodoapp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
