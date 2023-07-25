package com.channel4.mint.automated.spot.test.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenAudienceGroupChannel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenChannelSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenEiBand;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExclusionCategory;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanAutofillingDay;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanExclusion;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationEiTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenStationTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanDemandSupplyCriteria;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RqstDemandSupplyCriteria;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunAudienceGroupChannel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunEiBand;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunExtractParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationEiTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationTimeband;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
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
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestCreated;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestDeleted;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestModified;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequestTimebands;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroupInner;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategory;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.Exclusions;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummary;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;

public class TestUtil {

	public List<SnapshotSummary> getSnapshotSummaryList() {
		List<SnapshotSummary> SnapshotSummaryList = new ArrayList<>();

		SnapshotSummaryList.add(getSnapshotSummary());
		return SnapshotSummaryList;
	}

	public CamgenPlan getCamgenPlanValue() {
		CamgenPlan camgenPlan = new CamgenPlan();
		camgenPlan.setPlanId(1L);
		camgenPlan.setCamgenPlanExclusions(getListCamgenPlanExclusion());
		camgenPlan.setCamgenPlanDemandSupplies(getListCamgenPlanDemandSupply());
		List<CamgenPlanAutofillingDay> camgenPlanAutofillingDays = new ArrayList<>();
		CamgenPlanAutofillingDay camgenPlanAutofillingDay = new CamgenPlanAutofillingDay();
		camgenPlanAutofillingDay.setAutofillingDayId(1l);
		camgenPlanAutofillingDay.setDuration(BigDecimal.ONE);
		camgenPlanAutofillingDay.setOffset(BigDecimal.ONE);
		camgenPlanAutofillingDays.add(camgenPlanAutofillingDay);
		camgenPlan.setCamgenPlanAutofillingDays(camgenPlanAutofillingDays);
		return camgenPlan;
	}

	public List<CamgenPlanDemandSupply> getListCamgenPlanDemandSupply() {
		List<CamgenPlanDemandSupply> lst = new ArrayList<>();
		lst.add(getCamgenPlanDemandSupply());
		return lst;
	}

	public CamgenPlanDemandSupply getCamgenPlanDemandSupply() {
		CamgenPlanDemandSupply camgenPlanDemandSupply = new CamgenPlanDemandSupply();
		camgenPlanDemandSupply.setAmendmentPercentage(new BigDecimal(1));
		camgenPlanDemandSupply.setDemandSupplyId(1l);
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("demandSupplyLevelName1");
		camgenPlanDemandSupply.setCamgenDemandSupplyLevel(camgenDemandSupplyLevel);
		camgenPlanDemandSupply.setName("name");
		camgenPlanDemandSupply.setPlanDemandSupplyCriterias(getPlanDemandSupplyCriterias());
		return camgenPlanDemandSupply;
	}

	public List<PlanDemandSupplyCriteria> getPlanDemandSupplyCriterias() {
		List<PlanDemandSupplyCriteria> lst = new ArrayList<>();
		lst.add(getPlanDemandSupplyCriteria());
		return lst;
	}

