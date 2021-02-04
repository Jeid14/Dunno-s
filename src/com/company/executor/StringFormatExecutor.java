package com.company.executor;

import com.company.converter.IPersonConvertor;
import com.company.model.Person;
import com.company.utils.FileHelper;

import java.io.IOException;
import java.util.List;

public class StringFormatExecutor implements Executable {

    private final FileHelper fileHelper = new FileHelper();
    private final IPersonConvertor convertor;

    public StringFormatExecutor(IPersonConvertor convertor) {
        this.convertor = convertor;
    }

    @Override
    public void write(String fileName, List<Person> personList) throws IOException {
        fileHelper.saveToFile(convertor.convertPersonToStr(personList), fileName);

    }

    @Override
    public List<Person> read(String fileName) throws IOException {
        return convertor.convertStrToPerson(fileHelper.readFromFile(fileName));
    }

}
