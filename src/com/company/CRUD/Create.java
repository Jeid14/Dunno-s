package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Create {

    public void createPerson(List<Person> personList, JTextField textFieldId, JTextField textFieFn, JTextField textFieLn, JTextField textFieAge, JTextField textFieCity) throws IOException, InvalidValue {

        Person person = new Person();

        int id = 0;
        try {
            id = Integer.parseInt(textFieldId.getText());
        }
        catch (NumberFormatException e){
            throw new InvalidValue(Constants.JUST_NUMBER);
        }
        for (Person p:personList){
           if( p.getId() == id){
               throw  new InvalidValue(Constants.ONLY_ONE_ID);
           }

        }
        if (id<=0){
            throw new InvalidValue(Constants.ID_LESS_ONE);
        }else {
            person.setId(id);
        }
            person.setFirstName(textFieFn.getText());
            person.setLastName(textFieLn.getText());
            person.setCity(textFieCity.getText());
        int age =0;
        try {
            age = Integer.parseInt(textFieAge.getText());
        }
        catch (NumberFormatException e){
            throw new InvalidValue(Constants.AGE_ONLY_NUM);
        }
            if(age<0|| age> 130) {
                throw new InvalidValue(Constants.AGE_ONLY_POSITIVE);
            }else {
                person.setAge(age);
            }
            personList.add(person);


        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);
    }
}

