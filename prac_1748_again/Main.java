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
		int result = 0;
		/*
		 * for (int i = 1; i <= n; i *= 10) result += (n - i + 1);
		 */
		bw.write(result + "");

		bw.flush();
		bw.close();
		br.close();
	}

}
