package com.company.utils;

public class Constants {

    public static String TEAM_NAME = "Dunno-s";

    public static String FILE = "OPEN FILE";
    public static String CLEAR_ALL = "CLEAR ALL";
    public static String CONTROL_PANEL = "            CONTROL PANEL          ";

    public static String ICON = "src/resources/l.png.jpg";
    public static String COLOR_MAIN_FRAME = "#cbe8f3";

    //Buttons
    public static String BUTTON_OPEN = "Open";

    //Massages
    public static String MAS_CLEAR_ALL = "Delete all DATA from file?";
    public static String MAS_Q_SURE = "You are sure?";

    //Format files
    public final static String FORMAT_JSON = "json";
    public final static String FORMAT_YML = "yml";
    public final static String FORMAT_YAML = "yaml";
    public final static String FORMAT_XML = "XML";
    public final static String FORMAT_CSV = "csv";


    //CRUD
    public final static String CREATE = "                   create                ";
    public final static String UPDATE = "                   update                ";
    public final static String DELETE = "                   delete                ";


    //Person
    public static String ID = "id";
    public static String FIRST_NAME = "firstName";
    public static String LAST_NAME = "lastName";
    public static String CITY = "city";
    public static String AGE = "age";

    public static String LABEL_ID = " Id:";
    public static String LABEL_FIRST_NAME = " First Name:";
    public static String LABEL_LAST_NAME = " Last Name:";
    public static String LABEL_CITY = " City:";
    public static String LABEL_AGE = " Age:";

    //DB
    public static String DB_CHOSE_DATABASE = "OPEN DATABASE";
    public static String DB_CHOSE_POSTGRES = "SQL-PostgresSQL";
    public static String DB_CHOSE_H2 = "SQL-H2";
    public static String DB_CHOSE_MYSQL = "SQL-MySQL";
    public static String DB_CHOSE_MONGO = "NonSQL - Mongo";
    public static String DB_CHOSE_GRAPH = "NonSQL - Graph";
    public static String DB_CHOSE_CASSANDRA =  "NonSQL - Cassandra";
    public static String DB_CHOSE_REDIS =  "NonSQL - Redis";

    public static String[] SQL_NON_SQL = new String[]{DB_CHOSE_DATABASE, DB_CHOSE_POSTGRES, DB_CHOSE_H2, DB_CHOSE_MYSQL, DB_CHOSE_GRAPH, DB_CHOSE_MONGO, DB_CHOSE_CASSANDRA, DB_CHOSE_REDIS};

    //InvalidValue
    public static String JUST_NUMBER = "ID need be just Number!";
    public static String ONLY_ONE_ID = "Cant create one more Person with same Id!";
    public static String ID_LESS_ONE = "Id cannot be less than 1!";
    public static String AGE_ONLY_NUM = "Age need be just Number!";
    public static String AGE_ONLY_POSITIVE = "Age cannot be minus!";
    public static String NO_PERSON = "Person not found!";
    public static String DATA_PROBLEM = "DATA problem";
    public static String INCORRECT_QUERY = "Incorrect query!";
    public static String INVALID_VALUE = "Error Invalid Value!!!";

    //ValidValue
    public static String CHANGED_SAVED = "Changed saved!";


    //Cassandra
    public static String CASSANDRA_HOST = "127.0.0.1";
    public static String CASSANDRA_KEYSPACE = "persons";
    public static String CASSANDRA_READ = "SELECT * FROM person";
    public static String CASSANDRA_DROP_TABLE = "DROP TABLE person";
    public static String CASSANDRA_CREATE_TABLE = "CREATE TABLE person(id int PRIMARY KEY, firstName text, lastName text, city text, age int);";
    public static String CASSANDRA_INSERT = "INSERT INTO person (id,firstName,lastName,city,age) VALUES (?,?,?,?,?);";

    //GraphQl
    public static String GRAPHQL_URL = "bolt://localhost:7687";
    public static String GRAPHQL_USER = "neo4j";
    public static String GRAPHQL_PASSWORD = "1111";
    public static String GRAPHQL_READ = "MATCH (n) RETURN n.id, n.fname, n.lname, n.age, n.city";
    public static String GRAPHQL_DELETE = "MATCH (n { id: $id }) DETACH DELETE n";
    public static String GRAPHQL_CREATE ="CREATE (n:persons {id: $id, fname: $fname, lname: $lname, age: $age, city: $city})";

    //H2
    public static String H2_URL = "jdbc:h2:tcp://localhost/~/test";
    public static String H2_USER = "H2";
    public static String H2_PASSWORD = "1111";
    public static String H2_DRIVER = "org.h2.Driver";
    public static String H2_DROP = "DROP TABLE PERSONLIST";
    public static String H2_CREATE = "CREATE TABLE PERSONLIST( id INTEGER UNIQUE, FirstName VARCHAR NOT NULL, LastName VARCHAR NOT NULL, City VARCHAR NOT NULL, age INTEGER)";
    public static String H2_INSERT = "INSERT INTO PERSONLIST VALUES (%s,'%s','%s','%s',%s)";


    //Mongo
    public static String MONGO_HOST = "localhost";
    public static int MONGO_PORT = 27017;
    public static String MONGO_DB_NAME = "persons";
    public static String MONGO_COLLECTION_NAME = "person";


    //MySQL
    public static String MYSQL_URL = "jdbc:mysql://localhost:3306/persons";
    public static String MYSQL_USER = "root";
    public static String MYSQL_PASSWORD = "1111";
    public static String MYSQL_DROP = "DROP TABLE personList";
    public static String MYSQL_CREATE_T_P = "CREATE TABLE `persons`.`personlist` (\n" + "  `id` INT NOT NULL,\n" +
            "  `FirstName` VARCHAR(45) NULL,\n" +
            "  `LastName` VARCHAR(45) NULL,\n" +
            "  `City` VARCHAR(45) NULL,\n" +
            "  `Age` INT NULL);";
    public static String MYSQL_INSERT = "INSERT INTO personList(id,FirstName,LastName,City,age) VALUES (%s,'%s','%s','%s',%s);";
    public static String MYSQL_CREATE_T_PL = "CREATE TABLE personList( id INTEGER UNIQUE, FirstName VARCHAR NOT NULL, LastName VARCHAR NOT NULL, City VARCHAR NOT NULL, age INTEGER);";
    public static String MYSQL_READ = "SELECT*FROM personList";

    //Postgres POSTGRES
    public static String POSTGRES_URL = "jdbc:postgresql://localhost:5432/persons";
    public static String POSTGRES_USER = "postgres";
    public static String POSTGRES_PASSWORD = "1111";

//Redis
    public static String SEPARATOR = "\u00D8";
    public static String REDIS_HOST = "localhost";
    public static String REDIS_KEY = "person";
    public static int REDIS_PORT = 6379;


}
