package com.bridgelabz.introductionCSV;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;



import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReaderBuilder;

public class CSVReader1 {
    private static final String SAMPLE_CSV_FILE_PATH = "usersTwo.csv";

    try (
    Reader reader = Files.newBufferedReader( Paths.get(SAMPLE_CSV_FILE_PATH));
    com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(reader);
        ){
        public List<String[]> readAll(Reader reader) throws Exception {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> list = new ArrayList<>();
            list = csvReader.readAll();
            reader.close();
            csvReader.close();
            return list;
        }
    }



    public CSVReader1() throws IOException {
    }
}
