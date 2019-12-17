package prac_15988;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final long mod = 1000000009;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int j = 4; j <= 100000; j++) {
			dp[j] = (dp[j - 1] % mod) + (dp[j - 2] % mod) + (dp[j - 3] % mod);
			dp[j] %= mod;
		}
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
		
			bw.write(String.valueOf(dp[n])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
