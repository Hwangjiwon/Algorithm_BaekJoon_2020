package prac_9093;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < T; i++) {

			String str = sc.nextLine() + " ";
			int len = str.length();

			for (int j = 0; j < len; j++) {
				char c = str.charAt(j);
				if (c == ' ') {
					while (!stack.empty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				} else {
					stack.add(str.charAt(j));
				}
			}
		}
	}
}
