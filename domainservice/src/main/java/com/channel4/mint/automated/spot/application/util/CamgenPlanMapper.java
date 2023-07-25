package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanAutofillingDay;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlanExclusion;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.PlanDemandSupplyCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup.RunDayEnum;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine.OperatorEnum;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup.LevelCodeEnum;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionDemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.Exclusions;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummary;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.StartEndDate;
import com.channel4.mint.baseexception.MintBaseException;

@Component
public class CamgenPlanMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenPlanMapper.class);

	@Autowired
	private DateTimeUtility dateTimeUtility;
	
	@Autowired
	private SecurityUtil securityUtil;
	
	@Value("${active}")
	private String active = "";

	@Value("${inActive}")
	private String inActive = "";

	@Autowired
	private CamgenRepository camgenRepository;

	public CamgenPlan mapUpdatePlan(CamgenPlan camgenPlan, PlansObject plansObject) {

		camgenPlan.setModifiedBy(securityUtil.getLoginUser());
		camgenPlan.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

		if (null != plansObject.getIterationCount()) {
			camgenPlan.setTotalIteration(new BigDecimal(plansObject.getIterationCount()));
		}

		if (null != plansObject.getChannelSetId()) {
			camgenPlan.setChannelSetId(new BigDecimal(plansObject.getChannelSetId()));
		}

		if (null != plansObject.getDateRange() && null != plansObject.getDateRange().getStart()) {
			camgenPlan.setStartDate(plansObject.getDateRange().getStart().toDate());
		}

		if (null != plansObject.getDateRange() && null != plansObject.getDateRange().getEnd()) {
			camgenPlan.setEndDate(plansObject.getDateRange().getEnd().toDate());
		}

		if (plansObject.getRun()) {
			camgenPlan.setStatus(active);
		} else {
			camgenPlan.setStatus(inActive);
		}

		camgenPlan.setIsSlot(plansObject.getSlot() ? new BigDecimal(1) : new BigDecimal(0));
		camgenPlan.setIsRun(plansObject.getRun() ? new BigDecimal(1) : new BigDecimal(0));

		// map auto filling
		if (!CollectionUtils.isEmpty(plansObject.getAutoFilling())) {
			camgenPlan.setCamgenPlanAutofillingDays(mapUpdateAutoFilling(camgenPlan, plansObject.getAutoFilling()));
		}

		// map exclusions
		camgenPlan.setCamgenPlanExclusions(mapUpdatePlanExcusions(camgenPlan, plansObject));

		// map demand supply
		if (!CollectionUtils.isEmpty(plansObject.getDemandSupply())) {
			camgenPlan.setCamgenPlanDemandSupplies(mapUpdateDemandSupply(camgenPlan, plansObject.getDemandSupply()));
		}

		return camgenPlan;

	}

	private List<CamgenPlanDemandSupply> mapUpdateDemandSupply(CamgenPlan camgenPlan,
			List<DemandSupplyGroup> demandSupplyGroupInnerList) {
		List<CamgenPlanDemandSupply> camgenPlanDemandSupplyList = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanDemandSupplies())) {
			camgenPlanDemandSupplyList = camgenPlan.getCamgenPlanDemandSupplies();
			camgenPlanDemandSupplyList.clear();
		} else {
			camgenPlanDemandSupplyList = new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(demandSupplyGroupInnerList)) {
			Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelMap = camgenRepository
					.getAllCamgenDemandSupplyLevelMap();

			for (DemandSupplyGroup demandSupplyGroupInner : demandSupplyGroupInnerList) {
				CamgenPlanDemandSupply camgenPlanDemandSupply = new CamgenPlanDemandSupply();

				camgenPlanDemandSupply.setCamgenPlan(camgenPlan);

				if (null != demandSupplyGroupInner.getAmendmentPercent()) {
					camgenPlanDemandSupply
							.setAmendmentPercentage(new BigDecimal(demandSupplyGroupInner.getAmendmentPercent()));
				}

				setDemandSupplyLevelId(camgenDemandSupplyLevelMap, camgenPlanDemandSupply, demandSupplyGroupInner);

				camgenPlanDemandSupply.setName(demandSupplyGroupInner.getName());
				camgenPlanDemandSupply.setPlanDemandSupplyCriterias(
						mapUpdateCriteriaLine(camgenPlanDemandSupply, demandSupplyGroupInner.getCriterias()));

				camgenPlanDemandSupplyList.add(camgenPlanDemandSupply);
			}
		}

		return camgenPlanDemandSupplyList;

	}

	private void setDemandSupplyLevelId(Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelMap,
			CamgenPlanDemandSupply camgenPlanDemandSupply, DemandSupplyGroup demandSupplyGroupInner) {
		if (null != demandSupplyGroupInner.getLevelId()
				&& camgenDemandSupplyLevelMap.containsKey(demandSupplyGroupInner.getLevelId())) {
			camgenPlanDemandSupply
					.setCamgenDemandSupplyLevel(camgenDemandSupplyLevelMap.get(demandSupplyGroupInner.getLevelId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}

	private List<PlanDemandSupplyCriteria> mapUpdateCriteriaLine(CamgenPlanDemandSupply camgenPlanDemandSupply,
			List<CriteriaLine> criteriaLineList) {
		List<PlanDemandSupplyCriteria> planDemandSupplyCriteriaList = null;

		if (!CollectionUtils.isEmpty(camgenPlanDemandSupply.getPlanDemandSupplyCriterias())) {
			planDemandSupplyCriteriaList = camgenPlanDemandSupply.getPlanDemandSupplyCriterias();
			planDemandSupplyCriteriaList.clear();
		} else {
			planDemandSupplyCriteriaList = new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(criteriaLineList)) {
			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap = camgenRepository
					.getAllCamgenDemandSupplyAttributeMap();

			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = camgenRepository
					.getAllCamgenDemandSupplyConditionMap();

			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = camgenRepository
					.getAllCamgenDemandSupplyObjectMap();

			for (CriteriaLine criteriaLine : criteriaLineList) {
				planDemandSupplyCriteriaList.add(mapCriteriaLineObject(criteriaLine, camgenPlanDemandSupply,
						camgenDemandSupplyObjectMap, camgenDemandSupplyConditionMap, camgenDemandSupplyAttributeMap));
			}
		}

		return planDemandSupplyCriteriaList;

	}

	private List<CamgenPlanExclusion> mapUpdatePlanExcusions(CamgenPlan camgenPlan, PlansObject plansRequest) {
		List<CamgenPlanExclusion> camgenPlanExclusionList = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanExclusions())) {
			camgenPlanExclusionList = camgenPlan.getCamgenPlanExclusions();
			camgenPlanExclusionList.clear();
		} else {
			camgenPlanExclusionList = new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(plansRequest.getExclusions())) {
			for (ExclusionDemandSupplyGroup exclusionDemandSupplyGroup : plansRequest.getExclusions()) {
				CamgenPlanExclusion camgenPlanExclusion = new CamgenPlanExclusion();

				camgenPlanExclusion.setCamgenPlan(camgenPlan);
				camgenPlanExclusion.setCategory(exclusionDemandSupplyGroup.getCategoryName());
				camgenPlanExclusion.setReferenceCode(exclusionDemandSupplyGroup.getCategoryValue());
				camgenPlanExclusion.setStarTime(exclusionDemandSupplyGroup.getStartTime());
				camgenPlanExclusion.setEndTime(exclusionDemandSupplyGroup.getEndTime());

				camgenPlanExclusionList.add(camgenPlanExclusion);
			}
		}

		return camgenPlanExclusionList;
	}

	private List<CamgenPlanAutofillingDay> mapUpdateAutoFilling(CamgenPlan camgenPlan,
			List<AutoFillingDaySetup> autoFillingDaySetupList) {

		List<CamgenPlanAutofillingDay> camgenPlanAutofillingDayList = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanAutofillingDays())) {
			camgenPlanAutofillingDayList = camgenPlan.getCamgenPlanAutofillingDays();
			camgenPlanAutofillingDayList.clear();
		} else {
			camgenPlanAutofillingDayList = new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(autoFillingDaySetupList)) {
			for (AutoFillingDaySetup autoFillingDaySetup : autoFillingDaySetupList) {
				camgenPlanAutofillingDayList.add(mapAutoFillingObject(autoFillingDaySetup, camgenPlan));
			}
		}

		return camgenPlanAutofillingDayList;

	}

	private CamgenPlanAutofillingDay mapAutoFillingObject(AutoFillingDaySetup autoFillingDaySetup,
			CamgenPlan camgenPlan) {
		CamgenPlanAutofillingDay camgenPlanAutofillingDay = new CamgenPlanAutofillingDay();

		camgenPlanAutofillingDay.setCamgenPlan(camgenPlan);

		if (null != autoFillingDaySetup.getDuration()) {
			camgenPlanAutofillingDay.setDuration(autoFillingDaySetup.getDuration());
		}

		if (null != autoFillingDaySetup.getOffset()) {
			camgenPlanAutofillingDay.setOffset(new BigDecimal(autoFillingDaySetup.getOffset()));
		}

		camgenPlanAutofillingDay.setRunDay(autoFillingDaySetup.getRunDay().toString());
		camgenPlanAutofillingDay.setStartTime(autoFillingDaySetup.getStartTime());

		return camgenPlanAutofillingDay;
	}

	public CamgenPlan mapCreatePlan(PlansObject plansObject) {
		CamgenPlan camgenPlan = new CamgenPlan();

		camgenPlan.setCreatedBy(securityUtil.getLoginUser());
		camgenPlan.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

		if (null != plansObject.getIterationCount()) {
			camgenPlan.setTotalIteration(new BigDecimal(plansObject.getIterationCount()));
		}

		if (null != plansObject.getChannelSetId()) {
			camgenPlan.setChannelSetId(new BigDecimal(plansObject.getChannelSetId()));
		}

		if (null != plansObject.getDateRange() && null != plansObject.getDateRange().getStart()) {
			camgenPlan.setStartDate(plansObject.getDateRange().getStart().toDate());
		}

		if (null != plansObject.getDateRange() && null != plansObject.getDateRange().getEnd()) {
			camgenPlan.setEndDate(plansObject.getDateRange().getEnd().toDate());
		}

		if (null != plansObject.getChannelSetId()) {
			camgenPlan.setChannelSetId(new BigDecimal(plansObject.getChannelSetId()));
		}

		if (plansObject.getRun()) {
			camgenPlan.setStatus(active);
		} else {
			camgenPlan.setStatus(inActive);
		}

		camgenPlan.setIsSlot(plansObject.getSlot() ? new BigDecimal(1) : new BigDecimal(0));
		camgenPlan.setIsRun(plansObject.getRun() ? new BigDecimal(1) : new BigDecimal(0));

		// map auto filling

		if (!CollectionUtils.isEmpty(plansObject.getAutoFilling())) {
			camgenPlan.setCamgenPlanAutofillingDays(mapAutoFilling(camgenPlan, plansObject.getAutoFilling()));
		}

		// map exclusions

		camgenPlan.setCamgenPlanExclusions(mapPlanExcusions(camgenPlan, plansObject));
		// map demand supply
		if (!CollectionUtils.isEmpty(plansObject.getDemandSupply())) {
			camgenPlan.setCamgenPlanDemandSupplies(mapDemandSupply(camgenPlan, plansObject.getDemandSupply()));
		}

		return camgenPlan;

	}

	private List<CamgenPlanDemandSupply> mapDemandSupply(CamgenPlan camgenPlan,
			List<DemandSupplyGroup> demandSupplyGroupInnerList) {
		List<CamgenPlanDemandSupply> camgenPlanDemandSupplyList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(demandSupplyGroupInnerList)) {
			Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelMap = camgenRepository
					.getAllCamgenDemandSupplyLevelMap();

			for (DemandSupplyGroup demandSupplyGroupInner : demandSupplyGroupInnerList) {
				CamgenPlanDemandSupply camgenPlanDemandSupply = new CamgenPlanDemandSupply();

				camgenPlanDemandSupply.setCamgenPlan(camgenPlan);

				if (null != demandSupplyGroupInner.getAmendmentPercent()) {
					camgenPlanDemandSupply
							.setAmendmentPercentage(new BigDecimal(demandSupplyGroupInner.getAmendmentPercent()));
				}

				setDemandSupplyLevelId(camgenDemandSupplyLevelMap, camgenPlanDemandSupply, demandSupplyGroupInner);

				camgenPlanDemandSupply.setName(demandSupplyGroupInner.getName());
				camgenPlanDemandSupply.setPlanDemandSupplyCriterias(
						mapCriteriaLine(camgenPlanDemandSupply, demandSupplyGroupInner.getCriterias()));

				camgenPlanDemandSupplyList.add(camgenPlanDemandSupply);
			}
		}

		return camgenPlanDemandSupplyList;

	}

	private List<PlanDemandSupplyCriteria> mapCriteriaLine(CamgenPlanDemandSupply camgenPlanDemandSupply,
			List<CriteriaLine> criteriaLineList) {
		List<PlanDemandSupplyCriteria> planDemandSupplyCriteriaList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(criteriaLineList)) {
			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap = camgenRepository
					.getAllCamgenDemandSupplyAttributeMap();

			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = camgenRepository
					.getAllCamgenDemandSupplyConditionMap();

			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = camgenRepository
					.getAllCamgenDemandSupplyObjectMap();

			for (CriteriaLine criteriaLine : criteriaLineList) {
				planDemandSupplyCriteriaList.add(mapCriteriaLineObject(criteriaLine, camgenPlanDemandSupply,
						camgenDemandSupplyObjectMap, camgenDemandSupplyConditionMap, camgenDemandSupplyAttributeMap));
			}
		}

		return planDemandSupplyCriteriaList;

	}

	private PlanDemandSupplyCriteria mapCriteriaLineObject(CriteriaLine criteriaLine,
			CamgenPlanDemandSupply camgenPlanDemandSupply,
			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap,
			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap,
			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap) {
		PlanDemandSupplyCriteria planDemandSupplyCriteria = new PlanDemandSupplyCriteria();

		planDemandSupplyCriteria.setCamgenPlanDemandSupply(camgenPlanDemandSupply);

		setDemandSupplyAttribute(planDemandSupplyCriteria, camgenDemandSupplyAttributeMap, criteriaLine);

		setDemandSupplyCondition(planDemandSupplyCriteria, camgenDemandSupplyConditionMap, criteriaLine);

		setDemandSupplyObject(planDemandSupplyCriteria, camgenDemandSupplyObjectMap, criteriaLine);
		if(null != criteriaLine.getOperator()){
		planDemandSupplyCriteria.setOperator(criteriaLine.getOperator().toString());
		}
		planDemandSupplyCriteria.setValue(criteriaLine.getValue());

		return planDemandSupplyCriteria;
	}

	private void setDemandSupplyObject(PlanDemandSupplyCriteria planDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap, CriteriaLine criteriaLine) {
		if (null != criteriaLine.getObjectId() && camgenDemandSupplyObjectMap.containsKey(criteriaLine.getObjectId())) {
			planDemandSupplyCriteria
					.setCamgenDemandSupplyObject(camgenDemandSupplyObjectMap.get(criteriaLine.getObjectId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}

	private void setDemandSupplyCondition(PlanDemandSupplyCriteria planDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap, CriteriaLine criteriaLine) {
		if (null != criteriaLine.getConditionId()
				&& camgenDemandSupplyConditionMap.containsKey(criteriaLine.getConditionId())) {
			planDemandSupplyCriteria
					.setCamgenDemandSupplyCondition(camgenDemandSupplyConditionMap.get(criteriaLine.getConditionId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}

	private void setDemandSupplyAttribute(PlanDemandSupplyCriteria planDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap, CriteriaLine criteriaLine) {

		if (null != criteriaLine.getAttributeId()
				&& camgenDemandSupplyAttributeMap.containsKey(criteriaLine.getAttributeId())) {
			planDemandSupplyCriteria
					.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttributeMap.get(criteriaLine.getAttributeId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}

	}

	private List<CamgenPlanExclusion> mapPlanExcusions(CamgenPlan camgenPlan, PlansObject plansRequest) {
		List<CamgenPlanExclusion> camgenPlanExclusionList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(plansRequest.getExclusions())) {
			for (ExclusionDemandSupplyGroup exclusionDemandSupplyGroup : plansRequest.getExclusions()) {
				CamgenPlanExclusion camgenPlanExclusion = new CamgenPlanExclusion();

				camgenPlanExclusion.setCamgenPlan(camgenPlan);
				camgenPlanExclusion.setCategory(exclusionDemandSupplyGroup.getCategoryName());
				camgenPlanExclusion.setReferenceCode(exclusionDemandSupplyGroup.getCategoryValue());
				camgenPlanExclusion.setStarTime(exclusionDemandSupplyGroup.getStartTime());
				camgenPlanExclusion.setEndTime(exclusionDemandSupplyGroup.getEndTime());
				
				camgenPlanExclusionList.add(camgenPlanExclusion);
			}
		}

		return camgenPlanExclusionList;
	}

	private List<CamgenPlanAutofillingDay> mapAutoFilling(CamgenPlan camgenPlan,
			List<AutoFillingDaySetup> autoFillingDaySetupList) {
		List<CamgenPlanAutofillingDay> camgenPlanAutofillingDayList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(autoFillingDaySetupList)) {
			for (AutoFillingDaySetup autoFillingDaySetup : autoFillingDaySetupList) {
				camgenPlanAutofillingDayList.add(mapAutoFillingObject(autoFillingDaySetup, camgenPlan));
			}
		}

		return camgenPlanAutofillingDayList;

	}

	public List<PlansObject> getPlansObject(List<CamgenPlan> camgenPlanList, Boolean includeDemandSupply,
			Boolean includeExclussions) {
		List<PlansObject> plansObjectList = new ArrayList<>();
		for (CamgenPlan camgenPlan : camgenPlanList) {
			PlansObject plansObject = new PlansObject();
			plansObject.setPlanId((int) camgenPlan.getPlanId());
			plansObject.setCreatedBy(camgenPlan.getCreatedBy());

			if (null != camgenPlan.getCreatedOn()) {
				plansObject.setCreatedDateTime(new DateTime(camgenPlan.getCreatedOn()));
			}

			plansObject.setIterationCount(camgenPlan.getTotalIteration().intValue());
			plansObject.setChannelSetId(
					camgenPlan.getChannelSetId() == null ? null : camgenPlan.getChannelSetId().intValue());

			StartEndDate startEndDate = new StartEndDate();

			if (null != camgenPlan.getStartDate()) {
				startEndDate.setStart(new DateTime(camgenPlan.getStartDate()));
			}

			if (null != camgenPlan.getEndDate()) {
				startEndDate.setEnd(new DateTime(camgenPlan.getEndDate()));
			}

			plansObject.setDateRange(startEndDate);

			if (null != camgenPlan.getIsRun()) {
				plansObject.setRun(camgenPlan.getIsRun().intValue() != 0 ? true : false);
			}
			if (null != camgenPlan.getIsSlot()) {
				plansObject.setSlot(camgenPlan.getIsSlot().intValue() != 0 ? true : false);
			}

			plansObject.setAutoFilling(getAutoFillingDaySetup(camgenPlan));

			if (null != includeDemandSupply && includeDemandSupply) {
				plansObject.setDemandSupply(mapCamgenPlanDemandSupply(camgenPlan));
			}

			if (null != includeExclussions && includeExclussions) {
				plansObject.setExclusions(mapExclusions(camgenPlan));
			}

			plansObjectList.add(plansObject);
		}
		return plansObjectList;
	}

	private Exclusions mapExclusions(CamgenPlan camgenPlan) {
		Exclusions exclusions = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanExclusions())) {
			exclusions = new Exclusions();
			for (CamgenPlanExclusion camgenPlanExclusion : camgenPlan.getCamgenPlanExclusions()) {
				ExclusionDemandSupplyGroup exclusionDemandSupplyGroup = new ExclusionDemandSupplyGroup();
				exclusionDemandSupplyGroup.setCategoryId((int) camgenPlanExclusion.getCamgenPlanExclusionId());
				exclusionDemandSupplyGroup.setCategoryName(camgenPlanExclusion.getCategory());
				exclusionDemandSupplyGroup.setCategoryValue(camgenPlanExclusion.getReferenceCode());
				exclusionDemandSupplyGroup.setStartTime(camgenPlanExclusion.getStarTime());
				exclusionDemandSupplyGroup.setEndTime(camgenPlanExclusion.getEndTime());
				
				exclusions.add(exclusionDemandSupplyGroup);

			}
		}

		return exclusions;
	}

	private List<DemandSupplyGroup> mapCamgenPlanDemandSupply(CamgenPlan camgenPlan) {
		List<DemandSupplyGroup> demandSupply = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanDemandSupplies())) {
			demandSupply = new ArrayList<>();

			for (CamgenPlanDemandSupply camgenPlanDemandSupply : camgenPlan.getCamgenPlanDemandSupplies()) {
				DemandSupplyGroup demandSupplyGroupInner = new DemandSupplyGroup();
				demandSupplyGroupInner.setDemandSupplyId((int) camgenPlanDemandSupply.getDemandSupplyId());
				demandSupplyGroupInner.setName(camgenPlanDemandSupply.getName());

				if (null != camgenPlanDemandSupply.getCamgenDemandSupplyLevel()) {
					demandSupplyGroupInner
							.setLevelId(camgenPlanDemandSupply.getCamgenDemandSupplyLevel().getDemandSupplyLevelId());
					demandSupplyGroupInner.setLevelCode(LevelCodeEnum
							.valueOf(camgenPlanDemandSupply.getCamgenDemandSupplyLevel().getDemandSupplyLevelCode()));
				}

				demandSupplyGroupInner.setAmendmentPercent(camgenPlanDemandSupply.getAmendmentPercentage() != null
						? camgenPlanDemandSupply.getAmendmentPercentage().doubleValue() : null);
				demandSupplyGroupInner.setCriterias(
						getPlanDemandSupplyCriterias(camgenPlanDemandSupply.getPlanDemandSupplyCriterias()));
				demandSupply.add(demandSupplyGroupInner);
			}
		}

		return demandSupply;
	}

	private List<AutoFillingDaySetup> getAutoFillingDaySetup(CamgenPlan camgenPlan) {
		List<AutoFillingDaySetup> autoFilling = null;

		if (!CollectionUtils.isEmpty(camgenPlan.getCamgenPlanAutofillingDays())) {
			autoFilling = new ArrayList<>();
			for (CamgenPlanAutofillingDay camgenPlanAutofillingDay : camgenPlan.getCamgenPlanAutofillingDays()) {
				AutoFillingDaySetup autoFillingDaySetup = new AutoFillingDaySetup();
				autoFillingDaySetup.setRunDay(camgenPlanAutofillingDay.getRunDay() != null
						? RunDayEnum.fromValue(camgenPlanAutofillingDay.getRunDay()) : null);
				autoFillingDaySetup.setOffset(camgenPlanAutofillingDay.getOffset() != null
						? camgenPlanAutofillingDay.getOffset().longValue() : null);
				autoFillingDaySetup.setDuration(camgenPlanAutofillingDay.getDuration());
				autoFillingDaySetup.setStartTime(camgenPlanAutofillingDay.getStartTime());
				autoFilling.add(autoFillingDaySetup);
			}
		}

		return autoFilling;
	}

	private List<CriteriaLine> getPlanDemandSupplyCriterias(
			List<PlanDemandSupplyCriteria> planDemandSuplyCriteriaList) {

		List<CriteriaLine> criteriaLineList = null;

		if (!CollectionUtils.isEmpty(planDemandSuplyCriteriaList)) {
			criteriaLineList = new ArrayList<>();
			for (PlanDemandSupplyCriteria planDemandSupplyCriteria : planDemandSuplyCriteriaList) {
				CriteriaLine criteriaLine = new CriteriaLine();
				criteriaLine.setCriteriaLineId(planDemandSupplyCriteria.getPlanDemandSupplyCriteriaId());

				if (null != planDemandSupplyCriteria.getOperator()) {
					criteriaLine.setOperator(OperatorEnum.valueOf(planDemandSupplyCriteria.getOperator()));
				}

				if (null != planDemandSupplyCriteria.getCamgenDemandSupplyAttribute()) {
					criteriaLine.setAttributeId(
							planDemandSupplyCriteria.getCamgenDemandSupplyAttribute().getDemandSupplyAttributeId());
					criteriaLine.setAttributeCode(
							planDemandSupplyCriteria.getCamgenDemandSupplyAttribute().getDemandSupplyAttributeCode());
				}

				if (null != planDemandSupplyCriteria.getCamgenDemandSupplyCondition()) {
					criteriaLine.setConditionId(
							planDemandSupplyCriteria.getCamgenDemandSupplyCondition().getDemandSupplyConditionId());
					criteriaLine.setConditionCode(
							planDemandSupplyCriteria.getCamgenDemandSupplyCondition().getDemandSupplyConditionCode());
				}

				if (null != planDemandSupplyCriteria.getCamgenDemandSupplyObject()) {
					criteriaLine.setObjectId(
							planDemandSupplyCriteria.getCamgenDemandSupplyObject().getDemandSupplyObjectId());
					criteriaLine.setObjectCode(
							planDemandSupplyCriteria.getCamgenDemandSupplyObject().getDemandSupplyObjectCode());
				}

				criteriaLine.setValue(planDemandSupplyCriteria.getValue());
				criteriaLineList.add(criteriaLine);
			}
		}

		return criteriaLineList;

	}

	public List<PlanSummary> mapEntityListToCamgenPlan(List<CamgenPlan> camgenPlanList) {

		List<PlanSummary> planSummaryList = new ArrayList<>();
		for (CamgenPlan camgenPlan : camgenPlanList) {
			PlanSummary planSummary = new PlanSummary();
			planSummary.setPlanId((int) camgenPlan.getPlanId());
			if (camgenPlan.getStartDate() != null) {
				planSummary.setRunStartDate(new LocalDate(camgenPlan.getStartDate()));
			}
			if (camgenPlan.getEndDate() != null) {
				planSummary.setRunEndDate(new LocalDate(camgenPlan.getEndDate()));
			}

			if (null != camgenPlan.getChannelSetId()) {
				planSummary.setChannelSetId(camgenPlan.getChannelSetId().longValue());
			}

			if (null != camgenPlan.getTotalIteration()) {
				planSummary.setIteration(camgenPlan.getTotalIteration().intValue());
			}
			if (camgenPlan.getIsRun() != null) {
				planSummary.setRun(BooleanUtils.toBoolean(Integer.parseInt(camgenPlan.getIsRun().toString())));
			}
			if (camgenPlan.getIsSlot() != null) {
				planSummary.setSlot(BooleanUtils.toBoolean(Integer.parseInt(camgenPlan.getIsSlot().toString())));
			}
			planSummary.setCreatedBy(camgenPlan.getCreatedBy());
			planSummary.setStatus(camgenPlan.getStatus());

			planSummaryList.add(planSummary);
		}

		return planSummaryList;
	}

}
