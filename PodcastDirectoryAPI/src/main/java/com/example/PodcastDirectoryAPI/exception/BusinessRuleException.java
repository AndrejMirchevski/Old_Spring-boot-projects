package com.example.PodcastDirectoryAPI.exception;

//404
public class BusinessRuleException extends RuntimeException{
    public BusinessRuleException(String message){
        super(message);
    }
}
