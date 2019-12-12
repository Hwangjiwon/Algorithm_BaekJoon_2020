package prac_1918_again;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static int comparison(char ch) {
		if (ch == '(')
			return 0;
		if (ch == '+' || ch == '-')
			return 1;
		else
			return 2;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				bw.write(str.charAt(i));
			} else if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				while (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
						break;
					}
					bw.write(stack.pop());
				}
			} else { // ¿¬»êÀÚ
				while (!stack.isEmpty() && comparison(stack.peek()) >= comparison(str.charAt(i))) {
					bw.write(stack.pop());
				}
				stack.push(str.charAt(i));
			}
		}

		while (!stack.isEmpty()) {
			bw.write(stack.pop());
		}

		br.close();
		bw.close();
	}

}
