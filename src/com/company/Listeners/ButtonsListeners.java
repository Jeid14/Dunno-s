package com.company.Listeners;

import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFields;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonsListeners implements ActionListener {
    public static String path;
    private final JFrame frame;
    private final TextFields textFields;
    private final FileHelper fileHelper;
    private static Table table;
    static int countOpen = 0;


    public ButtonsListeners(JFrame frame, TextFields textFields, FileHelper fileHelper) {

        this.frame = frame;
        this.textFields = textFields;
        this.fileHelper = fileHelper;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(frame, Constants.BUTTON_OPEN);
        path = fileChooser.getSelectedFile().getAbsolutePath();
        frame.setTitle(fileChooser.getSelectedFile().getPath());
        try {
            if (countOpen == 0) {
                table = new Table(frame, textFields, fileHelper);
                setTable(table);
                fileHelper.isEmpty();
                table.createTable(fileHelper.getPersonList());
                countOpen++;
                System.out.println(countOpen);
            } else if (countOpen > 0) {
                table.redrawTable();
            }

            textFields.getTextFildId().setText("");
            textFields.getTextFieldAge().setText("");
            textFields.getTextFieldCity().setText("");
            textFields.getTextFieldFirstName().setText("");
            textFields.getTextFieldLastName().setText("");


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
