package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;
import com.company.visual.TextFilds;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Update {

    public void updatePerson(List<Person> personList, TextFilds textFilds) throws IOException {
        int count = 0;
        int id = Integer.parseInt(textFilds.getTextFildId().getText());
        if (id < 0) {
            textFilds.getTextFieldId().setText(("Id cant be minus"));
        }
        for (Person p : personList) {
            if (count == 0) {
                if (p.getId() == id) {
                    p.setId(id);

                    p.setFirstName(textFilds.getTextFieldFirstName().getText());

                    p.setLastName(textFilds.getTextFieldLastName().getText());

                    p.setCity(textFilds.getTextFieldCity().getText());


                    int age = Integer.parseInt(textFilds.getTextFildId().getText());
                    if (age < 0) {
                        textFilds.getTextFieldAge().setText("\"Age cant be minus\"");

                        count++;
                    }
                } else if (count <= 0) {
//
                    System.out.println("Person is not found!");
                }
            }


        }
        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);

    }
}
