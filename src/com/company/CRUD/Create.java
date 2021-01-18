package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.ConstantString;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Create {
    Scanner scanner = new Scanner(System.in);


    public List<Person> createPerson(List<Person> personList) throws IOException {
        int count = 0;
        Person person = new Person();
        System.out.println(ConstantString.ENTER_ID);
        person.setId( scanner.nextInt());

        for (Person p : personList) {
            if (p.getId() == person.getId()) {
                count++;
                Update update = new Update();
                update.updatePerson(personList, person.getId());

            }
        }
        if (count == 0) {
            System.out.println(ConstantString.ENTER_FIRST_NAME);
            person.setFirstName(scanner.next());
            System.out.println(ConstantString.ENTER_LAST_NAME);
            person.setLastName(scanner.next());
            System.out.println(ConstantString.ENTER_CITY);
            person.setCity(scanner.next());
            System.out.println(ConstantString.ENTER_AGE);
            int age = scanner.nextInt();
            if(age<0){
                System.out.println("Age cant be minus");
                System.out.println(ConstantString.ENTER_AGE);
                person.setAge(scanner.nextInt());

            }else {
                person.setAge(age);
            }

            personList.add(person);
            count++;
        }

        return personList;
    }
}

