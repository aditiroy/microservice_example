package com.channel4.mint.automated.spot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.BulkAmendServiceRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;
import com.channel4.mint.automated.spot.service.BulkAmendService;

@Service
public class BulkAmendServiceImpl implements BulkAmendService {

	@Value("${cancelStatus}")
	private String cancelStatus;

	@Value("${queueStatus}")
	private String queueStatus;

	@Autowired
	private BulkAmendServiceRepository bulkAmendServiceRepository;

	public List<Field> updateCancelStatus(List<Snapshots> snapshots) {
		List<Field> fieldList = new ArrayList<>();

		for (Snapshots snapshot : snapshots) {
			/**
			 * fetching camgen request from dB
			 */
			CamgenRequest camgenRequest = bulkAmendServiceRepository.getRequestById(snapshot.getCamgenRequestId());

			/**
			 * update status
			 */
			camgenRequest.setStatus(cancelStatus);

			/**
			 * saving updated record
			 */
			Long id = bulkAmendServiceRepository.updateStatus(camgenRequest);

			Field field = new Field();
			field.setId(id);

			fieldList.add(field);

		}

		return fieldList;

	}

	public List<Field> updateQueueStatus(List<Snapshots> snapshots) {

		List<Field> fieldList = new ArrayList<>();

		for (Snapshots snapshot : snapshots) {
			/**
			 * fetching camgen request from dB
			 */
			CamgenRequest camgenRequest = bulkAmendServiceRepository.getRequestById(snapshot.getCamgenRequestId());

			/**
			 * update status
			 */
			camgenRequest.setStatus(queueStatus);

			/**
			 * saving updated record
			 */
			Long id = bulkAmendServiceRepository.updateStatus(camgenRequest);

			Field field = new Field();
			field.setId(id);

			fieldList.add(field);

		}

		return fieldList;
	}

}
