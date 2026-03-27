package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ShowNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ShowNotFoundException ex) {

	    ErrorResponse error = new ErrorResponse(ex.getMessage(), 404);

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}