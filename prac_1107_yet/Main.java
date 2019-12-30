package prac_1107_yet;

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

		int dft = 100;
		String num = br.readLine();
		int n = Integer.parseInt(num);
		int m = Integer.parseInt(br.readLine());
	
		int cnt = 0;

		switch (n) {
		case 100:
			cnt = 0;
			break;
		case 101:
		case 99:
			cnt = 1;
			break;
		case 102:
			cnt = 2;
			break;
		default:
			if (m == 0)
				cnt = num.length();
			else {
				StringTokenizer tok = new StringTokenizer(br.readLine());
				boolean[] remote = new boolean[10];
				for (int i = 0; i < 10; i++) {
					if (tok.hasMoreElements()) {
						remote[Integer.parseInt(tok.nextToken())] = true;
					}
				}
				
				//+��ư�� ������ ��� : n���� �۰�,������ ���ڷ� ���� �� �ִ� ��
				
				
				//-��ư�� ������ ��� : n���� ũ��,������ ���ڷ� ���� �� �ִ� ��
				
				
			}
			break;
		}

		System.out.println(cnt);
		bw.flush();
		bw.close();
		br.close();
	}

}
