package org.scoula.travel;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CSVTest1 {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader(new FileReader("travel.csv"));
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            System.out.println(String.join(",", line));
        }
    }
}
