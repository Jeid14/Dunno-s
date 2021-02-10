package com.company.Listeners;

import com.company.model.Person;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFilds;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ButtonsListeners implements ActionListener {
    public static String path;
    private final JFrame frame;
    private final TextFilds textFilds;
    private final FileHelper fileHelper;
    private static Table table;
    static int countOpen = 0;


    public ButtonsListeners(JFrame frame, TextFilds textFilds, FileHelper fileHelper) {

        this.frame = frame;
        this.textFilds = textFilds;
        this.fileHelper = fileHelper;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(frame, "Open");
        path = fileChooser.getSelectedFile().getAbsolutePath();
        frame.setTitle(fileChooser.getSelectedFile().getPath());
        try {
            if (countOpen == 0) {
                table = new Table(frame, textFilds, fileHelper);
                setTable(table);
                fileHelper.isEmpty();
                table.createTable(fileHelper.getPersonList());
                countOpen++;
                System.out.println(countOpen);
            } else if (countOpen > 0) {
                table.redrawTable();
            }

            textFilds.getTextFildId().setText("");
            textFilds.getTextFieldAge().setText("");
            textFilds.getTextFieldCity().setText("");
            textFilds.getTextFieldFirstName().setText("");
            textFilds.getTextFieldLastName().setText("");


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static Table getTable() {
        return table;
    }

    public static void setTable(Table jtable) {
        table = jtable;
    }


}
