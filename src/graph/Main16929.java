package graph;

import java.util.Scanner;

public class Main16929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			String temp = sc.nextLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j) - 'A';
			}
		}
	}
}
