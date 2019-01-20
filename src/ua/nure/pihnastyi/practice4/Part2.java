package ua.nure.pihnastyi.practice4;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;


import java.util.Random;

public class Part2 {
    private static final String FILE_ENCODING = "UTF-8";
    private static final String NUMBERS_FILE_NAME = "part2.txt";
    private static final String SORTED_NUMBERS_FILE_NAME = "part2_sorted.txt";

    private static final String INPUT_TITLE = "input ==> ";
    private static final String OUTPUT_TITLE = "output ==> ";

    private static final int NUMBERS_COUNT = 10;
    private static final int MAX_NUMBER_VALUE = 50;

    public static void main(String[] args) throws IOException {
        int[] numbersArray = getRandomNumbersArray(NUMBERS_COUNT, MAX_NUMBER_VALUE);

        writeFile(NUMBERS_FILE_NAME, convertNumbersToString(numbersArray));
        printFile(NUMBERS_FILE_NAME, INPUT_TITLE);

        bubbleSort(numbersArray);

        writeFile(SORTED_NUMBERS_FILE_NAME,
                convertNumbersToString(numbersArray));
        printFile(SORTED_NUMBERS_FILE_NAME, OUTPUT_TITLE);
    }

    private static int[] getRandomNumbersArray(int count, int maxValue) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(maxValue);
        }

        return numbers;
    }

    private static String convertNumbersToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        return sb.toString().trim();
    }

    private static void writeFile(String fileName, String input) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName), FILE_ENCODING)) {
            writer.write(input);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printFile(String fileName, String title) {
        String input = Util.readFile(fileName, FILE_ENCODING);
        System.out.print(title);
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
