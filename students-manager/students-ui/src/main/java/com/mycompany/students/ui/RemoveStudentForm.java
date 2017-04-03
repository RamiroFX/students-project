/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.ui;

import com.mycompany.students.callbacks.RemoveStudentCallback;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.RemoveStudentFormService;
import com.mycompany.students.serviceimpl.RemoveStudentFormServiceImpl;
import com.mycompany.students.util.NumberConstants;
import com.mycompany.students.util.StringConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ramiro
 */
public class RemoveStudentForm extends JDialog implements ActionListener {

    private JButton removeButton;
    private JButton cancelButton;
    private JLabel studentName;
    private JComboBox<Student> studentComboBox;
    private RemoveStudentFormService removeStudentFormService;
    private RemoveStudentCallback removeStudentCallback;

    public RemoveStudentForm(JFrame parent) {
        super(parent, StringConstants.REMOVE_STUDENT_FORM_TITLE, false);
        initializeVariables();
        loadData();
        constructLayout();
        setWindows(parent);
    }

    public void loadData() {
        this.studentComboBox.removeAllItems();
        List<Student> studentList = this.removeStudentFormService.getAllStudents();

        for (Student student : studentList) {
            this.studentComboBox.addItem(student);
        }
    }

    private void setWindows(JFrame parent) {
        this.setSize(NumberConstants.STUDENT_FORM_WINDOWS_SIZE_WIDTH, NumberConstants.STUDENT_FORM_WINDOWS_SIZE_HEIGHT);
        this.setLocationRelativeTo(parent);
    }

    private void initializeVariables() {
        this.removeStudentFormService = new RemoveStudentFormServiceImpl();
        this.studentComboBox = new JComboBox<Student>();
        this.removeButton = new JButton(StringConstants.REMOVE_STUDENT_FORM_REMOVE);
        this.cancelButton = new JButton(StringConstants.REMOVE_STUDENT_FORM_CANCEL);
        this.studentName = new JLabel(StringConstants.REMOVE_STUDENT_FORM_NAME);

        this.removeButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
    }

    private void constructLayout() {
        JPanel studentInfoPanel = new JPanel();
        JPanel studentButtonPanel = new JPanel();

        int space = 15;
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.REMOVE_STUDENT_FORM_SUBTITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        studentInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        ///// FIRST ROW /////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx++;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(studentName, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(studentComboBox, gc);

        //// BUTTON PANEL /////
        studentButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        studentButtonPanel.add(removeButton);
        studentButtonPanel.add(cancelButton);

//        Dimension cancelButtonSize = this.cancelButton.getPreferredSize();
//        this.removeButton.setPreferredSize(cancelButtonSize);
        ///// SET LAYOUT /////
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(studentButtonPanel, BorderLayout.SOUTH);
    }

    public void setCallback(RemoveStudentCallback removeStudentCallback) {
        this.removeStudentCallback = removeStudentCallback;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();

        if (src.equals(cancelButton)) {
            this.setVisible(false);
        } else if (src.equals(removeButton)) {
            Student student = (Student) this.studentComboBox.getSelectedItem();
            this.removeStudentFormService.removeStudent(student);
            this.removeStudentCallback.studentRemoved();
            this.setVisible(false);
        }
    }
}
