package com.crudoperation.CrudOperation.customexception;

import com.crudoperation.CrudOperation.globalexception.StudentException;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message){
        super(message);
    }
}
