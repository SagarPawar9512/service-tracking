package com.tracking.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracking.report.model.DeviceData;

@Repository
public interface TrackingReportRepo extends JpaRepository<DeviceData, Integer>{

}
