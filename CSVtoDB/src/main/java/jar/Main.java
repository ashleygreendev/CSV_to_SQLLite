package jar;

import java.io.IOException;

import jar.CsvToDB;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvToDB csvToDB = new CsvToDB();
        csvToDB.readCSVFile("ms3Interview.csv");
    }
}
