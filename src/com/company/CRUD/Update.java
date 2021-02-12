package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.TextFields;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.io.IOException;
import java.util.List;

public class Update {

    public void updatePerson(List<Person> personList, TextFields textFields) throws IOException, InvalidValue {
        int count = 0;
        int id = 0;
        try {
            id = Integer.parseInt(textFields.getTextFildId().getText());
        }
        catch (NumberFormatException e){
            throw new InvalidValue(Constants.JUST_NUMBER);
        }
        if (id < 1) {
            textFields.getTextFieldId().setText((Constants.ID_LESS_ONE));
        }
        for (Person p : personList) {
            if (p.getId() == id && count == 0) {
                p.setId(id);
                p.setFirstName(textFields.getTextFieldFirstName().getText());
                p.setLastName(textFields.getTextFieldLastName().getText());
                p.setCity(textFields.getTextFieldCity().getText());
                count++;
                int age = 0;
                try {
                     age = Integer.parseInt(textFields.getTextFieldAge().getText());
                } catch (NumberFormatException e) {
                    throw new InvalidValue(Constants.AGE_ONLY_NUM);
                }
                if (age < 0 || age > 130) {
                    throw new InvalidValue(Constants.AGE_ONLY_POSITIVE);

                } else {
                    p.setAge(age);
                }
            }

        }
        if (count == 0) {
            throw new InvalidValue(Constants.NO_PERSON);
        }
        FileHelper fileHelper = new FileHelper();

        fileHelper.saveChange(personList);

    }
}
