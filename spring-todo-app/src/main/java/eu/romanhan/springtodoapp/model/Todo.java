package eu.romanhan.springtodoapp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 2, message = "Minnimum two letters")
	private String description;

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private LocalDate targetDate;
	private boolean completed;

	public Todo() {

	}

	public Todo(String description, LocalDate targetDate, boolean completed) {
		this.description = description;
		this.targetDate = targetDate;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
