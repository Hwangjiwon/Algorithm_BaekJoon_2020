package prac_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] voca = new String[str.length()];

		voca[0] = str;
		for (int i = 1; i < str.length(); i++) {
			voca[i] = voca[i - 1].substring(1);
		}

		Arrays.sort(voca);
		for(int i = 0; i < voca.length; i++)
			System.out.println(voca[i]);

		br.close();
	}

}
