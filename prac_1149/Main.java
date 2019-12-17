package prac_1149;

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

		int[][] dp = new int[1001][3];

		String[] h1 = br.readLine().split(" ");
		dp[1][0] = Integer.parseInt(h1[0]); // R
		dp[1][1] = Integer.parseInt(h1[1]); // G
		dp[1][2] = Integer.parseInt(h1[2]); // B

		for (int i = 2; i <= n; i++) {
			String[] hs = br.readLine().split(" ");
			dp[i][0] = Integer.parseInt(hs[0]); // R
			dp[i][1] = Integer.parseInt(hs[1]); // G
			dp[i][2] = Integer.parseInt(hs[2]); // B

			dp[i][0] = dp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = dp[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = dp[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		bw.write(String.valueOf(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]))));

		bw.flush();
		bw.close();
		br.close();
	}

}