	public PlanDemandSupplyCriteria getPlanDemandSupplyCriteria() {
		PlanDemandSupplyCriteria planDemandSupplyCriteria = new PlanDemandSupplyCriteria();
		/*
		 * planDemandSupplyCriteria.setAttribute("attribute");
		 * planDemandSupplyCriteria.setCondition("condition");
		 * planDemandSupplyCriteria.setObject("object");
		 */

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

	public List<CamgenPlanExclusion> getListCamgenPlanExclusion() {
		List<CamgenPlanExclusion> lst = new ArrayList<>();
		lst.add(getCamgenPlanExclusion());
		return lst;
	}

	public CamgenPlanExclusion getCamgenPlanExclusion() {
		CamgenPlanExclusion camgenPlanExclusion = new CamgenPlanExclusion();
		camgenPlanExclusion.setCamgenPlanExclusionId(1L);
		camgenPlanExclusion.setCategory("category");
		camgenPlanExclusion.setReferenceCode("referenceCode");
		return camgenPlanExclusion;
	}

	public SnapshotSummary getSnapshotSummary() {
		SnapshotSummary snapshotSummary = new SnapshotSummary();
		// snapshotSummary.setSnapshotID(1L);
		// snapshotSummary.setTxLevel("1");
		// snapshotSummary.setScheduleType("abc");
		// snapshotSummary.setChannelSet("abc");

		// edit
		snapshotSummary.setSnapshotPlanID(1L);

		List<SnapshotSummaryTxLevels> txLevels = new ArrayList<>();
		SnapshotSummaryTxLevels snapshotSummaryTxLevels = new SnapshotSummaryTxLevels();
		snapshotSummaryTxLevels.setTxLevelId(1L);
		txLevels.add(snapshotSummaryTxLevels);

		snapshotSummary.setTxLevels(txLevels);
		snapshotSummary.setChannelSetId(1L);
		snapshotSummary.setScheduledDate(new DateTime(2010 - 02 - 02));

		return snapshotSummary;
	}

	public CamgenRunParamAudGroupChannels getCamgenRunParamAudGroupChannels() {
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();
		camgenRunParamAudGroupChannel.setAudienceGroupId(1);
		camgenRunParamAudGroupChannel.setChannelId(1);
		camgenRunParamAudGroupChannel.setKeyAudienceId(1);
 
		camgenRunParamAudGroupChannel.setTargetPercentage("abc");
		camgenRunParamAudGroupChannel.setAudienceGroupId(1);
		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
		return camgenRunParamAudGroupChannels;
	}

	public CamgenParamAudGroupChannels getCamgenParamAudGroupChannels() {
		CamgenParamAudGroupChannels camgenParamAudGroupChannels = new CamgenParamAudGroupChannels();
		CamgenParamAudGroupChannel camgenParamAudGroupChannel = new CamgenParamAudGroupChannel();
		camgenParamAudGroupChannel.setAudienceGroupId(1);
		camgenParamAudGroupChannel.setChannelId(1);
		camgenParamAudGroupChannel.setCreatedBy("abc");
		camgenParamAudGroupChannel.setId(1L);
		camgenParamAudGroupChannel.setKeyAudienceId(1);
		camgenParamAudGroupChannel.setTargetPercentage("abc");
		camgenParamAudGroupChannels.add(camgenParamAudGroupChannel);
		return camgenParamAudGroupChannels;
	}

	public CamgenRunParameters getCamgenRunParameters() {
		CamgenRunParameters camgenRunParameters = new CamgenRunParameters();
		CamgenRunParam camgenRunParam = new CamgenRunParam();
		camgenRunParam.setParameter("abc");
		camgenRunParam.setStandardvalue("abc");
		camgenRunParam.setValue("abc");
		camgenRunParameters.add(camgenRunParam);
		return camgenRunParameters;
	}

	public CamgenRunParamExtracts getCamgenRunParamExtracts() {
		CamgenRunParamExtracts camgenRunParamExtracts = new CamgenRunParamExtracts();
		CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();
		camgenRunParamExtract.setParameter("abc");
		camgenRunParamExtract.setValue("abc");
		camgenRunParamExtracts.add(camgenRunParamExtract);
		return camgenRunParamExtracts;
	}

	public CamgenRunParamStationEITimeBands getCamgenRunParamStationEITimeBands() {
		CamgenRunParamStationEITimeBands camgenRunParamStationEITimeBands = new CamgenRunParamStationEITimeBands();
		CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = new CamgenRunParamStationEITimeBand();
		camgenRunParamStationEITimeBand.setDayCode("abc");
 
		camgenRunParamStationEITimeBand.setStartTime("9AM");
		camgenRunParamStationEITimeBand.setEndTime("6PM");
		camgenRunParamStationEITimeBands.add(camgenRunParamStationEITimeBand);
		return camgenRunParamStationEITimeBands;
	}

	public CamgenRunParamStationTimeBands getCamgenRunParamStationTimeBands() {
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands = new CamgenRunParamStationTimeBands();
		CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();
		camgenRunParamStationTimeBand.setChannelId(1);
		camgenRunParamStationTimeBand.setDayCode("abc");
		camgenRunParamStationTimeBand.setName("abc");
		camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
		return camgenRunParamStationTimeBands;
	}

	public CamgenRunParamEIBands getCamgenRunParamEIBands() {
		CamgenRunParamEIBands camgenRunParamEIBands = new CamgenRunParamEIBands();
		CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();
		camgenRunParamEIBand.setEiBand(1);
		camgenRunParamEIBands.add(camgenRunParamEIBand);
		return camgenRunParamEIBands;
	}

	public CamgenParamExtracts getCamgenParamExtracts() {
		CamgenParamExtracts camgenParamExtracts = new CamgenParamExtracts();

		camgenParamExtracts.add(getCamgenParamExtract());
		return camgenParamExtracts;
	}

	public CamgenParamExtract getCamgenParamExtract() {
		CamgenParamExtract camgenParamExtract = new CamgenParamExtract();
		camgenParamExtract.setCreatedBy("abc");
		camgenParamExtract.setId(1L);
		camgenParamExtract.setParameter("abc");
		camgenParamExtract.setValue("abc");
		return camgenParamExtract;
	}

	public CamgenParamStationEITimeBands getCamgenParamStationEITimeBands() {
		CamgenParamStationEITimeBands camgenParamStationEITimeBands = new CamgenParamStationEITimeBands();

		camgenParamStationEITimeBands.add(getCamgenParamStationEITimeBand());
		return camgenParamStationEITimeBands;
	}

	public CamgenParamStationEITimeBand getCamgenParamStationEITimeBand() {

		CamgenParamStationEITimeBand camgenParamStationEITimeBand = new CamgenParamStationEITimeBand();
		camgenParamStationEITimeBand.setCreatedBy("abc");
		camgenParamStationEITimeBand.setDayCode("abc");
		camgenParamStationEITimeBand.setId(1L);
		camgenParamStationEITimeBand.setStartTime("9AM");
		camgenParamStationEITimeBand.setEndTime("6PM");
		return camgenParamStationEITimeBand;
	}

	public CamgenParamStationTimeBands getCamgenParamStationTimeBands() {
		CamgenParamStationTimeBands camgenParamStationTimeBands = new CamgenParamStationTimeBands();
		CamgenParamStationTimeBand camgenParamStationTimeBand = new CamgenParamStationTimeBand();
		camgenParamStationTimeBand.setChannelId(1);
		camgenParamStationTimeBand.setDayCode("abc");
		camgenParamStationTimeBand.setId(1L);
		camgenParamStationTimeBand.setName("abc");
		camgenParamStationTimeBand.setAmendDemand(1);
		camgenParamStationTimeBand.setCreatedBy("abc");
		camgenParamStationTimeBand.setEndTime("6PM");
		camgenParamStationTimeBand.setExcludeFlag(true);
		camgenParamStationTimeBands.add(camgenParamStationTimeBand);
		return camgenParamStationTimeBands;
	}

	public CamgenParameters getCamgenParameters() {
		CamgenParameters camgenParameters = new CamgenParameters();

		camgenParameters.add(getCamgenParam());
		return camgenParameters;
	}

	public CamgenParam getCamgenParam() {

		CamgenParam camgenParam = new CamgenParam();
		camgenParam.setCreatedBy("abc");
		camgenParam.setId(1L);
		camgenParam.setParameter("abc");
		camgenParam.setRemarks("abc");
		camgenParam.setStandardvalue("abc");
		camgenParam.setValue("abc");
		camgenParam.setViewOrder(1);
		return camgenParam;
	}

	public CamgenParamEIBands getCamgenParamEIBands() {
		CamgenParamEIBands camgenParamEIBands = new CamgenParamEIBands();
		CamgenParamEIBand camgenParamEIBand = new CamgenParamEIBand();
		camgenParamEIBand.setCreatedBy("abc");
		camgenParamEIBand.setEiBand(1);
		camgenParamEIBand.setId(1L);
		camgenParamEIBands.add(camgenParamEIBand);
		return camgenParamEIBands;
	}

	public CamgenRunIterations getCamgenRunIterations() {
		CamgenRunIterations camgenRunIterations = new CamgenRunIterations();
		CamgenRunIteration camgenRunIteration = new CamgenRunIteration();
		camgenRunIteration.setEndTime("2017-01-01");
		camgenRunIteration.setIterationNumber(1);
		camgenRunIteration.setRunId(1);
		camgenRunIteration.setSnapShotId(1);
		camgenRunIteration.setSolutionFileName("abc");
		camgenRunIteration.setStartTime("2017-01-01");
		camgenRunIterations.add(camgenRunIteration);
		return camgenRunIterations;
	}

	public CamgenSnapshotRunDetails getCamgenSnapshotRunDetails() {
		CamgenSnapshotRunDetails camgenSnapshotRunDetails = new CamgenSnapshotRunDetails();
		CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();
 
		camgenSnapshotRunDetail.setIterationCount(1);
		camgenSnapshotRunDetail.setNotes("abc");
 
		camgenSnapshotRunDetail.setSnapshotId(1L);
		camgenSnapshotRunDetail.setRunId(1);
		camgenSnapshotRunDetails.add(camgenSnapshotRunDetail);
		return camgenSnapshotRunDetails;
	}

	public CamgenExtractParameter getCamgenExtractParameter() {
		CamgenExtractParameter camgenExtractParameter = new CamgenExtractParameter();
		camgenExtractParameter.setCreatedBy("abc");
		camgenExtractParameter.setExtractParameterName("abc");
		camgenExtractParameter.setValue("abc");
		return camgenExtractParameter;
	}

	public CamgenParameter getCamgenParameter() {
		CamgenParameter camgenParameter = new CamgenParameter();
		camgenParameter.setCreatedBy("abc");
		camgenParameter.setDescription("abc");
		camgenParameter.setParameterId(1L);
		camgenParameter.setParameterName("abc");
		camgenParameter.setDisplaySequenceNumber(new BigDecimal(1));
		return camgenParameter;
	}

	public CamgenStationEiTimeband getCamgenStationEiTimeband() {
		CamgenStationEiTimeband camgenStationEiTimeband = new CamgenStationEiTimeband();
		camgenStationEiTimeband.setCreatedBy("abc");
		camgenStationEiTimeband.setEndTime("6PM");
		camgenStationEiTimeband.setStartTime("9AM");
		camgenStationEiTimeband.setApplicableDay("abc");
		camgenStationEiTimeband.setModifiedBy("abc");
		return camgenStationEiTimeband;
	}

	public CamgenParamEIBand getcamgenParamEIBand() {
		CamgenParamEIBand camgenParamEIBand = new CamgenParamEIBand();
		camgenParamEIBand.setCreatedBy("abc");
		camgenParamEIBand.setCreatedBy("abc");
		camgenParamEIBand.setEiBand(1);
		camgenParamEIBand.setId(1L);
		return camgenParamEIBand;
	}

	public CamgenEiBand getCamgenEiBand() {
		CamgenEiBand camgenEiBand = new CamgenEiBand();
		camgenEiBand.setCreatedBy("abc");
		camgenEiBand.setEiBand(new BigDecimal(1));
		camgenEiBand.setEiBandId(1L);
		camgenEiBand.setModifiedBy("abc");
		return camgenEiBand;
	}

	public CamgenStationTimeband getCamgenStationTimeband() {
		CamgenStationTimeband camgenStationTimeband = new CamgenStationTimeband();
		camgenStationTimeband.setChannelId(new BigDecimal(1));
		camgenStationTimeband.setStationTimebandId(1L);
		camgenStationTimeband.setApplicableDay("abc");
		camgenStationTimeband.setTimeband("1");
		camgenStationTimeband.setIsExclude(new BigDecimal(1));
		camgenStationTimeband.setStartTime("9AM");
		camgenStationTimeband.setEndTime("6PM");
		camgenStationTimeband.setEiCutOff(new BigDecimal(1));
		camgenStationTimeband.setTbProgRepititionLimit(new BigDecimal(1));
		camgenStationTimeband.setAmendDemand(new BigDecimal(1));
		camgenStationTimeband.setCreatedBy("abc");
		return camgenStationTimeband;
	}

	public CamgenAudienceGroupChannel getCamgenAudienceGroupChannel() {
		CamgenAudienceGroupChannel camgenAudienceGroupChannel = new CamgenAudienceGroupChannel();
		camgenAudienceGroupChannel.setAudienceGroupChannelId(1L);
		camgenAudienceGroupChannel.setAudienceId(new BigDecimal(1));
		camgenAudienceGroupChannel.setChannelId(new BigDecimal(1));
		camgenAudienceGroupChannel.setCreatedBy("abc");
		camgenAudienceGroupChannel.setModifiedBy("abc");
		camgenAudienceGroupChannel.setTargetPercentage(new BigDecimal(1));
		return camgenAudienceGroupChannel;
	}

	public CamgenRun getCamgenRun() {
		CamgenRun camgenRun = new CamgenRun();
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setRequestId(1L);
		camgenRun.setCamgenRequest(camgenRequest);
		List<com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration> camgenRunIterations = new ArrayList<>();
		com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration runIteration = new com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration();
		runIteration.setCreatedBy("abc");
		runIteration.setEndDateTime(new Date(2017 - 02 - 02));
		runIteration.setIterationId(1L);
		runIteration.setIterationNumber(new BigDecimal(1));
		runIteration.setIterationSolutionFileName("abc");
		runIteration.setStartDateTime(new Date(2017 - 03 - 03));
		runIteration.setStatus("success");
		camgenRunIterations.add(runIteration);
		camgenRun.setRunId(1L);
		List<RunEiBand> runEiBandsList = new ArrayList<>();
		RunEiBand runEiBand = new RunEiBand();
		runEiBand.setCreatedBy("abc");
		runEiBand.setEiBand(new BigDecimal(1));
		runEiBand.setEiBandId(1L);
		runEiBandsList.add(runEiBand);
		camgenRun.setRunEiBands(runEiBandsList);
		List<RunParameter> runParameters = new ArrayList<>();
		RunParameter runParameter = new RunParameter();
		runParameter.setCreatedBy("abc");
		runParameter.setDisplaySequenceNumber(new BigDecimal(1));
		runParameters.add(runParameter);
		camgenRun.setRunParameters(runParameters);
		List<RunExtractParameter> runExtractParameters = new ArrayList<>();
		runExtractParameters.add(getrunExtractParameter());
		camgenRun.setRunExtractParameters(runExtractParameters);
		camgenRun.setCamgenRunIterations(camgenRunIterations);
		List<RunStationEiTimeband> runStationEiTimebands = new ArrayList<>();
		RunStationEiTimeband runStationEiTimeband = new RunStationEiTimeband();
		runStationEiTimeband.setApplicableDay("abc");
		runStationEiTimeband.setStationEiTimebandId(1L);
		runStationEiTimebands.add(runStationEiTimeband);
		camgenRun.setRunStationEiTimebands(runStationEiTimebands);
		List<RunStationTimeband> runStationTimebands = new ArrayList<>();
		RunStationTimeband runStationTimeband = new RunStationTimeband();
		runStationTimeband.setStationTimebandId(1L);
		runStationTimeband.setAmendDemand(new BigDecimal(1));
		runStationTimeband.setAmendDemand(new BigDecimal(1));
		runStationTimeband.setChannelId(new BigDecimal(1));
		runStationTimeband.setCreatedBy("abc");
		runStationTimeband.setEiCutOff(new BigDecimal(1));
		runStationTimeband.setEndTime("09:02:02");
		runStationTimeband.setIsExclude(new BigDecimal(1));
		runStationTimeband.setTbProgRepititionLimit(new BigDecimal(1));
		runStationTimeband.setStartTime("06:02:02");
		runStationTimebands.add(runStationTimeband);
		camgenRun.setRunStationTimebands(runStationTimebands);
		List<RunAudienceGroupChannel> runAudienceGroupChannels = new ArrayList<>();
		RunAudienceGroupChannel runAudienceGroupChannel = new RunAudienceGroupChannel();
		runAudienceGroupChannel.setAudienceGroupChannelId(1L);
		runAudienceGroupChannel.setAudienceId(new BigDecimal(1));
		runAudienceGroupChannel.setChannelId(new BigDecimal(1));
		runAudienceGroupChannel.setCreatedBy("abc");
		runAudienceGroupChannel.setTargetPercentage(new BigDecimal(1));
		runAudienceGroupChannels.add(runAudienceGroupChannel);
		camgenRun.setRunAudienceGroupChannels(runAudienceGroupChannels);
		return camgenRun;
	}

	public com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration getCamgenRunIteration() {
		com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRun = new CamgenRunIteration();
		camgenRun.setCreatedBy("abc");
		camgenRun.setEndTime("6PM");
		camgenRun.setIterationNumber(1);
		camgenRun.setRunId(1);
		camgenRun.setSnapShotId(1);
		camgenRun.setSolutionFileName("abc");
		camgenRun.setStartTime("9AM");
		return camgenRun;
	}

	public CamgenRunParamEIBand getCamgenRunParamEIBand() {
		CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();
		camgenRunParamEIBand.setCreatedBy("abc");
		camgenRunParamEIBand.setEiBand(1);
		return camgenRunParamEIBand;
	}

	public RunExtractParameter getrunExtractParameter() {
		RunExtractParameter runExtractParameter = new RunExtractParameter();

		runExtractParameter.setCreatedBy("abc");
		runExtractParameter.setExtractParameterId(1L);
		runExtractParameter.setExtractParameterName("abc");
		runExtractParameter.setValue("value");

		return runExtractParameter;
	}

	public CamgenRunParamExtract getCamgenRunParamExtract() {
		CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();

		camgenRunParamExtract.setCreatedBy("abc");
		camgenRunParamExtract.setParameter("abc");
 
		camgenRunParamExtract.setValue("abc");

		return camgenRunParamExtract;
	}

	public CamgenRunParam getCamgenRunParam() {
		CamgenRunParam camgenRunParam = new CamgenRunParam();

		camgenRunParam.setCreatedBy("abc");
		camgenRunParam.setParameter("abc");
		camgenRunParam.setRemarks("abc");
		camgenRunParam.setValue("abc");
		camgenRunParam.setStandardvalue("abc");
		return camgenRunParam;
	}

	public CriteriaLineNormalised getCriteriaLineNormalised() {
		CriteriaLineNormalised criteriaLineNormalised = new CriteriaLineNormalised();

		criteriaLineNormalised.setAttributeId(1L);
		criteriaLineNormalised.setConditionId(1L);
		criteriaLineNormalised.setCriteriaLineId(1L);
		criteriaLineNormalised.setObjectId(1L);
		criteriaLineNormalised.setOperator("abc");
		criteriaLineNormalised.setValue("abc");

		return criteriaLineNormalised;
	}

	public ChannelSetTimeBands getChannelSetTimeBands() {
		ChannelSetTimeBands channelSetTimeBands = new ChannelSetTimeBands();
		channelSetTimeBands.add(getChannelSetTimeBand());
		return channelSetTimeBands;
	}

	public ChannelSetTimeBand getChannelSetTimeBand() {
		ChannelSetTimeBand channelSetTimeBand = new ChannelSetTimeBand();
		channelSetTimeBand.setAvailability(1d);
		channelSetTimeBand.setChannelSetId(1);
		channelSetTimeBand.setDay("day");
		channelSetTimeBand.setEndTime("endTime");
		channelSetTimeBand.setId(1);
		channelSetTimeBand.setName("name");

		channelSetTimeBand.setStartTime("startTime");
		channelSetTimeBand.setName("timeBand");
		return channelSetTimeBand;
	}

	public List<CamgenRqstChSetTimeband> getListCamgenRqstChSetTimeband() {

		List<CamgenRqstChSetTimeband> lstCamgenRqstChSetTimeband = new ArrayList<>();

		lstCamgenRqstChSetTimeband.add(getCamgenRqstChSetTimeband());
		return lstCamgenRqstChSetTimeband;
	}

	public CamgenRqstChSetTimeband getCamgenRqstChSetTimeband() {
		CamgenRqstChSetTimeband camgenRqstChSetTimeband = new CamgenRqstChSetTimeband();
		CamgenRequest camgenRequest = new CamgenRequest();
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setRequestId(1);
		camgenRqstChSetTimeband.setApplicableDay("day");
		camgenRqstChSetTimeband.setAvailabilityPercentage(new BigDecimal(1));
		camgenRqstChSetTimeband.setCamgenRqstChSetTimebandId(1l);
		camgenRqstChSetTimeband.setCamgenRequest(camgenRequest);
		camgenRqstChSetTimeband.setEndTime("endTime");
		camgenRqstChSetTimeband.setStartTime("startTime");
		camgenRqstChSetTimeband.setTimeband("timeband");
		camgenRqstChSetTimeband.setCreatedBy("createdBy");
		camgenRqstChSetTimeband.setCreatedOn(new Timestamp(1l));
		return camgenRqstChSetTimeband;
	}

	public BatchTxLevels getBatchTxLevels() {
		BatchTxLevels batchTxLevels = new BatchTxLevels();
		batchTxLevels.add(getBatchTxLevel());
		return batchTxLevels;
	}

	public BatchTxLevel getBatchTxLevel() {
		BatchTxLevel batchTxLevel = new BatchTxLevel();
		batchTxLevel.setBatchTxLevelValue(1);
		batchTxLevel.setId(1);
		batchTxLevel.setTxLevelId(1l);;
		return batchTxLevel;
	}

	public List<CamgenRqstBatchTxLevel> getlstCamgenRqstBatchTxLevels() {
		List<CamgenRqstBatchTxLevel> lst = new ArrayList<>();
		lst.add(getCamgenRqstBatchTxLevel());
		return lst;
	}

	public CamgenRqstBatchTxLevel getCamgenRqstBatchTxLevel() {
		CamgenRqstBatchTxLevel camgenRqstBatchTxLevel = new CamgenRqstBatchTxLevel();
		camgenRqstBatchTxLevel.setBatchTxLevelId(1l);
		camgenRqstBatchTxLevel.setBatchValue(new BigDecimal(1));
		camgenRqstBatchTxLevel.setCamgenRequest(getCamgenRequest());
		camgenRqstBatchTxLevel.setCreatedBy("createdBy");
		camgenRqstBatchTxLevel.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		camgenRqstBatchTxLevel.setTransmissionLevelId(new BigDecimal(1));
		return camgenRqstBatchTxLevel;
	}

	public CamgenRequest getCamgenRequest() {
		CamgenRequest camgenRequest = new CamgenRequest();
		// camgenRequest.setCamgenRqstBatchTxLevels(getlstCamgenRqstBatchTxLevels());
		camgenRequest.setRequestId(1l);
		camgenRequest.setCamgenPlan(getCamgenPlan());
		camgenRequest.setChannelSetId(new BigDecimal(1));
		camgenRequest.setCreatedBy("abc");
		camgenRequest.setStartDate(new Date(2010 - 02 - 02));
		camgenRequest.setCamgenRqstChSetTimebands(getListCamgenRqstChSetTimeband());
		List<CamgenRqstDemandSupply> camgenRqstDemandSupplies = new ArrayList<>();
		camgenRqstDemandSupplies.add(getCamgenRqstDemandSupply());
		camgenRequest.setCamgenRqstDemandSupplies(camgenRqstDemandSupplies);

		List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelslist = new ArrayList<>();
		CamgenRqstBatchTxLevel camgenRqstBatchTxLevel = new CamgenRqstBatchTxLevel();
		camgenRqstBatchTxLevel.setBatchTxLevelId(1l);
		camgenRqstBatchTxLevel.setBatchValue(BigDecimal.ONE);
		camgenRqstBatchTxLevel.setTransmissionLevelId(BigDecimal.ONE);
		camgenRqstBatchTxLevelslist.add(camgenRqstBatchTxLevel);
		camgenRequest.setCamgenRqstBatchTxLevels(camgenRqstBatchTxLevelslist);
		// camgenRequest.setCamgenRqstChSetTimebands(getListCamgenRqstChSetTimeband());

		return camgenRequest;
	}

	public CamgenRqstDemandSupply getCamgenRqstDemandSupply() {

		CamgenRqstDemandSupply camgenRqstDemandSupply = new CamgenRqstDemandSupply();

		camgenRqstDemandSupply.setAmendmentPercentage(new BigDecimal(1));
		camgenRqstDemandSupply.setDemandSupplyId(1L);
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("demandSupplyLevelName1");
		camgenRqstDemandSupply.setCamgenDemandSupplyLevel(camgenDemandSupplyLevel);
		camgenRqstDemandSupply.setName("abc");
		List<RqstDemandSupplyCriteria> rqstDemandSupplyCriterias = new ArrayList<>();
		RqstDemandSupplyCriteria rqstDemandSupplyCriteria = new RqstDemandSupplyCriteria();

		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode1");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);

		rqstDemandSupplyCriteria.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttribute);

		rqstDemandSupplyCriteria.setRqstDemandSupplyCriteriaId(1l);
		rqstDemandSupplyCriteria.setValue("value1");
		rqstDemandSupplyCriterias.add(rqstDemandSupplyCriteria);
		camgenRqstDemandSupply.setRqstDemandSupplyCriterias(rqstDemandSupplyCriterias);

		return camgenRqstDemandSupply;
	}

