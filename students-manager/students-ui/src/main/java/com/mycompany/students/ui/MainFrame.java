/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.ui;

import com.mycompany.students.model.Student;
import com.mycompany.students.service.MainFrameService;
import com.mycompany.students.serviceimpl.MainFrameServiceImpl;
import com.mycompany.students.util.NumberConstants;
import com.mycompany.students.util.StringConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro
 */
public class MainFrame extends JFrame {

    private MainFrameService mainFrameService;
    private TablePanel tablePanel;
    private StatusPanel statusPanel;
    private AddStudentForm addStudentForm;

    public MainFrame() {
        super(StringConstants.APP_NAME);
        constructAppWindow();
        setJMenuBar(createFrameMenu());
        initializeVariables();
        constructLayout();
        refreshTable();
    }

    private void refreshTable() {
        List<Student> studentList = this.mainFrameService.getAllStudents();
        this.tablePanel.setTableModel(studentList);
        this.tablePanel.updateTable();
    }

    private void constructLayout() {
        setLayout(new BorderLayout());
        add(this.tablePanel, BorderLayout.CENTER);
        add(this.statusPanel, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        this.mainFrameService = new MainFrameServiceImpl();
        this.tablePanel = new TablePanel();
        this.statusPanel = new StatusPanel();
        this.addStudentForm = new AddStudentForm(this);
    }

    private void constructAppWindow() {
        setSize(NumberConstants.APP_WINDOWS_SIZE_HEIGHT, NumberConstants.APP_WINDOWS_SIZE_WIDTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createFrameMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu(StringConstants.MAIN_MENU_FILE);
        JMenuItem openMenuItem = new JMenuItem(StringConstants.MAIN_MENU_OPEN);
        JMenuItem exitMenuItem = new JMenuItem(StringConstants.MAIN_MENU_EXIT);
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);

        JMenu windowMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW);
        JMenuItem addItem = new JMenuItem(StringConstants.MAIN_MENU_ADD_STUDENT);
        JMenuItem removeItem = new JMenuItem(StringConstants.MAIN_MENU_REMOVE_STUDENT);
        windowMenu.add(addItem);
        windowMenu.add(removeItem);

        addItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                addStudentForm.setVisible(true);
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, StringConstants.MAIN_MENU_EXIT_TEXT, StringConstants.MAIN_MENU_EXIT_TITLE, JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    System.gc();
                    System.exit(0);
                }
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
}
