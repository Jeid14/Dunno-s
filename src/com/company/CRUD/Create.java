package com.company.CRUD;

import com.company.Listeners.ButtonsListeners;
import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Create {

    public void createPerson(List<Person> personList, JTextField textFieldId, JTextField textFieFn, JTextField textFieLn, JTextField textFieAge, JTextField textFieCity) throws IOException {
        int count = 0;
        Person person = new Person();
        person.setId(Integer.parseInt(textFieldId.getText()));
        if (count == 0) {

            person.setFirstName(textFieFn.getText());

            person.setLastName(textFieLn.getText());

            person.setCity(textFieCity.getText());

            int age = Integer.parseInt(textFieAge.getText());
            if(age<0) {
                System.out.println("Age cant be minus");
                textFieAge.setText(ConstantString.ENTER_AGE);
            }

            personList.add(person);
            count++;
        }

        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);
    }
}

