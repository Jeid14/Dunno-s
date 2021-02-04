package com.company.visual;


import com.company.Listeners.*;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

public class InterfaceMain extends JFrame {
    JFrame frame = new JFrame("Dunno-s");
    TextFilds textFilds = new TextFilds();
    String[] sqlNonSql = new String[]{"DATABASE","SQL-PostgresSql","SQL-H2","SQL-mySql","NonSQL"};
    //Table table = new Table(frame,textFilds);
    FileHelper fileHelper = new FileHelper();

    public void createFrame() throws IOException {

        textFilds.getTextFieldId().setBounds(500, 70, 100, 20);

        textFilds.getTextFieldFirstName().setBounds(500, 120, 100, 20);

        textFilds.getTextFieldLastName().setBounds(500, 170, 100, 20);

        textFilds.getTextFieldCity().setBounds(500, 220, 100, 20);

        textFilds.getTextFieldAge().setBounds(500, 270, 100, 20);

        JLabel labelId = new JLabel(ConstantString.ENTER_ID);
        labelId.setBounds(500, 50, 100, 20);
        JLabel labelFirstName = new JLabel(ConstantString.ENTER_FIRST_NAME);
        labelFirstName.setBounds(500, 100, 100, 20);
        JLabel labelLastName = new JLabel(ConstantString.ENTER_LAST_NAME);
        labelLastName.setBounds(500, 150, 100, 20);
        JLabel labelCity = new JLabel(ConstantString.ENTER_CITY);
        labelCity.setBounds(500, 200, 100, 20);
        JLabel labelAge = new JLabel(ConstantString.ENTER_AGE);
        labelAge.setBounds(500, 250, 100, 20);
        JLabel labelControlPanel = new JLabel();
        labelControlPanel.setBounds(500, 30, 100, 20);

        JButton buttonCreate = new JButton(ConstantString.CREATE);
        buttonCreate.setBounds(500, 300, 100, 20);

        ActionListener bCreate = new CreateListener(textFilds, frame,fileHelper);
        buttonCreate.addActionListener(bCreate);

        JButton buttonUpdate = new JButton(ConstantString.UPDATE);
        buttonUpdate.setBounds(500, 320, 100, 20);
        ActionListener bUodate = new UpdateListener(textFilds,frame);
        buttonUpdate.addActionListener(bUodate);
        JButton buttonDelete = new JButton(ConstantString.DELETE);
        buttonDelete.setBounds(500, 340, 100, 20);
        ActionListener bDelete = new DeleteListener(textFilds, frame,fileHelper);
        buttonDelete.addActionListener(bDelete);
        JButton buttonOpenFile = new JButton("File");
        ActionListener open = new ButtonsListeners(frame, textFilds,fileHelper);
        buttonOpenFile.addActionListener(open);
        buttonOpenFile.setBounds(50, 10, 100, 20);


        JComboBox jComboBox = new JComboBox(sqlNonSql);
        jComboBox.setBounds(160,10,110,20);
        ActionListener dTListener = new DataBaseListener(frame,textFilds,fileHelper);
        jComboBox.addActionListener(dTListener);


        JButton buttonClearAll = new JButton("CLEAR ALL");
        buttonClearAll.setBounds(50, 360, 100, 20);
        ActionListener dCAll = new ClearAllLiestener(frame);
        buttonClearAll.addActionListener(dCAll);


        frame.add(labelId);
        frame.add(labelFirstName);
        frame.add(labelLastName);
        frame.add(labelCity);
        frame.add(labelAge);
        frame.add(labelControlPanel);

        frame.add(textFilds.getTextFieldId());
        frame.add(textFilds.getTextFieldFirstName());
        frame.add(textFilds.getTextFieldLastName());
        frame.add(textFilds.getTextFieldCity());
        frame.add(textFilds.getTextFieldAge());

        frame.setLocation(550, 300);

        frame.add(buttonCreate);
        frame.add(buttonUpdate);
        frame.add(buttonDelete);
        frame.add(buttonOpenFile);
        frame.add(jComboBox);



        frame.add(buttonClearAll);

        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public  JFrame getFrame(){
        return frame;
    }
//


}



