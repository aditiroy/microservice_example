package com.channel4.mint.automated.spot.api;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.channel4.mint.automated.spot.interfaces.controller.impl.CamgenApiController;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroupInner;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummary;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;
import com.channel4.mint.automated.spot.service.BulkAmendService;
import com.channel4.mint.automated.spot.service.CamgenExclusionCategoryService;
import com.channel4.mint.automated.spot.service.CamgenParamAudGroupChannelsService;
import com.channel4.mint.automated.spot.service.CamgenParamEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParamRunEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParametersService;
import com.channel4.mint.automated.spot.service.ChannelSetTimebandsService;
import com.channel4.mint.automated.spot.service.DemandSupplyService;
import com.channel4.mint.automated.spot.service.ExtractParametersService;
import com.channel4.mint.automated.spot.service.GlobalParametersService;
import com.channel4.mint.automated.spot.service.ParamExtractsService;
import com.channel4.mint.automated.spot.service.ParamStationEITimeBandsService;
import com.channel4.mint.automated.spot.service.ParamStationTimeBandsService;
import com.channel4.mint.automated.spot.service.PlanService;
import com.channel4.mint.automated.spot.service.RunIterationService;
import com.channel4.mint.automated.spot.service.SnapshotParamBatchTxLevelsService;
import com.channel4.mint.automated.spot.service.SnapshotParamChannelSetTimebands;
import com.channel4.mint.automated.spot.service.SnapshotRunDetailsService;
import com.channel4.mint.automated.spot.service.StationEITimeBandsService;
import com.channel4.mint.automated.spot.service.StationTimeBandsService;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;
import com.channel4.mint.httpexception.MintHttpException;
import com.channel4.mint.restresponseerrorhandler.MintRestResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CamgenApiControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	CamgenApiController camgenApiController;

	@Mock
	private RunIterationService runIterationService;

	@Mock
	private ParamExtractsService paramExtractsService;

	@Mock
	private ExtractParametersService parametersService;

	@Mock
	private CamgenParametersService camgenParametersService;

	@Mock
	private StationTimeBandsService stationTimeBandsService;

	@Mock
	private CamgenParamEIBandsService camgenParmEIBandsService;

	@Mock
	private SnapshotRunDetailsService snapshotCamgenRunService;

	@Mock
	private StationEITimeBandsService stationEITimeBandsService;

	@Mock
	private CamgenParamRunEIBandsService camgenParamEIBandsService;

	@Mock
	private SnapshotRunDetailsService snapshotRunDetailsService;

	@Mock
	private ParamStationTimeBandsService paramStationTimeBandsService;

	@Mock
	private SnapshotParamChannelSetTimebands snapshotParamChannelSetTimebands;

	@Mock
	private ParamStationEITimeBandsService paramStationEITimeBandsService;

	@Mock
	private GlobalParametersService globalParametersService;

	@Mock
	private CamgenParamAudGroupChannelsService camgenParamAudGroupChannelsService;

	@Mock
	MintRestResponseErrorHandler mintRestHandler;

	@Mock
	private DemandSupplyService demandSupplyService;

	@Mock
	private ChannelSetTimebandsService channelSetTimebandsService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	private SnapshotParamBatchTxLevelsService snapshotParamBatchTxLevels;

	@Mock
	private PlanService planService;

	@Mock
	private CamgenExclusionCategoryService camgenExclusionCategoryService;
	
	@Mock
	private BulkAmendService bulkAmendService;

	private ChannelSetTimeBands channelSetTimeBands;

	private List<ExclusionDemandSupplyGroup> lstExclusionDemandSupplyGroup;
	private List<DemandSupplyGroup> listDemandSupplyGroup;

	private BatchTxLevels batchTxLevels;

	PlansObject plansObject;
	TestUtil testUtil = new TestUtil();
	List<DemandSupplyGroupInner> demandSupplyGroupList;
	List<PlansObject> plansObjectList;
	CamgenParameters camgenParameters;
	CamgenParamEIBands camgenParamEIBands;
	CamgenParamExtracts camgenParamExtracts;
	CamgenRunParameters camgenRunParameters;
	CamgenRunIterations camgenRunIterations;
	List<SnapshotSummary> snapshotSummaryList;
	CamgenRunParamEIBands camgenRunParamEIBands;
	CamgenRunParamExtracts camgenRunParamExtracts;
	CamgenSnapshotRunDetails camgenSnapshotRunDetails;
	CamgenParamAudGroupChannels camgenParamAudGroupChannels;
	CamgenParamStationTimeBands camgenParamStationTimeBands;
	CamgenParamStationEITimeBands camgenParamStationEITimeBands;
	CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels;
	CamgenRunParamStationTimeBands camgenRunParamStationTimeBands;
	CamgenRunParamStationEITimeBands camgenRunParamStationEITimeBands;
	CriteriaLineNormalised criteriaLineNormalised;
	List<CriteriaLineNormalised> criteriaLineNormalisedList = new ArrayList<>();
	SnapshotSummaryWithPagination snapshotSummaryWithPagination;

	List<ChannelSetTimeBandResponse> channelSetTimeBandResponseList = new ArrayList<>();
	ChannelSetTimeBandResponse channelSetTimeBandResponse;
	List<ChannelSetTimebandsBulkRequest> channelSetTimebandsBulkRequestList = new ArrayList<>();
	ChannelSetTimebandsBulkRequest channelSetTimebandsBulkRequest = new ChannelSetTimebandsBulkRequest();
	ExclusionCategories mockExclusionCategories;
	CamgenSnapshotRunDetail camgenSnapshotRunDetail;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(camgenApiController).build();

		demandSupplyGroupList = new ArrayList<>();
		demandSupplyGroupList = testUtil.getDemandSupplyGroupList();
		plansObjectList = new ArrayList<>();
		plansObjectList = testUtil.getPlansObjectList();
		criteriaLineNormalised = testUtil.getCriteriaLineNormalised();
		criteriaLineNormalisedList.add(criteriaLineNormalised);
		plansObject = new PlansObject();
		plansObject = testUtil.getPlansObject();

		camgenParameters = testUtil.getCamgenParameters();
		camgenParamEIBands = testUtil.getCamgenParamEIBands();
		camgenRunParameters = testUtil.getCamgenRunParameters();
		camgenRunIterations = testUtil.getCamgenRunIterations();
		camgenParamExtracts = testUtil.getCamgenParamExtracts();
		snapshotSummaryList = testUtil.getSnapshotSummaryList();
		camgenRunParamEIBands = testUtil.getCamgenRunParamEIBands();
		camgenRunParamExtracts = testUtil.getCamgenRunParamExtracts();
		camgenSnapshotRunDetails = testUtil.getCamgenSnapshotRunDetails();
		camgenParamAudGroupChannels = testUtil.getCamgenParamAudGroupChannels();
		camgenParamStationTimeBands = testUtil.getCamgenParamStationTimeBands();
		camgenParamStationEITimeBands = testUtil.getCamgenParamStationEITimeBands();
		camgenRunParamAudGroupChannels = testUtil.getCamgenRunParamAudGroupChannels();
		camgenRunParamStationTimeBands = testUtil.getCamgenRunParamStationTimeBands();
		camgenRunParamStationEITimeBands = testUtil.getCamgenRunParamStationEITimeBands();
		channelSetTimeBands = testUtil.getChannelSetTimeBands();
		batchTxLevels = testUtil.getBatchTxLevels();
		lstExclusionDemandSupplyGroup = testUtil.getListExclusionDemandSupplyGroup();
		listDemandSupplyGroup = testUtil.getListDemandSupplyGroup();
		snapshotSummaryWithPagination =	 testUtil.getSnapshotSummaryWithPagination();
		snapshotSummaryWithPagination = new SnapshotSummaryWithPagination();
		snapshotSummaryWithPagination.setSnapshotSummary(snapshotSummaryList);
		snapshotSummaryWithPagination.setTotalCount(1);

		channelSetTimeBandResponse = testUtil.getChannelSetTimeBandResponse();
		channelSetTimeBandResponseList.add(channelSetTimeBandResponse);

		channelSetTimebandsBulkRequest = testUtil.getChannelSetTimebandsBulkRequest();
		channelSetTimebandsBulkRequestList.add(channelSetTimebandsBulkRequest);

		mockExclusionCategories = testUtil.getExclusionCategories();
		camgenSnapshotRunDetail = testUtil.getCamgenSnapshotRunDetail();
	}

	@Test
	public void getCamgenRunParamAudGroupChannelsSuccessTest() throws Exception {
		when(snapshotCamgenRunService.getCamgenRunParamAudGroupChannels(1)).thenReturn(camgenRunParamAudGroupChannels);
		mockMvc.perform(get("/camgen/run/1/parameters/audienceGroupChannels", CamgenRunParamAudGroupChannels.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void getCamgenRunParamAudGroupChannelsExceptionTest() throws Exception {
		when(snapshotRunDetailsService.getCamgenRunParamAudGroupChannels(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamAudGroupChannels(1);

	}

	@Test
	public void createCamgenRunParamAudGroupChannelsSuccessTest() throws Exception {
		Mockito.doNothing().when(snapshotCamgenRunService).createCamgenRunParamAudGroupChannels(
				Mockito.any(CamgenRunParamAudGroupChannels.class), Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameters/audienceGroupChannels", Void.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenRunParamAudGroupChannels)))
				.andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParamAudGroupChannelsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(snapshotRunDetailsService).createCamgenRunParamAudGroupChannels(
						Mockito.any(CamgenRunParamAudGroupChannels.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParamAudGroupChannels(1, camgenRunParamAudGroupChannels);

	}

	private List<SnapshotDetail> getSnapshotDetailList() {
		List<SnapshotDetail> snapshotDetailList = new ArrayList<>();
		SnapshotDetail snapshotDetail = new SnapshotDetail();
		snapshotDetail.setChannelSet(1L);
		snapshotDetail.setCreatedBy("user1");
		snapshotDetail.setIterationCount(1);
		snapshotDetailList.add(snapshotDetail);
		return snapshotDetailList;

	}

	@Test
	public void getSnapshotExceptionTest() throws Exception {
		when(snapshotRunDetailsService.getSnapshot(Mockito.anyInt(),Mockito.any(LocalDate.class),Mockito.anyString(),Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getSnapshot(Mockito.anyInt(),Mockito.any(LocalDate.class),Mockito.anyString(),Mockito.anyString(), Mockito.anyString());

	}

	@Test
	public void createCamgenParamAudGroupChannelsSuccessTest() throws Exception {
		Mockito.doNothing().when(camgenParamAudGroupChannelsService)
				.createCamgenParamAudGroupChannels(Mockito.any(CamgenParamAudGroupChannels.class));
		mockMvc.perform(post("/camgen/parameter/audienceGroupChannels", Void.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamAudGroupChannels)))
				.andExpect(status().isOk());

	}

	@Test
	public void createCamgenParamAudGroupChannelsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParamAudGroupChannelsService)
				.createCamgenParamAudGroupChannels(Mockito.any(CamgenParamAudGroupChannels.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParamAudGroupChannels(camgenParamAudGroupChannels);

	}

	@Test
	public void getCamgenParamAudGroupChannelsSuccessTest() throws Exception {
		when(camgenParamAudGroupChannelsService.getCamgenParamAudGroupChannels())
				.thenReturn(camgenParamAudGroupChannels);
		mockMvc.perform(get("/camgen/parameter/audienceGroupChannels", CamgenParamAudGroupChannels.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1L)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].audienceGroupId").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].channelId").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].keyAudienceId").value(1));

	}

	@Test
	public void getCamgenParamAudGroupChannelsExceptionTest() throws Exception {
		when(camgenParamAudGroupChannelsService.getCamgenParamAudGroupChannels())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParameterAudienceGroupChannels();

	}

	@Test
	public void getCamgenRunParametersSuccessTest() throws Exception {
		when(parametersService.getCamgenRunParameters(1)).thenReturn(camgenRunParameters);
		mockMvc.perform(
				get("/camgen/run/1/parameters", CamgenRunParameters.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].parameter").value("abc"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].standardvalue").value("abc"))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].value").value("abc"));

	}

	@Test
	public void getCamgenRunParametersExceptionTest() throws Exception {
		when(parametersService.getCamgenRunParameters(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParameters(1);

	}

	@Test
	public void createCamgenRunParametersSuccessTest() throws Exception {
		Mockito.doNothing().when(parametersService).createCamgenRunParameters(Mockito.any(CamgenRunParameters.class),
				Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameters", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamAudGroupChannels))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParametersExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(parametersService)
				.createCamgenRunParameters(Mockito.any(CamgenRunParameters.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParameters(1, camgenRunParameters);

	}

	@Test
	public void getCamgenRunParamExtractsSuccessTest() throws Exception {

		when(paramExtractsService.getCamgenRunParamExtracts(1)).thenReturn(camgenRunParamExtracts);
		mockMvc.perform(get("/camgen/run/1/parameters/extracts", CamgenRunParamExtracts.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].parameter").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].value").value("abc")).andExpect(status().isOk());

	}

	@Test
	public void getCamgenRunParamExtractsExceptionTest() throws Exception {
		when(paramExtractsService.getCamgenRunParamExtracts(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamExtracts(1);

	}

	@Test
	public void createCamgenRunParamExtractsSuccessTest() throws Exception {
		Mockito.doNothing().when(paramExtractsService)
				.createCamgenRunParamExtracts(Mockito.any(CamgenRunParamExtracts.class), Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameters/extracts", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenRunParamExtracts))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParamExtractsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(paramExtractsService)
				.createCamgenRunParamExtracts(Mockito.any(CamgenRunParamExtracts.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParamExtracts(1, camgenRunParamExtracts);

	}

	@Test
	public void createCamgenRunParamStationEITimeBandsSuccessTest() throws Exception {
		Mockito.doNothing().when(paramStationEITimeBandsService).createCamgenRunParamStationEITimeBands(
				Mockito.any(CamgenRunParamStationEITimeBands.class), Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameter/stationEITimeBands", Void.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenRunParamStationEITimeBands)))
				.andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParamStationEITimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(paramStationEITimeBandsService).createCamgenRunParamStationEITimeBands(
						Mockito.any(CamgenRunParamStationEITimeBands.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParamStationEITimeBands(1, camgenRunParamStationEITimeBands);

	}

	@Test
	public void getCamgenRunParamStationEITimeBandsSuccessTest() throws Exception {

		when(paramStationEITimeBandsService.getCamgenRunParamStationEITimeBands(1))
				.thenReturn(camgenRunParamStationEITimeBands);
		mockMvc.perform(get("/camgen/run/1/parameter/stationEITimeBands", CamgenRunParamStationEITimeBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].dayCode").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].startTime").value("9AM")).andExpect(status().isOk());

	}

	@Test
	public void getCamgenRunParamStationEITimeBandsExceptionTest() throws Exception {
		when(paramStationEITimeBandsService.getCamgenRunParamStationEITimeBands(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamStationEITimeBands(1);

	}

	@Test
	public void getCamgenRunParamStationTimeBandsSuccessTest() throws Exception {

		when(paramStationTimeBandsService.getCamgenRunParamStationEITimeBands(Mockito.anyInt()))
				.thenReturn(camgenRunParamStationTimeBands);
		mockMvc.perform(get("/camgen/run/1/parameter/stationTimeBands", CamgenRunParamStationTimeBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].dayCode").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].channelId").value(1)).andExpect(status().isOk());

	}

	@Test
	public void getCamgenRunParamStationTimeBandsExceptionTest() throws Exception {
		when(paramStationTimeBandsService.getCamgenRunParamStationEITimeBands(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamStationTimeBands(1);

	}

	@Test
	public void createCamgenRunParamStationTimeBandsSuccessTest() throws Exception {
		Mockito.doNothing().when(paramStationTimeBandsService).createCamgenRunParamStationTimeBands(
				Mockito.any(CamgenRunParamStationTimeBands.class), Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameter/stationTimeBands", Void.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenRunParamStationTimeBands)))
				.andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParamStationTimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(paramStationTimeBandsService).createCamgenRunParamStationTimeBands(
						Mockito.any(CamgenRunParamStationTimeBands.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParamStationTimeBands(1, camgenRunParamStationTimeBands);

	}

	@Test
	public void createCamgenRunParamEIBandsSuccessTest() throws Exception {
		Mockito.doNothing().when(camgenParamEIBandsService)
				.createCamgenRunParamEIBands(Mockito.any(CamgenRunParamEIBands.class), Mockito.anyInt());
		mockMvc.perform(post("/camgen/run/1/parameters/eIBands", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenRunParamEIBands))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenRunParamEIBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParamEIBandsService)
				.createCamgenRunParamEIBands(Mockito.any(CamgenRunParamEIBands.class), Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunParamEIBands(1, camgenRunParamEIBands);

	}

	@Test
	public void getCamgenRunParamEIBandsSuccessTest() throws Exception {

		when(camgenParamEIBandsService.getCamgenRunParamEIBands(1)).thenReturn(camgenRunParamEIBands);
		mockMvc.perform(get("/camgen/run/1/parameters/eIBands", CamgenRunParamEIBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].eiBand").value(1)).andExpect(status().isOk());

	}

	@Test
	public void getCamgenRunParamEIBandsExceptionTest() throws Exception {
		when(camgenParamEIBandsService.getCamgenRunParamEIBands(1))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamEIBands(1);

	}

	@Test
	public void createCamgenParamExtractsSuccessTest() throws Exception {
		Mockito.doNothing().when(parametersService).createCamgenParamExtracts(Mockito.any(CamgenParamExtracts.class));
		mockMvc.perform(post("/camgen/parameter/extracts", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamExtracts))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenParamExtractsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(parametersService).createCamgenParamExtracts(Mockito.any(CamgenParamExtracts.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParamExtracts(camgenParamExtracts);

	}

	@Test
	public void createCamgenParamStationEITimeBandsSuccessTest() throws Exception {
		Mockito.doNothing().when(stationEITimeBandsService)
				.createCamgenParamStationEITimeBands(Mockito.any(CamgenParamStationEITimeBands.class));
		mockMvc.perform(post("/camgen/paramStationEITimeBands", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamStationEITimeBands))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenParamStationEITimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(stationEITimeBandsService)
				.createCamgenParamStationEITimeBands(Mockito.any(CamgenParamStationEITimeBands.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParamStationEITimeBands(camgenParamStationEITimeBands);

	}

	@Test
	public void createCamgenParamStationTimeBandsSuccessTest() throws Exception {
		Mockito.doNothing().when(stationTimeBandsService)
				.createCamgenParamStationTimeBands(Mockito.any(CamgenParamStationTimeBands.class));
		mockMvc.perform(post("/camgen/parameter/stationTimeBands", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamStationTimeBands))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenParamStationTimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(stationTimeBandsService)
				.createCamgenParamStationTimeBands(Mockito.any(CamgenParamStationTimeBands.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParamStationTimeBands(camgenParamStationTimeBands);

	}

	@Test
	public void createCamgenParametersSuccessTest() throws Exception {
		Mockito.doNothing().when(camgenParametersService).createCamgenParameters(Mockito.any(CamgenParameters.class));
		mockMvc.perform(post("/camgen/parameters", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParameters))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenParametersExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParametersService).createCamgenParameters(Mockito.any(CamgenParameters.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParameters(camgenParameters);

	}

	@Test
	public void createCamgenParameters_SuccessTest() throws Exception {
		Mockito.doNothing().when(camgenParmEIBandsService)
				.createCamgenParameters(Mockito.any(CamgenParamEIBands.class));
		mockMvc.perform(post("/camgen/parameter/EIBands", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamEIBands))).andExpect(status().isOk());

	}

	@Test
	public void createCamgenParameters_ExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParmEIBandsService).createCamgenParameters(Mockito.any(CamgenParamEIBands.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParametersEIBands(camgenParamEIBands);

	}

	@Test
	public void createCamgenRunIterationsSuccessTest() throws Exception {
		Mockito.doNothing().when(runIterationService).createCamgenRunIterations(Mockito.any(CamgenRunIterations.class));
		mockMvc.perform(post("/camgen/run/solutions", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenRunIterations))).andExpect(status().isOk());

	}

	@Test
	public void ccreateCamgenRunIterationsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(runIterationService).createCamgenRunIterations(Mockito.any(CamgenRunIterations.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenRunIterations(camgenRunIterations);

	}

	@Test
	public void createCamgenSnapshotRunDetailsSuccessTest() throws Exception {
		NewEntityCreated newEntityCreated =new  NewEntityCreated();
		newEntityCreated.setId("1");
	when(snapshotRunDetailsService.createCamgenSnapshotRunDetails(Mockito.any())).thenReturn(newEntityCreated);
		mockMvc.perform(post("/camgen/snapshot/runs", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenSnapshotRunDetail))).andExpect(status().isOk());
	}

	@Test
	public void createCamgenSnapshotRunDetailsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(snapshotRunDetailsService)
				.createCamgenSnapshotRunDetails(Mockito.any(CamgenSnapshotRunDetail.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenSnapshotRunDetails(camgenSnapshotRunDetail);
	}
	

	@Test
	public void getCamgenParamEIBandsSuccessTest() throws Exception {

		when(camgenParmEIBandsService.getCamgenParamEIBands()).thenReturn(camgenParamEIBands);
		mockMvc.perform(
				get("/camgen/parameter/EIBands", CamgenParamEIBands.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].eiBand").value(1L))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].createdBy").value("abc"));
	}

	@Test
	public void getCamgenParamEIBandsExceptionTest() throws Exception {

		when(camgenParmEIBandsService.getCamgenParamEIBands())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParamEIBands();

	}

	@Test
	public void getCamgenParamExtractsSuccessTest() throws Exception {

		when(parametersService.getCamgenParamExtracts()).thenReturn(camgenParamExtracts);
		mockMvc.perform(
				get("/camgen/parameter/extracts", CamgenParamExtracts.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].parameter").value("abc"))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].value").value("abc"));
	}

	@Test
	public void getCamgenParamExtractsExceptionTest() throws Exception {

		when(parametersService.getCamgenParamExtracts())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParameterExtracts();

	}

	@Test
	public void getCamgenParamStationEITimeBandsSuccessTest() throws Exception {

		when(stationEITimeBandsService.getCamgenParamStationEITimeBands()).thenReturn(camgenParamStationEITimeBands);
		mockMvc.perform(get("/camgen/paramStationEITimeBands", CamgenParamStationEITimeBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].dayCode").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].createdBy").value("abc"));
	}

	@Test
	public void getCamgenParamStationEITimeBandsExceptionTest() throws Exception {

		when(stationEITimeBandsService.getCamgenParamStationEITimeBands())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParamStationEITimeBands();

	}

	@Test
	public void getCamgenParamStationTimeBandsSuccessTest() throws Exception {

		when(stationTimeBandsService.getCamgenParamStationTimeBands()).thenReturn(camgenParamStationTimeBands);
		mockMvc.perform(get("/camgen/parameter/stationTimeBands", CamgenParamStationTimeBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1L)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].channelId").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("abc"));
	}

	@Test
	public void getCamgenParamStationTimeBandsExceptionTest() throws Exception {

		when(stationTimeBandsService.getCamgenParamStationTimeBands())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParamStationTimeBands();

	}

	@Test
	public void getCamgenParametersSuccessTest() throws Exception {

		when(camgenParametersService.getCamgenParameters()).thenReturn(camgenParameters);
		mockMvc.perform(get("/camgen/parameters", CamgenParameters.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1L))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].parameter").value("abc"))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].value").value("abc"));
	}

	@Test
	public void getCamgenParametersExceptionTest() throws Exception {

		when(camgenParametersService.getCamgenParameters())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParameters();

	}

	@Test
	public void getCamgenRunIterationsSuccessTest() throws Exception {

		when(runIterationService.getCamgenRunIterations(Mockito.anyInt())).thenReturn(camgenRunIterations);
		mockMvc.perform(
				get("/camgen/run/1/solutions", CamgenRunIterations.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].runId").value(1L))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].solutionFileName").value("abc"))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].snapShotId").value(1));
	}

	@Test
	public void getCamgenRunIterationsExceptionTest() throws Exception {

		when(runIterationService.getCamgenRunIterations(Mockito.anyInt()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunIterations(1);

	}

	@Test
	public void getCamgenSnapshotRunDetailsSuccessTest() throws Exception {
		List CamgenSnapshotRunDetailList = new ArrayList<>();
		CamgenSnapshotRunDetailList.add(camgenSnapshotRunDetail);
		when(snapshotRunDetailsService.getCamgenSnapshotRunDetails(Mockito.anyInt(),Mockito.any(),Mockito.any(),Mockito.any()))
				.thenReturn(CamgenSnapshotRunDetailList);
		mockMvc.perform(
				get("/camgen/snapshot/runs?runId=2", CamgenSnapshotRunDetail.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].runId").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].snapshotId").value(1L))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].iterationCount").value(10));
	}

	@Test
	public void getCamgenSnapshotRunDetailsExceptionTest() throws Exception {

		when(snapshotRunDetailsService.getCamgenSnapshotRunDetails(Mockito.anyInt(),Mockito.any(), Mockito.any(),Mockito.any()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenSnapshotRunDetails(1,new DateTime(),"requestStatus","runStatus");

	}

	CamgenGlobalParametersRequest camgenGlobalParametersRequest;

	@Test
	public void updateGlobalParametersSuccessTest() throws Exception {
		Mockito.doNothing().when(globalParametersService)
				.updateGlobalParameters(Mockito.any(CamgenGlobalParametersRequest.class));
		camgenApiController.updateGlobalParameters(camgenGlobalParametersRequest);
	}

	@Test
	public void updateGlobalParametersExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(globalParametersService).updateGlobalParameters(Mockito.any(CamgenGlobalParametersRequest.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateGlobalParameters(camgenGlobalParametersRequest);

	}

	@Test
	public void getCamgenSnapshotRunsSuccessTest() throws Exception {

		when(snapshotRunDetailsService.getCamgenSnapshotRunDetailsBySnapshotId(Mockito.anyInt()))
				.thenReturn(camgenSnapshotRunDetails);
		mockMvc.perform(
				get("/camgen/snapshot/1/runs", CamgenSnapshotRunDetails.class).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].runId").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].snapshotId").value(1L))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[0].iterationCount").value(1));
	}

	@Test
	public void getCamgenSnapshotRunsExceptionTest() throws Exception {

		when(snapshotRunDetailsService.getCamgenSnapshotRunDetailsBySnapshotId(Mockito.anyInt()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenSnapshotRuns(1);

	}

	@Test
	public void updateCamgenParamExtractsTest() throws Exception {
		Mockito.doNothing().when(parametersService).createCamgenParamExtracts(Mockito.any(CamgenParamExtracts.class));
		mockMvc.perform(put("/camgen/parameter/extracts", CamgenParamExtracts.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamExtracts)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCamgenParamExtractsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(parametersService).createCamgenParamExtracts(Mockito.any(CamgenParamExtracts.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenParamExtracts(camgenParamExtracts);

	}

	@Test
	public void updateCamgenParamStationEITimeBandsTest() throws Exception {
		Mockito.doNothing().when(stationEITimeBandsService)
				.createCamgenParamStationEITimeBands((Mockito.any(CamgenParamStationEITimeBands.class)));
		mockMvc.perform(put("/camgen/paramStationEITimeBands", CamgenParamStationEITimeBands.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamStationEITimeBands)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCamgenParamStationEITimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(stationEITimeBandsService)
				.createCamgenParamStationEITimeBands((Mockito.any(CamgenParamStationEITimeBands.class)));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenParamStationEITimeBands(camgenParamStationEITimeBands);

	}

	@Test
	public void updateCamgenParamStationTimeBandsTest() throws Exception {
		Mockito.doNothing().when(stationTimeBandsService)
				.createCamgenParamStationTimeBands((Mockito.any(CamgenParamStationTimeBands.class)));
		mockMvc.perform(put("/camgen/parameter/stationTimeBands", CamgenParamStationTimeBands.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamStationTimeBands)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCamgenParamStationTimeBandsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(stationTimeBandsService)
				.createCamgenParamStationTimeBands((Mockito.any(CamgenParamStationTimeBands.class)));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenParamStationTimeBands(camgenParamStationTimeBands);

	}

	@Test
	public void updateCamgenParameterAudGroupChannelsTest() throws Exception {
		Mockito.doNothing().when(camgenParamAudGroupChannelsService)
				.createCamgenParamAudGroupChannels((Mockito.any(CamgenParamAudGroupChannels.class)));
		mockMvc.perform(put("/camgen/parameter/audienceGroupChannels", CamgenParamAudGroupChannels.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamStationTimeBands)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateCamgenParameterAudGroupChannelsExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParamAudGroupChannelsService)
				.createCamgenParamAudGroupChannels((Mockito.any(CamgenParamAudGroupChannels.class)));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenParameterAudGroupChannels(camgenParamAudGroupChannels);

	}

	@Test
	public void updateCamgenParametersTest() throws Exception {
		Mockito.doNothing().when(camgenParametersService).createCamgenParameters((Mockito.any(CamgenParameters.class)));
		mockMvc.perform(put("/camgen/parameters", CamgenParameters.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenParamStationTimeBands))).andExpect(status().isOk());
	}

	@Test
	public void updateCamgenParametersExceptionTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParametersService).createCamgenParameters((Mockito.any(CamgenParameters.class)));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenParameters(camgenParameters);

	}

	@Test
	public void createCamgenParametersTest() throws Exception {
		Mockito.doNothing().when(camgenParmEIBandsService)
				.createCamgenParameters((Mockito.any(CamgenParamEIBands.class)));
		mockMvc.perform(put("/camgen/parameter/EIBands", CamgenParamEIBands.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(camgenParamStationTimeBands)))
				.andExpect(status().isOk());
	}

	@Test
	public void createCamgenParametersExceptionsTest() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(camgenParmEIBandsService).createCamgenParameters((Mockito.any(CamgenParamEIBands.class)));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParameters(camgenParamEIBands);

	}

	@Test
	public void getCamgenRunParamChannelSetTimebandsTest_success() throws Exception {

		when(snapshotParamChannelSetTimebands.getCamgenRunParamChannelSetTimebands(Mockito.anyInt()))
				.thenReturn(channelSetTimeBands);
		mockMvc.perform(get("/camgen/snapshot/parameters/channelSetTimebands?snapshotId=1", ChannelSetTimeBands.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].availability").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].day").value("day")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].endTime").value("endTime")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1)).andExpect(status().isOk());
	}

	@Test
	public void getCamgenRunParamBatchTxLevelsTest_success() throws Exception {
		when(snapshotParamBatchTxLevels.getCamgenRunParamBatchTxLevels(1)).thenReturn(batchTxLevels);
		mockMvc.perform(get("/camgen/snapshot/parameters/batchTxLevels?snapshotId=1", BatchTxLevels.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].batchTxLevelValue").value(1));
	}

	@Test
	public void getCamgenRunParamBatchTxLevelsTest_failure() throws Exception {
		when(snapshotParamBatchTxLevels.getCamgenRunParamBatchTxLevels(Mockito.anyInt()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamBatchTxLevels(1);
	}

	@Test
	public void getCamgenRunParamChannelSetTimebandsTest_failure() throws Exception {
		when(snapshotParamChannelSetTimebands.getCamgenRunParamChannelSetTimebands(Mockito.anyInt()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenRunParamChannelSetTimebands(1);
	}

	@Test
	public void getAllSnapshotsSuccessTest() throws Exception {

		when(snapshotRunDetailsService.getAllSnapshots(Mockito.anyInt(), Mockito.anyLong(), Mockito.anyString(),
				Mockito.anyString())).thenReturn(snapshotSummaryWithPagination);

		ResponseEntity<SnapshotSummaryWithPagination> response = camgenApiController.getSnapshotsList(1, 1L, "", "");
		assertNotNull(response);
		assertEquals(response.getBody().getTotalCount(), snapshotSummaryWithPagination.getTotalCount());
		assertEquals(response.getBody().getSnapshotSummary().get(0).getChannelSetId(),
				snapshotSummaryWithPagination.getSnapshotSummary().get(0).getChannelSetId());

	}

	@Test
	public void getAllSnapshotsTest_failure() throws Exception {
		when(snapshotRunDetailsService.getAllSnapshots(Mockito.anyInt(), Mockito.anyLong(), Mockito.anyString(),
				Mockito.anyString())).thenThrow(
						new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));

		camgenApiController.getSnapshotsList(1, 1L, "abc", "abc");

	}

	@Test
	public void createPlansTest_success() throws Exception {
		Mockito.doNothing().when(planService).createPlans(Mockito.any(PlansObject.class));
		camgenApiController.createPlans(plansObject);
	}

	@Test
	public void createPlansTest_failure() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(planService).createPlans(Mockito.any(PlansObject.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createPlans(plansObject);
	}

	@Test
	public void deleteSnapshotSuccessTest() throws Exception {
		Mockito.doNothing().when(snapshotRunDetailsService).deleteSnapshot(Mockito.anyInt());
		camgenApiController.deleteSnapshot(1);
	}

	@Test
	public void deleteSnapshotTest_failure() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(snapshotRunDetailsService).deleteSnapshot(Mockito.anyInt());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.deleteSnapshot(1);
	}

	@Test
	public void getPlanTest_failure() throws Exception {
		when(planService.getPlan(Mockito.any(LocalDate.class), Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyString())).thenThrow(
						new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getPlans(Mockito.any(LocalDate.class), Mockito.anyString(),
				Mockito.anyInt(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyString());
	}

	@Test
	public void updatePlansTest_success() throws Exception {
		Mockito.doNothing().when(planService).updatePlans(Mockito.any(PlansObject.class));
		camgenApiController.updatePlans(plansObject);
	}

	@Test
	public void updatePlansTest_failure() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(planService).updatePlans(Mockito.any(PlansObject.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updatePlans(plansObject);
	}

	@Test
	public void updateCamgenSnapshotRunDetailsTest_success() throws Exception {
		Mockito.doNothing().when(snapshotRunDetailsService)
				.updateCamgenSnapshotRunDetails(Mockito.any(CamgenSnapshotRunDetails.class));
		mockMvc.perform(put("/camgen/snapshot/runs", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(camgenSnapshotRunDetails))).andExpect(status().isOk());
	}
	
	@Test
	public void updateCamgenSnapshotRunDetailsTest_failure() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(snapshotRunDetailsService)
				.updateCamgenSnapshotRunDetails(Mockito.any(CamgenSnapshotRunDetails.class));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.updateCamgenSnapshotRunDetails(camgenSnapshotRunDetails);
	}

	@Test
	public void getCamgenParamChannelSetTimebandsSuccessTest() throws Exception {
		when(channelSetTimebandsService.getCamgenParamChannelSetTimebands(Mockito.anyInt()))
				.thenReturn(channelSetTimeBandResponseList);
		mockMvc.perform(get("/camgen/parameters/channelSet/1/timebands", ChannelSetTimeBandResponse.class)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].timeBandId").value(1L)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].day").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("abc")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].availability").value(new BigDecimal(1)));
	}

	@Test
	public void getCamgenParamChannelSetTimebandsTest_failure() throws Exception {
		when(channelSetTimebandsService.getCamgenParamChannelSetTimebands(Mockito.anyInt()))
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenParamChannelSetTimebands(1);
	}

	@Test
	public void createCamgenParamChannelSetTimebandsTest_success() throws Exception {
		Mockito.doNothing().when(channelSetTimebandsService).createCamgenParamChannelSetTimebands(Mockito.anyList());
		mockMvc.perform(post("/camgen/parameters/timebands/bulkamend", Void.class)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(channelSetTimebandsBulkRequestList)))
				.andExpect(status().isOk());
	}

	@Test
	public void createCamgenParamChannelSetTimebandsTest_failure() throws Exception {
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(channelSetTimebandsService).createCamgenParamChannelSetTimebands(Mockito.anyList());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.createCamgenParamChannelSetTimebands(channelSetTimebandsBulkRequestList);
	}

	@Test
	public void getCamgenPlanExclusionCategoriesSuccessTest() throws Exception {
		when(camgenExclusionCategoryService.getCamgenExclusionCategoryService()).thenReturn(mockExclusionCategories);
		ResponseEntity<ExclusionCategories> response = camgenApiController.getCamgenPlanExclusionCategiries();
		assertEquals(response.getBody().get(0).getCategoryId(), mockExclusionCategories.get(0).getCategoryId());
		assertEquals(response.getBody().get(0).getCategoryName(), mockExclusionCategories.get(0).getCategoryName());
	}

	@Test
	public void getCamgenPlanExclusionCategoriesTest_failure() throws Exception {
		when(camgenExclusionCategoryService.getCamgenExclusionCategoryService())
				.thenThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.getCamgenPlanExclusionCategiries();
	}
	
	@Test
	public void bulkCancelCamgenRequestsTest() throws Exception{
		List<Field> fieldList = new ArrayList<>();
		Field field = new Field();
		field.setId(1L);
		fieldList.add(field);
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		
		when(bulkAmendService.updateCancelStatus(Mockito.any())).thenReturn(fieldList);
		mockMvc.perform(post("/camgen/snapshots/bulkCancel", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(snapshotsList))).andExpect(status().isOk());
	}
	
	@Test
	public void bulkCancelCamgenRequestsTest_failure() throws Exception {
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(bulkAmendService).updateCancelStatus(Mockito.any());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.bulkCancelCamgenRequests(snapshotsList);
	}

	@Test
	public void bulkReInstateCamgenRequestsTest() throws Exception{
		List<Field> fieldList = new ArrayList<>();
		Field field = new Field();
		field.setId(1L);
		fieldList.add(field);
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		
		when(bulkAmendService.updateQueueStatus(Mockito.any())).thenReturn(fieldList);
		mockMvc.perform(post("/camgen/snapshots/bulkReInstate", Void.class).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(snapshotsList))).andExpect(status().isOk());
	}
	
	@Test
	public void bulkReInstateCamgenRequestsTest_failure() throws Exception {
		List<Snapshots> snapshotsList = new ArrayList<>();
		Snapshots snapshots = new Snapshots();
		snapshots.setCamgenRequestId(1L);
		snapshotsList.add(snapshots);
		Mockito.doThrow(new MintBaseException("Mint Base Exception", HttpStatus.INTERNAL_SERVER_ERROR.value()))
				.when(bulkAmendService).updateQueueStatus(Mockito.any());
		thrown.expect(MintHttpException.class);
		thrown.expectMessage(startsWith("Mint Base Exception"));
		thrown.expect(hasProperty("code", is(500)));
		camgenApiController.bulkReInstateCamgenRequests(snapshotsList);
	}
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper objMaper = new ObjectMapper();
			return objMaper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
