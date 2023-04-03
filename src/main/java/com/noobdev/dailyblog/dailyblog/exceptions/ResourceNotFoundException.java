package com.noobdev.dailyblog.dailyblog.exceptions;

import com.noobdev.dailyblog.dailyblog.models.User;
import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    String entity ;
    String field_name ;
    int id;

    public ResourceNotFoundException(String entity, String field_name, int userId){
        super(String.format("%s not found with %s : %l", entity, field_name, userId));
        this.entity = entity;
        this.field_name = field_name;
        this.id = id;

    }


}
