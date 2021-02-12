package com.company.Listeners;

import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ClearAllLiestener implements ActionListener {
    private final JFrame frame;
    private FileHelper fileHelper;
    private Table table;

    public ClearAllLiestener(JFrame frame,FileHelper fileHelper) {
        this.fileHelper = fileHelper;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(frame, Constants.MAS_CLEAR_ALL, Constants.MAS_Q_SURE, JOptionPane.YES_NO_OPTION);
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
