package com.syllabus.poc.POC.entities;

import lombok.Data;

@Data
public class Erlaubnisinhaber {
    private String registrierungsnummer;
    private String anrede;
    private String anredezusatz;
    private String titel;
    private String namenstitel;
    private String namenszusatz;
    private String nachtitel;
    private String firma;
    private String trittAufAls;
    private String gebundenerVermittler;

}
