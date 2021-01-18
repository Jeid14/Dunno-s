package com.company.converterstr;

import com.company.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface IPersonConvertor {

    String convertPersonToStr(List<Person> personList) throws IOException;
    List<Person> convertStrToPerson(String personStr) throws JsonProcessingException, IOException;
}
