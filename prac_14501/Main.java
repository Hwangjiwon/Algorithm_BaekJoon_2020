package prac_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] t = new int[n + 6]; // 소요시간
		int[] p = new int[n + 6]; // 수입
		int[] dp = new int[n + 6];

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n; i >= 1; i--) {
			if (i + t[i] <= n + 1)
				dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
			else
				dp[i] = dp[i + 1];
		}
		
		System.out.println(dp[1]);
		
		br.close();
	}

}
