package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RqstDemandSupplyCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup.RunDayEnum;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine.OperatorEnum;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroupInner;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.StartEndDate;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class CamgenParameterMapperTest {

	@InjectMocks
	private CamgenParameterMapper camgenParameterMapper;

	@Mock
	private DateTimeUtility dateTimeUtility;
	
	@Mock
	private CamgenRepository camgenRepository;
	
	@Mock
	private SecurityUtil securityUtil;

	TestUtil testUtil = new TestUtil();
	CamgenParam camgenParam;
	CamgenRequest camgenRequest;
	CamgenParameter camgenParameter;
	List<CamgenParameter> camgenParameterList = new ArrayList<>();
	ChannelSetTimeBand channelSetTimeBand = new ChannelSetTimeBand();


	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenParam = testUtil.getCamgenParam();
		camgenParameter = testUtil.getCamgenParameter();
		camgenRequest = testUtil.getCamgenRequest();


		camgenParameterList.add(camgenParameter);
		channelSetTimeBand = testUtil.getChannelSetTimeBand();
	}

	@Test
	public void testMapCamgenExtractMapper() {
		CamgenParameter response = camgenParameterMapper.mapCamgenParameterMapper(camgenParam, camgenParameter);
		assertEquals(response.getCreatedBy(), camgenParameter.getCreatedBy());
		assertEquals(response.getDescription(), camgenParameter.getDescription());
		assertEquals(response.getValue(), camgenParameter.getValue());
		assertEquals(response.getParameterId(), camgenParameter.getParameterId());
	}

	@Test
	public void testMapCamgenParamExtracts() {
		CamgenParameters response = camgenParameterMapper.mapCamgenParamExtracts(camgenParameterList);
		assertEquals(response.get(0).getCreatedBy(), camgenParameterList.get(0).getCreatedBy());
		assertEquals(response.get(0).getParameter(), camgenParameterList.get(0).getParameterName());
		assertEquals(response.get(0).getValue(), camgenParameterList.get(0).getValue());
	}

	@Test
	public void testmapCamgenRequestForUpdate() {

		SnapshotDetail snapshots = new SnapshotDetail();
		snapshots.setCreatedBy("createdBy");
		StartEndDate dateRange = new StartEndDate();
		dateRange.setEnd(new DateTime());
		dateRange.setStart(new DateTime());
		snapshots.setRun(true);
		snapshots.setSlot(true);
		snapshots.setIterationCount(1);
		snapshots.setChannelSet(1L);

		DemandSupplyGroup demandSupply = new DemandSupplyGroup();
		DemandSupplyGroupInner demandSupplyGroupInner = new DemandSupplyGroupInner();
		demandSupplyGroupInner.setAmendmentPercent(12d);
		demandSupplyGroupInner.setDemandSupplyId(1);
		demandSupplyGroupInner.setName("name");
		demandSupplyGroupInner.setStatus("status");
		
		demandSupplyGroupInner.setLevelId(1L);
		List<CriteriaLine> criterias = new ArrayList<>();

		CriteriaLine criteria = new CriteriaLine();
		criteria.setAttributeId(1L);
		criteria.setConditionId(1L);
		criteria.setValue("value");
		criteria.setObjectId(1L);
		criterias.add(criteria);
		demandSupplyGroupInner.setCriterias(criterias);

		List<DemandSupplyGroup> demandSupplyGroupList = new ArrayList<>();
		DemandSupplyGroup demandSupplyGroup = new DemandSupplyGroup();
		demandSupplyGroup.setAmendmentPercent(new Double(1));
		demandSupplyGroup.setDemandSupplyId(1);
		demandSupplyGroup.setLevelId(1L);
		demandSupplyGroup.setName("name");
		demandSupplyGroup.setStatus("status");

		demandSupplyGroupList.add(demandSupplyGroup);

		snapshots.setDemandSupply(demandSupplyGroupList);

		ChannelSetTimeBands channelSetTimebands = new ChannelSetTimeBands();
		ChannelSetTimeBand channelSetTimeBand = testUtil.getChannelSetTimeBand();
		channelSetTimebands.add(channelSetTimeBand);
		snapshots.setChannelSetTimebands(channelSetTimebands);

		List<BatchTxLevel> batchTxLevels = testUtil.getBatchTxLevels();
		snapshots.setBatchTxLevels(batchTxLevels);

		List<AutoFillingDaySetup> autoFillingList = new ArrayList<>();
		AutoFillingDaySetup autoFillingDaySetup = new AutoFillingDaySetup();
		autoFillingDaySetup.setDuration(new BigDecimal(12));
		autoFillingDaySetup.setOffset(13L);
		autoFillingDaySetup.setRunDay(RunDayEnum.fromValue("Mon"));
		autoFillingDaySetup.setStartTime("1234");
		autoFillingDaySetup.offset(12L);
		autoFillingList.add(autoFillingDaySetup);
		snapshots.setCamgenRequestStartDate(new LocalDate(2010 - 02 - 02));
		snapshots.setCamgenRequestEndDate(new LocalDate(2010 - 02 - 02));

		RqstDemandSupplyCriteria rqstDemandSupplyCriteria = getRqstDemandSupplyCriteria();

		Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap = getCamgenDemandSupplyAttributeMap();

		Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = getCamgenDemandSupplyConditionMap();

		Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = getCamgenDemandSupplyObjectMap();

		Timestamp zc = new Timestamp(System.currentTimeMillis());
		when(dateTimeUtility.getCurrentTimeStamp()).thenReturn(zc);
		Map<Long, CamgenDemandSupplyLevel> value = new HashMap<>();
		CamgenDemandSupplyLevel arg1 = new CamgenDemandSupplyLevel();
		arg1.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		arg1.setDemandSupplyLevelId(1L);
		arg1.setDemandSupplyLevelName("demandSupplyLevelName1");
		value.put(1L, arg1);

		when(camgenRepository.getAllCamgenDemandSupplyAttributeMap()).thenReturn(camgenDemandSupplyAttributeMap);
		when(camgenRepository.getAllCamgenDemandSupplyConditionMap()).thenReturn(camgenDemandSupplyConditionMap);
		when(camgenRepository.getAllCamgenDemandSupplyObjectMap()).thenReturn(camgenDemandSupplyObjectMap);
		when(camgenRepository.getAllCamgenDemandSupplyLevelMap()).thenReturn(value);
		CamgenRequest response = camgenParameterMapper.mapCamgenRequestForUpdate(camgenRequest, snapshots);

	}

	 

	private Map<Long, CamgenDemandSupplyObject> getCamgenDemandSupplyObjectMap() {
		Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = new HashMap<>();
		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyObject.setDemandSupplyObjectCode("demandSupplyObjectCode1");
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyObject.setDemandSupplyObjectName("demandSupplyObjectName1");
		camgenDemandSupplyObjectMap.put(1L, camgenDemandSupplyObject);
		return camgenDemandSupplyObjectMap;
	}

	private Map<Long, CamgenDemandSupplyCondition> getCamgenDemandSupplyConditionMap() {
		Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = new HashMap<>();
		CamgenDemandSupplyCondition CamgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		CamgenDemandSupplyCondition.setDemandSupplyConditionId(1l);
		CamgenDemandSupplyCondition.setDemandSupplyConditionDesc("demandSupplyConditionDesc1");
		camgenDemandSupplyConditionMap.put(1L, CamgenDemandSupplyCondition);
		return camgenDemandSupplyConditionMap;
	}

	private Map<Long, CamgenDemandSupplyAttribute> getCamgenDemandSupplyAttributeMap() {
		Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap = new HashMap<>();
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);
		camgenDemandSupplyAttribute.setDemandSupplyAttributeName("demandSupplyAttributeName1");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode1");
		camgenDemandSupplyAttributeMap.put(1L, camgenDemandSupplyAttribute);
		return camgenDemandSupplyAttributeMap;
	}

	private RqstDemandSupplyCriteria getRqstDemandSupplyCriteria() {
		RqstDemandSupplyCriteria rqstDemandSupplyCriteria = new RqstDemandSupplyCriteria();

		CamgenDemandSupplyCondition camgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		camgenDemandSupplyCondition.setDemandSupplyConditionCode("demandSupplyConditionCode1");
		camgenDemandSupplyCondition.setDemandSupplyConditionId(1l);
		camgenDemandSupplyCondition.setDemandSupplyConditionDesc("demandSupplyConditionDesc1");

		rqstDemandSupplyCriteria.setCamgenDemandSupplyCondition(camgenDemandSupplyCondition);

		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyObject.setDemandSupplyObjectCode("demandSupplyObjectCode1");
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyObject.setDemandSupplyObjectName("demandSupplyObjectName1");

		rqstDemandSupplyCriteria.setCamgenDemandSupplyObject(camgenDemandSupplyObject);
		rqstDemandSupplyCriteria.setOperator("operator1");
		rqstDemandSupplyCriteria.setValue("value1");

		return rqstDemandSupplyCriteria;
	}
}
