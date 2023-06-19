package com.student.Studentmanagementportal;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {
    Map<Integer, Student> Studentmap = new HashMap<>();

    public Student getStudent(int rollno){
        return Studentmap.get(rollno);
    }

    public String addStudent(Student student) {
        if(Studentmap.containsKey(student.getRollNo())){
            return "Student already in the database";
        } else {
            Studentmap.put(student.getRollNo(), student);
        }
        return  "Student added in the database";
    }
    public String deleteStudent(int rollno){
        if(!Studentmap.containsKey(rollno)){
            return null;
        }
        Studentmap.remove(rollno);
        return "student deleted successfully";
    }
    public Student updateStudentCourse(int rollno, String course){
       Student s = Studentmap.get(rollno);
       s.setCourse(course);
       Studentmap.put(s.getRollNo(),s);
       return s;
    }
}
