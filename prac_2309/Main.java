package prac_2309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		int one = 0;
		int two = 0;
		for (int i = 0; i < 9; i++) {
			arr.add(Integer.parseInt(br.readLine()));
			sum += arr.get(i);
		}

		for (int i = 0; i < 9; i++) {
			int sub = 0;
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				sub = arr.get(i) + arr.get(j);
				if (sum - sub == 100) {
					one = i;
					two = j;
					break;
				}
			}
		}

		arr.remove(one);
		arr.remove(two);
		Collections.sort(arr);

		for (int i = 0; i < arr.size(); i++)
			bw.write(arr.get(i) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
