package prod.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import prod.DTO.ErrorResponseDTO;

@RestControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponseDTO> dataIntegrityViolationException(DataIntegrityViolationException e) {
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setTimeStamp(LocalDateTime.now());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setError("Contraint Violation!");
		error.setMessage(e.getMessage());

		return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.BAD_REQUEST);
	}
}
