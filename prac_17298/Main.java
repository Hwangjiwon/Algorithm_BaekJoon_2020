package prac_17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] tmp = br.readLine().split(" ");
		int[] input = new int[N];
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(tmp[i]);

		int[] result = new int[N];

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for (int i = 1; i < N; i++) {
			if (stack.isEmpty())
				stack.push(i);
			while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
				result[stack.pop()] = input[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}

		br.close();
		bw.close();
	}

}
