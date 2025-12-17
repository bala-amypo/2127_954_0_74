package com.example.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.R

public class Studentcontroller{
    @Autowired
    Studentservice studentservice;

    @PostMapping("/add")
    public StudentEntity
post(@RequestBody StudentEntity student){
    return
studentservice.saveData(student);
}

    @GetMapping("/get")
    public List<StudentEntity>
getAllStudents(){
    return
studentservice.getAllStudentEntity();

}

    @GetMapping("get/{id}")
    public Optional<StudentEntity>
get(@PathVariable int id){
    return
studentservice.getStudentById(id);
}
    @PutMapping("/update/{id}")
    public String update(@RequestBody StudentEntity student,@PathVariable int id){
        Optional<StudentEntity>
    existingStudent=studentservice.getStudentById(id);
        if(existingStudent.isPresent()){
            student.setId(id);

    studentservice.insertStudent(student);
          return"Student updated successfully";
        }else{
            return "Student not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        optional<StudentEntity>student=studentservice.getStudentById(id);
        if(student.isPresent()){
    studentservice.deleteStudentById(id);
          return"Student deleted successfully";
        }else{
            return "Studnet not found";
        }
    }

}