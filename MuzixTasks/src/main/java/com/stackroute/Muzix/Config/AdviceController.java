package com.stackroute.Muzix.Config;

import com.stackroute.Muzix.exception.TrackAlreadyExistsException;
import com.stackroute.Muzix.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice("com.stackroute.Muzix")
public class AdviceController {


        @ExceptionHandler(TrackAlreadyExistsException.class)
        public ResponseEntity<Object> myMessage(TrackAlreadyExistsException e)
        {
            System.out.println("inside Message method");
            return new ResponseEntity<>("Global Exception "+ e.getMessage(), HttpStatus.CONFLICT);
        }
        @ExceptionHandler(TrackNotFoundException.class)
        public ResponseEntity<Object> myMessage(TrackNotFoundException e)
        {
            return new ResponseEntity<>("Global Exception "+e.getMessage(), HttpStatus.CONFLICT);
        }
/*        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> myMessage(Exception e)
        {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.CONFLICT);
        }*/
    }

