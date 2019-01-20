package ua.nure.pihnastyi.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String FILE_NAME = "part3.txt";
    private static final String FILE_ENCODING = "Cp1251";
    private static final String SYSTEM_ENCODING = "UTF-8";

    public static final String SEPARATOR_REGEX = "\\S+";
    public static final String CHARACTER_REGEX = "^\\S$";
    public static final String STRING_REGEX = "[A-zА-я]{2,}";
    public static final String INTEGER_REGEX = "^(-|)?\\d+$";
    public static final String DOUBLE_REGEX = "^(((-|)?\\d+\\.(\\d+|))|((-|)?\\.\\d+))$";

    public static void main(String[] args) {
        String input = Util.readFile(FILE_NAME, FILE_ENCODING);
        
        Scanner in = new Scanner(System.in, SYSTEM_ENCODING);
        String regexType;
        String entriesString;
        while (in.hasNextLine()) {
            regexType = getRegexType(in.nextLine())
            entriesString = getEntriesStringByRegexType(input, regexType);
            System.out.println(entriesString);
        }
    }

    private static String getRegexType(String type) {
        String regexType = "";
        switch (type) {
            case "char":
                regexType = CHARACTER_REGEX;
                break;
            case "String":
                regexType = STRING_REGEX;
                break;
            case "int":
                regexType = INTEGER_REGEX;
                break;
            case "double":
                regexType = DOUBLE_REGEX;
                break;
            default:
                regexType = STRING_REGEX;
                break;
        }

        return regexType;
    }
    
    private static void getEntriesStringByRegexType(String input, 
            String regexType) {
        Pattern pattern = Pattern.compile(SEPARATOR_REGEX);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            Matcher typedMatcher = Pattern.compile(regexType)
                    .matcher(matcher.group());

            if (typedMatcher.find()) {
                sb.append(typedMatcher.group()).append(" ");
            }
        }

        return sb.toString();
    }
}
