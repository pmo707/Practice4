package ua.nure.pihnastyi.practice4;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static final String ENCODING = "UTF-8";
    private static final String FILE1 = "part2.txt";
    private static final String FILE2 = "part2_sorted.txt";
    public static final int COUNT = 10;
    public static final String REGEX_EX = "[\\d]+";


    public static void main(String[] args) throws IOException {

        writeToFile();
        String input = Util.readFile("part2.txt", ENCODING);
        sortElements(input);
        System.out.print("input ==> ");
        printFile("part2.txt");
        System.out.print("output ==> ");
        printFile("part2_sorted.txt");


    }

    public static void writeToFile() throws IOException {
        int[] arrayNumber = new int[COUNT];
        FileWriter writer = new FileWriter(FILE1, false);
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < COUNT; i++) {
            arrayNumber[i] = random.nextInt(50);
            sb.append(arrayNumber[i]).append(" ");
        }
        writer.write(sb.toString().trim());
        writer.flush();
    }

    public static void printFile(String nameFile) {

        String input = Util.readFile(nameFile, "UTF-8");
        System.out.println(input);

    }

    public static void sortElements(String input) throws IOException {
        FileWriter writer = new FileWriter(FILE2, false);
        int[] arrayNumber = new int[COUNT];
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX_EX);
        Matcher matcher = pattern.matcher(input);
        int indexArray = 0;

        while (matcher.find()) {
            arrayNumber[indexArray] = Integer.parseInt(matcher.group());
            indexArray++;
        }
        int temporary;
        for (int i = 0; i < arrayNumber.length; i++)
            for (int j = 0; j < arrayNumber.length - i - 1; j++)
                if (arrayNumber[j] > arrayNumber[j + 1]) {
                    temporary = arrayNumber[j];
                    arrayNumber[j] = arrayNumber[j + 1];
                    arrayNumber[j + 1] = temporary;
                }
        for (int i = 0; i < COUNT; i++) {
            sb.append(arrayNumber[i]).append(" ");
        }
        writer.write(sb.toString().trim());
        writer.flush();

    }

}
