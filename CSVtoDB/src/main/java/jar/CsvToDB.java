package jar;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class CsvToDB {
    public static void readCSVFile(String filePath){
        try{
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
            
            String[] record;

            while((record = csvReader.readNext()) != null){
                for(String cell : record){
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}