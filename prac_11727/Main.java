package prac_11727;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + 2 * dp[i - 2];
			dp[i] %= 10007;
		}
		System.out.println(dp[n]);
		sc.close();
	}

}
