package org.codejudge.sb.exceptionhandling;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.codejudge.sb.error.ApiError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex,
			WebRequest request) {
		List<String> details = ex.getConstraintViolations().parallelStream().map(e -> e.getMessage())
				.collect(Collectors.toList());
		ApiError error = new ApiError("failure", "Please fill required fields");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<ApiError> handleConstraintViolation(DataIntegrityViolationException ex,
			WebRequest request) {
		ApiError error = new ApiError("failure", "Please Enter a Unique Email id");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public final ResponseEntity<ApiError> handleConstraintViolation(EmptyResultDataAccessException ex,
			WebRequest request) {
		ApiError error = new ApiError("failure", "The Lead you are trying to delete does not exist");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}


