package com.company.utils;

import java.util.Locale;

public class ConstantString {
    public final static String ENTER_FILE_NAME_COMMAND = "Enter File Name!";
    public final static String WELCOME = "Hello";
    public final static String ENTER_FILE_NAME = "Enter File Name with Extension";
    public final static String CREATE = "create";
    public final static String READ = "read";
    public final static String UPDATE = "update";
    public final static String DELETE = "delete";

    public final static String CREATE_COMMAND = "Command " + CREATE.toUpperCase(Locale.ROOT) + " create new Person and add to file.";
    public final static String READ_COMMAND = "Command " + READ.toUpperCase(Locale.ROOT) + " show all Persons in file.";
    public final static String UPDATE_COMMAND = "Command " + UPDATE.toUpperCase(Locale.ROOT) + " updates one person in the file by her ID";
    public final static String DELETE_COMMAND = "Command " + DELETE.toUpperCase(Locale.ROOT) + " delete one Person from file by her ID.";


    public final static String START = "start";
    public final static String HELP = "help";
    public final static String SWITCH = "switch";
    public final static String EXIT = "exit";

    public final static String EXIT_COMMAND = "After the EXIT command, the application is exited.";
    public final static String START_COMMAND = "After the START command, the changed is saved.";
    public final static String HELP_COMMAND = "After the HELP command, the available commands  are displayed.";
    public final static String SWITCH_COMMAND = "After the SWITCH command, the available commands and their format are displayed.!";


    public static String ENTER_FIRST_NAME = "First Name:";
    public static String ENTER_LAST_NAME = "Last Name:";
    public static String ENTER_CITY = "City:";
    public static String ENTER_ID = "Id:";
    public static String ENTER_AGE = "Age:";


    public static String HEAD_CONTROL_PANEL = "CONTROL PANEL";
    public static String BUTTON_CLEAR_ALL = "Clear All";
    public static String BUTTON_OPEN_FILE = "Open File";
    public static String BUTTON_DATABASE = "Database";

}
