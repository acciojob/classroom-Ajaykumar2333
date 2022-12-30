package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDB=new HashMap<>();
    HashMap<String,Teacher> teacherDB=new HashMap<>();
    HashMap<String, List<String>> pairmap=new HashMap<>();
    void addStudent(Student student){
        String name=student.getName();
        studentDB.put(name,student);

    }
    void addTeacher(Teacher teacher){
        String name=teacher.getName();
        teacherDB.put(name,teacher);
    }

    void addStudentTeacherPair(String studentName,String teacherName){
        if(studentDB.containsKey(studentName) && teacherDB.containsKey(teacherName)){
            if(!pairmap.containsKey(teacherName)){
                List<String> st=new ArrayList<>();
                st.add(studentName);
                pairmap.put(teacherName,st);
            }else {
                pairmap.get(teacherName).add(studentName);
            }
        }
    }

    Student getStudentByName(String studentName){
        return studentDB.get(studentName);
    }

    Teacher getTeacherByName(String teacherName){
        return teacherDB.get(teacherName);
    }

    List getStudentsByTeacherName(String teacherName){
        List<String> stnd=new ArrayList<>();
        if(pairmap.containsKey(teacherName)){
            stnd=pairmap.get(teacherName);
        }
        return stnd;
    }

    List getAllStudents(){
        List<String> std=new ArrayList<>();
        for(String s:studentDB.keySet()){
            std.add(s);
        }
        return std;
    }

    void deleteTeacherByName(String teacher){
        if(teacherDB.containsKey(teacher)){
            if (pairmap.containsKey(teacher)) {
                for(String s:pairmap.get(teacher)){
                    studentDB.remove(s);
                }
                pairmap.remove(teacher);
            }
            teacherDB.remove(teacher);
        }
    }

    void deleteAllTeachers(){
        ArrayList<String> st=new ArrayList<>();
        for(String s:pairmap.keySet()){
            for (String std:pairmap.get(s)){
                st.add(std);
            }
        }

        for (String ss:st){
            studentDB.remove(ss);
        }
    }
}