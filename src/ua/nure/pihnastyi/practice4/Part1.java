package ua.nure.pihnastyi.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final String INPUT_FILE_NAME = "part1.txt";
    private static final String FILE_ENCODING = "Cp1251";
    private static final String SINGLE_WORD_REGEX = "[A-zА-яёЁІіЇї]+";
    private static final int WORD_MAX_LENGTH = 3;

    public static void main(String[] args) {
        String input = Util.readFile(INPUT_FILE_NAME, FILE_ENCODING);
        System.out.println(convertMatchedWordsToUpperCase(input));
    }

    static String convertMatchedWordsToUpperCase(String input) {
        Pattern pattern = Pattern.compile(SINGLE_WORD_REGEX);
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        
        String matchedWord;
        while (matcher.find()) {
            matchedWord = matcher.group();
            if (matchedWord.length() > WORD_MAX_LENGTH) {
                matcher.appendReplacement(sb, matchedWord.toUpperCase());
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
