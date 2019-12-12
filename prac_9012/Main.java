package prac_9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < T; i++) {
			String vps = sc.nextLine();
			Stack<Character> stack = new Stack<Character>();

			int len = vps.length();
			int flag = 1;

			for (int j = 0; j < len; j++) {
				char c = vps.charAt(j);

				if (c == '(') {
					stack.push('(');
				} else if (c == ')') {
					if (stack.isEmpty()) {
						flag = 0;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (stack.isEmpty() && flag != 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
