package ua.nure.pihnastyi.practice4;

import org.junit.Test;

import java.io.IOException;

public class Part2Test {
    @Test
    public void testConstructor() {
        new Part2();
    }

    @Test
    public void testMain() throws IOException {
        Part2.main(new String[]{});
    }

    @Test
    public void testPrintFile() {
        Part2.printFile("part2.txt", "+++");
    }
}
