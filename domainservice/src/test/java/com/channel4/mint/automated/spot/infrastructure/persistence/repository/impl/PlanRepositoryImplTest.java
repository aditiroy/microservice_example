package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
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

import com.channel4.mint.automated.spot.application.util.CamgenPlanMapper;
import com.channel4.mint.automated.spot.application.util.PlanSummaryUtil;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class PlanRepositoryImplTest {

	@InjectMocks
	private PlanRepositoryImpl planRepositoryImpl;
	@Mock
	private CamgenPlanJpaRepository camgenPlanJpaRepository;
	

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Mock
	private CamgenPlanMapper camgenPlanMapper;

	@Mock
	private PlanSummaryUtil planSummaryUtil;

	private TestUtil testUtil = new TestUtil();
	private CamgenPlan camgenPlanValue;
	private List<ExclusionDemandSupplyGroup> listExclusionDemandSupplyGroup;
	private List<DemandSupplyGroup> lstDemandSupplyGroupList;

	private CamgenPlan camgenPlan;
	List<CamgenPlan> camgenPlanList = new ArrayList<>();
	PlanSummary planSummary = new PlanSummary();
	List<PlanSummary> planSummaryList = new ArrayList<>();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		camgenPlanValue = testUtil.getCamgenPlanValue();
		listExclusionDemandSupplyGroup = testUtil.getListExclusionDemandSupplyGroup();
		lstDemandSupplyGroupList = testUtil.getListDemandSupplyGroup();

		camgenPlan = testUtil.getCamgenPlan();
		camgenPlanList.add(camgenPlan);

		planSummary = testUtil.getPlanSummary();
		planSummaryList.add(planSummary);
	}

	

	@Test
	public void getPlanSuccessTest() throws Exception {
		List<CamgenPlan> camgenPlanList = new ArrayList<>();
		camgenPlanList.add(camgenPlan);
		when(camgenPlanJpaRepository.findAll(Mockito.any(org.springframework.data.jpa.domain.Specification.class)))
				.thenReturn(camgenPlanList);
		List<PlansObject> plansObjects = new ArrayList<>();
		PlansObject plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setCreatedBy("user1");
		plansObject.setIterationCount(1);
		plansObject.setPlanId(1);
		plansObjects.add(plansObject);
		when(camgenPlanMapper.getPlansObject(Mockito.anyList(), Mockito.anyBoolean(), Mockito.anyBoolean()))
				.thenReturn(plansObjects);
		List<PlansObject> response = planRepositoryImpl.getPlan(new LocalDate(), "2", 28, true, true, null);
		assertNotNull(response);
		assertEquals(response.get(0).getChannelSetId(), plansObjects.get(0).getChannelSetId());
		assertEquals(response.get(0).getCreatedBy(), plansObjects.get(0).getCreatedBy());
		assertEquals(response.get(0).getIterationCount(), plansObjects.get(0).getIterationCount());
		assertEquals(response.get(0).getPlanId(), plansObjects.get(0).getPlanId());

	}

	@Test
	public void getPlanExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenPlanJpaRepository.findAll(Mockito.any(org.springframework.data.jpa.domain.Specification.class)))
				.thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			planRepositoryImpl.getPlan(new LocalDate(), "", 34, true, true, null);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void getPlanNullException() {
		when(camgenPlanJpaRepository.findAll(Mockito.any(org.springframework.data.jpa.domain.Specification.class)))
				.thenReturn(null);
		int exc = 0;
		try {
			planRepositoryImpl.getPlan(new LocalDate(), "", 34, true, true, null);
		} catch (MintBaseException e) {
			exc = e.getCode();
		}
		assertEquals(exc, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getPlansSuccessTest() throws Exception {
		Page<CamgenPlan> camgenPlanPage = new PageImpl<>(camgenPlanList);
		when(camgenPlanJpaRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(camgenPlanPage);
		when(camgenPlanMapper.mapEntityListToCamgenPlan(Mockito.anyList())).thenReturn(planSummaryList);
		when(planSummaryUtil.getSortByField(Mockito.anyString())).thenReturn("planid");

		planRepositoryImpl.getPlans(1, 1L, "abc", "abc");
	}

	@Test
	public void testGetCamgenRequest() throws Exception {
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(BigDecimal.ONE);
		camgenRequest.setCreatedBy("user1");
		camgenRequest.setRequestId(1l);
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenRequest);
		CamgenRequest response = planRepositoryImpl.getCamgenRequest(1);
		assertNotNull(response);
		assertEquals(response.getChannelSetId(), camgenRequest.getChannelSetId());
		assertEquals(response.getCreatedBy(), camgenRequest.getCreatedBy());
		assertEquals(response.getRequestId(), camgenRequest.getRequestId());
	}

	@Test
	public void testGetCamgenRequest_Fail() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			planRepositoryImpl.getCamgenRequest(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void testGetCamgenRequest_FailDataNotFound_Fail() throws Exception {
		when(camgenRequestJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			planRepositoryImpl.getCamgenRequest(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

	@Test
	public void testGetCamgenPlan() throws Exception {
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenPlan.setPlanId(1l);
		camgenPlan.setChannelSetId(BigDecimal.ONE);
		camgenPlan.setCreatedBy("user1");
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenPlan);
		CamgenPlan response = planRepositoryImpl.getCamgenPlan(1);
		assertNotNull(response);
		assertEquals(response.getPlanId(), camgenPlan.getPlanId());
		assertEquals(response.getChannelSetId(), camgenPlan.getChannelSetId());
		assertEquals(response.getCreatedBy(), camgenPlan.getCreatedBy());
	}

	@Test
	public void testGetCamgenPlan_Fail() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			planRepositoryImpl.getCamgenPlan(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}

	@Test
	public void testGetCamgenPlan_FailDataNotFound_Fail() throws Exception {
		when(camgenPlanJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		int exceptionCode = 0;
		try {
			planRepositoryImpl.getCamgenPlan(1);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}

}
