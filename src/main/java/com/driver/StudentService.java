package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository studentRepository=new StudentRepository();


    // to add Student in repo
    public void addStudentInRepo(Student student){
        studentRepository.addStudentData(student);
    }

    // to  add teacher in repo
    public void addTeacherInRepo(Teacher teacher){
        studentRepository.addTeacherData(teacher);
    }

    //to get student data from repo
    public Student getStudentFromRepo(String StudentName){
        return studentRepository.getStudentData(StudentName);
    }

    // to get teacher data from repo
    public Teacher getTeacherFromRepo(String TeacherName){
        return studentRepository.getTeacherData(TeacherName);
    }

    // to get all students name
    public List<String> getListOfStudentsFromRepo(){
        return studentRepository.getListOfStudents();
    }

    // to add students teacher pair
    public void addstudentsTeacherPair(String TeacherName,String StudentName){
        studentRepository.addStudentTeacherPairData(TeacherName,StudentName);
    }

    // to get student name under a teacher
    public List<String> studentUnderTeacher(String teacher){
        return studentRepository.getStudentUnderTeacher(teacher);
    }

    // to delete a teacher and students under them
    public void delTeacherAndStudent(String teacher){
        studentRepository.deleteData(teacher);
    }

    // to delete all student and teacher pair from records
    public void delAllTeacherAndStudent(){
        studentRepository.deleteAllData();
    }

}
