package com.student.Studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    Repository repository;
    public Student getStudent(int rollno){
        return repository.getStudent(rollno);
    }

    public String addStudent(Student student) {
        return repository.addStudent(student);
    }
    public String deleteStudent(int rollno){
        return repository.deleteStudent(rollno);
    }
    public Student updateStudentCourse(int rollno, String course){
        return repository.updateStudentCourse(rollno,course);

    }
}
