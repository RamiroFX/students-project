/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Ramiro
 */
public enum EntityManagerHandler {

    INSTANCE;

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("students-persistence-unit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public void open() {
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    public void shutdown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