	public List<DemandSupplyGroup> getListDemandSupplyGroup() {
		List<DemandSupplyGroup> lst = new ArrayList<>();
		lst.add(getDemandSupplyGroup());
		return lst;
	}

	public DemandSupplyGroup getDemandSupplyGroup() {
		DemandSupplyGroup groupInner = new DemandSupplyGroup();
		groupInner.setCriterias(getListCriteriaLine());
		groupInner.setAmendmentPercent(1d);
		groupInner.setDemandSupplyId(1);
		groupInner.setLevelId(1L);
		groupInner.setName("name");
		groupInner.setStatus("status");
		return groupInner;
	}

	public List<ExclusionDemandSupplyGroup> getListExclusionDemandSupplyGroup() {
		List<ExclusionDemandSupplyGroup> listExclusionDemandSupplyGroup = new ArrayList<>();
		listExclusionDemandSupplyGroup.add(getExclusionDemandSupplyGroup());
		return listExclusionDemandSupplyGroup;
	}

	public List<CriteriaLine> getListCriteriaLine() {
		List<CriteriaLine> listCriteriaLine = new ArrayList<>();
		listCriteriaLine.add(getCriteriaLine());
		return listCriteriaLine;
	}

	public CriteriaLine getCriteriaLine() {
		CriteriaLine criteriaLine = new CriteriaLine();

		criteriaLine.setValue("value");
		criteriaLine.setAttributeId(1L);
		criteriaLine.setConditionId(1L);
		criteriaLine.setObjectId(1L);

		return criteriaLine;
	}

