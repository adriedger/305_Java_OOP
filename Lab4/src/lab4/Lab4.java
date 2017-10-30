/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4;

import java.util.List;
import java.util.Map;

/**
 *
 * @author adriedger
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadDict reader = new ReadDict();
        Map<String, List<String>> mapper = reader.buildMap();
    }    
}
