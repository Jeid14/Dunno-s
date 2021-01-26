package com.company.visual;

import javax.swing.*;
import java.awt.*;

public class InterfaceMain extends JFrame {

    private JButton buttonOpenFile;
    private JButton buttonSelectionDB;
    private JButton buttonClearAll;

    public void createGUI()
    {
        JFrame frame = new JFrame("Dunno-s");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setSize(500,500);
        //frame.pack();//Эта команда подбирает оптимальный размер в зависимости от содержимого окна

        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setBounds(850, 50, 100, 30);

        buttonSelectionDB = new JButton("Database");
        buttonSelectionDB.setBounds(850, 100, 100, 30);

        buttonClearAll = new JButton("Clear All");
        buttonClearAll.setBounds(150, 500, 100, 30);

        frame.add(buttonOpenFile);
        frame.add(buttonSelectionDB);
        frame.add(buttonClearAll);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}



