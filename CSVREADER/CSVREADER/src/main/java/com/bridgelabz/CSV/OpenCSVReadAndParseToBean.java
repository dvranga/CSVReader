package com.bridgelabz.CSV;

import com.bridgelabz.CSV.CSVUser;
import com.bridgelabz.CSV.CSVUserWithOutHeader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
        try (
                Reader reader1 = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVUserWithOutHeader> csvToBean1 = new CsvToBeanBuilder(reader1)
                    .withType(CSVUserWithOutHeader.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUserWithOutHeader> csvUserIterator1 = csvToBean1.iterator();

            while (csvUserIterator1.hasNext()) {
                CSVUserWithOutHeader csvUser = csvUserIterator1.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }
}