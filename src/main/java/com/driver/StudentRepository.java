package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {


    HashMap<String,Student> Smap = new HashMap<>(); //we are using hashmap bcz of time complexity
    HashMap<String,Teacher> Tmap = new HashMap<>();

    HashMap<String, List<String>> pairMap = new HashMap<>();





    public  void addStudent(Student student){
        String key = student.getName();
        Smap.put(key,student);
    }

    public  void addTeacher(Teacher teacher){
        String key = teacher.getName();
        Tmap.put(key,teacher);

    }
    public  void Pairing(String Tname, String Sname){


        if(Smap.containsKey(Sname) && Tmap.containsKey(Tname)){
            List<String> studentList = new ArrayList<>();
            if(pairMap.containsKey(Tname))
                studentList = pairMap.get(Tname);
                studentList.add(Sname);
                pairMap.put(Tname,studentList);
        }
    }
    public  Student getStudentbyname(String sNaam ){
        if(Smap.containsKey(sNaam)){
            Student student = Smap.get(sNaam);
            return  student;
        }else{
            return null;
        }
    }
    public  Teacher getStudentbyteacher(String TNaam){
        if(Tmap.containsKey(TNaam)){
            Teacher teacher = Tmap.get(TNaam);
            return  teacher;
        }else{
            return null;
        }
    }

  public List<String > getStudentsByTname(String Tname){
      List<String > movieList = new ArrayList<>();
        if(pairMap.containsKey(Tname))
            movieList = pairMap.get(Tname);
        return movieList;


  }

  public  List<String> getAllStudents(){
      return  new ArrayList<>(Smap.keySet());
  }
  public void  deleteByTecherName(String Tname){
      List<String > StdentList = new ArrayList<>();
        if(pairMap.containsKey(Tname)){
            StdentList = pairMap.get(Tname);
        }
        for(String student : StdentList){
            if(Smap.containsKey(student)) {
                Smap.remove(student);
            }
        }

        Tmap.remove(Tname);
       if(pairMap.containsKey(Tname)){
           pairMap.remove(Tname);
       }
  }
  public void  deleteAll( ){
        for(String student : pairMap.keySet()){
            Smap.remove(student);
        }
        Tmap = new HashMap<>();
        pairMap = new HashMap<>();


  }


}
