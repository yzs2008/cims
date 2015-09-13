package com.test.demo;

import java.util.Scanner;

public class BusBigCount {
	
	public static void main(String[] args) {
		
		int n;
		int max=0;
		int up;
		int down;
		int now=0;
		
		Scanner sc = new Scanner(System.in);   
		
		n=sc.nextInt();
		
		for(int i=0;i<n;i++){
			down=sc.nextInt();
			up=sc.nextInt();
			
			now+=(up-down);
			if(max<now){
				max=now;
			}
		}
		System.out.println(max);
	}

}
