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
    private List<Months> minMax(){
        List<Months> minMax = new ArrayList<>();
        Months minOffice, minTruck, minAirport, maxOffice, maxTruck ,maxAirport;
        minOffice = minTruck = minAirport = maxOffice = maxTruck = maxAirport = list.get(0);
        for(Months m : list){
            if(m.officeCount() < minOffice.officeCount())
                minOffice = m;
            if(m.truckCount() < minTruck.truckCount())
                minTruck = m;
            if(m.airportCount() < minAirport.airportCount())
                minAirport = m;
            if(m.officeCount() > maxOffice.officeCount())
                maxOffice = m;
            if(m.truckCount() > maxTruck.truckCount())
                maxTruck = m;
            if(m.airportCount() > maxAirport.airportCount())
                maxAirport = m;
        }
        minMax.add(minOffice);
        minMax.add(minTruck);
        minMax.add(minAirport);
        minMax.add(maxOffice);
        minMax.add(maxTruck);
        minMax.add(maxAirport);
        return minMax;
    }
    public void output(){
        System.out.println("    Office Truck Airport Total/Month");
        int officeTotal = 0;
        int truckTotal = 0;
        int airportTotal = 0;
        for(Months m : list){
            officeTotal += m.officeCount();
            truckTotal += m.truckCount();
            airportTotal += m.airportCount();
            System.out.format("%3s%7d%6d%8d%8d\n",m.shortName(),m.officeCount(),m.truckCount(),m.airportCount()
                ,(m.officeCount()+m.truckCount()+m.airportCount()));
        }
        System.out.format("%10d%6d%8d%8d\n",officeTotal,truckTotal,airportTotal
                ,(officeTotal+truckTotal+airportTotal));
        List<Months> minMax = minMax();
        System.out.println("Min(Post Office): "+minMax.get(0).officeCount()+","+minMax.get(0).shortName());
        System.out.println("Min(Truck Depot): "+minMax.get(1).truckCount()+","+minMax.get(1).shortName());
        System.out.println("Min(Airport): "+minMax.get(2).airportCount()+","+minMax.get(2).shortName());
        System.out.println("Max(Post Office): "+minMax.get(3).officeCount()+","+minMax.get(3).shortName());
        System.out.println("Max(Truck Depot): "+minMax.get(4).truckCount()+","+minMax.get(4).shortName());
        System.out.println("Max(Airport): "+minMax.get(5).airportCount()+","+minMax.get(5).shortName());
    }
}
