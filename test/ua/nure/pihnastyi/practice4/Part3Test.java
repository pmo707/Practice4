package ua.nure.pihnastyi.practice4;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Part3Test {
    private static final String ENCODING = "UTF-8";

    @Test
    public void testConstructor() {
        new Part3();
    }

    @Test
    public void testMain() throws IOException {
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(ENCODING)));
        Part3.main(new String[]{});
    }
}
