package prac_1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		for (int i = 0; i < str.length(); i++)
			left.push(str.charAt(i));

		for (int i = 0; i < n; i++) {
			String method = br.readLine();

			switch (method.charAt(0)) {
			case 'L':
				// 커서를 왼쪽으로 한칸. 오른쪽 스택에 넣기
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			case 'D':
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			case 'B':
				if (!left.isEmpty())
					left.pop();
				break;
			case 'P':
				left.push(method.charAt(2));
				break;
			}
		}
		while (!left.isEmpty())
			right.push(left.pop());

		while (!right.isEmpty())
			System.out.print(right.pop());
	}
}
