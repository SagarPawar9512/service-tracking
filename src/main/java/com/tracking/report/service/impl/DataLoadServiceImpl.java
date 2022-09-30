package com.tracking.report.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.tracking.report.exception.CustomFileNotFoundException;
import com.tracking.report.exception.MiscException;
import com.tracking.report.model.DeviceData;
import com.tracking.report.repository.TrackingReportRepo;
import com.tracking.report.service.DataLoadService;

@Service
public class DataLoadServiceImpl implements DataLoadService {

	@Autowired
	TrackingReportRepo trackingReportRepo;

	public String loadData(String filePath) throws CustomFileNotFoundException, MiscException {

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<DeviceData> list1 = new ArrayList<>();
			List<String[]> r = reader.readAll();
			r.remove(0);
			r.stream().forEach(s -> {
				List<String> list = Arrays.asList(s);
				DeviceData deviceData = new DeviceData();
				deviceData.setDateTime(new Timestamp(Double.valueOf(list.get(0)).longValue()));
				deviceData.setEventId(Long.valueOf(list.get(1)));
				deviceData.setProductId(list.get(2));
				deviceData.setLatitude(StringUtils.isBlank(list.get(3)) ? null : Double.parseDouble(list.get(3)));
				deviceData.setLongitude(StringUtils.isBlank(list.get(4)) ? null : Double.parseDouble(list.get(4)));
				deviceData.setBattery(Float.parseFloat(list.get(5)));
				deviceData.setLight(list.get(6));
				deviceData.setAirplaneMode(list.get(7));
				list1.add(deviceData);
				trackingReportRepo.save(deviceData);
			});
		} catch (FileNotFoundException e) {
			throw new CustomFileNotFoundException("ERROR: no data file found", e);
		} catch (Exception e) {
			throw new MiscException("ERROR: A technical exception occurred", e);
		}
		return "data refreshed";
	}
}
