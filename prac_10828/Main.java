package prac_10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String method = sc.next();
			if (method.equals("push")) {
				int input = sc.nextInt();
				stack.add(input);
			} else if (method.equals("pop")) {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
			} else if (method.equals("size")) {
				System.out.println(stack.size());
			} else if (method.equals("empty")) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if (method.equals("top")) {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
			}
		}

	}

}
