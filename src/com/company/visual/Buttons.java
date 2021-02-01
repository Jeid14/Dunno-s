package com.company.visual;

import com.company.Listeners.ButtonsListeners;
import com.company.utils.ConstantString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {

    private JButton buttonOpenFile;
    private JButton buttonSelectionDB;
    private JButton buttonClearAll;
    private JPanel panelHeader;
    private JPanel panelFooter;
    InterfaceMain interfaceMain;
    ControlPanel controlPanel;
    ActionListener actionListener;


    Buttons( InterfaceMain interfaceMain, ControlPanel controlPanel){
    this.interfaceMain = interfaceMain;
    this.controlPanel = controlPanel;
    }

   public JPanel createHeader(){

        panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBounds(0,0,900,60);
        panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelHeader.setOpaque(false);

        buttonOpenFile = new JButton(ConstantString.BUTTON_OPEN_FILE);
        buttonOpenFile.setBounds(10, 20, 100, 20);
        actionListener = new ButtonsListeners(interfaceMain.getFrame(), controlPanel.panelControl);
        buttonOpenFile.addActionListener(actionListener);

        buttonSelectionDB = new JButton(ConstantString.BUTTON_DATABASE);
        buttonSelectionDB.setBounds(140, 20, 100, 20);

        panelHeader.add(buttonOpenFile);
        panelHeader.add(buttonSelectionDB);

        panelHeader.setLayout(null);
        panelHeader.setVisible(true);

        return panelHeader;
    }

    public JPanel createFooter(){

        panelFooter = new JPanel();
        panelFooter.setLayout(new BoxLayout(panelFooter,BoxLayout.Y_AXIS));
        panelFooter.setBounds(0,440,900,60);
        panelFooter.setOpaque(false);

        buttonClearAll = new JButton(ConstantString.BUTTON_CLEAR_ALL);
        buttonClearAll.setBounds(0, 460, 100, 20);

        panelFooter.add(buttonClearAll);

        panelFooter.setVisible(true);
        return panelFooter;
    }

    public JButton getButtonOpenFile() {
        return buttonOpenFile;
    }

    public JPanel getPanelHeader() {
        return panelHeader;
    }

    public JPanel getPanelFooter() {
        return panelFooter;
    }
}
