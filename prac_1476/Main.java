package prac_1476;

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

		StringTokenizer tok = new StringTokenizer(br.readLine());

		int e = 1, s = 1, m = 1;
		int E = Integer.parseInt(tok.nextToken());
		int S = Integer.parseInt(tok.nextToken());
		int M = Integer.parseInt(tok.nextToken());

		for (int year = 1;; year++) {
			if (e == E && s == S && m == M) {
				bw.write(year + "\n");
				break;
			}

			e++;
			s++;
			m++;

			if (e == 16)
				e = 1;
			if (s == 29)
				s = 1;
			if (m == 20)
				m = 1;
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
