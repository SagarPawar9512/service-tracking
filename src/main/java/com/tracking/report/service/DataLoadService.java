package com.tracking.report.service;

import com.tracking.report.exception.CustomFileNotFoundException;
import com.tracking.report.exception.MiscException;

public interface DataLoadService {
	
	public String loadData(String filePath) throws CustomFileNotFoundException, MiscException;
	

}
