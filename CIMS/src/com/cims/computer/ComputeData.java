package com.cims.computer;

public class ComputeData {

	private Double score;
	private Integer weight=1;
	
	public ComputeData(){
		
	}
	
	public ComputeData(Double score){
		this.score=score;
		this.weight=1;
	}
	public ComputeData(Double score,Integer weight){
		this.score=score;
		this.weight=weight;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	
}
