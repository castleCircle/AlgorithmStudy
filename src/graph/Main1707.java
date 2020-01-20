package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1707 {
	
	public static void dfs(ArrayList<Integer>[] a,int[] color ,int x,int c) {
		color[x] = c;
		for(int j:a[x]) {
			if(color[j] == 0) {
				dfs(a,color,j,3-c);
			}
		}
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		while(testCase-- > 0) {
			
			int v = sc.nextInt();
			int e = sc.nextInt();

			ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[v+1];
			for(int i=1;i<=v;i++) {
				a[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<e;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				a[from].add(to);
				a[to].add(from);
			}
			
			int[] color = new int[v+1];
			
			boolean ok = true;
			
			for(int i=1;i<=v;i++) {
				if(color[i]==0) {
					dfs(a,color,i,1);
				}
			}
			
			for(int i=1;i<=v;i++) {
				for(int j:a[i]) {
					if(color[i] == color[j]) {
						ok = false;
					}
				}
			}
			
			if(ok) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
}
