// Implementation of Java File Reader.
// Developed on 02.03.2022
// Developed by Kritidipta Ghosh_11100119002
// Developed in Computer Networks Lab.

import java.io.*;

public class MyFileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int ch;
        while ((ch = fr.read()) != -1)
            System.out.print((char) ch);
        fr.close();
    }
}