	public ExclusionDemandSupplyGroup getExclusionDemandSupplyGroup() {
		ExclusionDemandSupplyGroup exclDemd = new ExclusionDemandSupplyGroup();
		exclDemd.setCategoryId(1);
		exclDemd.setCategoryName("category");
		exclDemd.setCategoryValue("categoryValue");
		return exclDemd;
	}

	public CamgenPlan getCamgenPlan() {
		CamgenPlan camgenPlan = new CamgenPlan();

		camgenPlan.setCreatedBy("abc");
		camgenPlan.setEndDate(new Date(2010 - 02 - 02));
		camgenPlan.setIsRun(new BigDecimal(1));
		camgenPlan.setIsSlot(new BigDecimal(1));
		camgenPlan.setPlanId(1L);
		camgenPlan.setChannelSetId(new BigDecimal(1));
		camgenPlan.setStartDate(new Date(2010 - 02 - 02));
		camgenPlan.setStatus("active");
		camgenPlan.setTotalIteration(new BigDecimal(1));
		List<CamgenPlanAutofillingDay> camgenPlanAutofillingDays = new ArrayList<>();
		CamgenPlanAutofillingDay camgenPlanAutofillingDay = new CamgenPlanAutofillingDay();
		camgenPlanAutofillingDay.setAutofillingDayId(1L);
		camgenPlanAutofillingDay.setStartTime("09:00");
		camgenPlanAutofillingDay.setRunDay("abc");
		camgenPlanAutofillingDay.setDuration(new BigDecimal(1));
		camgenPlanAutofillingDays.add(camgenPlanAutofillingDay);
		camgenPlan.setCamgenPlanAutofillingDays(camgenPlanAutofillingDays);
		List<CamgenPlanDemandSupply> camgenPlanDemandSupplies = new ArrayList<>();
		CamgenPlanDemandSupply camgenPlanDemandSupply = new CamgenPlanDemandSupply();
		camgenPlanDemandSupply.setAmendmentPercentage(new BigDecimal(1));
		camgenPlanDemandSupply.setDemandSupplyId(1L);

		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("demandSupplyLevelCode1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("demandSupplyLevelName1");
		camgenPlanDemandSupply.setCamgenDemandSupplyLevel(camgenDemandSupplyLevel);
		camgenPlanDemandSupply.setName("abc");
		List<PlanDemandSupplyCriteria> planDemandSupplyCriterias = new ArrayList<>();
		PlanDemandSupplyCriteria planDemandSupplyCriteria = new PlanDemandSupplyCriteria();

		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("demandSupplyAttributeCode1");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);
		camgenDemandSupplyAttribute.setDemandSupplyAttributeName("demandSupplyAttributeName1");
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

		planDemandSupplyCriteria.setOperator("AND");
		planDemandSupplyCriteria.setPlanDemandSupplyCriteriaId(1l);
		planDemandSupplyCriteria.setValue("value");
		planDemandSupplyCriteria.setPlanDemandSupplyCriteriaId(1L);
		planDemandSupplyCriteria.setValue("abc");
		planDemandSupplyCriterias.add(planDemandSupplyCriteria);
		camgenPlanDemandSupply.setPlanDemandSupplyCriterias(planDemandSupplyCriterias);
		camgenPlanDemandSupplies.add(camgenPlanDemandSupply);
		camgenPlan.setCamgenPlanDemandSupplies(camgenPlanDemandSupplies);
		List<CamgenPlanExclusion> camgenPlanExclusionList = new ArrayList<>();
		CamgenPlanExclusion camgenPlanExclusion = new CamgenPlanExclusion();
		camgenPlanExclusion.setCamgenPlanExclusionId(1L);
		camgenPlanExclusion.setCategory("abc");
		camgenPlanExclusion.setEndTime("09:03");
		camgenPlanExclusion.setReferenceCode("abc");
		camgenPlanExclusion.setStarTime("09:00");
		camgenPlanExclusionList.add(camgenPlanExclusion);
		camgenPlan.setCamgenPlanExclusions(camgenPlanExclusionList);

		return camgenPlan;
	}

