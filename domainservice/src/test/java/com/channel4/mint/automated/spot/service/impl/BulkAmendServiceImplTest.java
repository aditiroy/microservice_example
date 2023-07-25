package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.BulkAmendServiceRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;

public class BulkAmendServiceImplTest {
	
	@InjectMocks
	private   BulkAmendServiceImpl  bulkAmendService;
	
	@Mock
	private BulkAmendServiceRepository bulkAmendServiceRepository;

	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testupdateCancelStatus() {
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		Long id =1L;
		CamgenRequest camgenRequest = new CamgenRequest();
		when(bulkAmendServiceRepository.getRequestById(1L)).thenReturn(camgenRequest);
		when(bulkAmendServiceRepository.updateStatus(camgenRequest)).thenReturn(id);
	
		List<Field> fieldList = bulkAmendService.updateCancelStatus(snapshotsList);
		assertEquals(fieldList.get(0).getId(), id);

	}
	
	@Test
	public void testupdateQueueStatus() {
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		Long id =1L;
		CamgenRequest camgenRequest = new CamgenRequest();
		when(bulkAmendServiceRepository.getRequestById(1L)).thenReturn(camgenRequest);
		when(bulkAmendServiceRepository.updateStatus(camgenRequest)).thenReturn(id);
		
		List<Field> fieldList = bulkAmendService.updateQueueStatus(snapshotsList);
		assertEquals(fieldList.get(0).getId(), id);

	}


}
