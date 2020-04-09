package com.bridgelabz.introductionCSV;

public class CSVReader {
    public static void main(String[] args) {

    }
    public List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }
    public String readAllExample() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("csv/twoColumn.csv").toURI()));
        return CsvReaderExamples.readAll(reader).toString();
    }
    public List<String[]> oneByOne(Reader reader) throws Exception {
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        reader.close();
        csvReader.close();
        return list;
    }

    public String oneByOneExample() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("csv/twoColumn.csv").toURI()));
        return CsvReaderExamples.oneByOne(reader).toString();
    }
    CSVParser parser = new CSVParserBuilder()
            .withSeparator(',')
            .withIgnoreQuotations(true)
            .build();

    CSVReader csvReader = new CSVReaderBuilder(reader)
            .withSkipLines(0)
            .withCSVParser(parser)
            .build();
}
