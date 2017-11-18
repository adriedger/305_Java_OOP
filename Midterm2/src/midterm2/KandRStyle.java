package midterm2;

import java.util.Scanner;


public class KandRStyle implements midterm2.IndentFormatter {
    
    private StringBuilder builder;
    private int indentSize;
    
    public KandRStyle(int numSpaces) {
            builder = new StringBuilder();
            indentSize = numSpaces;
    }
       
    @Override
    public String format(String program) {
        // should return properly formatted program in Allman style
        Scanner reader = new Scanner(program);
        int count = 0;
        
        while(reader.hasNextLine()){
            String current = reader.nextLine();
                        
            if(!current.replace(" ", "").equals("{") && !current.replace(" ", "").equals("}")){
                addIndent(builder, count);
                builder.append(current.trim().replace("{", "").replace("}", "")).append("\n");
            }
            if(current.contains("{")){
                addIndent(builder, count);
                builder.append("{").append("\n");
                count++;               
            }
            if(current.contains("}")){
                count--;
                addIndent(builder, count);
                builder.append("}").append("\n");
            }
        }
        return builder.toString();
    }
    
    @Override
    public void setIndentSize(int numSpaces) {
        indentSize = numSpaces;
    }
    
    private void addIndent(StringBuilder builder, int count){
        for(int i = 0; i < (count*indentSize); i++){
                builder.append(" ");
        }
    }
}