	public PlanSummary getPlanSummary() {
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
		return planSummary;
	}

	public SnapshotSummaryWithPagination getSnapshotSummaryWithPagination() {
		SnapshotSummaryWithPagination snapshotSummaryWithPagination = new SnapshotSummaryWithPagination();
		List<SnapshotSummary> snapshotSummary = new ArrayList<>();
		snapshotSummary.add(getSnapshotSummary());
		snapshotSummaryWithPagination.setTotalCount(1);
		return snapshotSummaryWithPagination;
	}

	public ChannelSetTimeBandResponse getChannelSetTimeBandResponse() {
		ChannelSetTimeBandResponse channelSetTimeBandResponse = new ChannelSetTimeBandResponse();

		channelSetTimeBandResponse.setAvailability(new BigDecimal(1));
		channelSetTimeBandResponse.setDay("abc");
		channelSetTimeBandResponse.setName("abc");
		channelSetTimeBandResponse.setTimeBandId(1);

		return channelSetTimeBandResponse;
	}

	public ChannelSetTimebandsBulkRequest getChannelSetTimebandsBulkRequest() {
		ChannelSetTimebandsBulkRequest channelSetTimebandsBulkRequest = new ChannelSetTimebandsBulkRequest();

		channelSetTimebandsBulkRequest.setCreatedBy("abc");
		List<ChannelSetTimebandsBulkRequestCreated> created = new ArrayList<>();
		ChannelSetTimebandsBulkRequestCreated channelSetTimebandsBulkRequestCreated = new ChannelSetTimebandsBulkRequestCreated();
		channelSetTimebandsBulkRequestCreated.setChannelSetId(1);
		channelSetTimebandsBulkRequestCreated.setTimebands(gettimebands());
		created.add(channelSetTimebandsBulkRequestCreated);
		channelSetTimebandsBulkRequest.setCreated(created);

		List<ChannelSetTimebandsBulkRequestModified> modified = new ArrayList<>();
		ChannelSetTimebandsBulkRequestModified channelSetTimebandsBulkRequestModified = new ChannelSetTimebandsBulkRequestModified();
		channelSetTimebandsBulkRequestModified.setChannelSetId(1);
		channelSetTimebandsBulkRequestModified.setTimebands(gettimebands());
		modified.add(channelSetTimebandsBulkRequestModified);
		channelSetTimebandsBulkRequest.setModified(modified);

		List<ChannelSetTimebandsBulkRequestDeleted> deleted = new ArrayList<>();
		ChannelSetTimebandsBulkRequestDeleted channelSetTimebandsBulkRequestDeleted = new ChannelSetTimebandsBulkRequestDeleted();
		channelSetTimebandsBulkRequestDeleted.setTimebandId(1);
		deleted.add(channelSetTimebandsBulkRequestDeleted);
		channelSetTimebandsBulkRequest.setDeleted(deleted);

		return channelSetTimebandsBulkRequest;
	}

