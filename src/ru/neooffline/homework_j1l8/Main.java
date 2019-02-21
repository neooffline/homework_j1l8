package ru.neooffline.homework_j1l8;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Persons persons = new Persons();
        HashMap<String,Persona> hashMap = new HashMap<>();
        for (int j = 0; j < 40; j++) {
            hashMap.put("Pers #"+j, new Persona(persons));
        }
        new MainWindow(hashMap);
    }
}
