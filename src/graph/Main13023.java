package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Edge {

	int from;
	int to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

public class Main13023 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] a = new boolean[N][N];
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[N];
		ArrayList<Edge> edges = new ArrayList<Edge>();

		for (int i = 0; i < N; i++) {
			g[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges.add(new Edge(from, to));
			edges.add(new Edge(to, from));
			a[from][to] = a[to][from] = true;
			g[from].add(to);
			g[to].add(from);
		}

		M *= 2;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int A = edges.get(i).from;
				int B = edges.get(i).to;
				int C = edges.get(j).from;
				int D = edges.get(j).to;
				if (A == B || A == C || A == D || B == C || B == D || C == D) {
					continue;
				}

				if (!a[B][C])
					continue;

				for (int E : g[D]) {
					if (A == E || B == E || C == E || D == E) {
						continue;
					}
					System.out.println(1);
					System.exit(0);
				}

			}
		}
		
		System.out.println(0);
	}
}
