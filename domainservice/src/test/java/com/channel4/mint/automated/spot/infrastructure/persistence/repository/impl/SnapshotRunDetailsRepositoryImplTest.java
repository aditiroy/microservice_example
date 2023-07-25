package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;

import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.SecurityUtil;
import com.channel4.mint.automated.spot.application.util.SnapshotSummaryUtil;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunAudienceGroupChannelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanAutofillingDay;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanDemandSupplyCriteria;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunAudienceGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class SnapshotRunDetailsRepositoryImplTest {

	@InjectMocks
	private SnapshotRunDetailsRepositoryImpl snapshotRunDetailsRepositoryImpl;

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Mock
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Mock
	private CamgenPlanJpaRepository camgenPlanJpaRepository;

	@Mock
	private RunAudienceGroupChannelJpaRepository runAudienceGroupChannelJpaRepository;

	@Mock
	private DateTimeUtility dateTimeUtility;
	
	@Mock
	SecurityUtil securityUtil;
	

	@Mock
	private SnapshotSummaryUtil snapshotSummaryUtil;

	@Mock
	private CamgenParameterMapper camgenParameterMapper;

	CamgenSnapshotRunDetails camgenSnapshotRunDetails = new CamgenSnapshotRunDetails();
	CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();
	List<CamgenRequest> camgetReqList = new ArrayList<>();
	CamgenRequest camgetReq = new CamgenRequest();
	List<CamgenRun> camgenRunsList = new ArrayList<>();
	TestUtil testUtil = new TestUtil();
	CamgenPlan camgenPlan = new CamgenPlan();
	CamgenRun camgenRun = new CamgenRun();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		ReflectionTestUtils.setField(snapshotRunDetailsRepositoryImpl, "manualIterations", 1);
		ReflectionTestUtils.setField(snapshotRunDetailsRepositoryImpl, "active", "active");

		camgenPlan.setIsRun(BigDecimal.valueOf(1L));
		camgenPlan.setIsSlot(BigDecimal.valueOf(1L));
		camgenPlan.setStartDate(new Date());
		camgenPlan.setEndDate(new Date());
		camgetReq.setCamgenPlan(camgenPlan);

		camgenRun.setRunId(1L);
		camgenRun.setScheduleDateTime(new Date());
		camgenRunsList.add(camgenRun);
		camgetReq.setCamgenRuns(camgenRunsList);
		camgetReq.setChannelSetId(BigDecimal.valueOf(1L));
		camgetReq.setCreatedBy("createdBy");
		camgetReq.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		camgetReq.setEndDate(new Date());
		camgetReq.setModifiedBy("modifiedBy");
		camgetReq.setModifiedOn(new Timestamp(System.currentTimeMillis()));
		camgetReq.setRequestId(123L);
		camgetReq.setRequestType("requestType");
		camgetReq.setStartDate(new Date());
		camgetReq.setStatus("status");
		camgetReqList.add(camgetReq);

		camgenSnapshotRunDetail.setCreatedBy("user");
		camgenSnapshotRunDetail.setIterationCount(1);
		camgenSnapshotRunDetail.setNotes("notes");
		camgenSnapshotRunDetail.setRunDateTime("2010-01-01");
		camgenSnapshotRunDetail.setRunId(1);
		camgenSnapshotRunDetail.setRunStatus("abc");
		camgenSnapshotRunDetail.setSlotFileLastImportDate(new LocalDate("2010-02-02"));
		camgenSnapshotRunDetail.setSlotFlag(true);
		camgenSnapshotRunDetail.setSnapshotId(1L);

		CamgenParameters camgenParameters = new CamgenParameters();

		CamgenParam camgenParam = new CamgenParam();
		camgenParam.setId(1L);
		camgenParam.setParameter("parameter1");
		camgenParam.setStandardvalue("standardvalue1");
		camgenParam.setValue("value1");
		camgenParam.setViewOrder(1);
		camgenParameters.add(camgenParam);

		CamgenParamExtracts camgenParamExtracts = new CamgenParamExtracts();

		CamgenParamExtract camgenParamExtract = new CamgenParamExtract();
		camgenParamExtract.setId(1L);
		camgenParamExtract.setParameter("parameter1");
		camgenParamExtract.setValue("value1");
		camgenParamExtracts.add(camgenParamExtract);

		CamgenParamAudGroupChannels camgenParamAudGroupChannels = new CamgenParamAudGroupChannels();

		CamgenParamAudGroupChannel camgenParamAudGroupChannel = new CamgenParamAudGroupChannel();
		camgenParamAudGroupChannel.setAudienceGroupId(1);
		camgenParamAudGroupChannel.setChannelId(1);
		camgenParamAudGroupChannel.setId(1L);
		camgenParamAudGroupChannel.setKeyAudienceId(1);
		camgenParamAudGroupChannel.setTargetPercentage("1");
		camgenParamAudGroupChannels.add(camgenParamAudGroupChannel);


		CamgenParamEIBands camgenParamEIBands = new CamgenParamEIBands();

		CamgenParamEIBand camgenParamEIBand = new CamgenParamEIBand();
		camgenParamEIBand.setCreatedBy("user1");
		camgenParamEIBand.setEiBand(1);
		camgenParamEIBand.setId(1L);
		camgenParamEIBands.add(camgenParamEIBand);


		CamgenParamStationTimeBands camgenParamStationTimeBands = new CamgenParamStationTimeBands();

		CamgenParamStationTimeBand camgenParamStationTimeBand = new CamgenParamStationTimeBand();
		camgenParamStationTimeBand.setAmendDemand(1);
		camgenParamStationTimeBand.setChannelId(1);
		camgenParamStationTimeBand.setCreatedBy("user1");
		camgenParamStationTimeBand.setId(1L);
		camgenParamStationTimeBand.setName("name1");
		camgenParamStationTimeBand.setStationTimeBandId(1);
		camgenParamStationTimeBands.add(camgenParamStationTimeBand);


		CamgenParamStationEITimeBands camgenParamStationEITimeBands = new CamgenParamStationEITimeBands();

		CamgenParamStationEITimeBand camgenParamStationEITimeBand = new CamgenParamStationEITimeBand();
		camgenParamStationEITimeBand.setCreatedBy("user1");
		camgenParamStationEITimeBand.setId(1L);
		camgenParamStationEITimeBands.add(camgenParamStationEITimeBand);


		camgenSnapshotRunDetails.add(camgenSnapshotRunDetail);
	}

	@Test
	public void testCreateCamgenSnapshotRunDetails() {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgetReq);
		when(dateTimeUtility.getLocalDateFromString(Mockito.anyString())).thenReturn(new LocalDate("2010-02-02"));
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenPlan);
		when(camgenRunJpaRepository.save(Mockito.anyList())).thenReturn(camgenRunsList);
	}

	@Test
	public void updateCamgenSnapshotRunDetailsTest() {
		CamgenRun camgenReq = getCamgenRun();
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId()))).thenReturn(camgenReq);
		Timestamp timestam = new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(timestam);
		when(camgenRequestJpaRepository.findOne(camgenSnapshotRunDetail.getSnapshotId()))
				.thenReturn(getCamgenRequest());
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenPlan);
		LocalDate value = new LocalDate();
		when(dateTimeUtility.getLocalDateFromString("2010-01-01 02:02:02")).thenReturn(value);
		snapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
	}

	@Test
	public void updateCamgenSnapshotRunDetailsException3Test() {
		CamgenRun camgenReq = getCamgenRun();
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId()))).thenReturn(camgenReq);
		Timestamp timestam = new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(timestam);
		when(camgenRequestJpaRepository.findOne(camgenSnapshotRunDetail.getSnapshotId()))
				.thenReturn(getCamgenRequest());
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId())))
				.thenReturn(getCamgenRun());
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		LocalDate value = new LocalDate();
		when(dateTimeUtility.getLocalDateFromString("2010-01-01 02:02:02")).thenReturn(value);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void updateCamgenSnapshotRunDetailsException4Test() {
		CamgenRun camgenReq = getCamgenRun();
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId()))).thenReturn(camgenReq);
		Timestamp timestam = new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(timestam);
		when(camgenRequestJpaRepository.findOne(camgenSnapshotRunDetail.getSnapshotId()))
				.thenReturn(getCamgenRequest());
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId())))
				.thenReturn(getCamgenRun());
		LocalDate value = new LocalDate();
		when(dateTimeUtility.getLocalDateFromString("2010-01-01 02:02:02")).thenReturn(value);
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void updateCamgenSnapshotRunDetailsExceptionTest() {
		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId()))).thenReturn(null);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void updateCamgenSnapshotRunDetailsException1Test() {

		when(camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId())))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void testGetAllSnapshots() {
		Integer page = 1;
		Long count = 1L;
		String sortOrder = "";
		String sortByField = "";
		List<CamgenRequest> l = new ArrayList<>();

		l.add(getCamgenRequest());
		Page<CamgenRequest> camgetReqList11asdfa = new PageImpl<>(l);

		when(snapshotSummaryUtil.getSortByField(sortByField)).thenReturn("default");
		when(camgenRequestJpaRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(camgetReqList11asdfa);

		SnapshotSummaryWithPagination sanpShotListRes = snapshotRunDetailsRepositoryImpl.getAllSnapshots(page, count,
				sortOrder, sortByField);
		assertEquals(BigDecimal.valueOf((sanpShotListRes.getSnapshotSummary().get(0).getChannelSetId())),
				camgetReqList.get(0).getChannelSetId());

	}

	@Test
	public void testGetAllSnapshotsException1() {
		Integer page = 1;
		Long count = 1L;
		String sortOrder = "";
		String sortByField = "";
		List<CamgenRequest> l = new ArrayList<>();
		when(snapshotSummaryUtil.getSortByField(sortByField)).thenReturn("default");
		Page<CamgenRequest> camgetReqList11asdfa = new PageImpl<>(l);
		when(camgenRequestJpaRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(camgetReqList11asdfa);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getAllSnapshots(page, count, sortOrder, sortByField);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testGetAllSnapshotsException2() {
		Integer page = 1;
		Long count = 1L;
		String sortOrder = "";
		String sortByField = "";
		when(snapshotSummaryUtil.getSortByField(sortByField)).thenReturn("default");
		when(camgenRequestJpaRepository.findAll(Mockito.any(PageRequest.class)))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getAllSnapshots(page, count, sortOrder, sortByField);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void deleteSnapshotTest() {
		Integer snapshotId = 1;
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setRequestId(1L);
		when(camgenRequestJpaRepository.findOne(Long.valueOf(snapshotId))).thenReturn(camgenRequest);
		snapshotRunDetailsRepositoryImpl.deleteSnapshot(snapshotId);
	}

	@Test
	public void deleteSnapshotException() {
		Integer snapshotId = 1;
		when(camgenRequestJpaRepository.findOne(Long.valueOf(snapshotId)))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.deleteSnapshot(snapshotId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testCreateSnapshot() {
		List<SnapshotDetail> snapshotDetailList = getSnapShotDetailList();
		List<CamgenRequest> camgenRequestList = new ArrayList<>();
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setRequestId(1L);
		camgenRequestList.add(camgenRequest);
		
		when(camgenRequestJpaRepository.save(Mockito.anyList())).thenReturn(camgenRequestList);
		List<Field> fieldRes = snapshotRunDetailsRepositoryImpl.createSnapshot(snapshotDetailList);
		assertEquals(fieldRes.get(0).getId(), Long.valueOf(camgenRequestList.get(0).getRequestId()));

	}
	
	@Test
	public void testCreateSnapshotException() {
		when(camgenRequestJpaRepository.save(Mockito.anyList()))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			List<SnapshotDetail> snapshotDetailList = getSnapShotDetailList();
			snapshotRunDetailsRepositoryImpl.createSnapshot(snapshotDetailList);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc);
	}

	@Test
	public void updateSnapshotsTest() {
		SnapshotDetail snapshots = new SnapshotDetail();
		snapshots.setRun(true);
		snapshots.setSnapshotId(3);
		when(camgenRequestJpaRepository.findOne(Long.valueOf(snapshots.getSnapshotId()))).thenReturn(camgetReq);
		CamgenRequest value = new CamgenRequest();
		when(camgenParameterMapper.mapCamgenRequestForUpdate(Mockito.any(CamgenRequest.class),
				Mockito.any(SnapshotDetail.class))).thenReturn(value);
		snapshotRunDetailsRepositoryImpl.updateSnapshots(snapshots);
	}

	@Test
	public void updateSnapshotsTestException1() {
		SnapshotDetail snapshots = new SnapshotDetail();
		snapshots.setRun(true);
		snapshots.setSnapshotId(3);
		when(camgenRequestJpaRepository.findOne(Long.valueOf(snapshots.getSnapshotId()))).thenReturn(null);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.updateSnapshots(snapshots);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void updateSnapshotsTestException2() {
		SnapshotDetail snapshots = new SnapshotDetail();
		snapshots.setRun(true);
		snapshots.setSnapshotId(3);
		when(camgenRequestJpaRepository.findOne(Long.valueOf(snapshots.getSnapshotId())))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));

		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.updateSnapshots(snapshots);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetSnapshot() {

		List<CamgenRequest> camgetReqList = new ArrayList<>();
		camgetReqList.add(getCamgenRequest());
		when(camgenRequestJpaRepository.findAll()).thenReturn(camgetReqList);
	}

	@Test
	public void testGetSnapshotException() {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void testGetSnapshotException1() {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
	}

	@Test
	public void getCamgenRunParamAudGroupChannelsTest() {
		camgenRun = testUtil.getCamgenRun();
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRun);
		snapshotRunDetailsRepositoryImpl.getCamgenRunParamAudGroupChannels(1);
	}

	@Test
	public void getCamgenRunParamAudGroupChannelsTestException() {
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenRunParamAudGroupChannels(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getCamgenRunParamAudGroupChannelsExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenRunParamAudGroupChannels(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCamgenSnapshotRunDetailsTest() {
		Integer runId = 1;
		CamgenRun camgenRun = getCamgenRun();
		when(camgenRunJpaRepository.findOne(Long.valueOf(runId.toString()))).thenReturn(camgenRun);
	}

	@Test
	public void getCamgenSnapshotRunDetailsTestException() {
		Integer runId = 1;
		List camgenRunRequestList = null;
		
		when(camgenRunJpaRepository.findAll(Mockito.any(org.springframework.data.jpa.domain.Specification.class))).thenReturn(camgenRunRequestList);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenSnapshotRunDetails(runId,Mockito.any(),"status","runStatus");
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getCamgenSnapshotRunDetailsTestException2() {
		Integer runId = 1;
		CamgenRun runRequest =null;
		when(camgenRunJpaRepository.findAll(Mockito.any(org.springframework.data.jpa.domain.Specification.class)))
			.thenThrow(new DataRetrievalFailureException("Exception From Database"));
		int exceptionCode = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenSnapshotRunDetails(runId, Mockito.any(),"status","runStatus");
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getCreateCamgenRunParamAudGroupChannelsTest() {
		Integer runId = 1;

		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = getCamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);

		when(camgenRunJpaRepository.findOne(Long.valueOf(runId))).thenReturn(getCamgenRun());
		RunAudienceGroupChannel value = new RunAudienceGroupChannel();
		when(runAudienceGroupChannelJpaRepository.save(Mockito.any(RunAudienceGroupChannel.class))).thenReturn(value);
		snapshotRunDetailsRepositoryImpl.createCamgenRunParamAudGroupChannels(camgenRunParamAudGroupChannels, runId);
	}

	@Test
	public void getCreateCamgenRunParamAudGroupChannelsExceptionTest() {
		Integer runId = 1;
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = getCamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
		when(camgenRunJpaRepository.findOne(Long.valueOf(runId.toString()))).thenReturn(null);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.createCamgenRunParamAudGroupChannels(camgenRunParamAudGroupChannels,
					runId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getCreateCamgenRunParamAudGroupChannelsExceptionTest1() {
		Integer runId = 1;
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = getCamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
		when(camgenRunJpaRepository.findOne(Long.valueOf(runId.toString())))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.createCamgenRunParamAudGroupChannels(camgenRunParamAudGroupChannels,
					runId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getCamgenSnapshotRunDetailsBySnapshotIdTest() {
		Integer sanpshotId = 1;
		CamgenRun camgenRun = getCamgenRun();
		String time = new String("12:22:22");
		when(dateTimeUtility.getTimeFromDate(new Date())).thenReturn(time);
		CamgenRequest value = getCamgenRequest();
		when(camgenRequestJpaRepository.findOne(Long.valueOf(sanpshotId.toString()))).thenReturn(value);
		CamgenSnapshotRunDetails camgenSnapshotRunDetailsRes = snapshotRunDetailsRepositoryImpl
				.getCamgenSnapshotRunDetailsBySnapshotId(sanpshotId);
		assertEquals(camgenSnapshotRunDetailsRes.get(0).getNotes(), camgenRun.getNote());
	}

	@Test
	public void getCamgenSnapshotRunDetailsBySnapshotIdExceptionTest() {
		Integer sanpshotId = 1;
		when(camgenRequestJpaRepository.findOne(Long.valueOf(sanpshotId.toString()))).thenReturn(null);
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenSnapshotRunDetailsBySnapshotId(sanpshotId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getCamgenSnapshotRunDetailsBySnapshotIdException1Test() {
		Integer sanpshotId = 1;
		when(camgenRequestJpaRepository.findOne(Long.valueOf(sanpshotId.toString())))
				.thenThrow(new DataRetrievalFailureException("Exception from database"));
		int exc = 0;
		try {
			snapshotRunDetailsRepositoryImpl.getCamgenSnapshotRunDetailsBySnapshotId(sanpshotId);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	private CamgenRun getCamgenRun() {
		CamgenRun camgenRun = new CamgenRun();
		camgenRun.setIsFileImported(new BigDecimal(1));
		camgenRun.setFileImportDate(new Date());
		camgenRun.setScheduleDateTime(new Date());
		camgenRun.setNote("note");
		camgenRun.setRunId(1L);
		camgenRun.setStartDateTime(new Date());
		camgenRun.setStatus("status");
		camgenRun.setCamgenRequest(getCamgenRequest());
		return camgenRun;
	}

	private CamgenRunParamAudGroupChannel getCamgenRunParamAudGroupChannel() {
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannel.setAudienceGroupId(1);
		camgenRunParamAudGroupChannel.setChannelId(1);
		camgenRunParamAudGroupChannel.setKeyAudienceId(1);

		camgenRunParamAudGroupChannel.setTargetPercentage("23");
		return camgenRunParamAudGroupChannel;
	}

	private List<SnapshotDetail> getSnapShotDetailList() {
		List<SnapshotDetail> snapshotDetailList = new ArrayList<>();
		SnapshotDetail snapshotDetail = new SnapshotDetail();
		snapshotDetail.setCamgenRequestEndDate(new LocalDate());
		snapshotDetail.setChannelSet(1L);
		snapshotDetailList.add(snapshotDetail);
		return snapshotDetailList;
	}

	private CamgenRequest getCamgenRequest() {
		CamgenRequest camgetReq = new CamgenRequest();
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenPlan.setIsRun(BigDecimal.valueOf(1L));
		camgenPlan.setIsSlot(BigDecimal.valueOf(1L));
		camgenPlan.setStartDate(new Date());
		camgenPlan.setEndDate(new Date());
		camgenPlan.setTotalIteration(BigDecimal.valueOf(8L));
		List<CamgenPlanAutofillingDay> camgenPlanAutofillingDaysList = new ArrayList<>();
		CamgenPlanAutofillingDay camgenPlanAutofillingDay = new CamgenPlanAutofillingDay();
		camgenPlanAutofillingDay.setAutofillingDayId(1L);
		camgenPlanAutofillingDay.setDuration(new BigDecimal(1));
		camgenPlanAutofillingDay.setOffset(new BigDecimal(1));
		camgenPlanAutofillingDay.setRunDay("Mon");
		camgenPlanAutofillingDay.setStartTime("14 Feb");
		camgenPlanAutofillingDaysList.add(camgenPlanAutofillingDay);
		camgenPlan.setCamgenPlanAutofillingDays(camgenPlanAutofillingDaysList);

		List<CamgenPlanDemandSupply> camgenPlanDemandSupplies = new ArrayList<>();
		CamgenPlanDemandSupply camgenPlanDemandSupply = new CamgenPlanDemandSupply();
		camgenPlanDemandSupply.setAmendmentPercentage(new BigDecimal(1));
		camgenPlanDemandSupply.setDemandSupplyId(1l);
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("demandSupplyLevelName1");
		camgenPlanDemandSupply.setCamgenDemandSupplyLevel(camgenDemandSupplyLevel);
		camgenPlanDemandSupply.setName("name");
		List<PlanDemandSupplyCriteria> planDemandSupplyCriterias = new ArrayList<>();
		PlanDemandSupplyCriteria planDemandSupplyCriteria = new PlanDemandSupplyCriteria();
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode1");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);
		camgenDemandSupplyAttribute.setPlanDemandSupplyCriterias(getPlanDemandSupplyCriterias());

		planDemandSupplyCriteria.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttribute);

		CamgenDemandSupplyCondition camgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		camgenDemandSupplyCondition.setDemandSupplyConditionCode("demandSupplyConditionCode1");
		camgenDemandSupplyCondition.setDemandSupplyConditionDesc("demandSupplyConditionDesc1");
		camgenDemandSupplyCondition.setDemandSupplyConditionId(1l);

		planDemandSupplyCriteria.setCamgenDemandSupplyCondition(camgenDemandSupplyCondition);

		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyObject.setDemandSupplyObjectCode("demandSupplyObjectCode1");
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyObject.setDemandSupplyObjectName("demandSupplyObjectName1");

		planDemandSupplyCriteria.setCamgenDemandSupplyObject(camgenDemandSupplyObject);

		planDemandSupplyCriteria.setOperator("operator");
		planDemandSupplyCriteria.setPlanDemandSupplyCriteriaId(1l);
		planDemandSupplyCriteria.setValue("value");
		planDemandSupplyCriterias.add(planDemandSupplyCriteria);
		camgenPlanDemandSupply.setPlanDemandSupplyCriterias(planDemandSupplyCriterias);
		camgenPlanDemandSupplies.add(camgenPlanDemandSupply);
		camgenPlan.setCamgenPlanDemandSupplies(camgenPlanDemandSupplies);
		camgetReq.setCamgenPlan(camgenPlan);
		List<CamgenRun> camgenRunsList = new ArrayList<>();
		CamgenRun camgenR = new CamgenRun();
		camgenR.setRunId(1L);
		camgenR.setScheduleDateTime(new Date());
		camgenR.setIsFileImported(new BigDecimal(1));
		camgenR.setFileImportDate(new Date());
		camgenR.setStartDateTime(new Date());
		camgenR.setNote("note");
		camgenR.setRunId(1L);
		camgenR.setStartDateTime(new Date());
		camgenR.setStatus("status");
		camgenRunsList.add(camgenR);
		camgetReq.setCamgenRuns(camgenRunsList);
		camgetReq.setChannelSetId(BigDecimal.valueOf(1L));
		camgetReq.setCreatedBy("createdBy");
		camgetReq.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		camgetReq.setEndDate(new Date());
		camgetReq.setModifiedBy("modifiedBy");
		camgetReq.setModifiedOn(new Timestamp(System.currentTimeMillis()));
		camgetReq.setRequestId(123L);
		camgetReq.setRequestType("requestType");
		camgetReq.setStartDate(new Date());
		camgetReq.setStatus("status");
		return camgetReq;
	}

	public List<PlanDemandSupplyCriteria> getPlanDemandSupplyCriterias() {
		List<PlanDemandSupplyCriteria> lst = new ArrayList<>();
		lst.add(getPlanDemandSupplyCriteria());
		return lst;
	}

	public PlanDemandSupplyCriteria getPlanDemandSupplyCriteria() {
		PlanDemandSupplyCriteria planDemandSupplyCriteria = new PlanDemandSupplyCriteria();

		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode1");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);


		planDemandSupplyCriteria.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttribute);

		CamgenDemandSupplyCondition camgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		camgenDemandSupplyCondition.setDemandSupplyConditionCode("demandSupplyConditionCode1");
		camgenDemandSupplyCondition.setDemandSupplyConditionDesc("demandSupplyConditionDesc1");
		camgenDemandSupplyCondition.setDemandSupplyConditionId(1l);

		planDemandSupplyCriteria.setCamgenDemandSupplyCondition(camgenDemandSupplyCondition);

		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyObject.setDemandSupplyObjectCode("demandSupplyObjectCode1");
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyObject.setDemandSupplyObjectName("demandSupplyObjectName1");

		planDemandSupplyCriteria.setCamgenDemandSupplyObject(camgenDemandSupplyObject);

		planDemandSupplyCriteria.setOperator("operator");
		planDemandSupplyCriteria.setPlanDemandSupplyCriteriaId(1l);
		planDemandSupplyCriteria.setValue("value");
		return planDemandSupplyCriteria;
	}

	@Test
	public void createCamgenSnapshotRunDetailsTest_Success() {
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		List<CamgenRunParamExtract> camgenRunParamExtracts = new ArrayList<>();
		CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();
		camgenRunParamExtract.setCreatedBy("mintUser1");
		camgenRunParamExtract.setParameter("parameter");
		camgenRunParamExtract.setRunParameterExtractId(1);
		camgenRunParamExtract.setValue("1");
		camgenRunParamExtracts.add(camgenRunParamExtract);
		List<CamgenRunParam> camgenRunParameters = new ArrayList<>();
		CamgenRunParam camgenRunParam = new CamgenRunParam();
		camgenRunParam.setCreatedBy("mintUser1");
		camgenRunParam.setParameter("parameter");
		camgenRunParam.setRemarks("remarks");
		camgenRunParam.setRunParameterId(1);
		camgenRunParam.setStandardvalue("1");
		camgenRunParam.setValue("1");
		camgenRunParameters.add(camgenRunParam);
		List<CamgenRunParamAudGroupChannel> camgenRunParamAudGroupChannels = new ArrayList<>();
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannel.setAudienceGroupId(1);
		camgenRunParamAudGroupChannel.setChannelId(1);
		camgenRunParamAudGroupChannel.setKeyAudienceId(1);
		camgenRunParamAudGroupChannel.setRunParameterAudienceGroupChannelId(1);
		camgenRunParamAudGroupChannel.setTargetPercentage("1");
		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
		List<CamgenRunParamEIBand> camgenRunParamEIBands = new ArrayList<>();
		CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();
		camgenRunParamEIBand.setCreatedBy("mintUser1");
		camgenRunParamEIBand.setEiBand(1);
		camgenRunParamEIBand.setRunParameterEIBandId(1);
		camgenRunParamEIBands.add(camgenRunParamEIBand);
		List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands = new ArrayList<>();
		CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();
		camgenRunParamStationTimeBand.setAmendDemand(1);
		camgenRunParamStationTimeBand.setChannelId(1);
		camgenRunParamStationTimeBand.setCreatedBy("mintUser1");
		camgenRunParamStationTimeBand.setDayCode("01");
		camgenRunParamStationTimeBand.setEiCutOff(1);
		camgenRunParamStationTimeBand.setEndTime("12:00:00");
		camgenRunParamStationTimeBand.setExcludeFlag("true");
		camgenRunParamStationTimeBand.setName("name");
		camgenRunParamStationTimeBand.setRunParameterStationTimeBandId(1);
		camgenRunParamStationTimeBand.setStartTime("09:00:00");
		camgenRunParamStationTimeBand.setStationTimeBandId(1);
		camgenRunParamStationTimeBand.setTbProgRepetitionLimit(1);
		camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
		List<CamgenRunParamStationEITimeBand> camgenRunParamStationEITimeBands = new ArrayList<>();
		CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = new CamgenRunParamStationEITimeBand();
		camgenRunParamStationEITimeBand.setDayCode("01");
		camgenRunParamStationEITimeBand.setEndTime("12:00:00");
		camgenRunParamStationEITimeBand.setRunParameterStationEITimeBandId(1);
		camgenRunParamStationEITimeBand.setStartTime("09:00:00");
		camgenRunParamStationEITimeBands.add(camgenRunParamStationEITimeBand);

		CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();
		camgenSnapshotRunDetail.setRunId(1);
		camgenSnapshotRunDetail.setSnapshotId(1L);
		camgenSnapshotRunDetail.setCreatedBy("mintUser1");
		camgenSnapshotRunDetail.setIterationCount(1);
		camgenSnapshotRunDetail.setRunDateTime(fmt.print(dt));
		camgenSnapshotRunDetail.setRunStatus("Active");
		camgenSnapshotRunDetail.setNotes("Success");
		camgenSnapshotRunDetail.setSlotFileImportStatus("Active");
		camgenSnapshotRunDetail.setSlotFileLastImportDate(new LocalDate());
		camgenSnapshotRunDetail.setCamgenRunParameters(camgenRunParameters);
		camgenSnapshotRunDetail.setCamgenRunParamExtracts(camgenRunParamExtracts);
		camgenSnapshotRunDetail.setCamgenRunParamAudGroupChannels(camgenRunParamAudGroupChannels);
		camgenSnapshotRunDetail.setCamgenRunParamEIBands(camgenRunParamEIBands);
		camgenSnapshotRunDetail.setCamgenRunParamStationTimeBands(camgenRunParamStationTimeBands);
		camgenSnapshotRunDetail.setCamgenRunParamStationEITimeBands(camgenRunParamStationEITimeBands);
		camgenSnapshotRunDetail.setSlotFlag(true);
		
		when(camgenRunJpaRepository.findOne(Mockito.anyLong())).thenReturn(getCamgenRun());
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(getCamgenRequest());
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenPlan);
		when(securityUtil.getLoginUser()).thenReturn("hcl");
		when(camgenRunJpaRepository.save(Mockito.anyListOf(CamgenRun.class))).thenReturn(camgenRunsList);
		snapshotRunDetailsRepositoryImpl.createCamgenSnapshotRunDetails(camgenSnapshotRunDetail);
	}

}
