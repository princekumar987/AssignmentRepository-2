package com.crudoperation.CrudOperation.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private String address;

}
