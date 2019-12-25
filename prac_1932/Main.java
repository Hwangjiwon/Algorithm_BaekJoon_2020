package prac_1932;

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
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = str[i-1];
		}

		int[][] dp = new int[501][2];

		dp[1][0] = arr[1]; // dp[n][l]
		dp[1][1] = arr[1]; // dp[n][r]

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i];
			dp[i][1] = dp[i - 1][1] + arr[i + 1];
		}

		int sum = Math.max(dp[n][0], dp[n][1]);

		bw.write(sum + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
