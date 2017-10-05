package midterm1;

import java.util.HashMap;
import java.util.Map;

/**
 * MatcherTest contains code that tests and shows the expected behaviours of 
 * Matcher. 
 * 
 * Run and analyze this class to see the expected behaviours and requirements of 
 * Matcher. Passing all of these tests, however, does not guarantee the 
 * correctness of your code. Study these test cases to understand the 
 * requirements of Matcher and think carefully how you can implement the 
 * required features properly.
 * 
 * Maximum points for Matcher implementation: 30 points.
 * 6 out of 30 points are allocated for the overall quality of your Matcher 
 * implementation. Think of best practices in programming that we've discussed 
 * in class.
 * 
 * Do not modify this class!
 */
public class MatcherTest {
    public static void main(String[] args) {
        testSinglePair();
        testMultiplePairs();
    }
    
    private static void testSinglePair() {
        System.out.println("Test Single Pair:");
        
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        
        Matcher m = new Matcher(pairs);
        
        String empty = "";
        String noPairs = "[<still considered balanced";
        
        String matched1 = "nice { and } balanced { }";
        String matched2 = "{ ([ dfdf ] dfdf ) ]]]]]] }";
        String matched3 = "{{{<><<<[[]] }}} only this {} pair matters here";
        
        String unmatched1 = "{{{{ unbalanced }}";
        String unmatched2 = "{{{ unbalanced }}}}}}}";

        System.out.println("pass test empty: " + m.match(empty));
        System.out.println("pass test no pairs: " + m.match(noPairs));
        System.out.println("pass test matched1: " + m.match(matched1));
        System.out.println("pass test matched2: " + m.match(matched2));
        System.out.println("pass test matched3: " + m.match(matched3));
        
        System.out.println("pass test unmatched1: " + !m.match(unmatched1));
        System.out.println("pass test unmatched2: " + !m.match(unmatched2));
        System.out.println();
    }
    
    private static void testMultiplePairs() {
        System.out.println("Test Multiple Pairs:");
        
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('<', '>');
        
        Matcher m = new Matcher(pairs);
        
        String matched1 = "nice { <and> } ([balanced]) { }";
        String matched2 = "{ <html> [ fn(list[idx]) ] }";
        String matched3 = "<><<[[]]>> [][] {((balanced))} non-overlapping";
        
        String unmatched1 = "{{[[ unbalanced }}";
        String unmatched2 = "{< pairs } > overlapping";
        String unmatched3 = "((( unbalanced )))))))";
        String unmatched4 = "<<< {>}>> pairs overlapping";

        System.out.println("pass test matched1: " + m.match(matched1));
        System.out.println("pass test matched2: " + m.match(matched2));
        System.out.println("pass test matched3: " + m.match(matched3));
        
        System.out.println("pass test unmatched1: " + !m.match(unmatched1));
        System.out.println("pass test unmatched2: " + !m.match(unmatched2));
        System.out.println("pass test unmatched3: " + !m.match(unmatched3));
        System.out.println("pass test unmatched4: " + !m.match(unmatched4));                
    }
}
