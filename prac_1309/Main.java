package prac_1309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final int mod = 9901;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[100001][3];

		dp[1][0] = 1; // x | x
		dp[1][1] = 1; // o | x
		dp[1][2] = 1; // x | o

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
		}

		int cnt = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
		
		bw.write(cnt + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
