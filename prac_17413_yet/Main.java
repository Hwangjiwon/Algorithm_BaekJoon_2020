package prac_17413_yet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Stack<String> stack = new Stack<String>();
		Stack<String> result = new Stack<String>();
		
		
		String[] tok = str.split(" ");
		for (String n : tok) {
			String[] cha = n.split("");
			for (String m : cha) {
				stack.push(m);
			}

			while (!stack.isEmpty())
				result.push(stack.pop());
			
			result.push(" ");
		}

		for(int i = 0; i < result.size()-1; i++) {
			System.out.print(result.elementAt(i));
		}
		br.close();
	}

}
