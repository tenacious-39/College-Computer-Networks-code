// Implementation of Hamming code(Receiver Side).
// Developed on 16.03.2022
// Developed by Kritidipta Ghosh_11100119002
// Developed in Computer Networks Lab.



import java.util.*;

class HammingReceiver{
	int power(int base, int exp){
		int ans = 1;
		while(exp > 0){
			if(exp%2 ==1){
				exp--;
				ans *= base;
			} else{
				exp /= 2;
				base *= base;
			}
		}
		return ans;
	}
	void print(int[] arr, int n){
		for(int i = 1; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	int receiver(String data){
		int m = data.length();
		int[] codeword = new int[m+1];
		int idx = m-1;
		for(int i = 1; i < m+1; i++){
			codeword[i] = data.charAt(idx)-'0';
			idx--;
		}
		
		int r = 1;
		while(power(2, r) < m+1) r++;
		m -= r;
		String ans = "";

		//chacking the parity bits:
		int parity = 0;
		while(parity < r){
			int start = power(2, parity);
			parity++;
			int countOne = 0, cnt = 0;

			for(int i = start; i < m+r+1;){	
				if(cnt%2 == 0){
					int limit = Math.min(m+r+1, i+start);
					for(int j = i; j < limit; j++){
						if(codeword[j] == 1) countOne++;
					}
					
					int it = start; while(it-- > 0) i++;
				} else{
					int it = start;
					while(it-- > 0) i++;
				}
				cnt++;
			}
			ans += (countOne % 2 == 1)? '1' : '0';
		}

		int bit = 0;
		for(int i = 0; i < ans.length(); i++){
			if(ans.charAt(i) == '1') bit += power(2, i);
		}

		return bit;
	}

	int receiver1(String data){
		int m = data.length();
		int[] codeword = new int[m+1];
		int idx = m-1;
		for(int i = 1; i < m+1; i++){
			codeword[i] = data.charAt(idx)-'0';
			idx--;
		}
		
		int r = 1;
		while(power(2, r) < m+1) r++;
		m -= r;
		String ans = "";

		//chacking the parity bits:
		int parity = 0;
		while(parity < r){
			int start = power(2, parity);
			parity++;
			int countOne = 0;

			for(int i = start; i < m+r+1;){	
					if((i/start)%2 == 0) i += start-1;
					else if(codeword[i] == 1) countOne++;
					i++;
			}
			ans += (countOne % 2 == 1)? '1' : '0';
		}

		int bit = 0;
		for(int i = 0; i < ans.length(); i++){
			if(ans.charAt(i) == '1') bit += power(2, i);
		}

		return bit;
	}
}
class HammingReceiverMain{
	public static void main(String args[]){
		String codeword;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the codeword : ");
		codeword = sc.next();
		HammingReceiver obj = new HammingReceiver();
		int bit = obj.receiver1(codeword);
		if(bit != 0){
			System.out.println("Error occurred in the " + bit + "th bit of the code word from right.");
			System.out.print("The right codeword is : ");
			int m = codeword.length();
			for(int i = 0; i < m; i++){
				if(i == m-bit) System.out.print(('1'-codeword.charAt(i)));
				else System.out.print(codeword.charAt(i));
			}
			System.out.println("");
		} else{
			System.out.println("No error occurred.");
		}
		sc.close();
	}
}