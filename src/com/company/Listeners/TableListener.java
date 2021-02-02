package com.company.Listeners;

import javax.swing.*;
import java.awt.event.*;

public class TableListener implements MouseListener {
    private final JTable table;
    private final JTextField textFieldId;
    private final JTextField textFieldFirstName;
    private final JTextField textFieldLastName;
    private final JTextField textFieldAge;
    private final JTextField textFieldCity;


    public TableListener(JTable table,JTextField textFieldId, JTextField textFieldFirstName, JTextField textFieldCity,JTextField textFieldAge,JTextField textFieldLastName) {
        this.table = table;
        this.textFieldId = textFieldId;
        this.textFieldFirstName = textFieldFirstName;
        this.textFieldLastName = textFieldLastName;
        this.textFieldCity = textFieldCity;
        this.textFieldAge = textFieldAge;


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (table.getSelectedRow() > -1) {
            // print first column value from selected row
            textFieldId.setText( table.getValueAt(table.getSelectedRow(), 0).toString());
           textFieldFirstName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
           textFieldLastName.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
           textFieldCity.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
           textFieldAge.setText(table.getValueAt(table.getSelectedRow(), 4).toString());

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

