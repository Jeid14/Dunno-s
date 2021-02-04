package com.company.Listeners;

import com.company.CRUD.Create;
import com.company.Main;
import com.company.utils.FileHelper;
import com.company.visual.InterfaceMain;
import com.company.visual.Table;
import com.company.visual.TextFilds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CreateListener implements ActionListener {
    TextFilds textFilds;
    JFrame frame;
    FileHelper fileHelper;


    public CreateListener(TextFilds textFilds, JFrame frame, FileHelper fileHelper) {
        this.textFilds = textFilds;
        this.frame = frame;
        this.fileHelper = fileHelper;


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (ButtonsListeners.path == null) {
            createFotDataBase();
        } else {
            createForFile();
        }
    }

    public void createForFile() {
        try {
            Create create = new Create();
            fileHelper.isEmpty();
            create.createPerson(fileHelper.getPersonList(), textFilds.getTextFildId(), textFilds.getTextFieldFirstName(), textFilds.getTextFieldLastName(), textFilds.getTextFieldAge(), textFilds.getTextFieldCity());
            Table table = ButtonsListeners.getTable();
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

    public void createFotDataBase() {
        try {
            Create create = new Create();
            create.createPerson(fileHelper.getPersonList(), textFilds.getTextFildId(), textFilds.getTextFieldFirstName(), textFilds.getTextFieldLastName(), textFilds.getTextFieldAge(), textFilds.getTextFieldCity());
            Table table = ButtonsListeners.getTable();
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

