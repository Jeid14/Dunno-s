package com.company;
import com.company.database.GraphQl;
import com.company.database.H2;
import com.company.database.Postgres;
import com.company.executor.Executable;

import com.company.model.Person;
import com.company.visual.InterfaceMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        InterfaceMain interfaceMain = new InterfaceMain();
        interfaceMain.createFrame();



    }
}

