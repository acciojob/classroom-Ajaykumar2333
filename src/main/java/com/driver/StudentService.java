package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    void addStudent(Student student){
        studentRepository.addStudent(student);

    }
    void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    void addStudentTeacherPair(String studentName , String teacherName){
        studentRepository.addStudentTeacherPair(studentName,teacherName);
    }

    Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }


    Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherByName(teacherName);
    }

    List getStudentsByTeacherName(String teacherName){
        return studentRepository.getStudentsByTeacherName(teacherName);
    }


    List getAllStudents(){
        return studentRepository.getAllStudents();
    }

    void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}