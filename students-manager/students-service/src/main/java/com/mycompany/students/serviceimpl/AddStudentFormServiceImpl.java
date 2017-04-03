/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.serviceimpl;

import com.mycompany.students.query.AddStudentQuery;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.AddStudentFormService;

/**
 *
 * @author Ramiro
 */
public class AddStudentFormServiceImpl implements AddStudentFormService {

    private AddStudentQuery addStudentQuery;

    public AddStudentFormServiceImpl() {
        this.addStudentQuery = new AddStudentQuery();
    }

    @Override
    public void insertStudent(Student student) {
        this.addStudentQuery.insertStudent(student);
    }

}
