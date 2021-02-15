package com.company.Listeners;

import com.company.CRUD.Delete;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFields;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteListener implements ActionListener {
    private TextFields textFields;
    private JFrame frame;
    private Table table;
    private FileHelper fileHelper;

    public DeleteListener(TextFields textFields, JFrame frame, FileHelper fileHelper) {
        this.textFields = textFields;
        this.frame = frame;
        this.fileHelper = fileHelper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ButtonsListeners.path == null) {
            delete();
        } else {
            try {
                fileHelper.isEmpty();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            delete();
        }
    }
    public void delete() {
        Delete delete = new Delete();
        try {
            delete.deleteOnePerson(fileHelper.getPersonList(), textFields.getTextFieldId());
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
