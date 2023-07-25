package com.channel4.mint.automated.spot.service.impl;

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

import com.channel4.mint.automated.spot.application.util.CamgenPlanMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.PlanRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroupInner;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class PlanServiceImplTest {

	@InjectMocks
	private PlanServiceImpl planServiceImpl;

	@Mock
	private PlanRepository planRepository;

	@Mock
	CamgenPlanMapper camgenPlanMapper;

	private CamgenPlan camgenPlanValue;
	private TestUtil test = new TestUtil();
	private CamgenRequest camgenRequest;
	private List<DemandSupplyGroup> listDemandSupplyGroup;
	private List<ExclusionDemandSupplyGroup> listExclusionDemandSupplyGroup;
	private List<PlanSummaryWithPagination> listPlanSummaryWithPagination;
	private List<DemandSupplyGroupInner> demandSupplyGroupInner = new ArrayList<>();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		camgenPlanValue = test.getCamgenPlanValue();
		camgenRequest = test.getCamgenRequest();
		listDemandSupplyGroup = test.getListDemandSupplyGroup();
		listExclusionDemandSupplyGroup = test.getListExclusionDemandSupplyGroup();
		listPlanSummaryWithPagination =test.getListPlanSummaryWithPagination();
	}

	@Test
	public void testCreatePlans() {
		CamgenPlan body = new CamgenPlan();
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenPlan.setCreatedBy("user1");
		camgenPlan.setChannelSetId(BigDecimal.ONE);
		camgenPlan.setPlanId(1L);
		when(camgenPlanMapper.mapCreatePlan(Mockito.any(PlansObject.class))).thenReturn(camgenPlan);
		Mockito.doNothing().when(planRepository).savePlans(body);
		assertNotNull(camgenPlan);

	}

	@Test
	public void testGetPlan() {
		when(planRepository.getPlan(Mockito.any(LocalDate.class), Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyString())).thenReturn(getPlansObjectList());
		List<PlansObject> response = planServiceImpl.getPlan(Mockito.any(LocalDate.class),
				Mockito.anyString(), Mockito.anyInt(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyString());
		assertNotNull(response);
		assertEquals(response.get(0).getChannelSetId(), getPlansObjectList().get(0).getChannelSetId());
		assertEquals(response.get(0).getIterationCount(), getPlansObjectList().get(0).getIterationCount());
		assertEquals(response.get(0).getPlanId(), getPlansObjectList().get(0).getPlanId());
	}

	private List<PlansObject> getPlansObjectList() {
		List<PlansObject> plansObjectList = new ArrayList<>();
		PlansObject plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setIterationCount(1);
		plansObject.setPlanId(1);
		plansObjectList.add(plansObject);
		return plansObjectList;
	}

	@Test
	public void testGetPlans() {
		PlanSummaryWithPagination planSummaryWithPaginationObj = new PlanSummaryWithPagination();
		List<PlanSummary> planSummaryList = new ArrayList<>();
		PlanSummary planSummary = new PlanSummary();
		planSummary.setChannelSetId(1L);
		planSummary.setCreatedBy("abc");
		planSummary.setIteration(1);
		planSummary.setPlanId(1);
		planSummary.setPlanId(1);
		planSummary.setRun(true);
		planSummary.setRunEndDate(new LocalDate(2010 - 02 - 02));
		planSummary.setRunStartDate(new LocalDate(2010 - 02 - 02));
		planSummary.setSlot(true);
		planSummary.setStatus("success");
		planSummaryList.add(planSummary);
		planSummaryWithPaginationObj.setPlanSummary(planSummaryList);
		planSummaryWithPaginationObj.setTotalCount(planSummaryList.size());
		when(planRepository.getPlans(Mockito.anyInt(), Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(planSummaryWithPaginationObj);
		PlanSummaryWithPagination planSummaryWithPagination = planServiceImpl.getPlans(Mockito.anyInt(),
				Mockito.anyLong(), Mockito.anyString(), Mockito.anyString());

		assertEquals(planSummaryWithPagination.getTotalCount(), planSummaryWithPaginationObj.getTotalCount());

	}

	@Test
	public void testcreatePlans() {
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenPlan.setChannelSetId(BigDecimal.ONE);
		camgenPlan.setCreatedBy("user1");
		camgenPlan.setPlanId(1L);
		PlansObject plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setIterationCount(1);
		plansObject.setPlanId(1);
		when(camgenPlanMapper.mapCreatePlan(Mockito.any(PlansObject.class))).thenReturn(camgenPlan);
		planServiceImpl.createPlans(plansObject);
		assertNotNull(camgenPlan);
	}

	@Test
	public void testupdatePlans() {
		when(planRepository.getCamgenPlan(Mockito.anyInt())).thenReturn(camgenPlanValue);
		when(camgenPlanMapper.mapUpdatePlan(Mockito.any(CamgenPlan.class), Mockito.any(PlansObject.class)))
				.thenReturn(camgenPlanValue);
		planServiceImpl.updatePlans(getPlansObjectList().get(0));
	}

}
