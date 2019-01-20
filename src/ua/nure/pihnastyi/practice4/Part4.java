package ua.nure.pihnastyi.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable {
    private static final String ENCODING = "Cp1251";
    private String inputText;

    Part4(String inputText) {
        this.inputText = inputText;

    }

    @Override
    public Iterator iterator() {
        return new IterableIml();
    }

    private class IterableIml implements Iterator {
        private static final String REGEX = "([A-ZА-Я])([\\S\\s][^.]+)(\\.)";
        private Pattern pattern;
        private Matcher matcher;
        private boolean matcherHasNext;

        IterableIml() {
            pattern = Pattern.compile(REGEX);
            matcher = pattern.matcher(inputText);
            matcherHasNext = matcher.find();
        }

        @Override
        public boolean hasNext() {
            return matcherHasNext;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String result = matcher.group().replace(System.lineSeparator(), "");
            matcherHasNext = matcher.find();
            return result;
        }
    }

    public static void main(String[] args) {
        String inputText = Util.readFile("part4.txt", ENCODING);
        Part4 part4 = new Part4(inputText);
        for (Object aPart4 : part4) {
            System.out.println(aPart4);
        }
    }
}
