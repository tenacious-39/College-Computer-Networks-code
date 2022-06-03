// Implementation of Java File Writer.
// Developed on 02.03.2022
// Developed by Kritidipta Ghosh_11100119002
// Developed in Computer Networks Lab.

import java.io.*;
import java.util.*;

public class MyFileWriter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be written:");
        String str = sc.nextLine();

        FileWriter fw = new FileWriter("output.txt");
        for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }
        System.out.println("Successfully written");
        fw.close();
        sc.close();
    }
}
