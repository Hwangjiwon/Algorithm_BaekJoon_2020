package prac_10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		while ((str = br.readLine()) != null) {

			int[] cnt = new int[4]; // 소문자, 대문자, 숫자, 공백
			for (int j = 0; j < 4; j++)
				cnt[j] = 0;

			for (int j = 0; j < str.length(); j++) {
				if (Character.isLowerCase(str.charAt(j)) == true)
					cnt[0] += 1;
				else if (Character.isUpperCase(str.charAt(j)) == true)
					cnt[1] += 1;
				else if (str.charAt(j) - '0' >= 0 && str.charAt(j) - '0' <= 9)
					cnt[2] += 1;
				else if (str.charAt(j) == ' ')
					cnt[3] += 1;
			}
			for (int j = 0; j < 3; j++)
				System.out.print(cnt[j] + " ");
			System.out.println(cnt[3]);
		}

		br.close();
	}

}
