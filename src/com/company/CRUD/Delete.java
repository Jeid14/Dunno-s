package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delete {
    public void deleteOnePerson(List<Person> personList, JTextField textFieldId) throws IllegalArgumentException, IOException {
        int count = 0;
        Person personForDelete = new Person();
        int id = Integer.parseInt(textFieldId.getText());
        for (Person p : personList) {
            if (p.getId() == id) {
                personForDelete = p;
                count++;
            }

        }
        if (count == 0) {
           throw new IllegalArgumentException("Person not found!");

        }
        else {
            personList.remove(personForDelete);
        }
        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);
    }
}
