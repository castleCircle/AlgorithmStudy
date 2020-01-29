package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair7576{
	int x,y;
	public Pair7576(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main7576 {
	public static final int[] dx = {1, 0 , -1 , 0};
	public static final int[] dy = {0, -1 , 0 , 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		
		Queue<Pair7576> q = new LinkedList<Pair7576>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				dist[i][j] = -1;
				if(map[i][j]==1) {
					q.add(new Pair7576(i, j));
					dist[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair7576 p = q.remove();
			
			for(int i=0;i<4;i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(0<=tx && tx<M && 0<=ty && ty<N && map[tx][ty] ==0 && dist[tx][ty] == -1) {
					dist[tx][ty] = dist[p.x][p.y]+1;
					q.add(new Pair7576(tx, ty));
				}
			}
		}
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(ans < dist[i][j]) {
					ans = dist[i][j];
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==0 && dist[i][j] == -1) {
					ans = -1;
				}
			}
		}
		
		System.out.println(ans);
	}
}
