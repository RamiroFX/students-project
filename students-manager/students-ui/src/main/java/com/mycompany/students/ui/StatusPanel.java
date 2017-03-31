/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.ui;

import com.mycompany.students.util.StringConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ramiro
 */
public class StatusPanel extends JPanel {

    private JLabel statusLabel;
    private JLabel timeLabel;
    private Timer timer;

    public StatusPanel() {
        initializeVariables();
        constructLayout();
        startTimer();
    }

    private void constructLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(this.statusLabel);
        add(this.timeLabel);
    }

    public void startTimer() {
        this.timer.start();
    }

    public void stopTimer() {
        this.timer.setRunning(false);
    }

    private void initializeVariables() {
        this.statusLabel = new JLabel(StringConstants.STATUS_PANEL_TEXT);
        this.timeLabel = new JLabel();
        this.timer = new Timer(timeLabel);
    }

}
