package com.bridgelabz.introductionCSV;

public class CSVWriter {
    public String csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path.toString()));
        for (String[] array : stringArray) {
            writer.writeNext(array);
        }

        writer.close();
        return Helpers.readFile(path);
    }

    public String csvWriterOneByOne() throws Exception{
        Path path = Paths.get(
                ClassLoader.getSystemResource("csv/writtenOneByOne.csv").toURI());
        return CsvWriterExamples.csvWriterOneByOne(Helpers.fourColumnCsvString(), path);
    }

    public String csvWriterAll(List<String[]> stringArray, Path path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path.toString()));
        writer.writeAll(stringArray);
        writer.close();
        return Helpers.readFile(path);
    }

    public String csvWriterAll() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource("csv/writtenAll.csv").toURI());
        return CsvWriterExamples.csvWriterAll(Helpers.fourColumnCsvString(), path);
    }
}
