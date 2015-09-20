package com.test.demo;

import java.util.Scanner;

public class FindWay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);   
		int m=3;
		int n=3;
//		m=sc.nextInt();
//		n=sc.nextInt();
		int[][] path=new int[m][n];
//		for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//				path[i][j]=sc.nextInt();
//			}
//		}
		path[0][0]=1;
		path[0][1]=1;
		path[0][2]=1;
		path[1][0]=1;
		path[1][1]=0;
		path[1][2]=1;
		path[2][0]=1;
		path[2][1]=1;
		path[2][2]=1;
		find(path,m-1,0);
		System.out.println(count);

	}
	private static int count=0;
	public static void find(int[][] path, int x,int y){
		int m=path.length;
		int n=path[0].length-1;
		if(x<0||y>n){
			return;
		}
		if(x==0 && y==n){
			count++;
			return ;
		}
		if(path[x][y]==0){
			return;
		}else{
			find(path,x-1,y);
			find(path,x-1,y+1);
			find(path,x,y+1);
		}
	}
}
