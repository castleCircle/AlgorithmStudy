package graph;

import java.util.*;

public class Main1260 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		System.out.print(x + " ");
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x + " ");
			for(int y : a[x]) {
				if(c[y]==false) {
					c[y] = true;
					q.add(y);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		a = (ArrayList<Integer>[])new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			a[from].add(to);
			a[to].add(from);
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(a[i]);
		}
		c = new boolean[N+1];
		dfs(V);
		System.out.println();
		c = new boolean[N+1];
		bfs(V);
		System.out.println();
	}
	
	
}
