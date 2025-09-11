package com.crudoperation.CrudOperation.repository;

import com.crudoperation.CrudOperation.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

}
