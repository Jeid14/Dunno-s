package com.company.Listeners;

import com.company.CRUD.Delete;
import com.company.CRUD.Update;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFilds;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateListener  implements ActionListener {
    TextFilds textFilds;
    JFrame frame;
    Table table;
    FileHelper fileHelper;

    public UpdateListener(TextFilds textFilds, JFrame frame,FileHelper fileHelper) {
        this.textFilds = textFilds;
        this.frame = frame;
        this.table = table;
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

    public void update(){
        Update update = new Update();
        try {
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
        } catch (InvalidValue e) {
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error Invalid Value!!!",JOptionPane.ERROR_MESSAGE);
        }
    }
}
