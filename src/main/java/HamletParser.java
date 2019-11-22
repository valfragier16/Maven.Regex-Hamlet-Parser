import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;


    public HamletParser(){
        this.hamletData = loadFile();
    }



    public static String replacer(String value, String original, String replace){
        Pattern pattern = Pattern.compile("(?i:" + original +")");
        Matcher matcher = pattern.matcher(value);
        value = matcher.replaceAll(replace);
        return value;
    }

    public static String hamletReplacer(String value){
        return replacer(value,"Hamlet", "Leon");
    }
    public static String horatioReplacer(String value){
        return replacer(value,"Horatio", "Tariq");
    }

    public static String opheliaReplacer(String value) { return replacer(value, "Ophelia", "Valerie");}

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public static Boolean finder(String input, String value) {
        Pattern pattern = Pattern.compile("(?i:" + value + ")");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
