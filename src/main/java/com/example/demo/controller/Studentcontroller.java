package com.example.practice.ontroller;

public class Studentcontroller{
    @Autowired
    Studentservice studentservice;

    @PostMapping("/add")
    public StudentEntity
post(@RequestBody StudentEntity student){
    return
}
}