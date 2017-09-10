package demos1;

/**
 * This program demonstrates how an array is passed.  The contents of the array
 * are mutable even if the actual parameter itself is pass by value
 * 
 * @author Brian Brookwell
 */
public class ArrayProgram {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        int[] myArray = {74, 85, 102, 99, 101, 85, 56};
        System.out.println(lastIndexOf(myArray, 85));
    }

    /**
     * LatIndexOf - returns the index of the last entry in the array that 
     * matches the value passed as a parameter
     *
     * @param num Array being searched for the value
     * @param val Value being searched for
     * @return index of last occurrence of the value in the array or a -1 if the 
     *          value cannot be found
     */
    public static int lastIndexOf(int[] num, int val) {
        int index = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == val) {
                index = i;
            }
        }
        return index;
    }
}
