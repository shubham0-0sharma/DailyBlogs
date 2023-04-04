package com.noobdev.dailyblog.dailyblog.exceptions;

import com.noobdev.dailyblog.dailyblog.models.User;
import lombok.Data;


public class ResourceNotFoundException extends RuntimeException{
    String entity ;
    String field_name ;
    int id;

    public ResourceNotFoundException(String entity, String field_name, int userId){
        super(String.format("%s not found with %s : %s", entity, field_name, userId));

    }


}
