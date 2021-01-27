package com.company.visual;

import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfaceMain extends JFrame {

    Buttons buttons = new Buttons();
    Table table = new Table();
    ControlPanel controlPanel = new ControlPanel();

    public void createGUI()
    {
        JFrame frame = new JFrame("Dunno-s");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setSize(900,700);
        //frame.pack();//Эта команда подбирает оптимальный размер в зависимости от содержимого окна

        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.setSize(600,580);
        panelTable.setOpaque(false);

        frame.add(buttons.createHeader());
        frame.add(controlPanel.createControlPanel());
        frame.add(buttons.createFooter());

        frame.setLayout(null);
        frame.setVisible(true);
    }
}



