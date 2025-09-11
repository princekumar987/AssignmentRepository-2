package com.crudoperation.CrudOperation.controller;


import com.crudoperation.CrudOperation.dto.StudentDto;
import com.crudoperation.CrudOperation.entity.Student;
import com.crudoperation.CrudOperation.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    private StudentService studentService;

    public StudentController ( StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public String test(){
        return "Srudent controller";
    }


    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentdto){

          log.info("Student data is:--", studentdto);
          Student s=studentService.addStudentService(studentdto);
          return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(s);

    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){


         List<Student> students =studentService.getAllStudentService();
         return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Optional<Student>>> getStudent(@PathVariable String id){
        Optional<Student> students =studentService.getStudentService(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(Optional.ofNullable(students));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
         studentService.deleteStudentById(id);
         return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(" Student Deletd By this id:--"+id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody StudentDto std){
          Student s=studentService.updateStudentService(id,std);
          return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(s);
    }






}
