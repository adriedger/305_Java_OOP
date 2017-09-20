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
    private List<Months> minMonths(){
        List<Months> minMonths = new ArrayList<>();
        Months minOffice = list.get(0);
        Months minTruck = list.get(0);
        Months minAirport = list.get(0);
        for(Months m : list){
            if(m.officeCount() < minOffice.officeCount())
                minOffice = m;
            if(m.truckCount() < minTruck.truckCount())
                minTruck = m;
            if(m.airportCount() < minAirport.airportCount())
                minAirport = m;
        }
        minMonths.add(minOffice);
        minMonths.add(minTruck);
        minMonths.add(minAirport);
        return minMonths;
    }
    private List<Months> maxMonths(){
        List<Months> maxMonths = new ArrayList<>();
        Months maxOffice = list.get(0);
        Months maxTruck = list.get(0);
        Months maxAirport = list.get(0);
        for(Months m : list){
            if(m.officeCount() > maxOffice.officeCount())
                maxOffice = m;
            if(m.truckCount() > maxTruck.truckCount())
                maxTruck = m;
            if(m.airportCount() > maxAirport.airportCount())
                maxAirport = m;
        }
        maxMonths.add(maxOffice);
        maxMonths.add(maxTruck);
        maxMonths.add(maxAirport);
        return maxMonths;
    }
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
        List<Months> min = new ArrayList<>();
        min = minMonths();
        System.out.println(min.get(0).officeCount()+" "+min.get(0).shortName());
        System.out.println(min.get(1).truckCount()+" "+min.get(1).shortName());
        System.out.println(min.get(2).airportCount()+" "+min.get(2).shortName());
        List<Months> max = new ArrayList<>();
        max = maxMonths();
        System.out.println(max.get(0).officeCount()+" "+max.get(0).shortName());
        System.out.println(max.get(1).truckCount()+" "+max.get(1).shortName());
        System.out.println(max.get(2).airportCount()+" "+max.get(2).shortName());
    }
}
