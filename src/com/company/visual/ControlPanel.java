package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;

public class ControlPanel {

    public ControlPanel(){

        JLabel label1 = new JLabel(ConstantString.ENTER_ID);
        label1.setBounds(50, 50, 250, 40);
        JLabel label2 = new JLabel(ConstantString.ENTER_FIRST_NAME);
        label2.setBounds(50, 150, 250, 40);
        JLabel label3 = new JLabel(ConstantString.ENTER_LAST_NAME);
        label3.setBounds(50, 250, 250, 40);
        JLabel label4 = new JLabel(ConstantString.ENTER_AGE);
        label4.setBounds(50, 350, 250, 40);
        JLabel label5 = new JLabel(ConstantString.ENTER_CITY);
        label5.setBounds(50, 450, 250,40);

        JTextField textField1 = new JTextField();
        textField1.setBounds(50, 100, 250, 40);
        JTextField textField2 = new JTextField();
        textField2.setBounds(50, 200, 250, 40);
        JTextField textField3 = new JTextField();
        textField3.setBounds(50, 300, 250, 40);
        JTextField textField4 = new JTextField();
        textField4.setBounds(50, 400, 250, 40);
        JTextField textField5 = new JTextField();
        textField5.setBounds(50, 500, 250, 40);

    }

}
