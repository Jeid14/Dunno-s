package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;

import java.awt.*;

public class ControlPanel {
    private final JTextField textFieldId;
    private final JTextField textFieldFirstName;
    private final JTextField textFieldLastName;
    private final JTextField textFieldAge;
    private final JTextField textFieldCity;
    private final JPanel panelControl;


    public ControlPanel(JTextField textFieldId, JTextField textFieldFirstName, JTextField textFieldCity,JTextField textFieldAge,JTextField textFieldLastName) {
        panelControl = new JPanel(new BorderLayout());
        panelControl.setBounds(700, 60, 300, 580);
        panelControl.setOpaque(false);

        this.textFieldId = textFieldId;
        this.textFieldFirstName = textFieldFirstName;
        this.textFieldLastName = textFieldLastName;
        this.textFieldAge = textFieldAge;
        this.textFieldCity = textFieldCity;



        textFieldId.setBounds(10, 50, 150, 25);

        textFieldFirstName.setBounds(10, 120, 150, 25);

        textFieldLastName.setBounds(10, 190, 150, 25);

        textFieldCity.setBounds(10, 260, 150, 25);

        textFieldAge.setBounds(10, 330, 150, 25);




    }
    public JPanel createControlPanel(){
        JLabel labelHead = new JLabel(ConstantString.HEAD_CONTROL_PANEL);
        labelHead.setBounds(30, 0, 130, 20);

        JLabel labelId = new JLabel(ConstantString.ENTER_ID);
        labelId.setBounds(10, 25, 150, 25);
        JLabel labelFirstName = new JLabel(ConstantString.ENTER_FIRST_NAME);
        labelFirstName.setBounds(10, 95, 150, 25);
        JLabel labelLastName = new JLabel(ConstantString.ENTER_LAST_NAME);
        labelLastName.setBounds(10, 165, 150, 25);
        JLabel labelCity = new JLabel(ConstantString.ENTER_CITY);
        labelCity.setBounds(10, 235, 150, 25);
        JLabel labelAge = new JLabel(ConstantString.ENTER_AGE);
        labelAge.setBounds(10, 305, 150, 25);

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


}