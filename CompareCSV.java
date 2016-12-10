import java.io.*;
import java.util.*;

public class CompareCSV {

    public static void main(String[] args) {

        String fileName = "student.csv";
        try {
            BufferedReader br = new BufferedReader( new FileReader(fileName));
            String strLine = null;
            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;

            while((fileName = br.readLine()) != null) {
                lineNumber++;
                String[] result = fileName.split(",");
                for (int x=0; x<result.length; x++) {
                    System.out.println(result[x]);
                }
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}