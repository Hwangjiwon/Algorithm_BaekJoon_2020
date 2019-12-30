package prac_1748_again;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String nToStr = new String();
		nToStr = String.valueOf(n);
		int len = nToStr.length();
		
		int result = 1;

		for (int i = 1; i <= len; i++) {
			if( i == len ) {
				result += len;
			}
			else result += (int) (9 * Math.pow(10, i));
		}
		
		/*
		 * for (int i = 1; i <= n; i *= 10) result += (n - i + 1);
		 */

		System.out.println(result);
		bw.flush();
		bw.close();
		br.close();
	}

}
