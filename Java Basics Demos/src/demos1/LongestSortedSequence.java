package demos1;

/**
 * This finds and returns the number of values in the longest sorted sequence in 
 * an array of integers
 * 
 * @author Brian Brookwell
 */
public class LongestSortedSequence {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main (String[] args) {
        int[] data = {3, 8, 10, -3, 0, 0, 14, 207, 45, 98, 12};
        int[] data1 = {3, 8, 10, 45, 98, 12, -3, 0, 0, 14, 207};
        int[] data2 = {};
        
        System.out.println ("Data Maximum Sequence (5) = " + maxLength(data));
        System.out.println ("Data1 Maximum Sequence(5) = " + maxLength(data1));
        System.out.println ("Data2 Maximum Sequence(0) = " + maxLength(data2));
    }
/**
 * maxLength returns the length of the maximum sorted 
 *
 * @param data Array of integers for which maximum sorted length *			is being determined
 * @return Length of the maximum sorted list
 */

    private static int maxLength (int[] data) {
        int start = 0;
        int maxLength = 0;
        for (int idx=1;idx < data.length;idx++)
            if (data[idx] < data[idx-1]) {
                int length = idx - start;
                if (length > maxLength) {
                    maxLength = length;
                    start = idx;
                }
            }
        
        int tail = data.length - start - 1;
        return (tail > maxLength)?tail:maxLength;
    }
}
