package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;

public class ControlPanel {

    public ControlPanel(){

        JLabel label1 = new JLabel(ConstantString.ENTER_ID);
        label1.setBounds(50, 30, 250, 40);
        JLabel label2 = new JLabel(ConstantString.ENTER_FIRST_NAME);
        label2.setBounds(50, 90, 250, 40);
        JLabel label3 = new JLabel(ConstantString.ENTER_LAST_NAME);
        label3.setBounds(50, 150, 250, 40);
        JLabel label4 = new JLabel(ConstantString.ENTER_AGE);
        label4.setBounds(50, 210, 250, 40);
        JLabel label5 = new JLabel(ConstantString.ENTER_CITY);
        label5.setBounds(50, 270, 250,40);

        JTextField textField1 = new JTextField();
        textField1.setBounds(50, 60, 250, 40);
        JTextField textField2 = new JTextField();
        textField2.setBounds(50, 120, 250, 40);
        JTextField textField3 = new JTextField();
        textField3.setBounds(50, 180, 250, 40);
        JTextField textField4 = new JTextField();
        textField4.setBounds(50, 240, 250, 40);
        JTextField textField5 = new JTextField();
        textField5.setBounds(50, 300, 250, 40);

        JFrame f = new JFrame();
        f.setSize(700, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);

        f.add(textField1);
        f.add(textField2);
        f.add(textField3);
        f.add(textField4);
        f.add(textField5);
    }

}