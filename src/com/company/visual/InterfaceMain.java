package com.company.visual;


import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class InterfaceMain extends JFrame {

    Buttons buttons = new Buttons();
    Table table = new Table();
    ControlPanel controlPanel = new ControlPanel();

    public void createGUI() throws IOException {
        JFrame frame = new JFrame("Dunno-s");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,550);

        frame.add(buttons.createHeader());
        frame.add(controlPanel.createControlPanel());
        frame.add(buttons.createFooter());
        frame.add(table.createTable());


        frame.setLayout(null);
        frame.setVisible(true);
    }
}