	public List<ChannelSetTimebandsBulkRequestTimebands> gettimebands() {

		List<ChannelSetTimebandsBulkRequestTimebands> timebands = new ArrayList<>();
		ChannelSetTimebandsBulkRequestTimebands channelSetTimebandsBulkRequestTimebands = new ChannelSetTimebandsBulkRequestTimebands();
		channelSetTimebandsBulkRequestTimebands.setAvailability(new BigDecimal(1));
		channelSetTimebandsBulkRequestTimebands.setDay("friday");
		channelSetTimebandsBulkRequestTimebands.setEndTime("09");
		channelSetTimebandsBulkRequestTimebands.setName("abc");
		channelSetTimebandsBulkRequestTimebands.setStartTime("06");
		channelSetTimebandsBulkRequestTimebands.setTimeBand("abc");
		channelSetTimebandsBulkRequestTimebands.setTimebandId(1);
		timebands.add(channelSetTimebandsBulkRequestTimebands);
		return timebands;
	}

	public Exclusions getExclusions() {
		Exclusions exclusions = new Exclusions();
		exclusions.add(getExclusionDemandSupplyGroupValue());
		return exclusions;
	}

	public ExclusionDemandSupplyGroup getExclusionDemandSupplyGroupValue() {
		ExclusionDemandSupplyGroup exDemdGrp = new ExclusionDemandSupplyGroup();
		exDemdGrp.setCategoryId(1);
		exDemdGrp.setCategoryName("category");
		exDemdGrp.setCategoryValue("categoryValue");
		return exDemdGrp;
	}

