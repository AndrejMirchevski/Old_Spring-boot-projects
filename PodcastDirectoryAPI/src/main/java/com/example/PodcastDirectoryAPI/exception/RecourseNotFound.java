package com.example.PodcastDirectoryAPI.exception;

//409 conflict
public class RecourseNotFound extends RuntimeException{
    public RecourseNotFound(String message){
        super(message);
    }
}
