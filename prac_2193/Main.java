package prac_2193;

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
		long[][] dp = new long[91][2];  //n이 90이면 int로 불가

		dp[1][1] = 1;
		
		for (int i = 2; i <= n; i++) {

			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];

		}

		bw.write(String.valueOf(dp[n][0] + dp[n][1]));

		bw.flush();
		bw.close();
		br.close();

	}

}
