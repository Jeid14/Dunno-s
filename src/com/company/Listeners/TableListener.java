package com.company.Listeners;

import com.company.visual.TextFields;

import javax.swing.*;
import java.awt.event.*;

public class TableListener implements MouseListener {
    private JTable table;
    private TextFields textFields;


    public TableListener(JTable table, TextFields textFields) {
        this.table = table;
        this.textFields = textFields;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (table.getSelectedRow() > -1) {
            textFields.getTextFildId().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            textFields.getTextFieldFirstName().setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            textFields.getTextFieldLastName().setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            textFields.getTextFieldCity().setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            textFields.getTextFieldAge().setText(table.getValueAt(table.getSelectedRow(), 4).toString());

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

