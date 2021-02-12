package com.company.converter.model.impl;

import com.company.converter.IPersonConvertor;
import com.company.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.List;


public class PersonConvertToXML implements IPersonConvertor {
    private final XmlMapper mapper = new XmlMapper();



    @Override
    public String convertPersonToStr(List<Person> personList) {
        try {
           return mapper.writeValueAsString(personList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return " ";
    }

    @Override
    public List<Person> convertStrToPerson(String personStr) throws IOException {
        return mapper.readValue(personStr, new TypeReference<List<Person>>() {
        });

    }

}
