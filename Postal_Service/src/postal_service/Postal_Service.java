/*
 * Macewan University CMPT 305 Professor:Brian Brookwell
 */
package postal_service;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author adriedger
 */
public class Postal_Service {
    
    /**
     * gets input file name from user
     * @param args the command line arguments    
     */
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        String input = console.nextLine();
        try{
            Scanner inFile = new Scanner(Paths.get(input));             
            MonthList myList = new MonthList(processEntries(inFile));
            myList.output();
            
        } 
        catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Could not find file path."); 
        }
        
    }
    /**
     * processes lines of input file
     * skips blank lines, tokenizes by space, checks if line is month or code
     * @param inFile path to the input text file
     * @return monthList a list of months 
     */
    private static List<Months> processEntries(Scanner inFile){
        Months current = new Months("January");
        List<Months> monthList = new ArrayList<>();
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();            
            if(!line.equals("")) {
                Scanner token = new Scanner(line).useDelimiter(" ");
                String entry = token.next();
                if(Months.isMonth(entry)){
                    current = new Months(entry);
                    monthList.add(current);
                } 
                else{
                    current.addCode(entry);                    
                }
            }
        }
        return monthList;
    }
}
