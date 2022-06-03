// Implementation of Java CRC(Sender side).
// Developed on 16.03.2022
// Developed by Kritidipta Ghosh_11100119002
// Developed in Computer Networks Lab.

import java.util.*;

class CRC {
    String sender(String data, String crc) {
        int n = data.length(), m = crc.length();
        char[] encoded = new char[n + m - 1];
        for (int i = 0; i < n; i++)
            encoded[i] = data.charAt(i);
        for (int i = n; i < n + m - 1; i++)
            encoded[i] = '0';

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

        String ans = "";
        ans += data;
        for (int i = n; i < n + m - 1; i++)
            ans += encoded[i];
        System.out.println("Sender is sending the code:");
        System.out.println(ans);
        return ans;
    }
}

public class SenderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user data:");
        String user_data = sc.next();
        System.out.println("Enter the CRC generator:");
        String crc = sc.next();
        sc.reset();
        CRC obj = new CRC();
        String encoded = obj.sender(user_data, crc);
        sc.close();
    }
}
