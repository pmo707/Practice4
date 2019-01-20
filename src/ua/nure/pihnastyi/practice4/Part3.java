package ua.nure.pihnastyi.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String SEPARATOR = "\\S+";
    public static final String REGEX_CHAR = "^\\S$";
    public static final String REGEX_STRING = "[A-zА-я]{2,}";
    public static final String REGEX_INT = "^(-|)?\\d+$";
    public static final String REGEX_DOUBLE = "^(((-|)?\\d+\\.(\\d+|))|((-|)?\\.\\d+))$";


    public static void main(String[] args) {
        String inputLine = Util.readFile("part3.txt", "Cp1251");
        Scanner in = new Scanner(System.in, "UTF-8");
        while (in.hasNextLine()) {
            System.out.println(getType(in.nextLine(), inputLine));
        }
    }

    public static String getType(String consoleIn, String input) {
        String isType;
        switch (consoleIn) {
            case "char":
                isType = REGEX_CHAR;
                break;
            case "String":
                isType = REGEX_STRING;
                break;
            case "double":
                isType = REGEX_DOUBLE;
                break;
            case "int":
                isType = REGEX_INT;
                break;
            default:
                isType = "";
                break;
        }

        Pattern pattern = Pattern.compile(SEPARATOR);
        Matcher m = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            Matcher mType = Pattern.compile(isType).matcher(m.group());

            if (mType.find()) {
                sb.append(mType.group()).append(" ");
            }
        }
        return sb.toString();
    }


}