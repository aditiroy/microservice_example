package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup.RunDayEnum;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine.OperatorEnum;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.Exclusions;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.StartEndDate;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class CamgenPlanMapperTest {

	@InjectMocks
	private CamgenPlanMapper camgenPlanMapper;
	@Mock
	private DateTimeUtility dateTimeUtility;

	@Mock
	private CamgenRepository camgenRepository;

	@Mock
	private SecurityUtil securityUtil;

	CamgenRequest camgenRequest;
	List<CamgenPlan> camgenPlanList = new ArrayList<>();
	TestUtil testUtil = new TestUtil();
	PlansObject plansObject;
	CamgenPlan camgenPlan;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		ReflectionTestUtils.setField(camgenPlanMapper, "active", "active");

		camgenPlan = testUtil.getCamgenPlan();
		camgenPlanList.add(camgenPlan);

		camgenRequest = testUtil.getCamgenRequest();

		plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setCreatedBy("user1");
		plansObject.setIterationCount(1);
		plansObject.setRun(true);
		plansObject.setSlot(true);
		plansObject.setPlanId(1);
		StartEndDate dateRange = new StartEndDate();
		dateRange.setEnd(new DateTime());
		dateRange.setStart(new DateTime());
		plansObject.setDateRange(dateRange);

		plansObject.setAutoFilling(getAutoFillingDaySetuplist());

		plansObject.setDemandSupply(getDemandSupplyGroupInnerlist());

		plansObject.setExclusions(getExclution());
	}

	private Exclusions getExclution() {
		Exclusions exclusions = new Exclusions();
		ExclusionDemandSupplyGroup exclusion = new ExclusionDemandSupplyGroup();
		exclusion.setCategoryId(1);
		exclusion.setCategoryName("categoryName");
		exclusion.setCategoryValue("categoryValue");
		exclusions.add(exclusion);
		return exclusions;
	}

	private List<DemandSupplyGroup> getDemandSupplyGroupInnerlist() {
		List<DemandSupplyGroup> demandSupplyGroupInnerlist = new ArrayList<>();
		DemandSupplyGroup demandSupplyGroupInner = new DemandSupplyGroup();
		demandSupplyGroupInner.setDemandSupplyId(1);
		demandSupplyGroupInner.setLevelId(1L);
		demandSupplyGroupInner.setName("name1");
		demandSupplyGroupInner.setStatus("status1");
		demandSupplyGroupInner.setAmendmentPercent(123d);
		List<CriteriaLine> criterias = new ArrayList<>();
		CriteriaLine criteriaLine = new CriteriaLine();
		criteriaLine.setAttributeCode("attributeCode");
		criteriaLine.setAttributeId(1L);
		criteriaLine.setConditionCode("conditionCode");
		criteriaLine.setConditionId(1L);
		criteriaLine.setCriteriaLineId(1L);
		criteriaLine.setObjectCode("objectCode");
		criteriaLine.setObjectId(1L);
		criteriaLine.setOperator(OperatorEnum.fromValue("AND"));
		criteriaLine.setValue("value");
		criterias.add(criteriaLine);
		demandSupplyGroupInner.setCriterias(criterias);
		demandSupplyGroupInnerlist.add(demandSupplyGroupInner);
		return demandSupplyGroupInnerlist;
	}

	private List<AutoFillingDaySetup> getAutoFillingDaySetuplist() {
		List<AutoFillingDaySetup> autoFillings = new ArrayList<>();
		AutoFillingDaySetup autoFillingDaySetup = getAutoFillingDaySetup();
		autoFillings.add(autoFillingDaySetup);
		return autoFillings;
	}

	private AutoFillingDaySetup getAutoFillingDaySetup() {
		AutoFillingDaySetup autoFillingDaySetup = new AutoFillingDaySetup();
		autoFillingDaySetup.setDuration(new BigDecimal(1));
		autoFillingDaySetup.setOffset(1L);
		autoFillingDaySetup.offset(1L);

		autoFillingDaySetup.setRunDay(RunDayEnum.FRI);
		autoFillingDaySetup.setStartTime("12-03-2018");
		return autoFillingDaySetup;
	}


	@Test
	public void testmapEntityListToCamgenPlan() {

		List<PlanSummary> response = camgenPlanMapper.mapEntityListToCamgenPlan(camgenPlanList);
		assertEquals(response.get(0).getCreatedBy(), camgenPlanList.get(0).getCreatedBy());
		assertEquals(response.get(0).getPlanId().intValue(), camgenPlanList.get(0).getPlanId());
		assertEquals(response.get(0).getStatus(), camgenPlanList.get(0).getStatus());
		assertEquals(response.get(0).getIteration().intValue(), camgenPlanList.get(0).getTotalIteration().intValue());
	}

	@Test
	public void testmapUpdatePlan() {

		setDemandSupplyMap();
		CamgenPlan response = camgenPlanMapper.mapUpdatePlan(camgenPlan, plansObject);
		assertNotNull(response);
		assertEquals(response.getChannelSetId(), camgenPlan.getChannelSetId());
		assertEquals(response.getPlanId(), camgenPlan.getPlanId());
		assertEquals(response.getStatus(), camgenPlan.getStatus());
	}

	@Test
	public void testmapCreatePlan() {
		setDemandSupplyMap();
		CamgenPlan response = camgenPlanMapper.mapCreatePlan(plansObject);
		assertNotNull(response);
		assertEquals(response.getChannelSetId(), camgenPlan.getChannelSetId());
		assertEquals(response.getStatus(), camgenPlan.getStatus());

	}

	private void setDemandSupplyMap() {
		Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelvalue = new HashMap<>();
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1L);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("demandSupplyLevelName1");
		camgenDemandSupplyLevelvalue.put(1L, camgenDemandSupplyLevel);
		when(camgenRepository.getAllCamgenDemandSupplyLevelMap()).thenReturn(camgenDemandSupplyLevelvalue);

		Map<Long, CamgenDemandSupplyAttribute> camgenDemandMap = new HashMap<>();
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode");
		camgenDemandMap.put(1L, camgenDemandSupplyAttribute);
		when(camgenRepository.getAllCamgenDemandSupplyAttributeMap()).thenReturn(camgenDemandMap);

		Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = new HashMap<>();
		CamgenDemandSupplyCondition camgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		camgenDemandSupplyCondition.setDemandSupplyConditionCode("demandSupplyConditionCode");
		camgenDemandSupplyConditionMap.put(1L, camgenDemandSupplyCondition);
		when(camgenRepository.getAllCamgenDemandSupplyConditionMap()).thenReturn(camgenDemandSupplyConditionMap);

		Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = new HashMap<>();
		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyObject.setDemandSupplyObjectCode("demandSupplyObjectCode");
		camgenDemandSupplyObjectMap.put(1L, camgenDemandSupplyObject);
		when(camgenRepository.getAllCamgenDemandSupplyObjectMap()).thenReturn(camgenDemandSupplyObjectMap);
	}

}
