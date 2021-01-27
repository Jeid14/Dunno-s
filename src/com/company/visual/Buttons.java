package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;
import java.awt.*;

public class Buttons {

    public JButton buttonOpenFile;
    public JButton buttonSelectionDB;
    public JButton buttonClearAll;


   public JPanel createHeader(){

        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBounds(0,0,900,60);
        panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHeader.setOpaque(false);

        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setBounds(10, 20, 100, 20);

        buttonSelectionDB = new JButton("Database");
        buttonSelectionDB.setBounds(140, 20, 100, 20);

       /*buttonClearAll = new JButton("Clear All");
       buttonClearAll.setBounds(270, 20, 100, 20);*/

       //panelHeader.add(buttonClearAll);
       panelHeader.add(buttonOpenFile);
       panelHeader.add(buttonSelectionDB);

       panelHeader.setLayout(null);
       panelHeader.setVisible(true);

        return panelHeader;
    }

    public JPanel createFooter(){

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BoxLayout(panelFooter,BoxLayout.Y_AXIS));
        panelFooter.setBounds(0,440,900,60);
        panelFooter.setOpaque(false);

        buttonClearAll = new JButton(ConstantString.BUTTON_CLEAR_ALL);
        buttonClearAll.setBounds(0, 460, 100, 20);

        panelFooter.add(buttonClearAll);

        panelFooter.setVisible(true);
        return panelFooter;
    }
}
