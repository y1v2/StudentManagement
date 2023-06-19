package com.student.Studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class controller {
    @Autowired
    StudentService studentService;
   @GetMapping("/get_info")
   public ResponseEntity getStudent(@RequestParam("id") int rollNo){
        Student s=  studentService.getStudent(rollNo);
        if(s==null){
            return new ResponseEntity("student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
   }
   @PostMapping("/add")
   public ResponseEntity addStudent(@RequestBody Student student){
     String s=  studentService.addStudent(student);
     return new ResponseEntity(s, HttpStatus.ACCEPTED);
   }

   @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int rollNo){
     String s= studentService.deleteStudent(rollNo);
     if(s==null){
         return new ResponseEntity("Student not present in database", HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity(s, HttpStatus.ACCEPTED);
   }
   @PutMapping("/update/{id}/{course}")
    public ResponseEntity updateStudentCourse(@PathVariable("id") int rollNo, @PathVariable("course") String course){
       Student s = studentService.updateStudentCourse(rollNo, course);
       if(s==null){
           return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity(s, HttpStatus.ACCEPTED);
   }


}
