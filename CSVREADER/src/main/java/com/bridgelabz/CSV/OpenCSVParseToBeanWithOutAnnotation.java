package com.bridgelabz.CSV;

import com.bridgelabz.CSV.MyUser;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

class OpenCSVParseToBeanWithoutAnnotation {
    private static final String SAMPLE_CSV_FILE_PATH = "users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType( MyUser.class);
            String[] memberFieldsToBindTo = {"name", "email", "phoneNo", "country"};
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<MyUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<MyUser> myUserIterator = csvToBean.iterator();

            while (myUserIterator.hasNext()) {
                MyUser myUser = myUserIterator.next();
                System.out.println("Name : " + myUser.getName());
                System.out.println("Email : " + myUser.getEmail());
                System.out.println("PhoneNo : " + myUser.getPhoneNo());
                System.out.println("Country : " + myUser.getCountry());
                System.out.println("---------------------------");
            }
        }
    }
}
