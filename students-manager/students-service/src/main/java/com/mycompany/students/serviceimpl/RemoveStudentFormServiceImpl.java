/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.serviceimpl;

import com.mycompany.students.query.RemoveStudentQuery;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.RemoveStudentFormService;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class RemoveStudentFormServiceImpl implements RemoveStudentFormService {

    private RemoveStudentQuery removeStudentQuery;

    public RemoveStudentFormServiceImpl() {
        this.removeStudentQuery = new RemoveStudentQuery();
    }

    @Override
    public List<Student> getAllStudents() {
        return removeStudentQuery.getAllStudent();
    }

    @Override
    public void removeStudent(Student student) {
        removeStudentQuery.removeStudent(student);
    }

}
