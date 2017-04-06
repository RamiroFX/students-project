/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.ui;

import com.mycompany.students.callbacks.AddStudentCallback;
import com.mycompany.students.model.Student;
import com.mycompany.students.service.AddStudentFormService;
import com.mycompany.students.serviceimpl.AddStudentFormServiceImpl;
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Ramiro
 */
public class AddStudentForm extends JDialog implements ActionListener {

    private JButton saveButton;
    private JButton cancelButton;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel countryLabel;
    private JLabel zipCodeLabel;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField countryField;
    private JTextField zipCodeField;
    private AddStudentFormService addStudentFormService;
    private AddStudentCallback addStudentCallback;

    public AddStudentForm(JFrame parentFrame) {
        super(parentFrame, StringConstants.ADD_STUDENT_FORM_TITLE, false);
        initializeVariables();
        constructLayout();
        setWindows(parentFrame);
    }

    private void initializeVariables() {
        this.addStudentFormService = new AddStudentFormServiceImpl();
        this.saveButton = new JButton(StringConstants.ADD_STUDENT_FORM_SAVE);
        this.cancelButton = new JButton(StringConstants.ADD_STUDENT_FORM_CANCEL);
        this.saveButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
        this.nameLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_NAME);
        this.ageLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_AGE);
        this.countryLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_COUNTRY);
        this.zipCodeLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_ZIPCODE);
        this.nameField = new JTextField(NumberConstants.ADD_STUDENT_FORM_TEXTFILED_LENGHT);
        this.ageField = new JTextField(NumberConstants.ADD_STUDENT_FORM_TEXTFILED_LENGHT);
        this.countryField = new JTextField(NumberConstants.ADD_STUDENT_FORM_TEXTFILED_LENGHT);
        this.zipCodeField = new JTextField(NumberConstants.ADD_STUDENT_FORM_TEXTFILED_LENGHT);
    }

    private void constructLayout() {

        JPanel studentInfoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        int space = 15;
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.ADD_STUDENT_FORM_SUBTITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        studentInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        // ///// First row /////////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(nameLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(nameField, gc);

        // ////// Next row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(ageLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(ageField, gc);

        // ////// Next row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(countryLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(countryField, gc);

        // ////// Next row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        studentInfoPanel.add(zipCodeLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        studentInfoPanel.add(zipCodeField, gc);

        // ////////// Buttons Panel ///////////////
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = cancelButton.getPreferredSize();
        saveButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void setWindows(JFrame parentFrame) {
        setSize(NumberConstants.STUDENT_FORM_WINDOWS_SIZE_WIDTH, NumberConstants.STUDENT_FORM_WINDOWS_SIZE_HEIGHT);
        setLocationRelativeTo(parentFrame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(this.saveButton)) {
            String name = nameField.getText();
            String country = countryField.getText();
            int age = Integer.valueOf(ageField.getText());
            int zipCode = Integer.valueOf(zipCodeField.getText());
            Student student = new Student(name, country, age, zipCode);

            addStudentFormService.insertStudent(student);

            setVisible(false);
            addStudentCallback.studentSaved();
        } else if (source.equals(this.cancelButton)) {
            setVisible(false);
        }
    }

    public void setCallback(AddStudentCallback addStudentCallback) {
        this.addStudentCallback = addStudentCallback;
    }
}
