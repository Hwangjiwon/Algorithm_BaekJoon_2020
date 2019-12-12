package prac_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int result = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			} else if(str.charAt(i) == ')') {
				if(stack.peek() == i-1) { //레이저
					stack.pop();
					result += stack.size();
				}
				else { //막대기
					stack.pop();
					result++;
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
