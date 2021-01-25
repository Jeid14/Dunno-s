package com.company.visual;

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
}
