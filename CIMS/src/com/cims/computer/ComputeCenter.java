package com.cims.computer;

import java.util.List;

public interface ComputeCenter {
	
	Double compute(List<ComputeData> scoreList)throws Exception;
	
}
