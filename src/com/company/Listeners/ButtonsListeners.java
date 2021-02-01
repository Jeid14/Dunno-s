package com.company.Listeners;

import com.company.executor.ExecutorFactory;
import com.company.model.Person;
import com.company.visual.Buttons;
import com.company.visual.InterfaceMain;
import com.company.visual.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ButtonsListeners implements ActionListener{

    private  String path;
    Buttons buttons;
    InterfaceMain interfaceMain;
    public static String fileEx;
    JFrame frame;
    JPanel panelControl;

    public ButtonsListeners(JFrame frame, JPanel panelControl) {
        this.frame = frame;
        this.panelControl = panelControl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showDialog(buttons.getPanelHeader(), "Open");
            path = fileChooser.getSelectedFile().getAbsolutePath();
            Table table = new Table();
            try {
                interfaceMain.getFrame().add(table.createTable(getPersonList()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }


    public List<Person> getPersonList() throws IOException {
        return new ExecutorFactory().getInstanceByFormat(getFileExtension()).read(path);
    }

    public  String getFileExtension() {
            // если в имени файла есть точка и она не является первым символом в названии файла
        if (path.lastIndexOf(".") != -1 && path.lastIndexOf(".") != 0) {
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            fileEx = path.substring(path.lastIndexOf(".") + 1);
            return path.substring(path.lastIndexOf(".") + 1);
        }            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return " ";
    }
}

