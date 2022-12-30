package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public void addStudent(Student student){
        studentRepository.addStudent(student);

    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);

    }

    public  void pair(String Tname, String Sname){
        studentRepository.Pairing(Tname,Sname);

    }
    public  Student getStudentName(String sname){
        return studentRepository.getStudentbyname(sname);
    }
    public  Teacher getTeachernaaame(String Tname){
        return  studentRepository.getStudentbyteacher(Tname);
    }
    public List<String > getListOfTname(String Tname){
        return studentRepository.getStudentsByTname(Tname);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public void  delete( String Tname){
        studentRepository.deleteByTecherName(Tname);
    }
    public  void deleteAlll(){
        studentRepository.deleteAll();
    }




}
