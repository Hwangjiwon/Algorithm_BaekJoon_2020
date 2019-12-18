package prac_9465;

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

		int t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {

			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n + 1][2];

			String[] val0 = br.readLine().split(" ");
			String[] val1 = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(val0[i]);
				arr[i][1] = Integer.parseInt(val1[i]);
			}

			int[][] dp = new int[n + 1][3];

			dp[0][0] = 0;
			dp[0][1] = arr[0][0];
			dp[0][2] = arr[0][1];
			for (int i = 1; i <= n; i++) {
				dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i][0];
				dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][1];
			}

			int sum = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
			bw.write(String.valueOf(sum)+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
