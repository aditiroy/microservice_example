package com.channel4.mint.automated.spot.application.util;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class SnapshotParamBatchTxLevelsImplMapperTest {
	
	@InjectMocks
	SnapshotParamBatchTxLevelsImplMapper snapshotParamBatchTxLevelsImplMapper;
	
	@Mock
	DateTimeUtility dateTimeUtility;
	private CamgenRequest camgenRequestFindOne;
	private BatchTxLevel batchTxLevel;
	private CamgenRqstBatchTxLevel camgenRqstBatchTxLevel;
	private List<CamgenRqstBatchTxLevel> lstCamgenRqstBatchTxLevel;
	private TestUtil test= new TestUtil();
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		camgenRequestFindOne=test.getCamgenRequest();
		batchTxLevel=test.getBatchTxLevel();
		camgenRqstBatchTxLevel = test.getCamgenRqstBatchTxLevel();
		lstCamgenRqstBatchTxLevel= test.getlstCamgenRqstBatchTxLevels();
	}
	
	@Test
	public void testMapCreateCamgenRunParamBatchTxLevelsPost() {
		camgenRqstBatchTxLevel.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		snapshotParamBatchTxLevelsImplMapper.mapCreateCamgenRunParamBatchTxLevelsPost(camgenRequestFindOne, batchTxLevel);
	}
	@Test
	public void testMapCamgenRqstBatchTxLevelToBatchTxLevels() {
		snapshotParamBatchTxLevelsImplMapper.mapCamgenRqstBatchTxLevelToBatchTxLevels(lstCamgenRqstBatchTxLevel);
	}

}
