package prac_15990;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final long mod = 1000000009;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[][] dp = new long[100001][4];

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int max = 0;

			if (n <= max) { // n: 40 60 20 �� ��, 20�� �ٽ� ���� �ʿ� ����(max = 60, n = 20)
				bw.write((dp[n][1] + dp[n][2] + dp[n][3]) % mod + "\n");
			} else { // n : 40 60 20 80 �� ��, 80�� ���� �� 61 ���� ���ϱ� (max = 60, n = 80)
				for (int j = max + 1; j <= n; j++) {
					if (0 != dp[j][1])
						continue;

					if (j - 1 >= 0) {

						dp[j][1] = dp[j - 1][2] + dp[j - 1][3];
						dp[j][1] %= mod;
						if (j == 1) // 1+... ���� �� ���߿� �˻��� ��
							dp[j][1] = 1;
					}
					if (j - 2 >= 0) {

						dp[j][2] = dp[j - 2][1] + dp[j - 2][3];
						dp[j][2] %= mod;
						if (j == 2) // 2+... ���� �� ���߿� �˻��� ��
							dp[j][2] = 1;
					}
					if (j - 3 >= 0) {

						dp[j][3] = dp[j - 3][1] + dp[j - 3][2];
						dp[j][3] %= mod;
						if (j == 3) // 3+... ���� �� ���߿� �˻��� ��
							dp[j][3] = 1;
					}
				}
				bw.write((dp[n][1] + dp[n][2] + dp[n][3]) % mod + "\n");
				max = Math.max(max, n);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
