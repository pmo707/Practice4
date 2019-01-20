package ua.nure.pihnastyi.practice4;

import org.junit.Test;

import java.io.IOException;

public class Part5Test {
    @Test
    public void testConstructor(){
        new Part5();
    }
    @Test
    public void testMain() throws IOException {
        Part5.main(new String[]{});
    }
}
