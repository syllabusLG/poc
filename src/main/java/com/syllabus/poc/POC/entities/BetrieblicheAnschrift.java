package com.syllabus.poc.POC.entities;

import lombok.Data;

@Data
public class BetrieblicheAnschrift {
    private String hausnummer;
    private String plz;
    private String strasse;
    private String ort;
}
