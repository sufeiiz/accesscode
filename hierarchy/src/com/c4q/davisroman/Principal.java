package com.c4q.davisroman;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by davis on 4/4/15.
 */

public class Principal {
    private ArrayList<Teacher> teachers;
    private String name;

    public Principal(String name){
        teachers = new ArrayList<Teacher>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    // Given a color, return the number of students that have this
    // color lunchbox
    public int numOfStudentsWithCertainColorLunchbox(String color){
       int count = 0;

        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                for (Lunchbox box : student.lunchboxInteger.keySet()) {
                    if (box.getName().equalsIgnoreCase(color))
                        count++;
                }
            }
        }

        return count;
    }

    // Similar to the one above except that you should print the
    // names of students that have this color lunchbox.
    public void studentsWithCertainColorLunchbox(String color){
        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                for (Lunchbox box : student.lunchboxInteger.keySet()) {
                    if (box.getName().equalsIgnoreCase(color))
                        System.out.println(student.getName());
                }
            }
        }
    }

    // Given a student's name, return the student's teacher.
    // If no teacher is found, then print "new student"
    public String whoIsThisStudentsTeacher(String studentname){
        String teacherName = null;

        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                if (student.getName().equalsIgnoreCase(studentname))
                    teacherName = teacher.getName();
            }
        }

        return teacherName;
    }

    // Print the teachers who have students with less than 3 pencils
    // in their pocket.
    public void teachersThatHaveStudentsWithLessThanACertainNumberOfPencils(int numOfPencils){
        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                if (student.getNumOfPencilsInPocket() < numOfPencils) {
                    System.out.println(teacher.getName());
                    break;
                }
            }
        }
    }

}
