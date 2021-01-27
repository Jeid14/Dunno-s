package com.company.converter.model;

import com.company.converter.IPersonConvertor;
import com.company.model.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PersonConverterJson implements IPersonConvertor {

    private final Gson gson = new Gson();
    private final Type type = new TypeToken<List<Person>>() {
    }.getType();

    @Override
    public String convertPersonToStr(List<Person> personList) {
        return gson.toJson(personList);
    }

    @Override
    public List<Person> convertStrToPerson(String personStr) {
        return gson.fromJson(personStr, type);
    }
}
