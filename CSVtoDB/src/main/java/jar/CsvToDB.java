package jar;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

import com.opencsv.CSVReader;

public class CsvToDB {

    public static int received;
    public static int successful;
    public static int failed;

    public static void readCSVFile(String filePath) throws IOException {
        try {

            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);

            Connection connection = DriverManager.getConnection("jdbc:sqlite://ms3Interview.db");
            Statement statement = connection.createStatement();

            String[] nextRecord;
            while((nextRecord = csvReader.readNext()) != null){
                received++;
                    for(String cell : nextRecord) {
                        if(isValid(cell)){
                            successful++;
                            statement.executeUpdate("INSERT INTO customers" + nextRecord);
                        }                        
                    }                
            }
            csvReader.close();
        } catch (Exception e) {
            failed++;
            e.printStackTrace();
        }
        writeStatsToLog();        
    }

    private static boolean isValid(String cell){
        boolean isValid = true;
        if(cell == null || cell.isEmpty()){
            isValid = false;
        }
        return isValid;
    }

    private static void writeStatsToLog(){

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Received", received);
        stats.put("Successful", successful);
        stats.put("Failed", failed);

        try{
            FileOutputStream outputFile = new FileOutputStream("CSVtoDB/statistics.log");
            ObjectOutputStream output = new ObjectOutputStream(outputFile);
            output.writeObject(stats);
            output.close();
            outputFile.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}