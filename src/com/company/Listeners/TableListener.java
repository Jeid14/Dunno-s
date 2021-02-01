package com.company.Listeners;

import com.company.visual.ControlPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableListener implements MouseListener {
    JTable table;
    JPanel panelControl;
    ControlPanel controlPanel;

    public TableListener(JTable table, JPanel panelControl) {
        this.table = table;
        this.panelControl = panelControl;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (table.getSelectedRow() > -1) {
            controlPanel.getTextFieldId().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            controlPanel.getTextFieldFirstName().setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            controlPanel.getTextFieldLastName().setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            controlPanel.getTextFieldCity().setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            controlPanel.getTextFieldAge().setText(table.getValueAt(table.getSelectedRow(), 4).toString());
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
