package com.syllabus.poc.POC.entities;

import lombok.Data;

@Data
public class Vertretungsberechtigte {
    private String anrede;
    private String anredezusatz;
    private String name;
    private String vorname;
    private String titel;
    private String namenstitel;
    private String namenszusatz;
    private String nachtitel;
    private String funktion;
}
