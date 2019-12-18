package prac_11057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final int mod = 10007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][10];
		int[] result = new int[1001];

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k]; // ex) d[n][2] = d[n-1][0] + d[n-1][1]+d[n-1][2]
					dp[i][j] %= mod;
				}
			}
		}

		for (int i = 0; i <= 9; i++) {
			result[n] += dp[n][i];
			result[n] %= mod;
		}

		bw.write(String.valueOf(result[n]));

		bw.flush();
		bw.close();
		br.close();
	}

}
