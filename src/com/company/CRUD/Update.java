package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;
import com.company.visual.TextFilds;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Update {

    public void updatePerson(List<Person> personList, TextFilds textFilds) throws IOException, InvalidValue {
        int count = 0;
        int id = Integer.parseInt(textFilds.getTextFildId().getText());
        if (id < 0) {
            textFilds.getTextFieldId().setText(("Id cant be minus"));
        }
        for (Person p : personList) {
            if (p.getId() == id && count == 0) {
                p.setId(id);
                p.setFirstName(textFilds.getTextFieldFirstName().getText());
                p.setLastName(textFilds.getTextFieldLastName().getText());
                p.setCity(textFilds.getTextFieldCity().getText());
                count++;
                int age = Integer.parseInt(textFilds.getTextFieldAge().getText());
                if (age < 0 || age > 130) {
                    throw new InvalidValue("Age cannot be minus!");

                } else {
                    p.setAge(age);
                }
            }

            }
        if (count == 0) {
            throw new InvalidValue("Person not found!");
        }
        FileHelper fileHelper = new FileHelper();

        fileHelper.saveChange(personList);

    }
}
