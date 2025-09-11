package com.crudoperation.CrudOperation.service;

import com.crudoperation.CrudOperation.customexception.StudentNotFoundException;
import com.crudoperation.CrudOperation.dto.StudentDto;
import com.crudoperation.CrudOperation.entity.Student;
import com.crudoperation.CrudOperation.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;


    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper){
        this.studentRepository=studentRepository;
        this.modelMapper=modelMapper;
    }


    public Student addStudentService(StudentDto studentdto) {

        logger.info("adding student here");

        Student stud= modelMapper.map(studentdto, Student.class);
        return studentRepository.save(stud);
    }

    public List<Student> getAllStudentService() {

        logger.info("getting all students");
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentService(String id) {

        if(!studentRepository.existsById(id)){
            logger.info("Student not exists by this id");
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        logger.info("Student exist by this id");
        return studentRepository.findById(id);
    }

    public void deleteStudentById(String id) {

        if(!studentRepository.existsById(id)){
            logger.info("Student not exists by this id");
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        logger.info("Student exist by this id");
         studentRepository.deleteById(id);
    }

    public Student updateStudentService(String id, StudentDto std) {

        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        Student student=studentRepository.findById(id).get();
        student.setId(id);
        student.setName(std.getName());
        student.setAge(std.getAge());
        student.setAddress(std.getAddress());

        return studentRepository.save(student);


    }
}
