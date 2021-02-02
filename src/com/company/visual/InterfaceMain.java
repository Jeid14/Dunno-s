package com.company.visual;

import com.company.Listeners.ButtonsListeners;
import com.company.Listeners.TableListener;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import java.io.IOException;
import java.util.List;

public class InterfaceMain extends JFrame{
    JFrame frame = new JFrame("Dunno-s");


    JTextField textFieldId = new JTextField();
    JTextField textFieldFirstName= new JTextField();
    JTextField textFieldLastName= new JTextField();
    JTextField textFieldAge= new JTextField();
    JTextField textFieldCity= new JTextField();

    ControlPanel controlPanel = new ControlPanel(textFieldId ,textFieldFirstName, textFieldLastName, textFieldAge, textFieldCity);
    Buttons buttons = new Buttons(frame, controlPanel);


    public void createGUI() throws IOException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,550);

        frame.add(buttons.createHeader());
        frame.add(controlPanel.createControlPanel());
        frame.add(buttons.createFooter());

        ButtonsListeners buttonsListeners = new ButtonsListeners(buttons.panelHeader, frame, controlPanel);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}



