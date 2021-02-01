package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;

import java.awt.*;

public class ControlPanel {
    JPanel panelControl;
    JTextField textFieldId;
    JTextField textFieldFirstName;
    JTextField textFieldLastName;
    JTextField textFieldCity;
    JTextField textFieldAge;


    public JPanel createControlPanel(){

        panelControl = new JPanel(new BorderLayout());
        panelControl.setBounds(700,60,300,580);
        panelControl.setOpaque(false);

        JLabel labelHead = new JLabel(ConstantString.HEAD_CONTROL_PANEL);
        labelHead.setBounds(30,0,130,20);

        JLabel labelId = new JLabel(ConstantString.ENTER_ID);
        labelId.setBounds(10, 25, 150, 25);
        JLabel labelFirstName = new JLabel(ConstantString.ENTER_FIRST_NAME);
        labelFirstName.setBounds(10, 95, 150, 25);
        JLabel labelLastName = new JLabel(ConstantString.ENTER_LAST_NAME);
        labelLastName.setBounds(10, 165, 150, 25);
        JLabel labelCity = new JLabel(ConstantString.ENTER_CITY);
        labelCity.setBounds(10, 235, 150, 25);
        JLabel labelAge = new JLabel(ConstantString.ENTER_AGE);
        labelAge.setBounds(10, 305, 150,25);


        textFieldId = new JTextField();
        textFieldId.setBounds(10, 50, 150, 25);
        textFieldFirstName = new JTextField();
        textFieldFirstName.setBounds(10, 120, 150, 25);
        textFieldLastName = new JTextField();
        textFieldLastName.setBounds(10, 190, 150, 25);
        textFieldCity = new JTextField();
        textFieldCity.setBounds(10, 260, 150, 25);
        textFieldAge = new JTextField();
        textFieldAge.setBounds(10, 330, 150, 25);

        panelControl.add(labelHead);
        panelControl.add(labelId);
        panelControl.add(labelFirstName);
        panelControl.add(labelLastName);
        panelControl.add(labelCity);
        panelControl.add(labelAge);

        panelControl.add(textFieldId);
        panelControl.add(textFieldFirstName);
        panelControl.add(textFieldLastName);
        panelControl.add(textFieldCity);
        panelControl.add(textFieldAge);

        panelControl.setLayout(null);
        panelControl.setVisible(true);

        return panelControl;

    }

    public JPanel getPanelControl() {
        return panelControl;
    }

    public JTextField getTextFieldId() {
        return textFieldId;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public JTextField getTextFieldLastName() {
        return textFieldLastName;
    }

    public JTextField getTextFieldCity() {
        return textFieldCity;
    }

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public void setPanelControl(JPanel panelControl) {
        this.panelControl = panelControl;
    }

    public void setTextFieldId(JTextField textFieldId) {
        this.textFieldId = textFieldId;
    }

    public void setTextFieldFirstName(JTextField textFieldFirstName) {
        this.textFieldFirstName = textFieldFirstName;
    }

    public void setTextFieldLastName(JTextField textFieldLastName) {
        this.textFieldLastName = textFieldLastName;
    }

    public void setTextFieldCity(JTextField textFieldCity) {
        this.textFieldCity = textFieldCity;
    }

    public void setTextFieldAge(JTextField textFieldAge) {
        this.textFieldAge = textFieldAge;
    }
}