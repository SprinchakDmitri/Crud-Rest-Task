package com.example.demo.exception;

public class CustomException extends Exception{

    Exception exception;
    public CustomException(Exception e){
        exception = e;
    }

    @Override
    public String getMessage() {
        return "Exception in the CarService " + exception.getMessage();
    }
}
