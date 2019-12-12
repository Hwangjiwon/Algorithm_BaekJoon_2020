package prac_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<String> que = new LinkedList<String>();
		String last = "";
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer tok = new StringTokenizer(str, " ");
			
			switch(tok.nextToken()) {
			case "push":
				last = tok.nextToken();
				que.offer(last);
				break;
			case "pop":
				if(que.isEmpty())
					System.out.println(-1);
				else System.out.println(que.poll());
				break;
			case "size":
				System.out.println(que.size());
				break;
			case "empty":
				System.out.println(que.isEmpty()==true ? 1 : 0);
				break;
			case "front":
				if(que.isEmpty())
					System.out.println(-1);
				else System.out.println(que.peek());
				break;
			case "back":
				if(que.isEmpty())
					System.out.println(-1);
				else System.out.println(last);
				break;
			}
		}
	}
}
