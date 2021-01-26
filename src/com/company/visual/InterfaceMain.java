package com.company.visual;

<<<<<<< HEAD
import com.company.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class InterfaceMain {
    JFrame f ;

    List<Person> personList;
    Table table ;
    JScrollPane  jScrollPane;
    JTable jtable ;

   public InterfaceMain(List<Person> personList,Table table) throws IOException {
       this.f = new JFrame("Dunno's");
       this.personList = personList;
       this.table = table;
       this.jtable = table.create();
       this.jScrollPane = new JScrollPane(table.create());


    }
     public void addAllElement() throws IOException {

         f.setSize(800, 400);
         table.setSize(200,150);
         f.add(jScrollPane);
         f.setVisible(true);
     }
=======
import javax.swing.*;
import java.awt.*;

public class InterfaceMain extends JFrame {

    private JButton buttonOpenFile;
    private JButton buttonSelectionDB;
    private JButton buttonClearAll;

    public void createGUI()
    {
        JFrame frame = new JFrame("Dunno-s");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setSize(500,500);
        //frame.pack();//Эта команда подбирает оптимальный размер в зависимости от содержимого окна

        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setBounds(850, 50, 100, 30);

        buttonSelectionDB = new JButton("Database");
        buttonSelectionDB.setBounds(850, 100, 100, 30);

        buttonClearAll = new JButton("Clear All");
        buttonClearAll.setBounds(150, 500, 100, 30);

        frame.add(buttonOpenFile);
        frame.add(buttonSelectionDB);
        frame.add(buttonClearAll);
        frame.setLayout(null);
        frame.setVisible(true);
    }
>>>>>>> Develop
}



