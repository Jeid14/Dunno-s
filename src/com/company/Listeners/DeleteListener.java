package com.company.Listeners;

import com.company.CRUD.Delete;
import com.company.executor.ExecutorFactory;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFilds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class DeleteListener implements ActionListener {
    TextFilds textFilds;
    JFrame frame;
    Table table;
    FileHelper fileHelper;

    public DeleteListener(TextFilds textFilds, JFrame frame,FileHelper fileHelper) {
        this.textFilds = textFilds;
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

    public void delete(){
        Delete delete = new Delete();
        try {
            delete.deleteOnePerson(fileHelper.getPersonList(),textFilds.getTextFieldId());
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
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error Invalid Value!!!",JOptionPane.ERROR_MESSAGE);
        }

    }
}
