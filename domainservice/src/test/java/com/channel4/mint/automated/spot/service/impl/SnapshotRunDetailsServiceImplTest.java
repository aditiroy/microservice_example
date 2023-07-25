package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotRunDetailsRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummary;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class SnapshotRunDetailsServiceImplTest {
	@InjectMocks
	private SnapshotRunDetailsServiceImpl snapshotRunDetailsServiceImpl;

	@Mock
	private SnapshotRunDetailsRepository snapshotRunDetailsRepository;

	CamgenSnapshotRunDetails camgenSnapshotRunDetails = new CamgenSnapshotRunDetails();
	TestUtil tetsUtil = new TestUtil();
	NewEntityCreated newEntity;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		newEntity=new NewEntityCreated();
		newEntity.setId("1");
		camgenSnapshotRunDetails = tetsUtil.getCamgenSnapshotRunDetails();
	}

	@Test
	public void testCreateCamgenSnapshotRunDetails() {
		CamgenSnapshotRunDetail camgenSnapshotRunDetails = new CamgenSnapshotRunDetail();
		when(snapshotRunDetailsRepository.createCamgenSnapshotRunDetails(camgenSnapshotRunDetails)).thenReturn(newEntity);
		snapshotRunDetailsServiceImpl.createCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
	}

	@Test
	public void testCreateCamgenRunParamAudGroupChannels() {
		CamgenRunParamAudGroupChannels body = new CamgenRunParamAudGroupChannels();
		Mockito.doNothing().when(snapshotRunDetailsRepository).createCamgenRunParamAudGroupChannels(body, 1);

		snapshotRunDetailsServiceImpl.createCamgenRunParamAudGroupChannels(body, 1);
	}

	@Test
	public void testGetCamgenSnapshotRunDetails() {
		Integer runId = 1;
		List<CamgenSnapshotRunDetail> camgenSnapshotRunDetailList = new ArrayList<>();
		CamgenSnapshotRunDetail e = new CamgenSnapshotRunDetail();
		e.setNotes("notes");
		e.setIterationCount(1);
		camgenSnapshotRunDetailList.add(e);
		when(snapshotRunDetailsRepository.getCamgenSnapshotRunDetails(Mockito.anyInt(), Mockito.any(DateTime.class),
				Mockito.anyString(),Mockito.anyString())).thenReturn(camgenSnapshotRunDetailList);
		List<CamgenSnapshotRunDetail> camgenSnapshotRunDetailsRes = snapshotRunDetailsServiceImpl
				.getCamgenSnapshotRunDetails(runId, new DateTime(), "status","runStatus");
		assertEquals(camgenSnapshotRunDetailsRes.get(0).getNotes(), camgenSnapshotRunDetailList.get(0).getNotes());
	}

	@Test
	public void testGetCamgenRunParamAudGroupChannels() {

		CamgenRunParamAudGroupChannels value = new CamgenRunParamAudGroupChannels();
		CamgenRunParamAudGroupChannel e = new CamgenRunParamAudGroupChannel();
		e.setChannelId(1);
		value.add(e);
		when(snapshotRunDetailsRepository.getCamgenRunParamAudGroupChannels(1)).thenReturn(value);
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannelsRes = snapshotRunDetailsServiceImpl
				.getCamgenRunParamAudGroupChannels(1);
		assertEquals(camgenRunParamAudGroupChannelsRes.get(0).getChannelId(), value.get(0).getChannelId());
	}

	@Test
	public void testGetAllSnapshots() {
		Integer page = 1;
		Long count = 1L;
		String sortOrder = "";
		String sortByField = "";
		List<SnapshotSummary> value = new ArrayList<>();
		SnapshotSummary snapshotSummary = new SnapshotSummary();
		snapshotSummary.setChannelSetId(1L);
		snapshotSummary.setChannelSetId(1L);

		value.add(snapshotSummary);
		SnapshotSummaryWithPagination value11 = new SnapshotSummaryWithPagination();
		value11.setSnapshotSummary(value);
		when(snapshotRunDetailsRepository.getAllSnapshots(page, count, sortOrder, sortByField)).thenReturn(value11);
		SnapshotSummaryWithPagination snapshotSummaryRes = snapshotRunDetailsServiceImpl.getAllSnapshots(page, count,
				sortOrder, sortByField);
		assertEquals(snapshotSummaryRes.getSnapshotSummary().get(0).getChannelSetId(), value.get(0).getChannelSetId());

	}

	@Test
	public void createSnapshotTest() {
		List<SnapshotDetail> snapshotDetail = new ArrayList<>();
		Field field = new Field();
		field.setId(1L);
		List<Field> fieldList = new ArrayList<>();
		fieldList.add(field);
		when(snapshotRunDetailsRepository.createSnapshot(snapshotDetail)).thenReturn(fieldList);
		List<Field> fieldRes = snapshotRunDetailsServiceImpl.createSnapshot(snapshotDetail);
		assertEquals(fieldRes.get(0).getId(), fieldList.get(0).getId());
	}

	
	@Test
	public void testGetSnapshot() {
		List<SnapshotDetail> value=new ArrayList<>();
		 SnapshotDetail snapshotDetail=new SnapshotDetail();
		 snapshotDetail.setRun(true);
		 value.add(snapshotDetail);
		when(snapshotRunDetailsRepository.getSnapshot(Mockito.anyInt(),Mockito.any(),Mockito.anyString(),Mockito.anyString(), Mockito.anyString())).thenReturn(value);
		
		List<SnapshotDetail> snapshotSummaryRes = snapshotRunDetailsServiceImpl.getSnapshot(Mockito.anyInt(),Mockito.any(),Mockito.anyString(),Mockito.anyString(), Mockito.anyString());
		assertEquals(snapshotSummaryRes.get(0).getRun(), value.get(0).getRun());
	}

	@Test
	public void testgetCamgenSnapshotRunDetailsBySnapshotId() {

		when(snapshotRunDetailsRepository.getCamgenSnapshotRunDetailsBySnapshotId(Mockito.anyInt()))
				.thenReturn(camgenSnapshotRunDetails);
		snapshotRunDetailsServiceImpl.getCamgenSnapshotRunDetailsBySnapshotId(1);
	}

	@Test
	public void updateCamgenSnapshotRunDetailsTest() {
		Mockito.doNothing().when(snapshotRunDetailsRepository).updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
		snapshotRunDetailsServiceImpl.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
	}

	@Test
	public void deleteSnapshotTest() {
		Integer snapshotId = 1;
		Mockito.doNothing().when(snapshotRunDetailsRepository).deleteSnapshot(snapshotId);
		snapshotRunDetailsServiceImpl.deleteSnapshot(snapshotId);
	}

	@Test
	public void updateSnapshotsTest() {
		SnapshotDetail snapshots = new SnapshotDetail();
		Mockito.doNothing().when(snapshotRunDetailsRepository).updateSnapshots(snapshots);
		snapshotRunDetailsServiceImpl.updateSnapshots(snapshots);
	}

}
