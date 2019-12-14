package prac_10844;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static final long mod = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[][] dp = new long[101][11]; // dp[N][L(마지막 수 0~9)]인 계단 수

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8] % mod;
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long sum = 0;
		for (int j = 0; j <= 9; j++) {
			sum += dp[n][j];
		}

		bw.write(String.valueOf(sum % mod));

		bw.flush();
		bw.close();
		br.close();

	}

}
