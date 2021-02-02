package com.company.visual;

import com.company.Listeners.ButtonsListeners;
import com.company.utils.ConstantString;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {

    public JButton buttonOpenFile;
    public JButton buttonSelectionDB;
    public JButton buttonClearAll;
    JPanel panelHeader;
    JFrame frame;
    private JPanel controlPanel;

    public Buttons(JFrame frame, JPanel controlPanel){
        this.frame = frame;
        this.controlPanel = controlPanel;
    }


    public JPanel createHeader() {

        panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBounds(0, 0, 900, 60);
        panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHeader.setOpaque(false);

        buttonOpenFile = new JButton(ConstantString.BUTTON_OPEN_FILE);
        buttonOpenFile.setBounds(10, 20, 100, 20);

        buttonSelectionDB = new JButton(ConstantString.BUTTON_DATABASE);
        buttonSelectionDB.setBounds(140, 20, 100, 20);
        ActionListener actionListener = new ButtonsListeners(panelHeader,frame, (ControlPanel) controlPanel);
        buttonOpenFile.addActionListener(actionListener);

        panelHeader.add(buttonOpenFile);
        panelHeader.add(buttonSelectionDB);

        panelHeader.setLayout(null);
        panelHeader.setVisible(true);

        return panelHeader;
    }

    public JPanel createFooter() {

        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BoxLayout(panelFooter, BoxLayout.Y_AXIS));
        panelFooter.setBounds(0, 440, 500, 60);
        panelFooter.setOpaque(false);

        buttonClearAll = new JButton(ConstantString.BUTTON_CLEAR_ALL);
        buttonClearAll.setBounds(0, 460, 100, 20);

        panelFooter.add(buttonClearAll);

        panelFooter.setVisible(true);
        return panelFooter;
    }


}
