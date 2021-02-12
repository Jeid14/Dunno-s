package com.company.executor;

import com.company.converter.model.impl.PersonConvertToCSV;
import com.company.converter.model.impl.PersonConvertToXML;
import com.company.converter.model.impl.PersonConvertYaml;
import com.company.converter.model.impl.PersonConverterJson;
import com.company.utils.Constants;

public class ExecutorFactory {

    private final Executable binaryExecutable = new BinaryExecutor();
    private final Executable jsonExecutable = new StringFormatExecutor(new PersonConverterJson());
    private final Executable xmlExecutable = new StringFormatExecutor(new PersonConvertToXML());
    private final Executable ymlExecutable = new StringFormatExecutor(new PersonConvertYaml());
    private final Executable csvExecutable = new StringFormatExecutor(new PersonConvertToCSV());

    public Executable getInstanceByFormat(String format) {
        Executable result;
        switch (format) {
            case Constants.FORMAT_JSON:
                result = jsonExecutable;
                break;
            case Constants.FORMAT_XML:
                result = xmlExecutable;
                break;
            case Constants.FORMAT_YML:
            case Constants.FORMAT_YAML:
                result = ymlExecutable;
                break;
            case Constants.FORMAT_CSV:
                result = csvExecutable;
                break;
            default:
                result = binaryExecutable;
        }
        return result;
    }
}
