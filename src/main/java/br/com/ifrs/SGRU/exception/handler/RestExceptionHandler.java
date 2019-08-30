package br.com.ifrs.SGRU.exception.handler;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ifrs.SGRU.exceptions.EntityNotFoundException;
import br.com.ifrs.SGRU.exceptions.ExceptionResponse;



@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        
        ExceptionResponse exceptionResponse = new ExceptionResponse("NOT FOUND", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
    
    @ExceptionHandler(PSQLException.class)
    protected ResponseEntity<Object> handlePSQLException(PSQLException ex) {
    	ExceptionResponse exceptionResponse = new ExceptionResponse("Problema para agendar consumo: Problema com a data do agendamento", 
    			ex.getMessage());
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }
    
}
