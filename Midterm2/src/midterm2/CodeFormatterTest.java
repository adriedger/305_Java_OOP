package midterm2;

import midterm2.IndentFormatter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

// This class tests your AllmanStyle implementation and shows the expected
// behaviour of your implementation.
// It reads the content of Ticket.java, constructs an AllmanStyle formatter 
// (and sets the number of spaces per indent level), and prints out the returned 
// value of the format method. The format method should return properly 
// formatted program following the Allman indent style (see examples in the 
// MidtermNov22.pdf).
public class CodeFormatterTest {
    public static void main(String[] args) {
        try {
            String javaProgram = readContent("Ticket.java");
            
            // 2 spaces per indent level - see the expected output in Fig. 1.
            IndentFormatter kAndRFormatter = new KandRStyle(2);
            System.out.println(kAndRFormatter.format(javaProgram));
            
            System.out.println();
            
            // 4 spaces per indent level - see the expected output in Fig. 2.
            kAndRFormatter.setIndentSize(4);
            System.out.println(kAndRFormatter.format(javaProgram));
        } 
        catch (IOException ex) {
            System.err.println("Cannot open file");
        }
    }
    
    // This method reads the whole content of the given filename and returns
    // it as a String object.
    // Do not modify this method!
    private static String readContent(String filename) throws IOException {
        Scanner javaFile = new Scanner(Paths.get(filename));
        StringBuilder builder = new StringBuilder();
        while (javaFile.hasNextLine()) {
            builder.append(javaFile.nextLine())
                    .append("\n");
        }
        return builder.toString();
    }
}
