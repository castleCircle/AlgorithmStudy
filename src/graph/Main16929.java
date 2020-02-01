package graph;

import java.util.Scanner;

public class Main16929 {
	private static char[][] a;
	private static boolean[][] check;
	private static int n,m;
	final static int[] dx = {0,0,1,-1};
	final static int[] dy = {1,-1,0,0};

	static boolean go(int x,int y,int px,int py,char color) {
		if(check[x][y]) {
			return true;
		}
		check[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(0<=tx && tx<n && 0<=ty && ty<m) {
				if(!(tx==px && ty == py) && a[tx][ty] == color) {
					return go(tx,ty,x,y,color);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new char[n][m];
		check = new boolean[n][m];
		for(int i=0;i<n;i++) {
			a[i] = sc.next().toCharArray();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(check[i][j]) {
					continue;
				}
				if(go(i,j,-1,-1,a[i][j])) {
					System.out.println("Yes");
					System.exit(0);
				}
			}
		}
		System.out.println("No");
	}
}
