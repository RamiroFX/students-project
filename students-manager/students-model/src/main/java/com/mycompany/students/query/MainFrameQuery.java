/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.query;

import com.mycompany.students.model.EntityManagerHandler;
import com.mycompany.students.model.Student;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class MainFrameQuery extends AbstractQuery {

    public MainFrameQuery() {
    }

    public List<Student> getStudentList() {
        open();
        String jpql = "SELECT s FROM Student s";
        Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(jpql);
        List<Student> studentList = query.getResultList();
        return studentList;
    }

}
