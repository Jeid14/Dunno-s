package com.company.Listeners;

import com.company.CRUD.Update;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFields;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateListener implements ActionListener {
    private TextFields textFields;
    private JFrame frame;
    private Table table;
    private FileHelper fileHelper;

    public UpdateListener(TextFields textFields,  JFrame frame, FileHelper fileHelper) {
        this.textFields = textFields;
        this.frame = frame;
        this.fileHelper = fileHelper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ButtonsListeners.path == null) {
            update();
        } else {
            try {
                fileHelper.isEmpty();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            update();
        }
    }

    public void update() {
        Update update = new Update();
        try {
            update.updatePerson(fileHelper.getPersonList(), textFields);
            table = ButtonsListeners.getTable();
            table.redrawTable();
            textFields.getTextFildId().setText("");
            textFields.getTextFieldAge().setText("");
            textFields.getTextFieldCity().setText("");
            textFields.getTextFieldFirstName().setText("");
            textFields.getTextFieldLastName().setText("");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InvalidValue e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), Constants.INVALID_VALUE, JOptionPane.ERROR_MESSAGE);
        }
    }
}
