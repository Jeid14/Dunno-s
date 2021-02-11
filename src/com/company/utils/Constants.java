package com.company.utils;

import com.company.model.Person;

import java.util.List;

public class Constants {

    public final static String FORMAT_JSON = "json";
    public final static String FORMAT_YML = "yml";
    public final static String FORMAT_YAML = "yaml";
    public final static String FORMAT_XML = "XML";
    public final static String FORMAT_CSV = "csv";

   public static String[] SQL_NON_SQL = new String[]{ConstantString.DB_CHOSE_DATABASE, ConstantString.DB_CHOSE_POSTGRES, ConstantString.DB_CHOSE_H2, ConstantString.DB_CHOSE_MYSQL, "NonSQL - Graph", "NonSQL - Mongo", "NonSQL - Cassandra",ConstantString.DB_CHOSE_REDIS};


}
