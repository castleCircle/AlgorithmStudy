package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge{
	int from;
	int to;
	public Edge(int from , int to) {
		this.from = from;
		this.to   = to;
	}
}

public class Main1260 {

	static List<Edge> edge;
	static boolean[] check;
	
	public static void dfs() {
		
	}
	
	public static void bfs() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		edge = new ArrayList<Edge>();
		check = new boolean[N+1];
		
		for(int i=1;i<=M;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
		}
		
		
		dfs();
		
		
	}
	
	
}
