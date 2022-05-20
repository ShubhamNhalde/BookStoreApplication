package com.bridgelabz.userregistration.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserExceptionalHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMesg = errorList.stream()
							.map(objErr->objErr.getDefaultMessage())		
							.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(UserException exception) {
		ResponseDTO response = new ResponseDTO("Invalid Userid input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(PasswordException exception) {
		ResponseDTO response = new ResponseDTO("Invalid password input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
