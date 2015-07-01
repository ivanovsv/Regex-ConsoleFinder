import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This app searches for occurrences of a given expression in a log file.
 * Output can be piped in via console to any file.
 *
 * Created by IvanovsV on 01/07/2015.
 */
public class ConsoleFinder {
    public static void main(String[] args) throws IOException {
        String toFind = args[0];
        String regex = args[1];
        File file = new File(toFind);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Pattern pattern = Pattern.compile(regex);

        int lineNumber = 1;
        int count = 0;
        String line;
        Long startTime = System.currentTimeMillis();
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                count++;
                System.out.println("Line " + lineNumber + " : \t " + line );
            }
            lineNumber++;
        }
        Long stopTime = System.currentTimeMillis();
        System.out.println("Found Total: " + regex + " > " + count + " times");
        System.out.println("Found in " + (stopTime - startTime) + " ms");
    }
}
