package ua.nure.pihnastyi.practice4;


import org.junit.Assert;
import org.junit.Test;

public class Part1Test {


    private String input = "My name is Max Pihnastyi";
    private String out = "My NAME is Max PIHNASTYI";

    @Test
    public void testConvertToUpperMoreFour() {
        Assert.assertEquals(out, Part1.convertMatchedWordsToUpperCase(input));
    }

    @Test
    public void testMain() {
        Part1.main(new String[]{});
    }

    @Test
    public void testConstructor() {
        new Part1();
    }
}