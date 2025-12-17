package com.example.practice.ontroller;

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

}