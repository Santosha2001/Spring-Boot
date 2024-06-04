package com.xworkz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice -> Responsible to handle exceptions rather multiple exceptions globally through the project
@ControllerAdvice
public class CloudVendorExceptionHandler {

	// @ExceptionHandler -> Annotation for handling exceptions in specific handler
	// classes and/orhandler methods.
	@ExceptionHandler(value = CloudVendorNotFoundException.class)
	public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException notFoundException) {

		CloudVendorException cloudVendorException = new CloudVendorException(notFoundException.getMessage(),
				notFoundException.getCause(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
	}
}
