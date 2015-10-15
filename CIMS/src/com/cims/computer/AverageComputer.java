package com.cims.computer;

import java.util.List;

public class AverageComputer implements ComputeCenter {

	@Override
	public Double compute(List<ComputeData> scoreList) throws Exception {
		try{
			Double result=0.0;
			Double sum=0.0;//求平均前的总和
			Integer denominator=0;//评委数，就是求平均的分母
			for(ComputeData cd:scoreList){
				sum+=(cd.getScore()*cd.getWeight());
				denominator+=cd.getWeight();
			}
			result=sum/denominator;
			return result; 
		}catch(Exception e){
			throw e;
		}
	}

}
