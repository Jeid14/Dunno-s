package com.company.Listeners;

import com.company.utils.FileHelper;
import com.company.visual.InterfaceMain;
import com.company.visual.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ClearAllLiestener implements ActionListener {
    private final JFrame frame;
    FileHelper fileHelper = new FileHelper();
    Table table;


    public ClearAllLiestener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(frame,"Delete all DATA from file?","You are sure?",JOptionPane.YES_NO_OPTION);
        switch (res){
            case 0:
                try {
                    fileHelper.saveChange(new ArrayList<>());
                    table  = ButtonsListeners.getTable();
                    table.redrawTable();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case 1:
        }



    }
}
