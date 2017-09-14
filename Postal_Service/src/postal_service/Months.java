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
                ,"July","September","October","November","December"};
    private int monthNumber;
    private int codes;
    
    public Months (String entry) {
        codes = 0;
        monthNumber = 0;
        for(String s: months){
            if(!entry.equals(s))
                monthNumber++;
            else
                return;
        }
    }
    
    public int number () {return monthNumber;}
    public String shortName () {return months[monthNumber].substring (0, 3);}
    public static boolean isMonth (String entry) {
        for(String s: months){
            if(entry.equals(s))
                return true;
        }
        return false;
    }
    public void addCode(String code) {
        codes++;
    }
}
