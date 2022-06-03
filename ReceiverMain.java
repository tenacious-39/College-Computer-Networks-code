// Implementation of Java CRC(Receiver side).
// Developed on 16.03.2022
// Developed by Kritidipta Ghosh_11100119002
// Developed in Computer Networks Lab.

import java.util.*;

class CRC {
    void Receiver(String codeword, String crc) {
        int n = codeword.length(), m = crc.length();
        char[] encoded = new char[n];
        for (int i = 0; i < n; i++) {
            encoded[i] = codeword.charAt(i);
        }
        n -= m;

        for (int i = 0; i <= n;) {
            int j = 0;
            for (j = 0; j < m; j++) {
                encoded[i + j] = (encoded[i + j] == crc.charAt(j)) ? '0' : '1';
            }
            for (; i <= n; i++) {
                if (encoded[i] == '1')
                    break;
            }
        }

        for (int i = n; i < n + m; i++) {
            if (encoded[i] == '1') {
                System.out.println("Error detected.");
                return;
            }
        }
        System.out.println("No error detected.");
    }
}

public class ReceiverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the codeword:");
        String codeword = sc.next();
        System.out.println("Enter the crc generator:");
        String crc = sc.next();
        CRC obj = new CRC();
        obj.Receiver(codeword, crc);
        sc.close();
    }
}
