package com.syllabus.poc.POC.entities;

import lombok.Data;

import java.util.List;

@Data
public class DataRec {
    private Erlaubnisinhaber erlaubnisinhaber;
    private BetrieblicheAnschrift betrieblicheAnschrift;
    private List<Vertretungsberechtigte> vertretungsberechtigtes;
    private String auslandstaetigkeiten;
    private String auslandsniederlassungen;
    private List<Personenhandelsgesellschaften> personenhandelsgesellschaftens;
    private String leitendeAngestellte;
    private String weitereRegistrierungen;
    private String erlaubnisbehoerde;
    private Registerbehoerde registerbehoerde;
    private String taetigkeitsart;
    private String querverweisAnfrage;


}
