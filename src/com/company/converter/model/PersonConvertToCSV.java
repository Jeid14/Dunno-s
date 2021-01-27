package com.company.converter.model;

import com.company.converter.IPersonConvertor;
import com.company.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonConvertToCSV implements IPersonConvertor {
    CsvMapper csvMapper = new CsvMapper();
    CsvSchema schema = csvMapper.schemaFor(Person.class);

    @Override
    public String convertPersonToStr(List<Person> personList) throws JsonProcessingException {

        return csvMapper.writer(schema.withUseHeader(true)).writeValueAsString(personList);

    }

    @Override
    public List<Person> convertStrToPerson(String personStr) throws IOException {
        ArrayList<Person> listPerson = new ArrayList<>();
        try {
            return csvMapper.readValue(personStr, new TypeReference<List<Person>>() {
            });
        } catch (MismatchedInputException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPerson;
    }
}