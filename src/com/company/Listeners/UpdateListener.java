package com.company.Listeners;

import com.company.CRUD.Delete;
import com.company.CRUD.Update;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFilds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateListener  implements ActionListener {
    TextFilds textFilds;
    JFrame frame;
    Table table;

    public UpdateListener(TextFilds textFilds, JFrame frame) {
        this.textFilds = textFilds;
        this.frame = frame;
        this.table = table;
    }

    FileHelper fileHelper = new FileHelper();
    @Override
    public void actionPerformed(ActionEvent e) {
        Update update = new Update();
        try {
            fileHelper.isEmpty();
            update.updatePerson(fileHelper.getPersonList(),textFilds);

            table = ButtonsListeners.getTable();
            table.redrawTable();
            textFilds.getTextFildId().setText("");
            textFilds.getTextFieldAge().setText("");
            textFilds.getTextFieldCity().setText("");
            textFilds.getTextFieldFirstName().setText("");
            textFilds.getTextFieldLastName().setText("");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
