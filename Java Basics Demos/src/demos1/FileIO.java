package demos1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * This program reads a file called 'hours.txt'  Each line consists of an
 * employee id, an employee name and a list of hours worked (float)
 * 
 * @author Brian Brookwell
 */
public class FileIO {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main (String[] args) {
        try {
            Scanner inFile = new Scanner (Paths.get("hours.txt"));
            while (inFile.hasNextLine()) {
                String dataLine = inFile.nextLine();
                
                System.out.println (processEmployee (dataLine));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println ("Couldn't find 'words.txt'");
            return;
        }
    }
    
    /**
     * Parses the input line and creates a computation line or an error message
     * depending upon the contents of the input data line
     * 
     * @param dataLine Input data line: <Employee #> <Employee Name> <List of Hours Worked separated by spaces> 
     * @return Report output string or an error string
     */
    
    private static String processEmployee (String dataLine) {
        Scanner parser = new Scanner (dataLine);
        if (parser.hasNextInt()) {
            int id = parser.nextInt();

            if (parser.hasNext()) {
                String name = parser.next();

                BigDecimal time = new BigDecimal ("0.00");
                int count = 0;
                while (parser.hasNextBigDecimal()) {
                    BigDecimal hours = parser.nextBigDecimal();
                    time = time.add(hours);
                    count++;
                }

                return name + "(Id #: " + id + ") Hours Worked: " + time + 
                        " hours (" + time.divide (new BigDecimal(count)) + " hours/day)";
            } else {
                return "Line: " + dataLine + " :: No Employee Name";
            }
        } else {
            return "Line: " + dataLine + " :: Invalid Employee Id";
        }
    }
}
