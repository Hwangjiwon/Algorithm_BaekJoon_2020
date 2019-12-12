package prac_1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer tok = new StringTokenizer(str, " ");

		int N = Integer.parseInt(tok.nextToken());
		int K = Integer.parseInt(tok.nextToken());

		//큐로 풀어도 될듯!!
		Deque<Integer> deq = new LinkedList<Integer>();
		Deque<Integer> result = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			deq.offer(i);

		while (deq.size() != 0) {
			for (int i = 0; i < K - 1; i++) {
				deq.addLast(deq.pollFirst());
			}
			result.add(deq.peekFirst());
			deq.pollFirst();
		}

		bw.write("<");
		while (result.size() != 1) {
			bw.write(result.poll() + ", ");
		}
		bw.write(result.poll() + ">");

		br.close();
		bw.close();
	}
}
