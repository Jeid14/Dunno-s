package com.company.CRUD;

import com.company.Listeners.ButtonsListeners;
import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;
import com.oracle.jrockit.jfr.InvalidValueException;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Create {

    public void createPerson(List<Person> personList, JTextField textFieldId, JTextField textFieFn, JTextField textFieLn, JTextField textFieAge, JTextField textFieCity) throws IOException, InvalidValue {

        Person person = new Person();
        int id = Integer.parseInt(textFieldId.getText());
        for (Person p:personList){
           if( p.getId() == id){
               throw  new InvalidValue("Cant create one more Person with same Id!");
           }

        }
        if (id<=0){
            throw new InvalidValue("Id cannot be less than 1!");
        }else {
            person.setId(id);
        }
            person.setFirstName(textFieFn.getText());
            person.setLastName(textFieLn.getText());
            person.setCity(textFieCity.getText());
            int age = Integer.parseInt(textFieAge.getText());
            if(age<0|| age> 130) {
                throw new InvalidValue("Age cannot be minus!");
            }else {
                person.setAge(age);
            }
            personList.add(person);


        FileHelper fileHelper = new FileHelper();
        fileHelper.saveChange(personList);
    }
}

