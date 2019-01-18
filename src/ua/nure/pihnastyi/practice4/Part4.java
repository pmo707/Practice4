package ua.nure.pihnastyi.practice4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable {
    private static String ENCODING = "Cp1251";
    public static String inputText;
    StringBuilder stringBuilder = new StringBuilder();

    Part4(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public Iterator<String> iterator() {
        return new IterableIml();
    }

    private class IterableIml implements Iterator {
        private static final String REGEX = "([A-zА-я]+)(\\.?\\,?)(\\s)?";
        Pattern pattern;
        Matcher matcher;

        IterableIml() {
            pattern = Pattern.compile(REGEX);
            matcher = pattern.matcher(inputText);
        }

        @Override
        public boolean hasNext() {
            stringBuilder.setLength(0);
            while (matcher.find()) {
                stringBuilder.append(matcher.group(1));
                if (".".equals(matcher.group(2))) {
                    stringBuilder.append(matcher.group(2)).append(System.lineSeparator());
                    return true;
                } else stringBuilder.append(matcher.group(2));
                stringBuilder.append(" ");

            }

            return false;
        }

        @Override
        public Object next() {
            return stringBuilder.toString();
        }
    }


    public static void main(String[] args) {
        String inputText = Util.readFile("part4.txt", ENCODING);
        Part4 part4 = new Part4(inputText);
        Iterator<String> iterator = part4.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
