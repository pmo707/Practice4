package ua.nure.pihnastyi.practice4;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
    private static final String BASE_NAME = "resources";
    private static final String REGEX = "^(\\w+)\\s(\\w+)$";
    private static final int MATCHER_GROUP_NAME_INDEX = 1;
    private static final int MATCHER_GROUP_LANGUAGE_INDEX = 2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, Charset.defaultCharset().name());
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(MATCHER_GROUP_NAME_INDEX);
                String language = matcher.group(MATCHER_GROUP_LANGUAGE_INDEX);
                ResourceBundle resource = ResourceBundle.getBundle(BASE_NAME, new Locale(language));
                System.out.println(resource.getString(name));
            }
        }
    }

}