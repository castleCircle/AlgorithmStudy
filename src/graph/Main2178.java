package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2178{
	int x;
	int y;
	public Pair2178(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main2178 {
	
	private static final int[] dx = {0,1,0,-1};
	private static final int[] dy = {1,0,-1,0};
	public static void bfs(int[][] map,boolean[][] check,int[][] dist ,int x,int y,int N,int M) {
		Queue<Pair2178> q = new LinkedList<Pair2178>();
		q.add(new Pair2178(x, y));
		check[x][y] = true;
		dist[x][y] = 1;
		while(!q.isEmpty()) {
			Pair2178 p = q.remove();
			
			for(int i=0;i<4;i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];

				if(1<=tx && tx<=N && 1<=ty && ty<=M && map[tx][ty] == 1 && check[tx][ty] == false) {
					check[tx][ty] = true;
					q.add(new Pair2178(tx, ty));
					dist[tx][ty] = dist[p.x][p.y] + 1;
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N+1][M+1];
		sc.nextLine();
		for(int i=1;i<=N;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++) {
				map[i][j+1] = line.charAt(j) - '0';
			}
		}
		
		int[][] dist = new int[N+1][M+1];
		boolean[][] check = new boolean[N+1][M+1];
		bfs(map,check,dist,1,1,N,M);
		System.out.println(dist[N][M]);
	}
}
