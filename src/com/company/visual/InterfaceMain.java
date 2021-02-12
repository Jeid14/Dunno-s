package com.company.visual;

import com.company.Listeners.*;
import com.company.utils.Constants;
import com.company.utils.FileHelper;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class InterfaceMain extends JFrame {
    JFrame frame = new JFrame(Constants.TEAM_NAME);
    TextFields textFields = new TextFields();

    FileHelper fileHelper = new FileHelper();

    public void createFrame() throws IOException {

        textFields.getTextFieldId().setBounds(500, 70, 130, 25);

        textFields.getTextFieldFirstName().setBounds(500, 120, 130, 25);

        textFields.getTextFieldLastName().setBounds(500, 170, 130, 25);

        textFields.getTextFieldCity().setBounds(500, 220, 130, 25);

        textFields.getTextFieldAge().setBounds(500, 270, 130, 25);

        JLabel labelId = new JLabel(Constants.LABEL_ID);
        labelId.setBounds(500, 50, 100, 20);
        JLabel labelFirstName = new JLabel(Constants.LABEL_FIRST_NAME);
        labelFirstName.setBounds(500, 100, 100, 20);
        JLabel labelLastName = new JLabel(Constants.LABEL_LAST_NAME);
        labelLastName.setBounds(500, 150, 100, 20);
        JLabel labelCity = new JLabel(Constants.LABEL_CITY);
        labelCity.setBounds(500, 200, 100, 20);
        JLabel labelAge = new JLabel(Constants.LABEL_AGE);
        labelAge.setBounds(500, 250, 100, 20);
        JLabel labelControlPanel = new JLabel();
        labelControlPanel.setBounds(500, 30, 100, 20);

        JButton buttonCreate = new JButton(Constants.CREATE);
        buttonCreate.setBounds(500, 303, 130, 30);

        ActionListener bCreate = new CreateListener(textFields, frame, fileHelper);
        buttonCreate.addActionListener(bCreate);

        JButton buttonUpdate = new JButton(Constants.UPDATE);
        buttonUpdate.setBounds(500, 348, 130, 30);
        ActionListener bUpdate = new UpdateListener(textFields, frame,fileHelper);

        buttonUpdate.addActionListener(bUpdate);
        JButton buttonDelete = new JButton(Constants.DELETE);
        buttonDelete.setBounds(500, 393, 130, 30);

        ActionListener bDelete = new DeleteListener(textFields, frame, fileHelper);
        buttonDelete.addActionListener(bDelete);
        JButton buttonOpenFile = new JButton(Constants.FILE);
        ActionListener open = new ButtonsListeners(frame, textFields, fileHelper);
        buttonOpenFile.addActionListener(open);
        buttonOpenFile.setBounds(20, 10, 120, 30);


        JComboBox jComboBox = new JComboBox(Constants.SQL_NON_SQL);
        jComboBox.setBounds(160, 10, 120, 30);
        ActionListener dTListener = new DataBaseListener(frame, textFields, fileHelper);
        jComboBox.addActionListener(dTListener);
        jComboBox.setBackground(Color.lightGray);


        JButton buttonClearAll = new JButton(Constants.CLEAR_ALL);
        buttonClearAll.setBounds(10, 385, 150, 40);
        ActionListener dCAll = new ClearAllLiestener(frame,fileHelper);
        buttonClearAll.addActionListener(dCAll);


        frame.add(labelId);
        frame.add(labelFirstName);
        frame.add(labelLastName);
        frame.add(labelCity);
        frame.add(labelAge);
        frame.add(labelControlPanel);

        frame.getContentPane().setBackground(Color.decode(Constants.COLOR_MAIN_FRAME));
        buttonUpdate.setBackground(Color.lightGray);
        buttonCreate.setBackground(Color.lightGray);
        buttonDelete.setBackground(Color.lightGray);
        buttonOpenFile.setBackground(Color.lightGray);
        buttonClearAll.setBackground(Color.lightGray);

        frame.add(textFields.getTextFieldId());
        frame.add(textFields.getTextFieldFirstName());
        frame.add(textFields.getTextFieldLastName());
        frame.add(textFields.getTextFieldCity());
        frame.add(textFields.getTextFieldAge());

        frame.setLocation(550, 250);

        frame.add(buttonCreate);
        frame.add(buttonUpdate);
        frame.add(buttonDelete);
        frame.add(buttonOpenFile);
        frame.add(jComboBox);


        frame.add(buttonClearAll);
        frame.setIconImage(ImageIO.read(new File(Constants.ICON)));

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
//


}