	public List<PlanSummary> getListPlanSummary() {
		List<PlanSummary> lst = new ArrayList<>();
		lst.add(getPlanSummary());
		return lst;
	}

	public List<ChannelSetTimeBandResponse> getListChannelSetTimeBandResponse() {
		List<ChannelSetTimeBandResponse> lst = new ArrayList<>();
		lst.add(getChannelSetTimeBandResponse());
		return lst;
	}

	public List<PlanSummaryWithPagination> getListPlanSummaryWithPagination() {
		List<PlanSummaryWithPagination> lst = new ArrayList<>();
		lst.add(getPlanSummaryWithPagination());
		return lst;
	}

	public PlanSummaryWithPagination getPlanSummaryWithPagination() {
		PlanSummaryWithPagination pswp = new PlanSummaryWithPagination();
		pswp.setPlanSummary(getListPlanSummary());
		pswp.setTotalCount(1);
		return pswp;
	}

	public CamgenChannelSetTimeband getCamgenChannelSetTimeband() {
		CamgenChannelSetTimeband camgenChannelSetTimeband = new CamgenChannelSetTimeband();
		camgenChannelSetTimeband.setCamgenChannelSetTimebandId(1L);
		camgenChannelSetTimeband.setCreatedBy("abc");
		camgenChannelSetTimeband.setChannelSetId(new BigDecimal(1));
		camgenChannelSetTimeband.setCamgenChannelSetTimebandId(1L);
		return camgenChannelSetTimeband;
	}

