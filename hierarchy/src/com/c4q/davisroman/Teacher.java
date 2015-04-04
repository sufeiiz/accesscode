package com.c4q.davisroman;

import java.util.ArrayList;

/**
 * Skeleton created by davis on 4/4/15.
 * Completed by sufeiiz
 */

public class Teacher {
    private ArrayList<Student> students;
    private String name;

    public Teacher(String name){
        students = new ArrayList<Student>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
}
