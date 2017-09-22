/*
 * Macewan University CMPT 305 Professor:Brian Brookwell
 */
package postal_service;

/**
 *
 * @author adriedger
 */
public class Months {
    private static final String[] months = {"January","February","March","April","May","June"
                ,"July","August","September","October","November","December"};
    private int monthNumber;
    private int office;
    private int truck;
    private int airport;
    
    /**
     * sets monthNumber to correspond with month in the String array
     * @param entry input string which is a month
     */
    public Months (String entry) {
        for(String s: months){
            if(!entry.equals(s))
                monthNumber++;
            else
                return;
        }
    }
    /** 
     * sorts postal codes into destinations
     * @param code the postal pode
     */
    public void addCode(String code) {
        String first = code.substring(0,1);
        if(first.equals("T"))
            office++;       
        else if(first.equals("V") || first.equals("S"))
            truck++;       
        else
            airport++;            
    }    
    /**
     * checks if input is a month
     * @param entry the input string
     * @return boolean true if the string is a month, false if it is not
     */
    public static boolean isMonth(String entry) {
        for(String s: months){
            if(entry.equals(s))
                return true;
        }
        return false;
    }
    public int number() {return monthNumber;}
    public String shortName() {return months[monthNumber].substring (0, 3);}
    public int officeCount() {return office;}
    public int truckCount() {return truck;}
    public int airportCount() {return airport;}
}