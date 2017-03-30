/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class Database {

    private List<Student> studentList = new ArrayList<>();

    /**
     * @return the studentList
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        getStudentList().add(student);
    }

    public void removeStudent(Student student) {
        getStudentList().remove(student);
    }
}
