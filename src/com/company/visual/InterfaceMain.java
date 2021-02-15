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

        //header
        JPanel header = new JPanel();
        header.setLayout (new FlowLayout(FlowLayout.CENTER));
        header.setBackground(Color.lightGray);

        JButton buttonOpenFile = new JButton(Constants.FILE);
        JComboBox buttonSelectDB = new JComboBox(Constants.SQL_NON_SQL);

        ActionListener openFile = new ButtonsListeners(frame, textFields, fileHelper);
        ActionListener selectDB = new DataBaseListener(frame, textFields, fileHelper);

        buttonOpenFile.addActionListener(openFile);
        buttonSelectDB.addActionListener(selectDB);

        header.add(buttonOpenFile);
        header.add(buttonSelectDB);
        frame.add(header, BorderLayout.NORTH);


        //controlPanel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBackground(Color.lightGray);

        JLabel labelCPanel = new JLabel(Constants.CONTROL_PANEL);
        JLabel labelId = new JLabel(Constants.LABEL_ID);
        JLabel labelFirstName = new JLabel(Constants.LABEL_FIRST_NAME);
        JLabel labelLastName = new JLabel(Constants.LABEL_LAST_NAME);
        JLabel labelCity = new JLabel(Constants.LABEL_CITY);
        JLabel labelAge = new JLabel(Constants.LABEL_AGE);
        JLabel labelControlPanel = new JLabel();

        JButton buttonCreate = new JButton(Constants.CREATE);
        JButton buttonUpdate = new JButton(Constants.UPDATE);
        JButton buttonDelete = new JButton(Constants.DELETE);

        ActionListener bDelete = new DeleteListener(textFields, frame, fileHelper);
        ActionListener bCreate = new CreateListener(textFields, frame, fileHelper);
        ActionListener bUpdate = new UpdateListener(textFields, frame,fileHelper);

        buttonCreate.addActionListener(bCreate);
        buttonUpdate.addActionListener(bUpdate);
        buttonDelete.addActionListener(bDelete);

        controlPanel.add(labelCPanel);
        controlPanel.add(labelId);
        controlPanel.add(textFields.getTextFieldId());
        controlPanel.add(labelFirstName);
        controlPanel.add( textFields.getTextFieldFirstName());
        controlPanel.add(labelLastName);
        controlPanel.add(textFields.getTextFieldLastName());
        controlPanel.add(labelCity);
        controlPanel.add(textFields.getTextFieldCity());
        controlPanel.add(labelAge);
        controlPanel.add(textFields.getTextFieldAge());
        controlPanel.add(labelControlPanel);
        controlPanel.add(buttonCreate);
        controlPanel.add(buttonUpdate);
        controlPanel.add(buttonDelete);

        frame.add(controlPanel,BorderLayout.EAST);


        //footer
        JPanel footer = new JPanel();
        footer.setLayout (new FlowLayout(FlowLayout.LEFT));
        footer.setBackground(Color.lightGray);
        JButton buttonClearAll = new JButton(Constants.CLEAR_ALL);
        ActionListener bClearAll = new ClearAllLiestener(frame,fileHelper);
        buttonClearAll.addActionListener(bClearAll);
        footer.add(buttonClearAll);
        frame.add(footer, BorderLayout.SOUTH);

        JPanel addPanel = new JPanel();
        addPanel.setBackground(Color.lightGray);
        frame.add(addPanel, BorderLayout.WEST);


        //main
        frame.setIconImage(ImageIO.read(new File(Constants.ICON)));
        frame.setSize(630, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - 800) / 2;
        int locationY = (screenSize.height - 600) / 2;
        frame.setBounds(locationX, locationY,800, 600);

        frame.setVisible(true);
    }
}

