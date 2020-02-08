package br.com.technovaca.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.technovaca.error.ResourceNotFoundDetails;
import br.com.technovaca.error.ResourceNotFoundException;


@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception){
		ResourceNotFoundDetails details = ResourceNotFoundDetails.Builder
		.newBuilder()
		.timestamp(new Date().getTime())
		.status(HttpStatus.NOT_FOUND.value())
		.title("Resource not found")
		.details(exception.getMessage())
		.developMessage(exception.getClass().getName())
		.build();
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
	
	
}
