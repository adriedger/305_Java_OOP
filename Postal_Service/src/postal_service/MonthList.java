/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postal_service;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author adriedger
 */
public class MonthList {
    private static List<Months> list = new ArrayList<>();
    
    public MonthList(List<Months> input){
        list = input;
        Collections.sort(list, new Comparator<Months>() {
            public int compare(Months o1, Months o2) {
                return o1.number() < o2.number() ? -1 : o1.number() == o2.number() ? 0 : 1;
            }
        });
    }
    private Months minOffice(){
        Months min = list.get(0);
        for(Months m : list){
            if(m.officeCount() < min.officeCount()){
                min = m;
            }
        }
        return min;
    }
//    private int minTruck(){}
//    private int minAirport(){}
//    private int maxOffice(){}
//    private int maxTruck(){}
//    private int maxAirport(){}
    public void output(){
        int officeTotal = 0;
        int truckTotal = 0;
        int airportTotal = 0;
        for(Months m : list){
            officeTotal += m.officeCount();
            truckTotal += m.truckCount();
            airportTotal += m.airportCount();
            System.out.println(m.shortName()+" "+m.officeCount()+" "+m.truckCount()+" "+ m.airportCount()
                +" "+(m.officeCount()+m.truckCount()+m.airportCount()));
        }
        System.out.println(officeTotal+" "+truckTotal+" "+airportTotal+" "+
                (officeTotal+truckTotal+airportTotal));
        System.out.println(minOffice().officeCount()+" "+minOffice().shortName());
    }
}
