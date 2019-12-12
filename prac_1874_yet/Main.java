package prac_1874_yet;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		Stack<Integer> stack = new Stack<Integer>();
		int num = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= n; i++) {
			
			if (i <= num) {
				stack.push(i);
				// System.out.println("+");
				System.out.println(stack+"+");
				continue;
			}
			i = stack.peek();
			if(i == num) {
				stack.pop();
				//System.out.println("-");
				System.out.println(stack+"-");
				num = Integer.parseInt(sc.nextLine());
			}
			
			System.out.println(num+"**"+i);
		}

		sc.close();
	}

}
