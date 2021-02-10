package com.company.Listeners;
import com.company.visual.InterfaceMain;
import com.company.visual.Table;
import com.company.visual.TextFilds;

import javax.swing.*;
import java.awt.event.*;

public class TableListener implements MouseListener {
    private  JTable table;
    TextFilds textFilds;



    public TableListener(JTable table, TextFilds textFilds) {
        this.table = table;
        this.textFilds = textFilds;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if (table.getSelectedRow() > -1) {
            textFilds.getTextFildId().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            textFilds.getTextFieldFirstName().setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            textFilds.getTextFieldLastName().setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            textFilds.getTextFieldCity().setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            textFilds.getTextFieldAge().setText(table.getValueAt(table.getSelectedRow(), 4).toString());

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

