/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.query;

import com.mycompany.students.model.EntityManagerHandler;
import com.mycompany.students.model.Student;

/**
 *
 * @author Ramiro
 */
public class AddStudentQuery extends AbstractQuery {

    public AddStudentQuery() {
    }

    public void insertStudent(Student student) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(student);
        EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
    }

}
