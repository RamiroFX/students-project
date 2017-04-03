/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.serviceimpl;

import com.mycompany.students.query.MainFrameQuery;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.MainFrameService;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class MainFrameServiceImpl implements MainFrameService {

    private MainFrameQuery mainFrameQuery;

    public MainFrameServiceImpl() {
        this.mainFrameQuery = new MainFrameQuery();
    }

    @Override
    public List<Student> getAllStudents() {
        return mainFrameQuery.getStudentList();
    }

    @Override
    public void shutdown() {
        this.mainFrameQuery.shutdown();
    }

}
