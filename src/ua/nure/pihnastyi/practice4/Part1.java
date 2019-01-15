package ua.nure.pihnastyi.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String REGEX = "[A-zА-яёЁІіЇї]+";

    public static void main(String[] args) {

        String input = Util.readFile("part1.txt", "Cp1251");
        System.out.println(convertToUpperMoreFour(input));
    }

    public static String convertToUpperMoreFour(String input) {
        Pattern pat = Pattern.compile(REGEX);
        Matcher matcher = pat.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
if (matcher.group().length()>3) {
    matcher.appendReplacement(sb, matcher.group().toUpperCase());
}

        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}