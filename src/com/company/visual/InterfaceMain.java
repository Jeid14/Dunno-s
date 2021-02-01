package com.company.visual;

import com.company.Listeners.ButtonsListeners;

import javax.swing.*;
import java.io.IOException;

public class InterfaceMain extends JFrame {

    private JFrame frame = new JFrame("Dunno-s");
    Buttons buttons = new Buttons();
    ButtonsListeners buttonsListeners;
    Table table = new Table();

    ControlPanel controlPanel = new ControlPanel();

    public void createGUI() throws IOException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,550);


        frame.add(controlPanel.createControlPanel());
        frame.add(buttons.createHeader());
        frame.add(buttons.createFooter());
       // frame.add(table.createTable(buttonsListeners.getPersonList()));

        buttonsListeners = new ButtonsListeners(frame, controlPanel.getPanelControl());

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}



