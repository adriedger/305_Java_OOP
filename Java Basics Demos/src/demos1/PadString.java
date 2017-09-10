package demos1;

/**
 * This demonstrates a function which pads a string with spaces to a specified
 * length.
 * 
 * @author Brian Brookwell
 */
public class PadString {
    /**
     * main -- This is called to run this application
     * 
     * @param args Parameters passed by system when application is run
     */
    public static void main(String[] args) {
        System.out.println("'" + padString("hello", 8) + "'");
        System.out.println("'" + padString("congradulations", 10) + "'");
    }
    
    /** 
     * returns a string which is the source string with sufficient spaces to have
     * a length specified by the width.  If the word starts too long, word is
     * returned unmodified
     * 
     * @param source String being padded
     * @param width Character width of the resulting string
     * @return a String which is the padded string or the original word
     */
    
    public static String padString (String source, int width) {
        if (source.length() >= width)
            return source;
        
        StringBuilder build = new StringBuilder();
        build.append(source);
        for (int i=source.length();i < width;i++) {
            build.append(" ");
        }
        return build.toString();
            
    }
}
