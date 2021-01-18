package com.company.CRUD;

import com.company.model.Person;
import com.company.utils.ConstantString;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Update {
    Scanner scanner = new Scanner(System.in);

    public List<Person> updatePerson(List<Person> personList,int id) throws IOException {
        int count = 0;
        if(id<0) {
            System.out.println("Id cant be minus");
            System.out.println(ConstantString.ENTER_ID);
           id = scanner.nextInt();
        }
        for (Person p : personList) {
            if (count == 0) {
                if (p.getId() == id) {
                    p.setId(id);
                    System.out.println(ConstantString.ENTER_FIRST_NAME);
                    p.setFirstName(scanner.next());
                    System.out.println(ConstantString.ENTER_LAST_NAME);
                    p.setLastName(scanner.next());
                    System.out.println(ConstantString.ENTER_CITY);
                    p.setCity(scanner.next());
                    System.out.println(ConstantString.ENTER_AGE);
                    int age = scanner.nextInt();
                    if(age<0){
                        System.out.println("Age cant be minus");
                        System.out.println(ConstantString.ENTER_AGE);
                        p.setAge(scanner.nextInt());

                    }else {
                        p.setAge(age);
                    }
                    count++;
                } }else if (count <= 0) {
//
                    System.out.println("Person is not found!");
                }
            }





        return personList;
    }
}
