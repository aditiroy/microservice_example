package com.channel4.mint.automated.spot.service.impl;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.application.util.SnapshotParamBatchTxLevelsImplMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotParamBatchTxLevelsImplRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class SnapshotParamBatchTxLevelsServiceImplTest {

	@InjectMocks
	private SnapshotParamBatchTxLevelsServiceImpl snapshotParamBatchTxLevelsServiceImpl;

	@Mock
	private SnapshotParamBatchTxLevelsImplRepository snapshotParamBatchTxLevelsImplRepository;

	@Mock
	private SnapshotParamBatchTxLevelsImplMapper snapshotParamBatchTxLevelsImplMapper;

	private TestUtil test = new TestUtil();
	private List<CamgenRqstBatchTxLevel> lstCamgenRqstBatchTxLevels;

	private BatchTxLevels batchTxLevels;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		batchTxLevels = test.getBatchTxLevels();
		lstCamgenRqstBatchTxLevels = test.getlstCamgenRqstBatchTxLevels();
	}

	@Test
	public void testGetCamgenRunParamBatchTxLevels() {
		when(snapshotParamBatchTxLevelsImplRepository.getCamgenRunParamBatchTxLevels(1)).thenReturn(batchTxLevels);
		when(snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(lstCamgenRqstBatchTxLevels))
				.thenReturn(batchTxLevels);
		snapshotParamBatchTxLevelsServiceImpl.getCamgenRunParamBatchTxLevels(1);
	}

}
