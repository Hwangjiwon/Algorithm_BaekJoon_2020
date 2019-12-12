package prac_10808;

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
		int[] cnt = new int[26];
		
		for(int i = 0; i < S.length(); i++) {
			cnt[S.charAt(i)-'a'] += 1;
		}
		
		for(int i = 0; i < cnt.length-1; i++)
			bw.write(String.valueOf(cnt[i])+" ");
		bw.write(String.valueOf(cnt[cnt.length-1]));
		
		br.close();
		bw.close();
	}

}
