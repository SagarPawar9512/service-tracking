package com.tracking.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.report.service.DataLoadService;

@RestController
@RequestMapping("/iot/event/v1")
public class TrackingReportController {
	
	@Autowired
	DataLoadService dataLoadservice;
	
	@PostMapping("loadData")
	public ResponseEntity<String> loadDataFromFileToDB(){
		String filepath="src/main/resources/data_new.csv";
		dataLoadservice.loadData(filepath);
		return ResponseEntity.ok("data refreshed");
		
	}

}
