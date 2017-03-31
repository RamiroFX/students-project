/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.ui;

import com.mycompany.students.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ramiro
 */
public class TableModel extends AbstractTableModel {

    List<Student> studentList;
    private String[] colNames = {"Id", "Name", "Age", "Country", "ZipCode"};

    public TableModel() {
        studentList = new ArrayList<Student>();
    }

    @Override
    public String getColumnName(int i) {
        return this.colNames[i];
    }

    @Override
    public int getRowCount() {
        return this.studentList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Student student = this.studentList.get(rowIndex);
        switch (colIndex) {
            case 0: {
                return student.getId();
            }
            case 1: {
                return student.getName();
            }
            case 2: {
                return student.getAge();
            }
            case 3: {
                return student.getCountry();
            }
            case 4: {
                return student.getZipCode();
            }
            default: {
                return null;
            }
        }
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
