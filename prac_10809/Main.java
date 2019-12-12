package prac_10809;

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

		String S = br.readLine();
		int[] index = new int[26];
		for (int i = 0; i < 26; i++)
			index[i] = -1;

		for (int i = 0; i < S.length(); i++) {
			if (index[S.charAt(i) - 'a'] != -1)
				continue;
			index[S.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < index.length-1; i++)
			bw.write(index[i] + " ");
		bw.write(String.valueOf(index[index.length-1]));

		br.close();
		bw.close();
	}

}
