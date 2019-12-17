package prac_11053;

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

		String[] in = br.readLine().split(" ");
		int[] input = new int[n + 1];
		int[] dp = new int[1001];

		for (int i = 0; i < n; i++) {
			input[i + 1] = Integer.parseInt(in[i]);
			dp[i + 1] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (input[i] > input[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		bw.write(String.valueOf(max));

		bw.flush();
		bw.close();
		br.close();
	}

}
