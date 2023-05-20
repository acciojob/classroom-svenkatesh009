package com.driver;

import java.util.*;

public class StudentRepository {
    private Map<String, List<String>> studentTeacherdata=new HashMap<>();
    private Map<String,Student> studentsData=new HashMap<>();
    private Map<String,Teacher> teachersData=new HashMap<>();

    // to add student
    public void addStudentData(Student student){
        studentsData.put(student.getName(), student);
    }



    // to add teacher
    public void addTeacherData(Teacher teacher){
        teachersData.put(teacher.getName(), teacher);
    }



    // to get the student
    public Student getStudentData(String name){
            return studentsData.getOrDefault(studentsData.get(name),null);
    }



    // to get the teacher
    public Teacher getTeacherData(String name){
            return teachersData.getOrDefault(teachersData.get(name),null);
    }



    // to get the list of students
    public List<String> getListOfStudents(){
        List<String> currListOfStudent=new ArrayList<>();
        currListOfStudent.addAll(studentsData.keySet());
        return currListOfStudent;
    }




    // to add student-teacher pair
    public void addStudentTeacherPairData(String nameOfTeacher,String nameOfStudent){
        if(!studentsData.containsKey(nameOfStudent) || !teachersData.containsKey(nameOfTeacher)){
            return;
        }
        else{
            if(studentTeacherdata.containsKey(nameOfTeacher)){
                List<String> oldStudentsdata=studentTeacherdata.get(nameOfTeacher);
                oldStudentsdata.add(nameOfStudent);
                studentTeacherdata.put(nameOfTeacher,oldStudentsdata);
                Teacher teacher=teachersData.get(nameOfTeacher);
                teacher.setNumberOfStudents(oldStudentsdata.size());
            }
            else{
                List<String> newStudentsdata=new ArrayList<>();
                newStudentsdata.add(nameOfStudent);
                studentTeacherdata.put(nameOfTeacher,newStudentsdata);
                Teacher teacher=teachersData.get(nameOfTeacher);
                teacher.setNumberOfStudents(1);
            }
        }
    }



    // to get the list of students under a teacher
    public List<String> getStudentUnderTeacher(String name){

        if(studentTeacherdata.containsKey(name)){
            return studentTeacherdata.get(name);
        }
        return new ArrayList<>();

    }



    //to delete a specific student-teachers pair data
    public void deleteData(String tname){
        if(!teachersData.containsKey(tname)){
            return;
        }
        else{
            teachersData.remove(tname);
            if(!studentTeacherdata.containsKey(tname)) return;
            List<String> studentNames=studentTeacherdata.get(tname);
            for(String sname:studentNames){
                studentsData.remove(sname);
            }
            studentTeacherdata.remove(tname);
        }
    }



    // to delete all student-teachers data in pair
    public void deleteAllData(){
        for(String tname:studentTeacherdata.keySet()){
            deleteData(tname);
        }
    }
}
