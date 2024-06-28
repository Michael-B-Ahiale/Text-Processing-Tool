package textprocessingtool.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class RegexHelper {
    //method to check if a given string contains a certain pattern
    public static boolean containsPattern(String text, String pattern){
        //pattern object from the pattern string
        Pattern regexPattern=Pattern.compile(pattern);

        //matcher object that will search the text
        Matcher matcher=regexPattern.matcher(text);

        return matcher.find();

    }
    //method to find all occurences of a pattern in the text
    public static List<String> findAllMatches(String text, String pattern){
            List<String> matches =new ArrayList<>();
            Pattern regexPattern=Pattern.compile(pattern);
            Matcher matcher = regexPattern.matcher(text);

            while(matcher.find()){
                matches.add(matcher.group());
            }
            return matches;
    }
    // This method replaces all occurrences of a pattern with a replacement string
    public static String replaceAll(String text, String pattern, String replacement) {
        // Compile the pattern
        Pattern regexPattern = Pattern.compile(pattern);

        // Use the replaceAll method of Matcher to replace all occurrences
        return regexPattern.matcher(text).replaceAll(replacement);
    }
}
