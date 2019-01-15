package ua.nure.pihnastyi.practice4;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Util {


    public static String readFile(String path,String encoding) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, encoding);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt","Cp1251"));
    }

}