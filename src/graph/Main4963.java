package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair4963 {
	int x;
	int y;

	Pair4963(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main4963 {
	public static final int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static final int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void bfs(int[][] map, int[][] group, int x, int y, int cnt, int n, int m) {
		Queue<Pair4963> q = new LinkedList<Pair4963>();
		group[x][y] = cnt;
		q.add(new Pair4963(x, y));
		while (!q.isEmpty()) {
			Pair4963 p = q.remove();
			for (int i = 0; i < dx.length; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				if (tx >= 0 && tx < n && ty >= 0 && ty < m && group[tx][ty] == 0 && map[tx][ty] == 1) {
					q.add(new Pair4963(tx, ty));
					group[tx][ty] = cnt; 
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			int[][] group = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && group[i][j] == 0) {
						bfs(map, group, i, j, ++cnt, h, w);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
