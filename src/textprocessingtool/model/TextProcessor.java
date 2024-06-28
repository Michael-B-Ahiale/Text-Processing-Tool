package textprocessingtool.model;

import java.util.List;

public class TextProcessor {

            //Method to count number of words in a given text
            public static int wordCount(String text){
                text=text.trim();
                if(text.isEmpty()){
                    return 0;
                }
                return text.split("\\s+").length;
            }

            //Method to count the occurences of a specific word in the text
            public static int wordOccurenceCount(String text,String word){
                text=text.toLowerCase();
                word=word.toLowerCase();

                String pattern="\\b"+word+"\\b";
                List<String> matches= RegexHelper.findAllMatches(text,pattern);

                return matches.size();
            }

            //Method to capitalize the first letter of each word
            public static String capitalizeWord(String text){
                if(text.isEmpty()){
                    return text;
                }

                String[] words =text.split("\\s+");
                StringBuilder result= new StringBuilder();

                for(String word:words){
                    if(!word.isEmpty()){
                        result.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1).toLowerCase())
                                .append(" ");
                    }
                }
                return result.toString().trim();
            }

            //method to reverse words
            public static String reverseWords(String text){
                String[] words = text.split("\\s+");
                StringBuilder reversed = new StringBuilder();

                // Append words in reverse order
                for (int i = words.length - 1; i >= 0; i--) {
                    reversed.append(words[i]).append(" ");
                }

                // Remove the trailing space and return the result
                return reversed.toString().trim();

            }
}
