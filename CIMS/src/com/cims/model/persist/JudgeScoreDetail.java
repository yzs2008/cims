package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_scoreDetail")
public class JudgeScoreDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scoreDetailId;
	private Integer scoreId;
	private Integer standardId;
	private Double score;
    
	public Integer getScoreDetailId() {
		return scoreDetailId;
	}
	public void setScoreDetailId(Integer scoreDetailId) {
		this.scoreDetailId = scoreDetailId;
	}
	public Integer getScoreId() {
		return scoreId;
	}
	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}
	public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
