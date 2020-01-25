package prac_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
	static Map<String, LinkedList<String>> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			LinkedList<String> list = new LinkedList<String>();
			list.add(str[1]); //왼쪽 자식노드
			list.add(str[2]); //오른쪽 자식노드
			map.put(str[0], list); //부모 map에 자식 list붙이기
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
		
		br.close();
	}
	
	public static void preorder(String s) {
		if(s.equals(".")) return;
		
		System.out.print(s);
		preorder(map.get(s).get(0));
		preorder(map.get(s).get(1));
	}
	
	public static void inorder(String s) {
		if(s.equals(".")) return;
		
		inorder(map.get(s).get(0));
		System.out.print(s);
		inorder(map.get(s).get(1));
	}

	public static void postorder(String s) {
		if(s.equals(".")) return;
		
		postorder(map.get(s).get(0));
		postorder(map.get(s).get(1));
		System.out.print(s);
	}
}
