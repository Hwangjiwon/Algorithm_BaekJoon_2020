package prac_9095;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {

			int n = sc.nextInt();
			int[] dp = new int[11];

			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int j = 4; j <= n; j++) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			System.out.println(dp[n]);

		}
		sc.close();
	}

}
