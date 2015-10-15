package com.cims.computer;

import java.util.List;

public class SumComputer implements ComputeCenter {

	@Override
	public Double compute(List<ComputeData> scoreList) throws Exception{
		try{
			Double result=0.0;
			Double sum=0.0;
			for(ComputeData cd:scoreList){
				sum+=(cd.getScore()*cd.getWeight());
			}
			result=sum;
			return result; 
		}catch(Exception e){
			throw e;
		}
	}

}