	public List<DemandSupplyGroupInner> getDemandSupplyGroupList() {

		List<DemandSupplyGroupInner> demandSupplyGroupList = new ArrayList<>();
		DemandSupplyGroupInner demandSupplyGroupInner = new DemandSupplyGroupInner();
		demandSupplyGroupInner.setDemandSupplyId(1);
		demandSupplyGroupInner.setName("name");
		demandSupplyGroupInner.setStatus("status");
		demandSupplyGroupInner.setAmendmentPercent(1.1);
		demandSupplyGroupList.add(demandSupplyGroupInner);
		return demandSupplyGroupList;
	}

	public List<PlansObject> getPlansObjectList() {
		List<PlansObject> plansObjectList = new ArrayList<>();
		PlansObject plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setCreatedBy("createdBy");
		plansObject.setCreatedDateTime(new DateTime());
		plansObject.setPlanId(1);
		plansObjectList.add(plansObject);
		return plansObjectList;
	}

	public PlansObject getPlansObject() {
		PlansObject plansObject = new PlansObject();
		plansObject.setChannelSetId(1);
		plansObject.setCreatedBy("createdBy");
		plansObject.setPlanId(1);
		plansObject.setCreatedDateTime(new DateTime());
		plansObject.setIterationCount(1);
		return plansObject;
	}
	
	
	public ExclusionCategories getExclusionCategories(){
		ExclusionCategories exclusionCategories= new ExclusionCategories();
		ExclusionCategory exclusionCategory = new ExclusionCategory();
		exclusionCategory.setCategoryId("categoryId");
		exclusionCategory.setCategoryName("categoryName");
		exclusionCategories.add(exclusionCategory);
		return exclusionCategories;
	}
	
	public CamgenExclusionCategory getCamgenExclusionCategory(){
		CamgenExclusionCategory exclusionCategory= new CamgenExclusionCategory();
		exclusionCategory.setCategoryId(new BigDecimal(1));
		exclusionCategory.setCategoryName("categoryName");
		return exclusionCategory;
	}
	
	public CamgenSnapshotRunDetail getCamgenSnapshotRunDetail(){
		CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();
		camgenSnapshotRunDetail.setIterationCount(10);
		camgenSnapshotRunDetail.setRunId(1);
		camgenSnapshotRunDetail.setSnapshotId(1L);
		camgenSnapshotRunDetail.setNotes("notes");
		camgenSnapshotRunDetail.setRunDateTime("2018-11-20");
		return camgenSnapshotRunDetail;
	}
}
