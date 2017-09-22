/*
 * Macewan University CMPT 305 Professor:Brian Brookwell
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
    private Months minOffice;
    private Months minTruck;
    private Months minAirport;
    private Months maxOffice;
    private Months maxTruck;
    private Months maxAirport;
    
    /**
     * sorts list of months into calendar order
     * finds min and max of each destination
     * @param input list of months
     */
    public MonthList(List<Months> input){
        list = input;
        Collections.sort(list, new Comparator<Months>() {
            public int compare(Months o1, Months o2) {
                return o1.number() < o2.number() ? -1 : o1.number() == o2.number() ? 0 : 1;
            }
        });
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
    }
    /**
     * outputs info onto console
     */
    public void output(){
        System.out.println("    Office Truck Airport Total/Month");
        int officeTotal = 0;
        int truckTotal = 0;
        int airportTotal = 0;
        for(Months m : list){
            officeTotal += m.officeCount();
            truckTotal += m.truckCount();
            airportTotal += m.airportCount();
            System.out.format("%3s%6d%7d%8d%8d\n",m.shortName(),m.officeCount(),m.truckCount(),m.airportCount()
                ,(m.officeCount()+m.truckCount()+m.airportCount()));
        }
        System.out.format("%9d%7d%8d%8d\n",officeTotal,truckTotal,airportTotal
                ,(officeTotal+truckTotal+airportTotal));
        System.out.println("Min(Post Office): "+minOffice.officeCount()+","+minOffice.shortName());
        System.out.println("Min(Truck Depot): "+minTruck.truckCount()+","+minTruck.shortName());
        System.out.println("Min(Airport): "+minAirport.airportCount()+","+minAirport.shortName());
        System.out.println("Max(Post Office): "+maxOffice.officeCount()+","+maxOffice.shortName());
        System.out.println("Max(Truck Depot): "+maxTruck.truckCount()+","+maxTruck.shortName());
        System.out.println("Max(Airport): "+maxAirport.airportCount()+","+maxAirport.shortName());
    }
}
