package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Delete {
    public void deleteOnePerson(List<Person> personList, JTextField textFieldId) throws InvalidValue, IOException {
        int count = 0;
        Person personForDelete = new Person();
        int id = 0;
        try {
            id = Integer.parseInt(textFieldId.getText());
        }
        catch (NumberFormatException e){
            throw new InvalidValue(Constants.ONLY_ONE_ID);

            
        }
        for (Person p : personList) {
            if (p.getId() == id) {
                personForDelete = p;
                count++;
            }

        }
        if (count == 0) {
            throw new InvalidValue(Constants.NO_PERSON);

        } else {
            personList.remove(personForDelete);
        }
        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);
    }
}
