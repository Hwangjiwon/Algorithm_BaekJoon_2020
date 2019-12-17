package prac_2225;

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

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		//dp[k][n] k개의 정수로 n을 만드는 경우의 수
		long[][] dp = new long[201][201];

		//1개의 정수로 n을 만드는 경우의 수는 1개
		for(int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] += dp[i - 1][j - l];
					dp[i][j] %= mod;
				}
			}
		}

		bw.write(String.valueOf(dp[k][n]));
		
		bw.flush();
		bw.close();
		br.close();
	}

}
