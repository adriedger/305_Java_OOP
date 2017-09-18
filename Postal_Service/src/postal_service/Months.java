/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public Months (String entry) {
//        monthNumber = 1;
        for(String s: months){
            if(!entry.equals(s))
                monthNumber++;
            else
                return;
        }
    }
    public void addCode(String code) {
        String first = code.substring(0,1);
        if(first.equals("T")){
            office++;
        }
        else if(first.equals("V") || first.equals("S")){
            truck++;
        }
        else{
            airport++;
        }        
    }
    public int number() {return monthNumber;}
    public String shortName() {return months[monthNumber].substring (0, 3);}
    public static boolean isMonth(String entry) {
        for(String s: months){
            if(entry.equals(s))
                return true;
        }
        return false;
    }
    public int officeCount() {return office;}
    public int truckCount() {return truck;}
    public int airportCount() {return airport;}
}