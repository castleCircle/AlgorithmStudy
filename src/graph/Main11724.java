package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11724 {
	
	
	public static void dfs(boolean[] check ,ArrayList<Integer>[] data, int v) {
		if(check[v]) {
			return;
		}
		
		check[v] = true;

		for(int d : data[v]) {
			if(check[d]==false) {
				dfs(check,data,d);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] data = (ArrayList<Integer>[])new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			data[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			data[from].add(to);
			data[to].add(from);
		}
		
		boolean[] check = new boolean[N+1];
		
		
		int ans = 0;
		for(int i=1;i<=N;i++) {
			if(check[i]==false) {
				dfs(check,data,i);
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	
}
