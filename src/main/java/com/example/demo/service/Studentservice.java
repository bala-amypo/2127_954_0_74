

package com.example.practice.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.practice.entity.StudentEntity;
@Service
public class Studentservice {
    Map<Integer, StudentEntity> details = new HashMap<>();

    public StudentEntity saveData(StudentEntity student) {
        details.put(student.getId(), student);
        return student;
    }
    public java.util.List<StudentEntity> getAllStudentEntity() {
        return new java.util.ArrayList<>(details.values());
    }
     public void deleteStudentById(int id) {
        details.remove(id);
    }
       public java.util.Optional<StudentEntity> getStudentById(int id) {
        return java.util.Optional.ofNullable(details.get(id));
    }
    public void insertStudent(StudentEntity student) {
        details.put(student.getId(), student);
    }
}