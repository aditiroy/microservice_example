package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.application.util.SnapshotParamBatchTxLevelsImplMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenBatchTxLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRqstBatchTxLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenBatchTxLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class SnapshotParamBatchTxLevelsImplRepositoryImplTest {

	@InjectMocks
	private SnapshotParamBatchTxLevelsImplRepositoryImpl snapshotParamBatchTxLevelsImplRepositoryImpl;

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Mock
	private CamgenBatchTxLevelJpaRepository camgenBatchTxLevelJpaRepository;

	@Mock
	private SnapshotParamBatchTxLevelsImplMapper snapshotParamBatchTxLevelsImplMapper;
	@Mock
	private CamgenRqstBatchTxLevelJpaRepository camgenRqstBatchTxLevelJpaRepository;
	private TestUtil test = new TestUtil();
	private List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList;
	private CamgenRqstBatchTxLevel camgenRqstBatchTxLevel;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		camgenRqstBatchTxLevelList = test.getlstCamgenRqstBatchTxLevels();
		camgenRqstBatchTxLevel = test.getCamgenRqstBatchTxLevel();
	}

	@Test
	public void testGetCamgenRequestFindOne() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(1l)).thenReturn(camgenRequest);
		snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRequestFindOne(1l);
	}

	@Test
	public void testGetCamgenRequestFindOne_failure() {

		when(camgenRqstBatchTxLevelJpaRepository.save(camgenRqstBatchTxLevelList)).thenReturn(null);
		int exc = 0;
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRequestFindOne(1l);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testSaveParamBatchTxLevels_failure() {

		when(camgenRqstBatchTxLevelJpaRepository.save(camgenRqstBatchTxLevelList)).thenReturn(null);
		int exc = 0;
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels(camgenRqstBatchTxLevelList);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testSaveParamBatchTxLevels() {
		when(camgenRqstBatchTxLevelJpaRepository.save(camgenRqstBatchTxLevelList))
				.thenReturn(camgenRqstBatchTxLevelList);
		snapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels(camgenRqstBatchTxLevelList);
	}

	@Test
	public void testGetCamgenRunParamBatchTxLevels() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		camgenRequest.setCamgenRqstBatchTxLevels(camgenRqstBatchTxLevelList);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		BatchTxLevel batchTxLevel = new BatchTxLevel();
		batchTxLevel.setBatchTxLevelValue(1);
		batchTxLevel.setId(1);
		batchTxLevels.add(batchTxLevel);
		when(snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(Mockito.anyList()))
				.thenReturn(batchTxLevels);
		BatchTxLevels response = snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		assertNotNull(response);
		assertEquals(response.get(0).getBatchTxLevelValue(), batchTxLevels.get(0).getBatchTxLevelValue());
		assertEquals(response.get(0).getId(), batchTxLevels.get(0).getId());

	}

	@Test
	public void getCamgenRunParamBatchTxLevelsEmptyTest_Success() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		BatchTxLevel batchTxLevel = new BatchTxLevel();
		batchTxLevel.setBatchTxLevelValue(1);
		batchTxLevel.setId(1);
		batchTxLevels.add(batchTxLevel);
		List<CamgenBatchTxLevel> camgenBatchTxLevelList = new ArrayList<>();
		CamgenBatchTxLevel camgenBatchTxLevel = new CamgenBatchTxLevel();
		camgenBatchTxLevel.setBatchTxLevelId(1l);
		camgenBatchTxLevel.setBatchValue(new BigDecimal(1));
		camgenBatchTxLevel.setCreatedBy("mintUser1");
		camgenBatchTxLevel.setModifiedBy("mintUser1");
		camgenBatchTxLevel.setTransmissionLevelId(new BigDecimal(1));
		camgenBatchTxLevelList.add(camgenBatchTxLevel);
		when(camgenBatchTxLevelJpaRepository.findAll()).thenReturn(camgenBatchTxLevelList);
		when(snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(Mockito.anyList()))
				.thenReturn(batchTxLevels);
		BatchTxLevels response = snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		assertNotNull(response);
		assertEquals(response.get(0).getBatchTxLevelValue(), batchTxLevels.get(0).getBatchTxLevelValue());
		assertEquals(response.get(0).getId(), batchTxLevels.get(0).getId());
	}

	@Test
	public void getCamgenRunParamBatchTxLevelsEmptyTest_Failure() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		BatchTxLevel batchTxLevel = new BatchTxLevel();
		batchTxLevel.setBatchTxLevelValue(1);
		batchTxLevel.setId(1);
		batchTxLevels.add(batchTxLevel);
		List<CamgenBatchTxLevel> camgenBatchTxLevelList = new ArrayList<>();
		CamgenBatchTxLevel camgenBatchTxLevel = new CamgenBatchTxLevel();
		int exceptionCode = 0;
		try {
			when(camgenBatchTxLevelJpaRepository.findAll()).thenReturn(camgenBatchTxLevelList);
			when(snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(Mockito.anyList()))
					.thenReturn(batchTxLevels);
			snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
	}

	@Test
	public void getCamgenRunParamBatchTxLevelsDBTest_Failure() {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		BatchTxLevel batchTxLevel = new BatchTxLevel();
		batchTxLevel.setBatchTxLevelValue(1);
		batchTxLevel.setId(1);
		batchTxLevels.add(batchTxLevel);
		List<CamgenBatchTxLevel> camgenBatchTxLevelList = new ArrayList<>();
		CamgenBatchTxLevel camgenBatchTxLevel = new CamgenBatchTxLevel();
		int exceptionCode = 0;
		when(camgenBatchTxLevelJpaRepository.findAll())
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		when(snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(Mockito.anyList()))
				.thenReturn(batchTxLevels);
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(exceptionCode, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetCamgenRunParamBatchTxLevels_Exception() {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testGetCamgenRunParamBatchTxLevels_failure() {

		when(camgenRequestJpaRepository.findOne(1L)).thenReturn(null);
		int exc = 0;
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.getCamgenRunParamBatchTxLevels(1);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void saveParamBatchTxLevels_Exception() {
		when(camgenRqstBatchTxLevelJpaRepository.save(camgenRqstBatchTxLevelList))
				.thenThrow(new DataRetrievalFailureException("Exception from Database"));
		int exc = 0;
		try {
			snapshotParamBatchTxLevelsImplRepositoryImpl.saveParamBatchTxLevels(camgenRqstBatchTxLevelList);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

}
