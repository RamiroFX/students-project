/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.serviceimpl;

import com.mycompany.students.model.Database;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.MainFrameService;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class MainFrameServiceImpl implements MainFrameService {

    Database database;

    public MainFrameServiceImpl() {
        this.database = new Database();
    }

    @Override
    public List<Student> getAllStudents() {
        return database.getStudentList();
    }

}
