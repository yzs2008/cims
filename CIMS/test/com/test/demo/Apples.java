package com.test.demo;

import java.util.Scanner;

public class Apples {
	
	private Integer[] probeList=new Integer[10];
	private Integer N;
	
	private void doProbe(int start){
		int candidate=start;
		int index=0;
		for(int i=1;i<50&& index<10;i++){
			if(candidate%N==1 && (candidate-1)%N==0){
				probeList[index++]=candidate;
			}
			candidate+=N;
		}
	}
	
	public int test(int n,int target){
		if(n==0){
			return 1;
		}
		if(target%N==1 && (target-1)%N==0){
			return test(n-1,target-(target-1)/N-1);
		}else{
			return -1;
		}
	}
	
	public void wiseMan(){
		doProbe(N+1);
		for(int i=0;i<probeList.length;i++){
			int resultCode=test(N,probeList[i]);
			if(resultCode==-1){
				if(i==probeList.length-1){
					doProbe(probeList[probeList.length-1]);
					i=-1;
				}else{
					continue;
				}
			}else{
				System.out.println(probeList[i]);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);   
		
		Apples app=new Apples();
		app.N=sc.nextInt();
		app.wiseMan();
	}

}
