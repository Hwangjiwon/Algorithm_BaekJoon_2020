package prac_10866;

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
		
		int N = Integer.parseInt(br.readLine());
		Deque<String> deq = new LinkedList<String>();		
		
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			StringTokenizer tok = new StringTokenizer(str);
			
			switch(tok.nextToken()) {
			case "push_front":
				deq.addFirst(tok.nextToken());
				break;
			case "push_back":
				deq.addLast(tok.nextToken());
				break;
			case "pop_front":
				bw.write((deq.isEmpty() == true ? "-1" : deq.pollFirst())+"\n");
				break;
			case "pop_back":
				bw.write((deq.isEmpty() == true ? "-1" : deq.pollLast())+"\n");
				break;
			case "size":
				bw.write(deq.size()+"\n");
				break;
			case "empty":
				bw.write((deq.isEmpty() == true ? "1" : "0")+"\n");
				break;
			case "front":
				bw.write((deq.isEmpty() == true ? "-1" : deq.peekFirst())+"\n");
				break;
			case "back":
				bw.write((deq.isEmpty() == true ? "-1" : deq.peekLast())+"\n");
				break;
			}
		}		
		br.close();
		bw.close();
	}

}
