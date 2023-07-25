/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyAttributeJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyConditionJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyObjectJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBreakExclIncl;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstClimExclIncl;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RqstDemandSupplyCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRequestBreakExclIncl;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRequestCMExclIncl;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The class CamgenParameterMapper is the mapper class for handling common CamgenParameter operations.
 *
 * @author HCL
 */
@Component
public class CamgenParameterMapper {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenParameterMapper.class);

	/** The date time utility. */
	@Autowired
	private DateTimeUtility dateTimeUtility;

	/** The camgen repository. */
	@Autowired
	private CamgenRepository camgenRepository;
	
	/** The security util. */
	@Autowired
	private SecurityUtil securityUtil;

	private static final String MANUAL = "Manual";

	private static final String AUTO = "Auto";
	
	@Autowired
	private CamgenDemandSupplyAttributeJpaRepository camgenDemandSupplyAttributeJpaRepository;

	@Autowired
	private CamgenDemandSupplyConditionJpaRepository camgenDemandSupplyConditionJpaRepository;

	@Autowired
	private CamgenDemandSupplyObjectJpaRepository camgenDemandSupplyObjectJpaRepository;

	@Autowired
	private CamgenDemandSupplyLevelJpaRepository camgenDemandSupplyLevelJpaRepository;
	
	@Autowired
	private CamgenPlanJpaRepository camgenPlanJpaRepository;

	/**
	 * Map camgen parameter mapper.
	 *
	 * @param camgenParam the camgen param
	 * @param camgenParameter the camgen parameter
	 * @return CamgenParameter
	 */
	public CamgenParameter mapCamgenParameterMapper(CamgenParam camgenParam, CamgenParameter camgenParameter) {
		camgenParameter.setDescription(camgenParam.getRemarks());
		camgenParameter.setParameterName(camgenParam.getParameter());
		camgenParameter.setValue(camgenParam.getValue());
		camgenParameter.setDisplaySequenceNumber(new BigDecimal(camgenParam.getViewOrder()));

		return camgenParameter;
	}

	/**
	 * Map camgen param extracts.
	 *
	 * @param camgenParameterList the camgen parameter list
	 * @return CamgenParameters
	 */
	public CamgenParameters mapCamgenParamExtracts(List<CamgenParameter> camgenParameterList) {

		CamgenParameters camgenParameters = new CamgenParameters();

		for (CamgenParameter camgenParameter : camgenParameterList) {

			CamgenParam camgenParam = new CamgenParam();

			camgenParam.setCreatedBy(camgenParameter.getCreatedBy());
			camgenParam.setId(camgenParameter.getParameterId());
			camgenParam.setParameter(camgenParameter.getParameterName());
			camgenParam.setRemarks(camgenParameter.getDescription());
			camgenParam.setValue(camgenParameter.getValue());
			camgenParam.setViewOrder(camgenParameter.getDisplaySequenceNumber().intValue());

			camgenParameters.add(camgenParam);
		}
		return camgenParameters;
	}

	/**
	 * Map camgen request for update.
	 *
	 * @param camgenRequest the camgen request
	 * @param snapshots the snapshots
	 * @return CamgenRequest
	 */
	public CamgenRequest mapCamgenRequestForUpdate(CamgenRequest camgenRequest, SnapshotDetail snapshots) {

		if (null != snapshots.getChannelSet()){
			camgenRequest.setChannelSetId(new BigDecimal(snapshots.getChannelSet()));
		}

		camgenRequest.setModifiedBy(securityUtil.getLoginUser());
		camgenRequest.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

		if(null != snapshots.getCamgenRequestStartDate()){
			camgenRequest.setStartDate(snapshots.getCamgenRequestStartDate().toDate());
		}
		if(null != snapshots.getCamgenRequestEndDate()){
			camgenRequest.setEndDate(snapshots.getCamgenRequestEndDate().toDate());
		}
		camgenRequest.setCamgenRqstDemandSupplies(mapDemandSupply(snapshots, camgenRequest));

		camgenRequest.setCamgenRqstBatchTxLevels(getCamgenRqstBatchTxLevels(snapshots, camgenRequest));

		camgenRequest.setCamgenRqstChSetTimebands(getCamgenRqstChSetTimeband(snapshots, camgenRequest));

		camgenRequest.setCamgenRqstBreakExclIncls(getCamgenRqstBreakExclIncls(snapshots,camgenRequest));
		
		camgenRequest.setCamgenRqstClimExclIncls(getCamgenRqstClimExclIncls(snapshots,camgenRequest));
		
		if (null != snapshots.getIterationCount()){
			camgenRequest.setTotalIteration(new BigDecimal(snapshots.getIterationCount()));
		}
		if (null != snapshots.getRun()){
			Boolean run = snapshots.getRun();
			BigDecimal isRun = run ? new BigDecimal(1) : new BigDecimal(0);
			camgenRequest.setIsRun(isRun);
		}
		if (null != snapshots.getSlot()){
			Boolean slot = snapshots.getSlot();
			BigDecimal isSlot = slot ? new BigDecimal(1) : new BigDecimal(0);
			camgenRequest.setIsSlot(isSlot);
		}
		if (null != snapshots.getStatus()){
			camgenRequest.setStatus(snapshots.getStatus());
		}
		if (null != snapshots.getType()){
			camgenRequest.setRequestType(snapshots.getType());
		}
		
		if (null != snapshots.getScheduledDateTime()){
			camgenRequest.setScheduleDateTime(snapshots.getScheduledDateTime().toDate());
		}
		return camgenRequest;
	}

	/**
	 * Gets the camgen rqst ch set timeband.
	 *
	 * @param snapshots the snapshots
	 * @param camgenRequest the camgen request
	 * @return List<CamgenRqstChSetTimeband>
	 */
	private List<CamgenRqstChSetTimeband> getCamgenRqstChSetTimeband(SnapshotDetail snapshots,
			CamgenRequest camgenRequest) {
		List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList = camgenRequest.getCamgenRqstChSetTimebands();
		if (!CollectionUtils.isEmpty(snapshots.getChannelSetTimebands())) {

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstChSetTimebands())) {
				camgenRqstChSetTimebandList = camgenRequest.getCamgenRqstChSetTimebands();
				camgenRqstChSetTimebandList.clear();
			}

			for (ChannelSetTimeBand timeBand : snapshots.getChannelSetTimebands()) {
				CamgenRqstChSetTimeband camgenRqstChSetTimeband = new CamgenRqstChSetTimeband();
				camgenRqstChSetTimeband.setCamgenRequest(camgenRequest);
				camgenRqstChSetTimeband.setTimeband(timeBand.getName());
				camgenRqstChSetTimeband.setApplicableDay(timeBand.getDay());
				camgenRqstChSetTimeband.setStartTime(timeBand.getStartTime());
				camgenRqstChSetTimeband.setEndTime(timeBand.getEndTime());
				camgenRqstChSetTimeband.setAvailabilityPercentage(BigDecimal.valueOf(timeBand.getAvailability()));
				
				camgenRqstChSetTimeband.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
				camgenRqstChSetTimeband.setModifiedBy(securityUtil.getLoginUser());
				camgenRqstChSetTimebandList.add(camgenRqstChSetTimeband);
			}
		}
		return camgenRqstChSetTimebandList;
	}

	/**
	 * Gets the camgen rqst batch tx levels.
	 *
	 * @param snapshots the snapshots
	 * @param camgenRequest the camgen request
	 * @return List<CamgenRqstBatchTxLevel>
	 */
	private List<CamgenRqstBatchTxLevel> getCamgenRqstBatchTxLevels(SnapshotDetail snapshots,
			CamgenRequest camgenRequest) {
		List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList = camgenRequest.getCamgenRqstBatchTxLevels();

		if (!CollectionUtils.isEmpty(snapshots.getBatchTxLevels())) {

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstBatchTxLevels())) {
				camgenRqstBatchTxLevelList = camgenRequest.getCamgenRqstBatchTxLevels();
				camgenRqstBatchTxLevelList.clear();
			}

			for (BatchTxLevel txLevel : snapshots.getBatchTxLevels()) {
				CamgenRqstBatchTxLevel camgenRqstBatchTxLevel = new CamgenRqstBatchTxLevel();
				camgenRqstBatchTxLevel.setBatchValue(BigDecimal.valueOf(txLevel.getBatchTxLevelValue()));
				camgenRqstBatchTxLevel.setCamgenRequest(camgenRequest);
				camgenRqstBatchTxLevel.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				camgenRqstBatchTxLevel.setCreatedBy(snapshots.getCreatedBy());
				camgenRqstBatchTxLevel.setTransmissionLevelId(BigDecimal.valueOf(txLevel.getTxLevelId()));
				camgenRqstBatchTxLevelList.add(camgenRqstBatchTxLevel);
			}
		}
		return camgenRqstBatchTxLevelList;
	}

	/**
	 * Map demand supply.
	 *
	 * @param snapshots the snapshots
	 * @param camgenRequest the camgen request
	 * @return List<CamgenRqstDemandSupply>
	 */
	private List<CamgenRqstDemandSupply> mapDemandSupply(SnapshotDetail snapshots, CamgenRequest camgenRequest) {
		List<CamgenRqstDemandSupply> camgenRqstDemandSupplyList = camgenRequest.getCamgenRqstDemandSupplies();

		if (!CollectionUtils.isEmpty(snapshots.getDemandSupply())) {
			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstDemandSupplies())) {
				camgenRqstDemandSupplyList = camgenRequest.getCamgenRqstDemandSupplies();
				camgenRqstDemandSupplyList.clear();
			}

			Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelMap = camgenRepository
					.getAllCamgenDemandSupplyLevelMap();

			for (DemandSupplyGroup demandSupplyGroupInner : snapshots.getDemandSupply()) {
				CamgenRqstDemandSupply camgenRqstDemandSupply = new CamgenRqstDemandSupply();

				camgenRqstDemandSupply.setCamgenRequest(camgenRequest);

				if (null != demandSupplyGroupInner.getAmendmentPercent()) {
					camgenRqstDemandSupply
							.setAmendmentPercentage(new BigDecimal(demandSupplyGroupInner.getAmendmentPercent()));
				}
				setDemandSupplyLevelId(camgenDemandSupplyLevelMap, camgenRqstDemandSupply, demandSupplyGroupInner);

				camgenRqstDemandSupply.setName(demandSupplyGroupInner.getName());
				camgenRqstDemandSupply.setRqstDemandSupplyCriterias(
						mapCriteriaList(camgenRqstDemandSupply, demandSupplyGroupInner.getCriterias()));

				camgenRqstDemandSupplyList.add(camgenRqstDemandSupply);
			}

		}

		return camgenRqstDemandSupplyList;

	}

	/**
	 * Sets the demand supply level id.
	 *
	 * @param camgenDemandSupplyLevelMap the camgen demand supply level map
	 * @param camgenRqstDemandSupply the camgen rqst demand supply
	 * @param demandSupplyGroupInner the demand supply group inner
	 */
	private void setDemandSupplyLevelId(Map<Long, CamgenDemandSupplyLevel> camgenDemandSupplyLevelMap,
			CamgenRqstDemandSupply camgenRqstDemandSupply, DemandSupplyGroup demandSupplyGroupInner) {
		if (null != demandSupplyGroupInner.getLevelId()
				&& camgenDemandSupplyLevelMap.containsKey(demandSupplyGroupInner.getLevelId())) {
			camgenRqstDemandSupply
					.setCamgenDemandSupplyLevel(camgenDemandSupplyLevelMap.get(demandSupplyGroupInner.getLevelId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}


	/**
	 * Map criteria list.
	 *
	 * @param camgenRqstDemandSupply the camgen rqst demand supply
	 * @param criteriaLineList the criteria line list
	 * @return List<RqstDemandSupplyCriteria>
	 */
	private List<RqstDemandSupplyCriteria> mapCriteriaList(CamgenRqstDemandSupply camgenRqstDemandSupply,
			List<CriteriaLine> criteriaLineList) {
		List<RqstDemandSupplyCriteria> rqstDemandSupplyCriteriaList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(criteriaLineList)) {
			if (!CollectionUtils.isEmpty(camgenRqstDemandSupply.getRqstDemandSupplyCriterias())) {
				rqstDemandSupplyCriteriaList = camgenRqstDemandSupply.getRqstDemandSupplyCriterias();
				rqstDemandSupplyCriteriaList.clear();
			}

			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap = camgenRepository
					.getAllCamgenDemandSupplyAttributeMap();

			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap = camgenRepository
					.getAllCamgenDemandSupplyConditionMap();

			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap = camgenRepository
					.getAllCamgenDemandSupplyObjectMap();

			for (CriteriaLine criteriaLine : criteriaLineList) {
				RqstDemandSupplyCriteria rqstDemandSupplyCriteria = new RqstDemandSupplyCriteria();

				rqstDemandSupplyCriteria.setCamgenRqstDemandSupply(camgenRqstDemandSupply);

				setDemandSupplyAttribute(rqstDemandSupplyCriteria, camgenDemandSupplyAttributeMap, criteriaLine);

				setDemandSupplyCondition(rqstDemandSupplyCriteria, camgenDemandSupplyConditionMap, criteriaLine);

				setDemandSupplyObject(rqstDemandSupplyCriteria, camgenDemandSupplyObjectMap, criteriaLine);

				rqstDemandSupplyCriteria.setOperator(criteriaLine.getOperator().toString());
				rqstDemandSupplyCriteria.setValue(criteriaLine.getValue());

				rqstDemandSupplyCriteriaList.add(rqstDemandSupplyCriteria);
			}
		}

		return rqstDemandSupplyCriteriaList;
	}

	/**
	 * Sets the demand supply object.
	 *
	 * @param rqstDemandSupplyCriteria the rqst demand supply criteria
	 * @param camgenDemandSupplyObjectMap the camgen demand supply object map
	 * @param criteriaLine the criteria line
	 */
	private void setDemandSupplyObject(RqstDemandSupplyCriteria rqstDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyObject> camgenDemandSupplyObjectMap, CriteriaLine criteriaLine) {
		if (null != criteriaLine.getObjectId() && camgenDemandSupplyObjectMap.containsKey(criteriaLine.getObjectId())) {
			rqstDemandSupplyCriteria
					.setCamgenDemandSupplyObject(camgenDemandSupplyObjectMap.get(criteriaLine.getObjectId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}

	/**
	 * Sets the demand supply condition.
	 *
	 * @param rqstDemandSupplyCriteria the rqst demand supply criteria
	 * @param camgenDemandSupplyConditionMap the camgen demand supply condition map
	 * @param criteriaLine the criteria line
	 */
	private void setDemandSupplyCondition(RqstDemandSupplyCriteria rqstDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyCondition> camgenDemandSupplyConditionMap, CriteriaLine criteriaLine) {
		if (null != criteriaLine.getConditionId()
				&& camgenDemandSupplyConditionMap.containsKey(criteriaLine.getConditionId())) {
			rqstDemandSupplyCriteria
					.setCamgenDemandSupplyCondition(camgenDemandSupplyConditionMap.get(criteriaLine.getConditionId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
	}

	/**
	 * Sets the demand supply attribute.
	 *
	 * @param rqstDemandSupplyCriteria the rqst demand supply criteria
	 * @param camgenDemandSupplyAttributeMap the camgen demand supply attribute map
	 * @param criteriaLine the criteria line
	 */
	private void setDemandSupplyAttribute(RqstDemandSupplyCriteria rqstDemandSupplyCriteria,
			Map<Long, CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeMap, CriteriaLine criteriaLine) {

		if (null != criteriaLine.getAttributeId()
				&& camgenDemandSupplyAttributeMap.containsKey(criteriaLine.getAttributeId())) {
			rqstDemandSupplyCriteria
					.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttributeMap.get(criteriaLine.getAttributeId()));
		} else {
			LOGGER.error(AutomatedSpotConstants.BAD_REQUEST);
			throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}

	}
	/**
	 * Gets the camgen rqst break excl incls.
	 *
	 * @param snapshots the snapshots
	 * @param camgenRequest the camgen request
	 * @return List<CamgenRqstBreakExclIncl>
	 */
	private List<CamgenRqstBreakExclIncl> getCamgenRqstBreakExclIncls(SnapshotDetail snapshots,
			CamgenRequest camgenRequest) {
		List<CamgenRqstBreakExclIncl> camgenRqstBreakExclInclList = camgenRequest.getCamgenRqstBreakExclIncls();
		if (!CollectionUtils.isEmpty(snapshots.getCommercialBreakInclExcls())) {
			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstBreakExclIncls())) {
				camgenRqstBreakExclInclList = camgenRequest.getCamgenRqstBreakExclIncls();
				camgenRqstBreakExclInclList.clear();
			}
			for (CamgenRequestBreakExclIncl camgenRequestBreakExclIncl : snapshots.getCommercialBreakInclExcls()) {
				CamgenRqstBreakExclIncl camgenRqstBreakExclIncl = new CamgenRqstBreakExclIncl();
				camgenRqstBreakExclIncl.setCamgenRequest(camgenRequest);
				if(null != camgenRequestBreakExclIncl.getCommercialBreakId()){ 
					camgenRqstBreakExclIncl.setCommercialBreakId(new BigDecimal(camgenRequestBreakExclIncl.getCommercialBreakId()));
				}
				camgenRqstBreakExclIncl.setModifiedBy(securityUtil.getLoginUser());
				camgenRqstBreakExclIncl.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
				if(null != camgenRequestBreakExclIncl.isIsExcluded()){
					camgenRqstBreakExclIncl.setIsExcluded(camgenRequestBreakExclIncl.isIsExcluded() ? new BigDecimal(1) : new BigDecimal(0));
				}
				camgenRqstBreakExclInclList.add(camgenRqstBreakExclIncl);
			}
		}
		return camgenRqstBreakExclInclList;
	}	

	/**
	 * Gets the camgen rqst clim excl incls.
	 *
	 * @param snapshots the snapshots
	 * @param camgenRequest the camgen request
	 * @return List<CamgenRqstClimExclIncl>
	 */
	private List<CamgenRqstClimExclIncl> getCamgenRqstClimExclIncls(SnapshotDetail snapshots,
			CamgenRequest camgenRequest) {
		List<CamgenRqstClimExclIncl> camgenRqstClimExclInclList = camgenRequest.getCamgenRqstClimExclIncls();
		if (!CollectionUtils.isEmpty(snapshots.getCampaignMonthInclExcls())) {
			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstClimExclIncls())) {
				camgenRqstClimExclInclList = camgenRequest.getCamgenRqstClimExclIncls();
				camgenRqstClimExclInclList.clear();
			}
			for (CamgenRequestCMExclIncl camgenRequestCMExclIncl : snapshots.getCampaignMonthInclExcls()) {
				CamgenRqstClimExclIncl camgenRqstClimExclIncl = new CamgenRqstClimExclIncl();
				camgenRqstClimExclIncl.setCamgenRequest(camgenRequest);
				if (null != camgenRequestCMExclIncl.getCmId()) {
					camgenRqstClimExclIncl.setCampaignLineMonthId(new BigDecimal(camgenRequestCMExclIncl.getCmId()));
				}
				camgenRqstClimExclIncl.setCreatedBy(camgenRequest.getCreatedBy());
				camgenRqstClimExclIncl.setCreatedOn(camgenRequest.getCreatedOn());
				if (null != camgenRequestCMExclIncl.isIsExcluded()) {
					camgenRqstClimExclIncl.setIsExcluded(
							camgenRequestCMExclIncl.isIsExcluded() ? new BigDecimal(1) : new BigDecimal(0));
				}
				camgenRqstClimExclIncl.setModifiedBy(securityUtil.getLoginUser());
				camgenRqstClimExclIncl.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
				camgenRqstClimExclInclList.add(camgenRqstClimExclIncl);
			}
		}
		return camgenRqstClimExclInclList;
	}
	
	
	
	
	public CamgenRequest mapCreateSnapshot(SnapshotDetail snapshot) {
		CamgenRequest camgetReq = new CamgenRequest();
		if (null != snapshot.getChannelSet()) {
			camgetReq.setChannelSetId(BigDecimal.valueOf(snapshot.getChannelSet()));
		}
		camgetReq.setRequestType(snapshot.getType());
		camgetReq.setStatus(snapshot.getStatus());
		
		if(null != snapshot.getPlanId()){
			camgetReq.setCamgenPlan(getCamgenPlan(snapshot.getPlanId()));
		}
		
		camgetReq.setCamgenRqstBatchTxLevels(
				mapcamgenRqstBatchTxLevelsForCreate(snapshot.getBatchTxLevels(), camgetReq));
		camgetReq.setCamgenRqstChSetTimebands(
				mapCamgenRqstChSetTimebandsForCreate(snapshot.getChannelSetTimebands(), camgetReq));
		camgetReq.setCamgenRqstDemandSupplies(
				mapCamgenRqstDemandSuppliesForCreate(snapshot.getDemandSupply(), camgetReq));
		camgetReq.setCamgenRqstBreakExclIncls(
				mapCamgenRqstBreakExclInclsForcreate(snapshot.getCommercialBreakInclExcls(), camgetReq));
		camgetReq.setCamgenRqstClimExclIncls(
				mapcamgenRqstClimExclInclsForCreate(snapshot.getCampaignMonthInclExcls(), camgetReq));
		if (null != snapshot.getChannelSet()) {
			camgetReq.setChannelSetId(BigDecimal.valueOf(snapshot.getChannelSet()));
		}

		if (null != snapshot.getCamgenRequestEndDate()) {
			camgetReq.setEndDate(snapshot.getCamgenRequestEndDate().toDate());
		}
		camgetReq.setIsRun(getRun(snapshot.getRun()));
		camgetReq.setIsSlot(getSlot(snapshot.getSlot()));

		camgetReq.setRequestType(snapshot.getType());
		if (null != snapshot.getCamgenRequestStartDate()) {
			camgetReq.setStartDate(snapshot.getCamgenRequestStartDate().toDate());
		}
		camgetReq.setStatus(snapshot.getStatus());

		if (null != snapshot.getIterationCount()) {
			camgetReq.setTotalIteration(BigDecimal.valueOf(snapshot.getIterationCount()));
		}

		if (null != snapshot.getCamgenRequestStartDate()) {
			camgetReq.setStartDate(Date.valueOf(snapshot.getCamgenRequestStartDate().toString()));
		}
		if (null != snapshot.getCamgenRequestEndDate()) {
			camgetReq.setEndDate(Date.valueOf(snapshot.getCamgenRequestEndDate().toString()));
		}
		if (null != snapshot.getScheduledDateTime()){
			camgetReq.setScheduleDateTime(snapshot.getScheduledDateTime().toDate());
		}
		if(null != snapshot.getFillingStartDate()){
			camgetReq.setFillingStartDate(Date.valueOf(snapshot.getFillingStartDate().toString()));
		}
		if(null != snapshot.getFillingEndDate()){
			camgetReq.setFillingEndDate(Date.valueOf(snapshot.getFillingEndDate().toString()));
		}
		camgetReq.setCreatedBy(securityUtil.getLoginUser());
		camgetReq.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
		return camgetReq;
	}
	
	private List<CamgenRqstBatchTxLevel> mapcamgenRqstBatchTxLevelsForCreate(List<BatchTxLevel> batchTxLevelList,
			CamgenRequest camgenReq) {
		List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(batchTxLevelList)) {
			for (BatchTxLevel batchTxLevelobj : batchTxLevelList) {
				CamgenRqstBatchTxLevel camgenRqstBatchTxLevelObj = new CamgenRqstBatchTxLevel();
				if (null != batchTxLevelobj.getBatchTxLevelValue()) {
					camgenRqstBatchTxLevelObj.setBatchValue(BigDecimal.valueOf(batchTxLevelobj.getBatchTxLevelValue()));
				}
				camgenRqstBatchTxLevelObj.setCamgenRequest(camgenReq);
				camgenRqstBatchTxLevelObj.setCreatedBy(securityUtil.getLoginUser());
				camgenRqstBatchTxLevelObj.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
				if (null != batchTxLevelobj.getTxLevelId()) {
					camgenRqstBatchTxLevelObj
							.setTransmissionLevelId(BigDecimal.valueOf(batchTxLevelobj.getTxLevelId()));
				}
				camgenRqstBatchTxLevelList.add(camgenRqstBatchTxLevelObj);
			}
		}
		return camgenRqstBatchTxLevelList;
	}

	private List<CamgenRqstChSetTimeband> mapCamgenRqstChSetTimebandsForCreate(List<ChannelSetTimeBand> channelSetTimeBands,
			CamgenRequest camgenRequest) {
		List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList = new ArrayList<>();
		if (null != channelSetTimeBands) {
			for (ChannelSetTimeBand channelSetTimeBandObj : channelSetTimeBands) {
				CamgenRqstChSetTimeband camgenRqstChSetTimeband = new CamgenRqstChSetTimeband();
				camgenRqstChSetTimeband.setApplicableDay(channelSetTimeBandObj.getDay());
				if (null != channelSetTimeBandObj.getAvailability()) {
					camgenRqstChSetTimeband
							.setAvailabilityPercentage(BigDecimal.valueOf(channelSetTimeBandObj.getAvailability()));
				}
				camgenRqstChSetTimeband.setCamgenRequest(camgenRequest);
				camgenRqstChSetTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
				camgenRqstChSetTimeband.setEndTime(channelSetTimeBandObj.getEndTime());
				camgenRqstChSetTimeband.setStartTime(channelSetTimeBandObj.getStartTime());
				camgenRqstChSetTimeband.setCreatedBy(securityUtil.getLoginUser());
				camgenRqstChSetTimeband.setTimeband(channelSetTimeBandObj.getName());
				camgenRqstChSetTimebandList.add(camgenRqstChSetTimeband);
			}
		}
		return camgenRqstChSetTimebandList;
	}

	private BigDecimal getRun(Boolean run) {
		BigDecimal runval = null;
		if(null != run){
			runval=	run ? new BigDecimal(1) : new BigDecimal(0);
		}
		return runval;
	}

	private BigDecimal getSlot(Boolean slot) {
		BigDecimal slotval = null;
		if(null != slot){
			slotval= slot ? new BigDecimal(1) : new BigDecimal(0);
		}
		return slotval;
	}

	private List<CamgenRqstDemandSupply> mapCamgenRqstDemandSuppliesForCreate(List<DemandSupplyGroup> demandSupplyGroup,
			CamgenRequest camgenRequest) {
		List<CamgenRqstDemandSupply> camgenRqstDemandSupplyList = new ArrayList<>();
		if (null != demandSupplyGroup) {
			for (DemandSupplyGroup demandSupplyGroupObj : demandSupplyGroup) {
				CamgenRqstDemandSupply camgenRqstDemandSupplyObj = new CamgenRqstDemandSupply();
				if(null != demandSupplyGroupObj.getAmendmentPercent()){
					camgenRqstDemandSupplyObj
						.setAmendmentPercentage(BigDecimal.valueOf(demandSupplyGroupObj.getAmendmentPercent()));
				}
				camgenRqstDemandSupplyObj
						.setCamgenDemandSupplyLevel(getCamgenDemandSupplyLevelForCreate(demandSupplyGroupObj.getLevelId()));
				camgenRqstDemandSupplyObj.setCamgenRequest(camgenRequest);
				camgenRqstDemandSupplyObj.setName(demandSupplyGroupObj.getName());
				camgenRqstDemandSupplyObj.setRqstDemandSupplyCriterias(
						mapRqstDemandSupplyCriteriasForCreate(demandSupplyGroupObj.getCriterias(), camgenRqstDemandSupplyObj));
				camgenRqstDemandSupplyList.add(camgenRqstDemandSupplyObj);
			}
		}
		return camgenRqstDemandSupplyList;
	}

	private List<RqstDemandSupplyCriteria> mapRqstDemandSupplyCriteriasForCreate(List<CriteriaLine> criteriaLineList,
			CamgenRqstDemandSupply camgenRqstDemandSupply) {
		List<RqstDemandSupplyCriteria> rqstDemandSupplyCriteriaList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(criteriaLineList)) {
			for (CriteriaLine criteriaLine : criteriaLineList) {
				RqstDemandSupplyCriteria rqstDemandSupplyCriteriaObj = new RqstDemandSupplyCriteria();
				rqstDemandSupplyCriteriaObj
						.setCamgenDemandSupplyAttribute(getCamgenDemandSupplyAttributeForcreate(criteriaLine.getAttributeId()));
				rqstDemandSupplyCriteriaObj
						.setCamgenDemandSupplyCondition(getCamgenDemandSupplyConditionForCreate(criteriaLine.getConditionId()));
				rqstDemandSupplyCriteriaObj
						.setCamgenDemandSupplyObject(getCamgenDemandSupplyObjectForCreate(criteriaLine.getObjectId()));
				rqstDemandSupplyCriteriaObj.setCamgenRqstDemandSupply(camgenRqstDemandSupply);
				rqstDemandSupplyCriteriaObj.setOperator(criteriaLine.getOperator().name());
				
				
				rqstDemandSupplyCriteriaObj.setValue(criteriaLine.getValue());
				rqstDemandSupplyCriteriaList.add(rqstDemandSupplyCriteriaObj);
			}
		}
		return rqstDemandSupplyCriteriaList;
	}

	private CamgenDemandSupplyLevel getCamgenDemandSupplyLevelForCreate(Long levelId) {
		LOGGER.info(" >> CamgenDemandSupplyLevelJpaRepository : getCamgenDemandSupplyLevel()");
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = null;
		try {
			camgenDemandSupplyLevel = camgenDemandSupplyLevelJpaRepository.findOne(levelId);
			if (null == camgenDemandSupplyLevel) {
				LOGGER.info(" Data not found for camgenDemandSupplyObject");
				throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			LOGGER.info(" << CamgenDemandSupplyLevelJpaRepository : getCamgenDemandSupplyLevel()");
		} catch (DataAccessException e) {
			LOGGER.error(
					"Exception during getting getCamgenDemandSupplyLevel in CamgenDemandSupplyLevelJpaRepository {}",
					e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenDemandSupplyLevel;
	}
	
	/**
	 * Gets the CamgenDemandSupplyAttribute
	 *
	 * @param attributeId
	 *            the attributeId
	 * @return CamgenDemandSupplyAttribute
	 */
	private CamgenDemandSupplyAttribute getCamgenDemandSupplyAttributeForcreate(Long attributeId) {
		LOGGER.info(" >> CamgenDemandSupplyAttributeJpaRepositoryImpl : getCamgenDemandSupplyAttribute()");
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = null;
		try {
			camgenDemandSupplyAttribute = camgenDemandSupplyAttributeJpaRepository.findOne(attributeId);
			if (null == camgenDemandSupplyAttribute) {
				LOGGER.info(" Data not found for CamgenDemandSupplyAttribute");
				throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			LOGGER.info(" << CamgenDemandSupplyAttributeJpaRepositoryImpl : getCamgenDemandSupplyAttribute()");
		} catch (DataAccessException e) {
			LOGGER.error(
					"Exception during getting getCamgenDemandSupplyAttribute in SnapshotRunDetailsRepositoryImpl {}",
					e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenDemandSupplyAttribute;
	}

	/**
	 * Gets the CamgenDemandSupplyCondition
	 *
	 * @param conditionId
	 *            the conditionId
	 * @return CamgenDemandSupplyCondition
	 */
	private CamgenDemandSupplyCondition getCamgenDemandSupplyConditionForCreate(Long conditionId) {
		LOGGER.info(" >> CamgenDemandSupplyConditionJpaRepository : getCamgenDemandSupplyAttribute()");
		CamgenDemandSupplyCondition camgenDemandSupplyCondition = null;
		try {
			camgenDemandSupplyCondition = camgenDemandSupplyConditionJpaRepository.findOne(conditionId);
			if (null == camgenDemandSupplyCondition) {
				LOGGER.info(" Data not found for camgenDemandSupplyCondition");
				throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			LOGGER.info(" << CamgenDemandSupplyConditionJpaRepository : getCamgenDemandSupplyCondition()");
		} catch (DataAccessException e) {
			LOGGER.error(
					"Exception during getting getCamgenDemandSupplyCondition in CamgenDemandSupplyConditionJpaRepositoryImpl {}",
					e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenDemandSupplyCondition;
	}

	/**
	 * Gets the CamgenDemandSupplyObject
	 *
	 * @param objectId
	 *            the objectId
	 * @return CamgenDemandSupplyObject
	 */
	private CamgenDemandSupplyObject getCamgenDemandSupplyObjectForCreate(Long objectId) {
		LOGGER.info(" >> CamgenDemandSupplyObjectJpaRepository : getCamgenDemandSupplyObject()");
		CamgenDemandSupplyObject camgenDemandSupplyObject = null;
		try {
			camgenDemandSupplyObject = camgenDemandSupplyObjectJpaRepository.findOne(objectId);
			if (null == camgenDemandSupplyObject) {
				LOGGER.info(" Data not found for camgenDemandSupplyObject");
				throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			LOGGER.info(" << CamgenDemandSupplyObjectJpaRepository : getCamgenDemandSupplyObject()");
		} catch (DataAccessException e) {
			LOGGER.error(
					"Exception during getting getCamgenDemandSupplyObject in CamgenDemandSupplyObjectJpaRepository {}",
					e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenDemandSupplyObject;
	}

	/**
	 * Gets the camgen plan.
	 *
	 * @param planId
	 *            the plan id
	 * @return CamgenPlan
	 */
	private CamgenPlan getCamgenPlan(long planId) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : getCamgenPlan()");
		CamgenPlan camgenPlan = null;
		try {
			camgenPlan = camgenPlanJpaRepository.findOne(planId);
			if (null == camgenPlan) {
				LOGGER.info(" Data not found for CamgenPlan");
				throw new MintBaseException(AutomatedSpotConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
			}
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : getCamgenPlan()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting getCamgenPlan {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenPlan;
	}
	
	private List<CamgenRqstBreakExclIncl> mapCamgenRqstBreakExclInclsForcreate(List<CamgenRequestBreakExclIncl> camgenRequestBreakExclInclList ,
			CamgenRequest camgetReq){
		List<CamgenRqstBreakExclIncl> camgenRqstBreakExclInclList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(camgenRequestBreakExclInclList)) {
			for (CamgenRequestBreakExclIncl  camgenRequestBreakExclIncl : camgenRequestBreakExclInclList) {
				CamgenRqstBreakExclIncl camgenRqstBreakExclInclObj = new CamgenRqstBreakExclIncl();
				camgenRqstBreakExclInclObj.setCamgenRequest(camgetReq);
				if(null != camgenRequestBreakExclIncl.getCommercialBreakId()){
					camgenRqstBreakExclInclObj.setCommercialBreakId(new BigDecimal(camgenRequestBreakExclIncl.getCommercialBreakId()));
				}
				camgenRqstBreakExclInclObj.setCreatedBy(securityUtil.getLoginUser());
				camgenRqstBreakExclInclObj.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
				if(null != camgenRequestBreakExclIncl.isIsExcluded()){
					camgenRqstBreakExclInclObj.setIsExcluded(camgenRequestBreakExclIncl.isIsExcluded() ? new BigDecimal(1) : new BigDecimal(0));
				}
				camgenRqstBreakExclInclList.add(camgenRqstBreakExclInclObj);
			}
		}
		return camgenRqstBreakExclInclList;
	}

	private List<CamgenRqstClimExclIncl> mapcamgenRqstClimExclInclsForCreate(List<CamgenRequestCMExclIncl> camgenRequestCMExclInclList, CamgenRequest camgetReq){
		 List<CamgenRqstClimExclIncl> camgenRqstClimExclInclList = new ArrayList<>();
		 
		 if(!CollectionUtils.isEmpty(camgenRequestCMExclInclList)){
			 for(CamgenRequestCMExclIncl camgenRequestCMExclInclObj : camgenRequestCMExclInclList ){
				 CamgenRqstClimExclIncl camgenRqstClimExclIncl = new CamgenRqstClimExclIncl();
				 camgenRqstClimExclIncl.setCamgenRequest(camgetReq);
				 if(null != camgenRequestCMExclInclObj.getCmId()){
					camgenRqstClimExclIncl.setCampaignLineMonthId(new BigDecimal(camgenRequestCMExclInclObj.getCmId()));
				 }
				 camgenRqstClimExclIncl.setCreatedBy(securityUtil.getLoginUser());
				 camgenRqstClimExclIncl.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
				 if(null != camgenRequestCMExclInclObj.isIsExcluded()){
					 camgenRqstClimExclIncl.setIsExcluded(camgenRequestCMExclInclObj.isIsExcluded() ? new BigDecimal(1) : new BigDecimal(0));
				 }
				 camgenRqstClimExclInclList.add(camgenRqstClimExclIncl);
			 }
		 }
		 
		 return camgenRqstClimExclInclList;
	}
	
}
