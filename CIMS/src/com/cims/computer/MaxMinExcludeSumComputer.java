package com.cims.computer;

import java.util.List;

public class MaxMinExcludeSumComputer implements ComputeCenter {

	@Override
	public Double compute(List<ComputeData> scoreList) throws Exception {
		try{
			Double result=0.0;
			Double max=0.0;
			Double min=Double.MAX_VALUE;
			Double sum=0.0;
			Integer denominator=0;
			for(ComputeData cd:scoreList){
				sum+=(cd.getScore()*cd.getWeight());
				denominator+=cd.getWeight();
				if(max<cd.getScore()){
					max=cd.getScore();
				}
				if(min>cd.getScore()){
					min=cd.getScore();
				}
			}
			if(denominator<3){
				result=sum;
			}else{
				result=(sum-min-max);
			}
			return result;
		}catch(Exception e){
			throw e;
		}
	}


}
