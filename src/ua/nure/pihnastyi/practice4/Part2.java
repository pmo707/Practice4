package ua.nure.pihnastyi.practice4;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static final String FILE_ENCODING = "UTF-8";
    private static final String NUMBERS_FILE_NAME = "part2.txt";
    private static final String SORTED_NUMBERS_FILE_NAME = "part2_sorted.txt";

    private static final String INPUT_TITLE = "input ==> ";
    private static final String OUTPUT_TITLE = "output ==> ";

    public static final int NUMBERS_COUNT = 10;
    public static final int MAX_NUMBER_VALUE = 50;

    private static int[] numbersArray;

    public static void main(String[] args) throws IOException {
        numbersArray = getRandomNumbersArray(NUMBERS_COUNT, MAX_NUMBER_VALUE);
        
        writeFile(NUMBERS_FILE_NAME, getFormattedNumbersString(numbersArray));
        printFile(NUMBERS_FILE_NAME, INPUT_TITLE);
        
        bubbleSort(numbersArray);
        
        writeFile(SORTED_NUMBERS_FILE_NAME,
                  getFormattedNumbersString(numbersArray));
        printFile(SORTED_NUMBERS_FILE_NAME, OUTPUT_TITLE);
    }

    private static getRandomNumbersArray(int count, int maxValue) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers[i] = random.nextInt(maxValue);
        }

        return numbers;
    }

    private static String getFormattedNumbersString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private static void writeFile(String fileName, String input) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName), FILE_ENCODING)) {
            writer.write(input);
            writer.flush();
    }

    private static void printFile(String fileName) {
        String input = Util.readFile(fileName, FILE_ENCODING);
        System.out.print(INPUT_TITLE);
        System.out.println(input);
    }

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
