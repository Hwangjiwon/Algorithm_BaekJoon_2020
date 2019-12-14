package prac_11053;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];

		String str = br.readLine();
		StringTokenizer tok = new StringTokenizer(str, " ");

		int before = Integer.parseInt(tok.nextToken());
		
		int dif = before;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int present = Integer.parseInt(tok.nextToken());
			if ((present - before) > 0 && dif <= (present - before)) {
				dif = present - before;
				dp[i] = dp[i - 1] + 1;
			} else
				dp[i] = dp[i - 1];

			before = present;
		}
		bw.write(String.valueOf(dp[n]));

		bw.flush();
		bw.close();
		br.close();
	}

}
