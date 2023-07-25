package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.CamgenConstant;
import com.channel4.mint.automated.spot.application.util.CamgenParameterMapper;
import com.channel4.mint.automated.spot.application.util.DateTimeUtility;
import com.channel4.mint.automated.spot.application.util.SecurityUtil;
import com.channel4.mint.automated.spot.application.util.SnapshotSummaryUtil;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenPlanJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunAudienceGroupChannelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.SnapshotRunDetailsRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenPlan;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequestSpecificationBuilder;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBatchTxLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstBreakExclIncl;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstChSetTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstClimExclIncl;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRqstDemandSupply;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunSpecification;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RqstDemandSupplyCriteria;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunAudienceGroupChannel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunEiBand;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunExtractParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunParameter;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationEiTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.RunStationTimeband;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.SearchCriteria;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup;
import com.channel4.mint.automated.spot.interfaces.dto.AutoFillingDaySetup.RunDayEnum;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevel;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRequestBreakExclIncl;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRequestCMExclIncl;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLine.OperatorEnum;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyGroup.LevelCodeEnum;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummary;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.StartEndDate;
import com.channel4.mint.automated.spot.service.impl.SnapshotRunDetailsServiceImpl;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * class for snap shot run details db operations.
 * 
 * @author HCL
 */
@Service
public class SnapshotRunDetailsRepositoryImpl implements SnapshotRunDetailsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotRunDetailsServiceImpl.class);

	@Autowired
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	@Autowired
	private DateTimeUtility dateTimeUtility;

	@Autowired
	SecurityUtil securityUtil;

	@Autowired
	private RunAudienceGroupChannelJpaRepository runAudienceGroupChannelJpaRepository;

	@Autowired
	private CamgenParameterMapper camgenRunParameterMapper;

	@Autowired
	private SnapshotSummaryUtil snapshotSummaryUtil;

	@Autowired
	private CamgenPlanJpaRepository camgenPlanJpaRepository;

	@Value("${manualIterations}")
	private Integer manualIterations;

	@Value("${active}")
	private String active = "";

	/**
	 * method for create camgen snapshot details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 */
	@Override
	public NewEntityCreated createCamgenSnapshotRunDetails(CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		NewEntityCreated newEntityCreated = new NewEntityCreated();
		try {
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.createCamgenSnapshotRunDetails()");
			List<CamgenRun> camgenRunRequest = mapCamgenSnapshotRunDetails(camgenSnapshotRunDetail, false);
			List<CamgenRun> camgenResponse = camgenRunJpaRepository.save(camgenRunRequest);
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.createCamgenSnapshotRunDetails()");
			camgenResponse.forEach(e -> {

				newEntityCreated.setId(String.valueOf(e.getRunId()));
				newEntityCreated.setMessage("success");

			});
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return newEntityCreated;
	}

	/**
	 * Update camgen snapshot run details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 */
	@Override
	public void updateCamgenSnapshotRunDetails(CamgenSnapshotRunDetails camgenSnapshotRunDetails) {
		try {
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails()");
			if(!CollectionUtils.isEmpty(camgenSnapshotRunDetails)){
				for(CamgenSnapshotRunDetail camgenSnapshotRunDetail : camgenSnapshotRunDetails){
				 List<CamgenRun> camgenRunRequest =	 mapCamgenSnapshotRunDetails(camgenSnapshotRunDetail, true);
				 camgenRunJpaRepository.save(camgenRunRequest);
				 }
			}
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.updateCamgenSnapshotRunDetails()");
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Map camgen snapshot run details.
	 *
	 * @param camgenSnapshotRunDetails
	 *            the camgen snapshot run details
	 * @param update
	 *            the update
	 * @return CamgenRun
	 */
	private List<CamgenRun> mapCamgenSnapshotRunDetails(CamgenSnapshotRunDetail camgenSnapshotRunDetail,
			Boolean update) {
		List<CamgenRun> camgenRunList = new ArrayList<>();
		CamgenRun camgenRun = null;
		if (update) {
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.mapCamgenSnapshotRunDetails()");
			camgenRun = camgenRunJpaRepository.findOne(Long.valueOf(camgenSnapshotRunDetail.getRunId()));
			if (null == camgenRun) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} else {
			camgenRun = new CamgenRun();
		}

		CamgenRequest camgenRequest = findCamgenRequest(camgenSnapshotRunDetail);
		camgenRun.setCamgenRequest(camgenRequest);

		camgenRun.setCamgenRunIterations(mapRunIterations(camgenRun, update, camgenSnapshotRunDetail));

		setCamgenRun(camgenSnapshotRunDetail, camgenRun);

		if (update) {
			camgenRun.setModifiedBy(camgenSnapshotRunDetail.getCreatedBy());
			camgenRun.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());
		} else {
			camgenRun.setCreatedBy(camgenSnapshotRunDetail.getCreatedBy());
			camgenRun.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());
		}

		if (!update) {
			// update camgen run paramters
			setCamgenRunParameters(camgenRun, camgenSnapshotRunDetail);

			// set extracts paramters
			setCamgenExtracts(camgenRun, camgenSnapshotRunDetail);

			// set audience group channel
			setAudienceGroupChannel(camgenRun, camgenSnapshotRunDetail);

			// add ei bands
			setEiBands(camgenRun, camgenSnapshotRunDetail);

			// add station time bands
			setStationTimeBands(camgenRun, camgenSnapshotRunDetail);

			// set station ei time bands
			setStationEiTimeBands(camgenRun, camgenSnapshotRunDetail);

		}

		camgenRunList.add(camgenRun);

		// update slot flag
		updateSlotFlagForrun(camgenSnapshotRunDetail, camgenRequest);

		return camgenRunList;
	}

	private void setStationEiTimeBands(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParamStationEITimeBands())) {
			List<RunStationEiTimeband> runStationEiTimebands = new ArrayList<>();

			for (CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand : camgenSnapshotRunDetail
					.getCamgenRunParamStationEITimeBands()) {
				RunStationEiTimeband runStationEiTimeband = new RunStationEiTimeband();

				runStationEiTimeband.setCamgenRun(camgenRun);
				runStationEiTimeband.setApplicableDay(camgenRunParamStationEITimeBand.getDayCode());
				runStationEiTimeband.setStartTime(camgenRunParamStationEITimeBand.getStartTime());
				runStationEiTimeband.setEndTime(camgenRunParamStationEITimeBand.getEndTime());
				runStationEiTimeband.setCreatedBy(securityUtil.getLoginUser());
				runStationEiTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runStationEiTimebands.add(runStationEiTimeband);
			}

			camgenRun.setRunStationEiTimebands(runStationEiTimebands);
		}
	}

	private void setStationTimeBands(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParamStationTimeBands())) {
			List<RunStationTimeband> runStationTimebands = new ArrayList<>();

			for (CamgenRunParamStationTimeBand camgenRunParamStationTimeBand : camgenSnapshotRunDetail
					.getCamgenRunParamStationTimeBands()) {
				RunStationTimeband runStationTimeband = new RunStationTimeband();

				runStationTimeband.setCamgenRun(camgenRun);
				runStationTimeband.setTimeband(camgenRunParamStationTimeBand.getName());

				if (null != camgenRunParamStationTimeBand.getChannelId()) {
					runStationTimeband.setChannelId(new BigDecimal(camgenRunParamStationTimeBand.getChannelId()));
				}
				runStationTimeband.setApplicableDay(camgenRunParamStationTimeBand.getDayCode());
				runStationTimeband.setStartTime(camgenRunParamStationTimeBand.getStartTime());
				runStationTimeband.setEndTime(camgenRunParamStationTimeBand.getEndTime());

				if (null != camgenRunParamStationTimeBand.getEiCutOff()) {
					runStationTimeband.setEiCutOff(new BigDecimal(camgenRunParamStationTimeBand.getEiCutOff()));
				}

				if (null != camgenRunParamStationTimeBand.getTbProgRepetitionLimit()) {
					runStationTimeband.setTbProgRepititionLimit(
							new BigDecimal(camgenRunParamStationTimeBand.getTbProgRepetitionLimit()));
				}

				if (null != camgenRunParamStationTimeBand.getAmendDemand()) {
					runStationTimeband.setAmendDemand(new BigDecimal(camgenRunParamStationTimeBand.getAmendDemand()));
				}

				if (null != camgenRunParamStationTimeBand.getExcludeFlag()) {
					runStationTimeband.setIsExclude(camgenRunParamStationTimeBand.getExcludeFlag().equals("true")
							? new BigDecimal(1) : new BigDecimal(0));
				}

				runStationTimeband.setCreatedBy(securityUtil.getLoginUser());
				runStationTimeband.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runStationTimebands.add(runStationTimeband);
			}

			camgenRun.setRunStationTimebands(runStationTimebands);
		}
	}

	private void setEiBands(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParamEIBands())) {
			List<RunEiBand> runEiBands = new ArrayList<>();

			for (CamgenRunParamEIBand camgenRunParamEIBand : camgenSnapshotRunDetail.getCamgenRunParamEIBands()) {
				RunEiBand runEiBand = new RunEiBand();

				runEiBand.setCamgenRun(camgenRun);

				if (null != camgenRunParamEIBand.getEiBand()) {
					runEiBand.setEiBand(new BigDecimal(camgenRunParamEIBand.getEiBand()));
				}

				runEiBand.setCreatedBy(securityUtil.getLoginUser());
				runEiBand.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runEiBands.add(runEiBand);
			}

			camgenRun.setRunEiBands(runEiBands);
		}
	}

	private void setAudienceGroupChannel(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParamAudGroupChannels())) {
			List<RunAudienceGroupChannel> runAudienceGroupChannels = new ArrayList<>();

			for (CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel : camgenSnapshotRunDetail
					.getCamgenRunParamAudGroupChannels()) {
				RunAudienceGroupChannel runAudienceGroupChannel = new RunAudienceGroupChannel();

				runAudienceGroupChannel.setCamgenRun(camgenRun);

				if (null != camgenRunParamAudGroupChannel.getChannelId()) {
					runAudienceGroupChannel.setChannelId(new BigDecimal(camgenRunParamAudGroupChannel.getChannelId()));
				}

				if (null != camgenRunParamAudGroupChannel.getAudienceGroupId()) {
					runAudienceGroupChannel
							.setAudienceId(new BigDecimal(camgenRunParamAudGroupChannel.getAudienceGroupId()));
				}

				if (StringUtils.isNotEmpty(camgenRunParamAudGroupChannel.getTargetPercentage())) {
					runAudienceGroupChannel
							.setTargetPercentage(new BigDecimal(camgenRunParamAudGroupChannel.getTargetPercentage()));
				}

				runAudienceGroupChannel.setCreatedBy(securityUtil.getLoginUser());
				runAudienceGroupChannel.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runAudienceGroupChannels.add(runAudienceGroupChannel);
			}

			camgenRun.setRunAudienceGroupChannels(runAudienceGroupChannels);
		}
	}

	private void setCamgenExtracts(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParamExtracts())) {
			List<RunExtractParameter> runExtractParameters = new ArrayList<>();

			for (CamgenRunParamExtract camgenRunParamExtract : camgenSnapshotRunDetail.getCamgenRunParamExtracts()) {
				RunExtractParameter runExtractParameter = new RunExtractParameter();

				runExtractParameter.setCamgenRun(camgenRun);
				runExtractParameter.setExtractParameterName(camgenRunParamExtract.getParameter());
				runExtractParameter.setValue(camgenRunParamExtract.getValue());
				runExtractParameter.setCreatedBy(securityUtil.getLoginUser());
				runExtractParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runExtractParameters.add(runExtractParameter);
			}

			camgenRun.setRunExtractParameters(runExtractParameters);
		}
	}

	private void setCamgenRunParameters(CamgenRun camgenRun, CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		if (!CollectionUtils.isEmpty(camgenSnapshotRunDetail.getCamgenRunParameters())) {
			List<RunParameter> runParameters = new ArrayList<>();

			for (CamgenRunParam camgenRunParam : camgenSnapshotRunDetail.getCamgenRunParameters()) {
				RunParameter runParameter = new RunParameter();

				runParameter.setCamgenRun(camgenRun);
				runParameter.setParameterName(camgenRunParam.getParameter());
				runParameter.setValue(camgenRunParam.getValue());

				runParameter.setDescription(camgenRunParam.getRemarks());
				runParameter.setCreatedBy(securityUtil.getLoginUser());
				runParameter.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

				runParameters.add(runParameter);
			}

			camgenRun.setRunParameters(runParameters);
		}
	}

	/**
	 * Map run iterations.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @param update
	 *            the update
	 * @param camgenSnapshotRunDetail
	 *            the camgen snapshot run detail
	 * @return CamgenRunIteration
	 */
	private List<CamgenRunIteration> mapRunIterations(CamgenRun camgenRun, Boolean update,
			CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		List<CamgenRunIteration> camgenRunIterations = null;

		if (update && !CollectionUtils.isEmpty(camgenRun.getCamgenRunIterations())) {
			camgenRunIterations = camgenRun.getCamgenRunIterations();
			camgenRunIterations.clear();
		} else {
			camgenRunIterations = new ArrayList<>();
		}

		CamgenRunIteration camgenRunIteration = new CamgenRunIteration();
		camgenRunIteration.setCreatedBy(camgenSnapshotRunDetail.getCreatedBy());
		camgenRunIteration.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

		if (null != camgenSnapshotRunDetail.getIterationCount()) {
			camgenRunIteration.setIterationNumber(BigDecimal.valueOf(camgenSnapshotRunDetail.getIterationCount()));
		}

		camgenRunIteration.setCamgenRun(camgenRun);

		camgenRunIterations.add(camgenRunIteration);

		return camgenRunIterations;
	}

	/**
	 * Update slot flag forrun.
	 *
	 * @param camgenSnapshotRunDetail
	 *            the camgen snapshot run detail
	 * @param camgenRequest
	 *            the camgen request
	 */
	private void updateSlotFlagForrun(CamgenSnapshotRunDetail camgenSnapshotRunDetail, CamgenRequest camgenRequest) {
		if (null != camgenRequest.getCamgenPlan()) {
			CamgenPlan camgenPlan = getCamgenPlan(camgenRequest.getCamgenPlan().getPlanId());
			if (null != camgenSnapshotRunDetail.getSlotFlag())
				camgenPlan.setIsSlot(
						camgenSnapshotRunDetail.getSlotFlag().equals(true) ? new BigDecimal(1) : new BigDecimal(0));
			camgenPlan.setModifiedBy(camgenSnapshotRunDetail.getCreatedBy());
			camgenPlan.setModifiedOn(dateTimeUtility.getCurrentTimeStamp());

			camgenPlanJpaRepository.save(camgenPlan);
		}
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
				throw new MintBaseException(CamgenConstant.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : getCamgenPlan()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting getCamgenPlan {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenPlan;
	}

	/**
	 * Sets the camgen run.
	 *
	 * @param camgenSnapshotRunDetail
	 *            the camgen snapshot run detail
	 * @param camgenRun
	 *            the camgen run
	 */
	private void setCamgenRun(CamgenSnapshotRunDetail camgenSnapshotRunDetail, CamgenRun camgenRun) {

		if (null != camgenSnapshotRunDetail.getRunDateTime()) {
			camgenRun.setStartDateTime(new LocalDate(camgenSnapshotRunDetail.getRunDateTime()).toDate());
		}
		camgenRun.setStatus(camgenSnapshotRunDetail.getRunStatus());
		camgenRun.setNote(camgenSnapshotRunDetail.getNotes());
		if (null != camgenSnapshotRunDetail.getScheduledRunDateTime()) {
			camgenRun.setScheduleDateTime(DateTime.parse(camgenSnapshotRunDetail.getScheduledRunDateTime(), 
	                DateTimeFormat.forPattern("yyyy-MM-dd'T'HHmmss")).toDate());
		}
		if (null != camgenSnapshotRunDetail.getSlotFileImportStatus()) {
			camgenRun.setIsFileImported("true".equalsIgnoreCase(camgenSnapshotRunDetail.getSlotFileImportStatus())
					? new BigDecimal(1) : new BigDecimal(0));
		}
		if (null != camgenSnapshotRunDetail.getSlotFlag()) {
			camgenRun.setIsSlot(camgenSnapshotRunDetail.getSlotFlag().booleanValue() == Boolean.TRUE ? new BigDecimal(1)
					: new BigDecimal(0));
		}

		if (null != camgenSnapshotRunDetail.getSlotFileLastImportDate()) {
			camgenRun.setFileImportDate(camgenSnapshotRunDetail.getSlotFileLastImportDate().toDate());
		}
		if (null != camgenSnapshotRunDetail.getIterationCount())
			camgenRun.setIterationNumberFile(new BigDecimal(camgenSnapshotRunDetail.getIterationCount()));
		camgenRun.setCreatedBy(securityUtil.getLoginUser());
	}

	/**
	 * Find camgen request.
	 *
	 * @param camgenSnapshotRunDetail
	 *            the camgen snapshot run detail
	 * @return CamgenRequest
	 */
	private CamgenRequest findCamgenRequest(CamgenSnapshotRunDetail camgenSnapshotRunDetail) {
		CamgenRequest camgenRequest = null;
		try {
			LOGGER.info(">>SnapshotRunDetailsRepositoryImpl.findCamgenRequest()");
			if(camgenSnapshotRunDetail.getSnapshotId()!=null){
				camgenRequest = camgenRequestJpaRepository.findOne(camgenSnapshotRunDetail.getSnapshotId());
			}
			if (null == camgenRequest) {
				LOGGER.info("camgen Request not found ");
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			LOGGER.info("<<SnapshotRunDetailsRepositoryImpl.findCamgenRequest()");
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenRequest;
	}

	/**
	 * method for get camgen snap shot run details.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public List<CamgenSnapshotRunDetail> getCamgenSnapshotRunDetails(Integer runId, DateTime scheduledDate,
			String requestStatus, String runStatus) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : getCamgenSnapshotRunDetails()");

		List<CamgenRun> runRequestList = null;
		try {
			runRequestList = camgenRunJpaRepository.findAll(getSpec(runId, scheduledDate, requestStatus,runStatus));
			if (CollectionUtils.isEmpty(runRequestList)) {
				throw new MintBaseException(CamgenConstant.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			mapEntityListToCamgenSnapshotRunDetails(runRequestList);
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : getCamgenSnapshotRunDetails()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenSnapshotRunDetails {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return mapEntityListToCamgenSnapshotRunDetails(runRequestList);
	}

	private Specification<CamgenRun> getSpec(Integer runId, DateTime scheduledDate, String requestStatus,String runStatus) {
		List<SearchCriteria> criterias = new ArrayList<>();

		if (null != runId) {
			SearchCriteria searchCriteria = new SearchCriteria("runId", "[eq]", runId.toString());
			criterias.add(searchCriteria);
		}

		if (null != scheduledDate) {
			SearchCriteria searchCriteriaScheduleStartTime = new SearchCriteria("scheduleDateTime", "[gt]",
					scheduledDate.minus(Period.minutes(15)).toString());
			criterias.add(searchCriteriaScheduleStartTime);

			SearchCriteria searchCriteriaScheduleEndTime = new SearchCriteria("scheduleDateTime", "[lt]",
					scheduledDate.plus(Period.minutes(15)).toString());
			criterias.add(searchCriteriaScheduleEndTime);
		}
		if (null != requestStatus) {
			SearchCriteria searchCriteriaScheduleStartTime = new SearchCriteria("requestStatus", "[eq]", requestStatus);
			criterias.add(searchCriteriaScheduleStartTime);
		}
		
		if (null != runStatus) {
			SearchCriteria searchCriteria = new SearchCriteria("runStatus", "[eq]", runStatus);
			criterias.add(searchCriteria);
		}
		List<Specification<CamgenRun>> specs = new ArrayList<>();
		for (SearchCriteria criteria : criterias) {
			specs.add(new CamgenRunSpecification(criteria));
		}

		Specification<CamgenRun> result = null;

		if (!CollectionUtils.isEmpty(criterias)) {
			result = specs.get(0);

			for (int i = 1; i < specs.size(); i++) {
				result = Specifications.where(result).and(specs.get(i));
			}
		}

		return result;
	}

	/**
	 * Map entity list to camgen snapshot run details.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenSnapshotRunDetails
	 */
	private List<CamgenSnapshotRunDetail> mapEntityListToCamgenSnapshotRunDetails(List<CamgenRun> runRequestList) {

		List<CamgenSnapshotRunDetail> camgenSnapshotRunDetailList = new ArrayList<>();

		for (CamgenRun camgenRun : runRequestList) {
			CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();

			if (null != camgenRun.getIsFileImported()) {
				camgenSnapshotRunDetail
						.setSlotFileImportStatus(camgenRun.getIsFileImported().intValue() == 1 ? "true" : "false");
			}

			camgenSnapshotRunDetail.setSlotFileLastImportDate(new LocalDate(camgenRun.getFileImportDate()));
			camgenSnapshotRunDetail.setNotes(camgenRun.getNote());

			if (null != camgenRun.getStartDateTime()) {
				camgenSnapshotRunDetail.setRunDateTime(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(camgenRun.getStartDateTime()));
			}

			if (null != camgenRun.getScheduleDateTime()) {
				camgenSnapshotRunDetail.setScheduledRunDateTime(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(camgenRun.getScheduleDateTime()));
			}

			camgenSnapshotRunDetail.setRunId((int) camgenRun.getRunId());
			camgenSnapshotRunDetail.setRunStatus(camgenRun.getStatus());

			if (camgenRun.getCamgenRequest() != null) {
				CamgenRequest camgenRequest = camgenRun.getCamgenRequest();
				camgenSnapshotRunDetail
						.setSlotFlag(camgenRequest.getCamgenPlan() == null ? null : setIsSlots(camgenRequest));
				camgenSnapshotRunDetail.setSnapshotId(camgenRequest.getRequestId());
			}

			camgenSnapshotRunDetail
					.setIterationCount(CollectionUtils.isEmpty(camgenRun.getCamgenRunIterations()) ? null
							: (camgenRun.getCamgenRunIterations().get(0).getIterationNumber() != null
									? camgenRun.getCamgenRunIterations().get(0).getIterationNumber().intValue()
									: null));
			camgenSnapshotRunDetail.setCreatedBy(camgenRun.getCreatedBy());
			if (!CollectionUtils.isEmpty(camgenRun.getRunParameters())) {
				camgenSnapshotRunDetail.setCamgenRunParameters(getCamgenRunParam(camgenRun.getRunParameters()));
			}
			if (!CollectionUtils.isEmpty(camgenRun.getRunExtractParameters())) {
				camgenSnapshotRunDetail
						.setCamgenRunParamExtracts(getRunParamExtracts(camgenRun.getRunExtractParameters()));
			}
			if (!CollectionUtils.isEmpty(camgenRun.getRunStationEiTimebands())) {
				camgenSnapshotRunDetail.setCamgenRunParamStationEITimeBands(
						getCamgenRunParamStationEITimeBands(camgenRun.getRunStationEiTimebands()));
			}
			if (!CollectionUtils.isEmpty(camgenRun.getRunStationTimebands())) {
				camgenSnapshotRunDetail.setCamgenRunParamStationTimeBands(
						camgenRunParamStationTimeBands(camgenRun.getRunStationTimebands()));
			}
			if (!CollectionUtils.isEmpty(getRunParamEIBands(camgenRun.getRunEiBands()))) {
				camgenSnapshotRunDetail.setCamgenRunParamEIBands(getRunParamEIBands(camgenRun.getRunEiBands()));
			}
			if (!CollectionUtils.isEmpty(camgenRun.getRunAudienceGroupChannels())) {
				camgenSnapshotRunDetail.setCamgenRunParamAudGroupChannels(
						getCamgenRunParamAudGroupChannels(camgenRun.getRunAudienceGroupChannels()));
			}

			camgenSnapshotRunDetailList.add(camgenSnapshotRunDetail);
		}

		return camgenSnapshotRunDetailList;

	}

	private List<CamgenRunParamAudGroupChannel> getCamgenRunParamAudGroupChannels(
			List<RunAudienceGroupChannel> runAudienceGroupChannels) {
		List<CamgenRunParamAudGroupChannel> camgenRunParamAudGroupChannels = new ArrayList<>();

		runAudienceGroupChannels.stream().forEach(object -> {
			CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();
			camgenRunParamAudGroupChannel.setRunParameterAudienceGroupChannelId(
					Integer.valueOf(String.valueOf(object.getAudienceGroupChannelId())));
			if (null != object.getAudienceId()) {
				camgenRunParamAudGroupChannel
						.setAudienceGroupId(Integer.valueOf(String.valueOf(object.getAudienceId())));
			}
			if (object.getChannelId() != null) {
				camgenRunParamAudGroupChannel.setChannelId(Integer.valueOf(String.valueOf(object.getChannelId())));
			}

			if (object.getTargetPercentage() != null) {
				camgenRunParamAudGroupChannel.setTargetPercentage(object.getTargetPercentage().toString());
			}
			camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
		});

		return camgenRunParamAudGroupChannels;
	}

	private List<CamgenRunParamEIBand> getRunParamEIBands(List<RunEiBand> runEiBands) {
		List<CamgenRunParamEIBand> camgenRunParamEIBands = new ArrayList<>();

		runEiBands.stream().forEach(runEiBand -> {
			CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();
			camgenRunParamEIBand.setCreatedBy(runEiBand.getCreatedBy());
			camgenRunParamEIBand.setEiBand(Integer.valueOf(runEiBand.getEiBand().toString()));
			camgenRunParamEIBand.setRunParameterEIBandId(Integer.valueOf(String.valueOf(runEiBand.getEiBandId())));
			camgenRunParamEIBands.add(camgenRunParamEIBand);
		});
		return camgenRunParamEIBands;
	}

	private List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands(
			List<RunStationTimeband> runStationTimebands) {
		List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands = new ArrayList<>();
		runStationTimebands.stream().forEach(stationTimeBandObj -> {
			CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();
			if (null != stationTimeBandObj.getAmendDemand()) {
				camgenRunParamStationTimeBand
						.setAmendDemand(Integer.parseInt(stationTimeBandObj.getAmendDemand().toString()));
			}
			if (stationTimeBandObj.getChannelId() != null) {
				camgenRunParamStationTimeBand
						.setChannelId(Integer.parseInt(stationTimeBandObj.getChannelId().toString()));
			}
			camgenRunParamStationTimeBand.setCreatedBy(stationTimeBandObj.getCreatedBy());
			camgenRunParamStationTimeBand.setDayCode(stationTimeBandObj.getApplicableDay());
			if (null != stationTimeBandObj.getEiCutOff()) {
				camgenRunParamStationTimeBand
						.setEiCutOff(Integer.parseInt(stationTimeBandObj.getEiCutOff().toString()));
			}
			camgenRunParamStationTimeBand.setEndTime(stationTimeBandObj.getEndTime());
			if (null != stationTimeBandObj.getIsExclude()
					&& "1".equalsIgnoreCase(stationTimeBandObj.getIsExclude().toString())) {
				camgenRunParamStationTimeBand.setExcludeFlag("true");
			} else {
				camgenRunParamStationTimeBand.setExcludeFlag("false");
			}
			camgenRunParamStationTimeBand.setName(stationTimeBandObj.getTimeband());
			camgenRunParamStationTimeBand.setRunParameterStationTimeBandId(
					Integer.valueOf(String.valueOf(stationTimeBandObj.getStationTimebandId())));
			camgenRunParamStationTimeBand.setStartTime(stationTimeBandObj.getStartTime());
			camgenRunParamStationTimeBand
					.setStationTimeBandId(Integer.valueOf(String.valueOf(stationTimeBandObj.getStationTimebandId())));
			camgenRunParamStationTimeBand.setTbProgRepetitionLimit(
					Integer.valueOf(stationTimeBandObj.getTbProgRepititionLimit().toString()));
			camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
		});
		return camgenRunParamStationTimeBands;
	}

	private List<CamgenRunParamStationEITimeBand> getCamgenRunParamStationEITimeBands(
			List<RunStationEiTimeband> runStationEiTimebands) {
		List<CamgenRunParamStationEITimeBand> camgenRunParamStationEITimeBandsList = new ArrayList<>();
		runStationEiTimebands.stream().forEach(stationEiTimeBand -> {
			CamgenRunParamStationEITimeBand camgenRunParamStationEITimeBand = new CamgenRunParamStationEITimeBand();
			camgenRunParamStationEITimeBand.setDayCode(stationEiTimeBand.getApplicableDay());
			camgenRunParamStationEITimeBand.setEndTime(stationEiTimeBand.getEndTime());
			camgenRunParamStationEITimeBand.setRunParameterStationEITimeBandId(
					Integer.parseInt(String.valueOf(stationEiTimeBand.getStationEiTimebandId())));
			camgenRunParamStationEITimeBand.setStartTime(stationEiTimeBand.getStartTime());
			camgenRunParamStationEITimeBandsList.add(camgenRunParamStationEITimeBand);
		});
		return camgenRunParamStationEITimeBandsList;
	}

	private List<CamgenRunParamExtract> getRunParamExtracts(List<RunExtractParameter> runExtractParameters) {
		List<CamgenRunParamExtract> camgenRunParamExtractList = new ArrayList<>();
		runExtractParameters.stream().forEach(runExObj -> {
			CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();
			camgenRunParamExtract.setCreatedBy(runExObj.getCreatedBy());
			camgenRunParamExtract.setParameter(runExObj.getExtractParameterName());
			camgenRunParamExtract
					.setRunParameterExtractId(Integer.parseInt(String.valueOf(runExObj.getExtractParameterId())));
			camgenRunParamExtract.setValue(runExObj.getValue());
			camgenRunParamExtractList.add(camgenRunParamExtract);
		});
		return camgenRunParamExtractList;
	}

	private List<CamgenRunParam> getCamgenRunParam(List<RunParameter> runParameters) {
		List<CamgenRunParam> camgenRunParamList = new ArrayList<>();
		runParameters.stream().forEach(runParam -> {
			CamgenRunParam camgenRunParam = new CamgenRunParam();
			camgenRunParam.setParameter(runParam.getParameterName());
			camgenRunParam.setCreatedBy(runParam.getCreatedBy());
			camgenRunParam.setRemarks(runParam.getDescription());
			camgenRunParam.setRunParameterId(Integer.parseInt(String.valueOf(runParam.getParameterId())));
			camgenRunParam.setStandardvalue(runParam.getValue());
			camgenRunParam.setValue(runParam.getValue());
			camgenRunParamList.add(camgenRunParam);
		});

		return camgenRunParamList;
	}

	/**
	 * Gets the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamAudGroupChannels
	 */
	@Override
	public CamgenRunParamAudGroupChannels getCamgenRunParamAudGroupChannels(Integer runId) {
		CamgenRun camgenRun = null;
		LOGGER.info(">> SnapshotRunDetailsRepositoryImpl : getCamgenRunParamAudGroupChannels()");
		try {
			camgenRun = camgenRunJpaRepository.findOne(runId.longValue());

			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getRunAudienceGroupChannels())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating getCamgenRunParamAudGroupChannels {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< SnapshotRunDetailsRepositoryImpl : getCamgenRunParamAudGroupChannels()");

		return mapCamgenRunParamAudGroupChannels(camgenRun);
	}

	/**
	 * Map camgen run param aud group channels.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @return CamgenRunParamAudGroupChannels
	 */
	private CamgenRunParamAudGroupChannels mapCamgenRunParamAudGroupChannels(CamgenRun camgenRun) {
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();

		camgenRun.getRunAudienceGroupChannels()
				.forEach(item -> mapCamgenRunParamAudGroup(camgenRun, camgenRunParamAudGroupChannels, item));

		return camgenRunParamAudGroupChannels;

	}

	/**
	 * Map camgen run param aud group.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @param camgenRunParamAudGroupChannels
	 *            the camgen run param aud group channels
	 * @param item
	 *            the item
	 */
	private void mapCamgenRunParamAudGroup(CamgenRun camgenRun,
			CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels, RunAudienceGroupChannel item) {
		CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();

		if (null != item.getAudienceId()) {
			camgenRunParamAudGroupChannel.setKeyAudienceId(Integer.parseInt(String.valueOf(item.getAudienceId())));
		}

		mapCamgenRunParamAudGroupChannel(camgenRun, item, camgenRunParamAudGroupChannel);

		if (null != item.getChannelId()) {
			camgenRunParamAudGroupChannel.setChannelId(Integer.parseInt(String.valueOf(item.getChannelId())));
		}

		camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);
	}

	/**
	 * Map camgen run param aud group channel.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @param item
	 *            the item
	 * @param camgenRunParamAudGroupChannel
	 *            the camgen run param aud group channel
	 */
	private void mapCamgenRunParamAudGroupChannel(CamgenRun camgenRun, RunAudienceGroupChannel item,
			CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel) {
		// camgenRunParamAudGroupChannel.setId(Integer.parseInt(String.valueOf(item.getAudienceGroupChannelId())));

		if (null != item.getTargetPercentage()) {
			camgenRunParamAudGroupChannel.setTargetPercentage(item.getTargetPercentage().toString());
		}

	}

	/**
	 * Creates the camgen run param aud group channels.
	 *
	 * @param camgenRunParamAudGroupChannels
	 *            the camgen run param aud group channels
	 * @param runId
	 *            the run id
	 */
	@Override
	public void createCamgenRunParamAudGroupChannels(CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels,
			Integer runId) {
		LOGGER.info(">> SnapshotRunDetailsRepositoryImpl : createCamgenRunParamStationTimeBands()");
		try {
			List<RunAudienceGroupChannel> runAudienceGroupChannelList = mapCamgenRunParamAudGroupChannels(
					camgenRunParamAudGroupChannels, runId);
			runAudienceGroupChannelJpaRepository.save(runAudienceGroupChannelList);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating CamgenRunParamAudGroupChannels {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< SnapshotRunDetailsRepositoryImpl : createCamgenRunParamStationTimeBands()");
	}

	/**
	 * Map camgen run param aud group channels.
	 *
	 * @param camgenRunParamAudGroupChannels
	 *            the camgen run param aud group channels
	 * @param runId
	 *            the run id
	 * @return RunAudienceGroupChannel
	 */
	private List<RunAudienceGroupChannel> mapCamgenRunParamAudGroupChannels(
			CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels, Integer runId) {
		CamgenRun camgenRun = camgenRunJpaRepository.findOne(Long.valueOf(runId));
		if (camgenRun == null) {
			throw new MintBaseException("Data Not Found For Run Id " + runId, HttpStatus.NOT_FOUND.value());
		}

		List<RunAudienceGroupChannel> runAudiGroupchannel = new ArrayList<>();

		camgenRunParamAudGroupChannels.stream().forEach(groupcannnels ->

		mapRunAudienceGroupChannel(camgenRun, runAudiGroupchannel, groupcannnels));

		return runAudiGroupchannel;
	}

	/**
	 * Map run audience group channel.
	 *
	 * @param camgenRun
	 *            the camgen run
	 * @param runAudiGroupchannel
	 *            the run audi groupchannel
	 * @param groupcannnels
	 *            the groupcannnels
	 */
	private void mapRunAudienceGroupChannel(CamgenRun camgenRun, List<RunAudienceGroupChannel> runAudiGroupchannel,
			CamgenRunParamAudGroupChannel groupcannnels) {
		RunAudienceGroupChannel runAudienceGroupChannel = new RunAudienceGroupChannel();
		runAudienceGroupChannel.setAudienceId(BigDecimal.valueOf(groupcannnels.getKeyAudienceId()));
		runAudienceGroupChannel.setChannelId(BigDecimal.valueOf(groupcannnels.getChannelId()));
		runAudienceGroupChannel.setTargetPercentage(new BigDecimal(groupcannnels.getTargetPercentage()));

		runAudienceGroupChannel.setCamgenRun(camgenRun);
		runAudienceGroupChannel.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		runAudienceGroupChannel.setCreatedBy(camgenRun.getCreatedBy());

		runAudiGroupchannel.add(runAudienceGroupChannel);
	}

	/**
	 * Gets the all snapshots.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return SnapshotSummaryWithPagination
	 */
	@Override
	public SnapshotSummaryWithPagination getAllSnapshots(Integer page, Long count, String sortOrder,
			String sortByField) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : getAllSnapshots()");
		SnapshotSummaryWithPagination snapshotSummaryWithPagination = null;
		Page<CamgenRequest> camgenRequestPageList = null;
		List<SnapshotSummary> snapshotSummaryList = null;
		try {
			camgenRequestPageList = camgenRequestJpaRepository
					.findAll(getPageRequest(page, count.intValue(), sortOrder, sortByField));
			if (CollectionUtils.isEmpty(camgenRequestPageList.getContent())) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
			snapshotSummaryList = mapEntityListTocamgenRunParamStationEITimeBands(camgenRequestPageList.getContent());
			snapshotSummaryWithPagination = new SnapshotSummaryWithPagination();
			snapshotSummaryWithPagination.setTotalCount(camgenRequestPageList.getNumberOfElements());
			snapshotSummaryWithPagination.setSnapshotSummary(snapshotSummaryList);
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : SnapshotSummary()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting SnapshotSummary {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return snapshotSummaryWithPagination;
	}

	/**
	 * Gets the page request.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return PageRequest
	 */
	private PageRequest getPageRequest(Integer page, Integer count, String sortOrder, String sortByField) {
		Sort.Direction direction = Sort.Direction.DESC;
		if (null != sortOrder && "ASC".equalsIgnoreCase(sortOrder)) {
			direction = Sort.Direction.ASC;
		}
		return new PageRequest(page.intValue(), count.intValue(), direction,
				snapshotSummaryUtil.getSortByField(sortByField));
	}

	/**
	 * Map entity list to camgen param station EI time bands.
	 *
	 * @param listOfCamgenRequest
	 *            the list of camgen request
	 * @return SnapshotSummary
	 */
	private List<SnapshotSummary> mapEntityListTocamgenRunParamStationEITimeBands(
			List<CamgenRequest> listOfCamgenRequest) {
		List<SnapshotSummary> snapshotSummaryList = new ArrayList<>();
		listOfCamgenRequest.stream().forEach(camgenReq -> {
			SnapshotSummary snapshotSummaryObj = new SnapshotSummary();

			snapshotSummaryObj.setSnapshotrequestID(camgenReq.getRequestId());
			snapshotSummaryObj.setCreationDate(new DateTime(camgenReq.getCreatedOn()));

			if (!CollectionUtils.isEmpty(camgenReq.getCamgenRqstBatchTxLevels())) {
				snapshotSummaryObj.setTxLevels(mapTxLevels(camgenReq.getCamgenRqstBatchTxLevels()));
			}

			snapshotSummaryObj.setSnpashotStartEndDate(mapSnpashotStartEndDate(camgenReq));

			snapshotSummaryObj.setChannelSetId(
					camgenReq.getChannelSetId() == null ? null : camgenReq.getChannelSetId().longValue());

			if (null != camgenReq.getCamgenPlan()) {
				snapshotSummaryObj.setSnapshotPlanID(camgenReq.getCamgenPlan().getPlanId());
			}

			snapshotSummaryObj.setRequestType(camgenReq.getRequestType());
			snapshotSummaryObj.setStatus(camgenReq.getStatus());

			if (null != camgenReq.getIsRun()) {
				snapshotSummaryObj.setRun(camgenReq.getIsRun() == new BigDecimal(1) ? true : false);
			}

			if (null != camgenReq.getIsSlot()) {
				snapshotSummaryObj.setSlot(camgenReq.getIsSlot() == new BigDecimal(1) ? true : false);
			}
			snapshotSummaryObj.setLastModifiedBy(camgenReq.getModifiedBy());

			if (null != camgenReq.getScheduleDateTime()) {
				snapshotSummaryObj.setScheduledDate(new DateTime(camgenReq.getScheduleDateTime()));
				snapshotSummaryObj.setStartTime(new DateTime(camgenReq.getScheduleDateTime()));
			}

			if (null != camgenReq.getFillingStartDate()) {
				snapshotSummaryObj.setFillingStartDate(new DateTime(camgenReq.getFillingStartDate()));
			}

			if (null != camgenReq.getFillingEndDate()) {
				snapshotSummaryObj.setFillingEndDate(new DateTime(camgenReq.getFillingEndDate()));
			}

			snapshotSummaryList.add(snapshotSummaryObj);
		});
		return snapshotSummaryList;
	}

	private StartEndDate mapSnpashotStartEndDate(CamgenRequest camgenReq) {
		StartEndDate startEndDate = new StartEndDate();

		if (null != camgenReq.getStartDate()) {
			startEndDate.setStart(new DateTime(camgenReq.getStartDate()));
		}

		if (null != camgenReq.getEndDate()) {
			startEndDate.setEnd(new DateTime(camgenReq.getEndDate()));
		}

		return startEndDate;
	}

	private List<SnapshotSummaryTxLevels> mapTxLevels(List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList) {
		List<SnapshotSummaryTxLevels> snapshotSummaryTxLevelsList = new ArrayList<>();

		for (CamgenRqstBatchTxLevel camgenRqstBatchTxLevel : camgenRqstBatchTxLevelList) {
			SnapshotSummaryTxLevels snapshotSummaryTxLevels = new SnapshotSummaryTxLevels();

			if (null != camgenRqstBatchTxLevel.getTransmissionLevelId()) {
				snapshotSummaryTxLevels.setTxLevelId(camgenRqstBatchTxLevel.getTransmissionLevelId().longValue());
				snapshotSummaryTxLevelsList.add(snapshotSummaryTxLevels);
			}

		}

		if (CollectionUtils.isEmpty(snapshotSummaryTxLevelsList)) {
			return null;
		}

		return snapshotSummaryTxLevelsList;
	}

	/**
	 * Sets the is slots.
	 *
	 * @param camgenReq
	 *            the camgen req
	 * @return Boolean
	 */
	private Boolean setIsSlots(CamgenRequest camgenReq) {
		Boolean isSlot = null;
		if (null != camgenReq.getIsSlot()) {
			isSlot = camgenReq.getIsSlot().intValue() == 1 ? true : false;
		}
		return isSlot;
	}

	/**
	 * Sets the schedule date time.
	 *
	 * @param camgenReq
	 *            the camgen req
	 * @return Object
	 */
	private Object setScheduleDateTime(CamgenRequest camgenReq) {
		return camgenReq.getCamgenRuns().get(0) == null ? null : camgenReq.getCamgenRuns().get(0).getScheduleDateTime();
	}

	/**
	 * Sets the is run.
	 *
	 * @param camgenReq
	 *            the camgen req
	 * @return Boolean
	 */
	private Boolean setIsRun(CamgenRequest camgenReq) {
		Boolean isRun = null;
		if (null != camgenReq.getIsRun()) {
			isRun = camgenReq.getIsRun().intValue() == 1 ? true : false;
		}

		return isRun;

	}

	/**
	 * creates Snapshot.
	 *
	 * @param manualSnapshot
	 *            the manual snapshot
	 * @return Field
	 */
	@Override
	public List<Field> createSnapshot(List<SnapshotDetail> snapshotDetailList) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : createSnapshot()");
		List<Field> fieldList = new ArrayList<>();
		try {
			List<CamgenRequest> camgenRequestList = new ArrayList<>();
			for (SnapshotDetail snapshotDetail : snapshotDetailList) {
				CamgenRequest camgenRequest = camgenRunParameterMapper.mapCreateSnapshot(snapshotDetail);
				camgenRequestList.add(camgenRequest);
			}
			List<CamgenRequest> camgenRequestRes = camgenRequestJpaRepository.save(camgenRequestList);
			
			if(!CollectionUtils.isEmpty(camgenRequestRes)){
				
				for(CamgenRequest camgenRequest : camgenRequestRes){
					Field field = new Field();
					field.setId(camgenRequest.getRequestId());
					
					fieldList.add(field);
				}
				
			}
			
		} catch (DataAccessException e) {
			LOGGER.error("Exception during creating ManualSnapshot {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : createSnapshot()");
		return fieldList;

	}

	/**
	 * Gets the snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return SnapshotPlanDetail
	 */
	@Override
	public List<SnapshotDetail> getSnapshot(Integer snapshotId, LocalDate scheduledDate, String scheduledStartTime,
			String scheduledEndTime, String status) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : getSnapshot()");
		List<SnapshotDetail> snapshotDetailList = null;
		StringBuilder searchCriteriaOnj = getSearchString(snapshotId, scheduledDate, scheduledStartTime,
				scheduledEndTime, status);
		try {
			List<CamgenRequest> listOfCamgenRequest = camgenRequestJpaRepository
					.findAll(getSpecification(searchCriteriaOnj.toString()));
			if (CollectionUtils.isEmpty(listOfCamgenRequest)) {
				throw new MintBaseException("Data Not Found", HttpStatus.NOT_FOUND.value());
			}
			snapshotDetailList = mapEntityListToSnapshotPlanDetailList(listOfCamgenRequest);
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : getSnapshot()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting SnapshotPlanDetail {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return snapshotDetailList;
	}

	private StringBuilder getSearchString(Integer snapshotId, LocalDate scheduledDate, String scheduledStartTime,
			String scheduledEndTime, String status) {
		StringBuilder searchCriteriaOnj = new StringBuilder();

		addParamIfNotNull(searchCriteriaOnj, "snapshotId[eq]", String.valueOf(snapshotId));
		addParamIfNotNull(searchCriteriaOnj, "scheduledDate[eq]", String.valueOf(scheduledDate));
		addParamIfNotNull(searchCriteriaOnj, "scheduledStartTime[eq]", String.valueOf(scheduledStartTime));
		addParamIfNotNull(searchCriteriaOnj, "scheduledEndTime[eq]", String.valueOf(scheduledEndTime));
		addParamIfNotNull(searchCriteriaOnj, "status[eq]", String.valueOf(status));
		return searchCriteriaOnj;
	}

	/**
	 * @param sb
	 * @param paramName
	 * @param paramValue
	 */
	private void addParamIfNotNull(StringBuilder sb, String paramName, String paramValue) {
		if ((StringUtils.isNotEmpty(paramName) && StringUtils.isNotEmpty(paramValue))
				&& !paramValue.equalsIgnoreCase("null"))
			sb.append(paramName).append(paramValue).append(":");
	}

	/**
	 * @param searchCriteria
	 * @return CamgenRequest CamgenRequest
	 */
	private org.springframework.data.jpa.domain.Specification<CamgenRequest> getSpecification(String searchCriteria) {
		CamgenRequestSpecificationBuilder builder = new CamgenRequestSpecificationBuilder();
		Pattern pattern = Pattern.compile(
				"(\\w+?)(\\[gt\\]|\\[lt\\]|\\[sw\\]|\\[ne\\]|\\[eq\\]|\\[cts\\]|\\[st\\]|\\[in\\])([a-zA-Z0-9\\s\\-\\,]+):");
		Matcher matcher = pattern.matcher(searchCriteria + ":");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		org.springframework.data.jpa.domain.Specification<CamgenRequest> spec = builder.build();
		return spec;
	}

	/**
	 * Map entity list to snapshot plan detail list.
	 *
	 * @param camgenRequest
	 *            the camgen request
	 * @return SnapshotPlanDetail
	 */
	private List<SnapshotDetail> mapEntityListToSnapshotPlanDetailList(List<CamgenRequest> camgenRequestList) {
		List<SnapshotDetail> snapshotDetailList = new ArrayList<>();

		for (CamgenRequest camgenRequest : camgenRequestList) {
			SnapshotDetail snapshotDetailObj = new SnapshotDetail();

			snapshotDetailObj.setSnapshotId(new Integer(Long.toString(camgenRequest.getRequestId())));
			setBasicCamgenRequest(camgenRequest, snapshotDetailObj);

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstDemandSupplies())) {
				snapshotDetailObj.setDemandSupply(getDemapSupply(camgenRequest.getCamgenRqstDemandSupplies()));
			}

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstChSetTimebands())) {
				snapshotDetailObj
						.setChannelSetTimebands(getChannelSetTimeBands(camgenRequest.getCamgenRqstChSetTimebands()));
			}

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstBatchTxLevels())) {
				snapshotDetailObj.setBatchTxLevels(getRqstBatchTxLevels(camgenRequest.getCamgenRqstBatchTxLevels()));
			}

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstBreakExclIncls())) {
				snapshotDetailObj.setCommercialBreakInclExcls(
						getCommercialBreakInclExcls(camgenRequest.getCamgenRqstBreakExclIncls()));
			}

			if (!CollectionUtils.isEmpty(camgenRequest.getCamgenRqstClimExclIncls())) {
				snapshotDetailObj.setCampaignMonthInclExcls(
						getCampaignMonthInclExcls(camgenRequest.getCamgenRqstClimExclIncls()));
			}
			snapshotDetailObj.setCreatedBy(camgenRequest.getCreatedBy());

			snapshotDetailList.add(snapshotDetailObj);
		}
		return snapshotDetailList;
	}

	/**
	 * set Basic CamgenRequest Details
	 * 
	 * @param camgenRequest
	 * @param snapshotDetailObj
	 */
	private void setBasicCamgenRequest(CamgenRequest camgenRequest, SnapshotDetail snapshotDetailObj) {
		snapshotDetailObj.setType(camgenRequest.getRequestType());
		snapshotDetailObj.setChannelSet(camgenRequest.getChannelSetId() == null ? null
				: Long.valueOf(camgenRequest.getChannelSetId().toString()));

		if (null != camgenRequest.getTotalIteration()) {
			snapshotDetailObj.setIterationCount(camgenRequest.getTotalIteration().intValue());
		}

		if (camgenRequest.getCamgenPlan() != null) {
			snapshotDetailObj.setPlanId(camgenRequest.getCamgenPlan().getPlanId());
		}
		snapshotDetailObj.setCamgenRequestStartDate(new LocalDate(camgenRequest.getStartDate()));
		snapshotDetailObj.setCamgenRequestEndDate(new LocalDate(camgenRequest.getEndDate()));
		snapshotDetailObj.setRun(setIsRun(camgenRequest));
		snapshotDetailObj.setSlot(setIsSlots(camgenRequest));
		snapshotDetailObj.setStatus(camgenRequest.getStatus());
		snapshotDetailObj.setCreatedBy(camgenRequest.getCreatedBy());
		if (null != camgenRequest.getCreatedOn()) {
			snapshotDetailObj.setCreatedOn(new DateTime(camgenRequest.getCreatedOn()));
		}
		if (null != camgenRequest.getScheduleDateTime()) {
			snapshotDetailObj.setScheduledDateTime(new LocalDate(camgenRequest.getScheduleDateTime()));
		}
	}

	/**
	 * @param camgenRqstClimExclIncls
	 * @return List of CamgenRequestCMExclIncl
	 */
	private List<CamgenRequestCMExclIncl> getCampaignMonthInclExcls(
			List<CamgenRqstClimExclIncl> camgenRqstClimExclIncls) {
		List<CamgenRequestCMExclIncl> camgenRequestCMExclInclList = new ArrayList<>();
		for (CamgenRqstClimExclIncl camgenRqstClimExclIncl : camgenRqstClimExclIncls) {
			CamgenRequestCMExclIncl camgenRequestCMExclIncl = new CamgenRequestCMExclIncl();
			if (camgenRqstClimExclIncl.getCampaignLineMonthId() != null) {
				camgenRequestCMExclIncl
						.setCmId(Long.valueOf(camgenRqstClimExclIncl.getCampaignLineMonthId().toString()));
			}
			camgenRequestCMExclIncl.setId(camgenRqstClimExclIncl.getCamgenRqstClimExclInclId());
			if (camgenRqstClimExclIncl.getIsExcluded() != null
					&& "1".equalsIgnoreCase(camgenRqstClimExclIncl.getIsExcluded().toString())) {
				camgenRequestCMExclIncl.setIsExcluded(true);
			} else {
				camgenRequestCMExclIncl.setIsExcluded(false);
			}
			camgenRequestCMExclInclList.add(camgenRequestCMExclIncl);
		}
		return camgenRequestCMExclInclList;
	}

	/**
	 * @param camgenRqstBreakExclIncls
	 * @return List of CamgenRequestBreakExclIncl
	 */
	private List<CamgenRequestBreakExclIncl> getCommercialBreakInclExcls(
			List<CamgenRqstBreakExclIncl> camgenRqstBreakExclIncls) {
		List<CamgenRequestBreakExclIncl> camgenRequestBreakExclInclList = new ArrayList<>();
		for (CamgenRqstBreakExclIncl camgenRqstBreakExclIncl : camgenRqstBreakExclIncls) {
			CamgenRequestBreakExclIncl camgenRequestBreakExclIncl = new CamgenRequestBreakExclIncl();
			camgenRequestBreakExclIncl.setId(camgenRqstBreakExclIncl.getCamgenRqstBreakExclInclId());
			if (camgenRqstBreakExclIncl.getCommercialBreakId() != null) {
				camgenRequestBreakExclIncl
						.setCommercialBreakId(Long.valueOf(camgenRqstBreakExclIncl.getCommercialBreakId().toString()));
			}
			if (camgenRqstBreakExclIncl.getIsExcluded() != null
					&& "1".equalsIgnoreCase(camgenRqstBreakExclIncl.getIsExcluded().toString()))
				camgenRequestBreakExclIncl.setIsExcluded(true);
			else {
				camgenRequestBreakExclIncl.setIsExcluded(false);
			}
			camgenRequestBreakExclInclList.add(camgenRequestBreakExclIncl);
		}
		return camgenRequestBreakExclInclList;
	}

	/**
	 * Gets the demap supply.
	 *
	 * @param camgenPlan
	 *            the camgen plan
	 * @return DemandSupplyGroup
	 */
	private ChannelSetTimeBands getChannelSetTimeBands(List<CamgenRqstChSetTimeband> camgenRqstChSetTimebandList) {
		ChannelSetTimeBands channelSetTimeBands = new ChannelSetTimeBands();
		for (CamgenRqstChSetTimeband camgenRqstChSetTimeband : camgenRqstChSetTimebandList) {
			ChannelSetTimeBand channelSetTimeBand = new ChannelSetTimeBand();
			channelSetTimeBand.setId((int) camgenRqstChSetTimeband.getCamgenRqstChSetTimebandId());
			if (camgenRqstChSetTimeband.getCamgenRequest() != null
					&& camgenRqstChSetTimeband.getCamgenRequest().getChannelSetId() != null) {
				channelSetTimeBand.setChannelSetId(
						Integer.parseInt(camgenRqstChSetTimeband.getCamgenRequest().getChannelSetId().toString()));
			}
			channelSetTimeBand.setDay(camgenRqstChSetTimeband.getApplicableDay());
			channelSetTimeBand.setStartTime(camgenRqstChSetTimeband.getStartTime());
			channelSetTimeBand.setEndTime(camgenRqstChSetTimeband.getEndTime());
			channelSetTimeBand.setName(camgenRqstChSetTimeband.getTimeband());
			if (camgenRqstChSetTimeband.getAvailabilityPercentage() != null) {
				channelSetTimeBand.setAvailability(
						Double.valueOf(camgenRqstChSetTimeband.getAvailabilityPercentage().toString()));
			}
			channelSetTimeBands.add(channelSetTimeBand);
		}
		return channelSetTimeBands;

	}

	/**
	 * @param camgenRqstBatchTxLevelList
	 * @return BatchTxLevels BatchTxLevels
	 */
	private BatchTxLevels getRqstBatchTxLevels(List<CamgenRqstBatchTxLevel> camgenRqstBatchTxLevelList) {
		BatchTxLevels batchTxLevels = new BatchTxLevels();

		for (CamgenRqstBatchTxLevel camgenRqstBatchTxLevel : camgenRqstBatchTxLevelList) {
			BatchTxLevel batchTxLevel = new BatchTxLevel();
			batchTxLevel.setId((int) camgenRqstBatchTxLevel.getBatchTxLevelId());
			if (camgenRqstBatchTxLevel.getTransmissionLevelId() != null) {
				batchTxLevel.setTxLevelId(Long.valueOf(camgenRqstBatchTxLevel.getTransmissionLevelId().intValue()));
			}
			if (camgenRqstBatchTxLevel.getBatchValue() != null) {
				batchTxLevel.setBatchTxLevelValue(camgenRqstBatchTxLevel.getBatchValue().intValue());
			}
			batchTxLevels.add(batchTxLevel);
		}
		return batchTxLevels;
	}

	/**
	 * Gets the demap supply.
	 *
	 * @param camgenPlan
	 *            the camgen plan
	 * @return DemandSupplyGroup
	 */
	private List<DemandSupplyGroup> getDemapSupply(List<CamgenRqstDemandSupply> camgenRqstDemandSupplyList) {
		List<DemandSupplyGroup> demandSupplyGroupList = new ArrayList<>();
		for (CamgenRqstDemandSupply camgenPlanDemandSupply : camgenRqstDemandSupplyList) {
			DemandSupplyGroup demandSupplyGroupInner = new DemandSupplyGroup();

			demandSupplyGroupInner
					.setDemandSupplyId(Integer.valueOf(String.valueOf(camgenPlanDemandSupply.getDemandSupplyId())));
			demandSupplyGroupInner.setName(camgenPlanDemandSupply.getName());
			if (null != camgenPlanDemandSupply.getCamgenDemandSupplyLevel()) {
				demandSupplyGroupInner
						.setLevelId(camgenPlanDemandSupply.getCamgenDemandSupplyLevel().getDemandSupplyLevelId());
				demandSupplyGroupInner.setLevelCode(LevelCodeEnum
						.fromValue(camgenPlanDemandSupply.getCamgenDemandSupplyLevel().getDemandSupplyLevelCode()));
			}

			if (null != camgenPlanDemandSupply.getAmendmentPercentage()) {
				demandSupplyGroupInner
						.setAmendmentPercent(camgenPlanDemandSupply.getAmendmentPercentage().doubleValue());
			}
			if (!CollectionUtils.isEmpty(camgenPlanDemandSupply.getRqstDemandSupplyCriterias())) {
				demandSupplyGroupInner
						.setCriterias(getCriteriaLine(camgenPlanDemandSupply.getRqstDemandSupplyCriterias()));
			}

			demandSupplyGroupList.add(demandSupplyGroupInner);
		}
		return demandSupplyGroupList;
	}

	/**
	 * Gets the criteria line.
	 *
	 * @param camgenPlanDemandSupply
	 *            the camgen plan demand supply
	 * @return CriteriaLine
	 */
	private List<CriteriaLine> getCriteriaLine(List<RqstDemandSupplyCriteria> rqstDemandSupplyCriteriaList) {
		List<CriteriaLine> criteriaLineList = new ArrayList<>();
		for (RqstDemandSupplyCriteria planDemandSupplyCriteria : rqstDemandSupplyCriteriaList) {
			CriteriaLine criteriaLine = new CriteriaLine();
			criteriaLine.setCriteriaLineId(planDemandSupplyCriteria.getRqstDemandSupplyCriteriaId());
			if (planDemandSupplyCriteria.getOperator() != null) {
				criteriaLine.setOperator(OperatorEnum.valueOf(planDemandSupplyCriteria.getOperator()));
			}
			if (null != planDemandSupplyCriteria.getCamgenDemandSupplyObject()) {
				criteriaLine
						.setObjectId(planDemandSupplyCriteria.getCamgenDemandSupplyObject().getDemandSupplyObjectId());
				criteriaLine.setObjectCode(
						planDemandSupplyCriteria.getCamgenDemandSupplyObject().getDemandSupplyObjectCode());
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
			criteriaLine.setValue(planDemandSupplyCriteria.getValue());
			criteriaLineList.add(criteriaLine);
		}
		return criteriaLineList;
	}

	/**
	 * Gets the auto filling list.
	 *
	 * @param camgenRequest
	 *            the camgen request
	 * @return AutoFillingDaySetup
	 */
	private List<AutoFillingDaySetup> getAutoFillingList(CamgenRequest camgenRequest) {
		List<AutoFillingDaySetup> autoFillingList = new ArrayList<>();

		camgenRequest.getCamgenPlan().getCamgenPlanAutofillingDays().stream().forEach(autoFillingDays -> {
			AutoFillingDaySetup autoFillingDaySetup = new AutoFillingDaySetup();
			autoFillingDaySetup.setDuration(autoFillingDays.getDuration());
			autoFillingDaySetup.setOffset(Long.valueOf(autoFillingDays.getOffset().toString()));
			autoFillingDaySetup.setRunDay(RunDayEnum.fromValue(autoFillingDays.getRunDay()));
			autoFillingDaySetup.setStartTime(autoFillingDays.getStartTime());
			autoFillingList.add(autoFillingDaySetup);
		});

		return autoFillingList;
	}

	/**
	 * Gets the camgen snapshot run details by snapshot id.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public CamgenSnapshotRunDetails getCamgenSnapshotRunDetailsBySnapshotId(Integer snapshotId) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : getCamgenSnapshotRunDetailsBySnapshotId()");
		CamgenSnapshotRunDetails camgenSnapshotRunDetails = null;
		try {
			CamgenRequest camgenRequest = camgenRequestJpaRepository.findOne(Long.valueOf(snapshotId.toString()));
			if (null == camgenRequest || CollectionUtils.isEmpty(camgenRequest.getCamgenRuns())) {
				LOGGER.error(CamgenConstant.DATA_NOT_FOUND);
				throw new MintBaseException(CamgenConstant.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			camgenSnapshotRunDetails = mapEntityListToCamgenSnapshotRunDetails(camgenRequest);
			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : getCamgenSnapshotRunDetailsBySnapshotId()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting CamgenSnapshotRunDetails {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return camgenSnapshotRunDetails;
	}

	/**
	 * Map entity list to camgen snapshot run details.
	 *
	 * @param camgenRequest
	 *            the camgen request
	 * @return CamgenSnapshotRunDetails
	 */
	private CamgenSnapshotRunDetails mapEntityListToCamgenSnapshotRunDetails(CamgenRequest camgenRequest) {
		CamgenSnapshotRunDetails camgenSnapshotRunDetails = new CamgenSnapshotRunDetails();

		for (CamgenRun camgenRunLocal : camgenRequest.getCamgenRuns()) {
			CamgenSnapshotRunDetail camgenSnapshotRunDetail = new CamgenSnapshotRunDetail();

			camgenSnapshotRunDetail.setRunId((int) camgenRunLocal.getRunId());
			if (null != camgenRunLocal.getCamgenRequest()) {
				camgenSnapshotRunDetail.setSnapshotId(camgenRunLocal.getCamgenRequest().getRequestId());
			}

			if (null != camgenRunLocal.getIterationNumberFile()) {

				camgenSnapshotRunDetail.setIterationCount(camgenRunLocal.getIterationNumberFile().intValue());
			}

			if (null != camgenRunLocal.getStartDateTime()) {
				camgenSnapshotRunDetail.setRunDateTime(new LocalDate(camgenRunLocal.getStartDateTime()).toString());
			}
			camgenSnapshotRunDetail.setRunStatus(camgenRunLocal.getStatus());

			if (null != camgenRunLocal.getIsFileImported()) {
				camgenSnapshotRunDetail.setSlotFileImportStatus(
						camgenRunLocal.getIsFileImported() == new BigDecimal(1) ? "Imported" : "Not Imported");
			}

			if (null != camgenRunLocal.getIsSlot()) {
				BigDecimal bigdecilamlTrue = new BigDecimal(1);
				camgenSnapshotRunDetail.setSlotFlag(camgenRunLocal.getIsSlot().equals(bigdecilamlTrue) ? true : false);
			}
			camgenSnapshotRunDetail.setNotes(camgenRunLocal.getNote());
			camgenSnapshotRunDetail.setSlotFileLastImportDate(new LocalDate(camgenRunLocal.getFileImportDate()));
			List<CamgenRunParam> camgenRunParameters = new ArrayList<>();

			if (!CollectionUtils.isEmpty(camgenRunLocal.getRunParameters()))
				camgenRunLocal.getRunParameters().forEach(e -> {
					CamgenRunParam camgenRunParam = new CamgenRunParam();
					camgenRunParam.setCreatedBy(e.getCreatedBy());
					camgenRunParam.setRunParameterId((int) e.getParameterId());
					camgenRunParam.setValue(e.getValue());
					camgenRunParam.setStandardvalue(e.getValue());
					camgenRunParam.setRemarks(e.getDescription());
					camgenRunParameters.add(camgenRunParam);

				});
			camgenSnapshotRunDetail.setCamgenRunParameters(camgenRunParameters);

			List<CamgenRunParamAudGroupChannel> camgenRunParamAudGroupChannels = new ArrayList<>();
			if (!CollectionUtils.isEmpty(camgenRunLocal.getRunAudienceGroupChannels())) {
				camgenRunLocal.getRunAudienceGroupChannels().forEach(audienceGroup -> {
					CamgenRunParamAudGroupChannel camgenRunParamAudGroupChannel = new CamgenRunParamAudGroupChannel();

					if (null != audienceGroup)
						camgenRunParamAudGroupChannel.setChannelId(audienceGroup.getChannelId().intValue());
					if (null != audienceGroup.getAudienceId())
						camgenRunParamAudGroupChannel.setAudienceGroupId(audienceGroup.getAudienceId().intValue());
					camgenRunParamAudGroupChannel
							.setRunParameterAudienceGroupChannelId((int) audienceGroup.getAudienceGroupChannelId());
					if (null != audienceGroup.getTargetPercentage()) {
						camgenRunParamAudGroupChannel
								.setTargetPercentage(audienceGroup.getTargetPercentage().toString());
					}
					camgenRunParamAudGroupChannels.add(camgenRunParamAudGroupChannel);

				});
				camgenSnapshotRunDetail.setCamgenRunParamAudGroupChannels(camgenRunParamAudGroupChannels);
			}
			if (null != camgenRunLocal.getRunEiBands()) {
				List<CamgenRunParamEIBand> camgenRunParamEIBands = new ArrayList<>();
				camgenRunLocal.getRunEiBands().forEach(eiBands -> {
					CamgenRunParamEIBand camgenRunParamEIBand = new CamgenRunParamEIBand();
					camgenRunParamEIBand.setEiBand(eiBands.getEiBand().intValueExact());
					camgenRunParamEIBand.setRunParameterEIBandId((int) eiBands.getEiBandId());
					camgenRunParamEIBands.add(camgenRunParamEIBand);
				});
				camgenSnapshotRunDetail.setCamgenRunParamEIBands(camgenRunParamEIBands);
			}
			if (!CollectionUtils.isEmpty(camgenRunLocal.getRunStationEiTimebands())) {
				List<CamgenRunParamStationEITimeBand> camgenRunParamStationEITimeBands = new ArrayList<>();
				camgenRunLocal.getRunStationEiTimebands().forEach(stationEiBand -> {
					CamgenRunParamStationEITimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationEITimeBand();
					camgenRunParamStationTimeBand.setDayCode(stationEiBand.getApplicableDay());
					camgenRunParamStationTimeBand
							.setRunParameterStationEITimeBandId((int) stationEiBand.getStationEiTimebandId());
					camgenRunParamStationTimeBand.setStartTime(stationEiBand.getStartTime());
					camgenRunParamStationTimeBand.setEndTime(stationEiBand.getEndTime());
					camgenRunParamStationEITimeBands.add(camgenRunParamStationTimeBand);
				});
				camgenSnapshotRunDetail.setCamgenRunParamStationEITimeBands(camgenRunParamStationEITimeBands);
			}
			List<CamgenRunParamStationTimeBand> camgenRunParamStationTimeBands = new ArrayList<>();
			if (!CollectionUtils.isEmpty(camgenRunLocal.getRunStationTimebands())) {
				camgenRunLocal.getRunStationTimebands().forEach(stationTimeBand -> {
					CamgenRunParamStationTimeBand camgenRunParamStationTimeBand = new CamgenRunParamStationTimeBand();
					if (null != stationTimeBand.getAmendDemand()) {
						camgenRunParamStationTimeBand.setAmendDemand(stationTimeBand.getAmendDemand().intValue());
					}
					if (null != stationTimeBand.getChannelId())
						camgenRunParamStationTimeBand.setChannelId(stationTimeBand.getChannelId().intValue());

					if (null != stationTimeBand.getEiCutOff()) {
						camgenRunParamStationTimeBand.setEiCutOff(stationTimeBand.getEiCutOff().intValue());
					}

					camgenRunParamStationTimeBand
							.setExcludeFlag(stationTimeBand.getIsExclude() == new BigDecimal(1) ? "true" : "false");
					camgenRunParamStationTimeBand.setEndTime(stationTimeBand.getEndTime());
					camgenRunParamStationTimeBand.setStartTime(stationTimeBand.getStartTime());
					if (null != stationTimeBand.getTbProgRepititionLimit()) {
						camgenRunParamStationTimeBand
								.setTbProgRepetitionLimit(stationTimeBand.getTbProgRepititionLimit().intValue());
					}
					camgenRunParamStationTimeBand.setName(stationTimeBand.getTimeband());
					camgenRunParamStationTimeBand.setStationTimeBandId((int) stationTimeBand.getStationTimebandId());
					camgenRunParamStationTimeBand
							.setRunParameterStationTimeBandId((int) stationTimeBand.getStationTimebandId());
					camgenRunParamStationTimeBands.add(camgenRunParamStationTimeBand);
				});
				camgenSnapshotRunDetail.setCamgenRunParamStationTimeBands(camgenRunParamStationTimeBands);
			}
			if (!CollectionUtils.isEmpty(camgenRunLocal.getRunExtractParameters())) {
				List<CamgenRunParamExtract> camgenRunParamExtracts = new ArrayList<>();
				camgenRunLocal.getRunExtractParameters().forEach(extract -> {
					CamgenRunParamExtract camgenRunParamExtract = new CamgenRunParamExtract();
					camgenRunParamExtract.setParameter(extract.getExtractParameterName());
					camgenRunParamExtract.setRunParameterExtractId((int) extract.getExtractParameterId());
					camgenRunParamExtract.setValue(extract.getValue());
					camgenRunParamExtracts.add(camgenRunParamExtract);
				});
				camgenSnapshotRunDetail.setCamgenRunParamExtracts(camgenRunParamExtracts);
			}
			camgenSnapshotRunDetails.add(camgenSnapshotRunDetail);
		}

		return camgenSnapshotRunDetails;
	}

	/**
	 * Delete snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 */
	@Override
	public void deleteSnapshot(Integer snapshotId) {
		LOGGER.info(" >> SnapshotRunDetailsRepositoryImpl : deleteSnapshot()");
		try {
			CamgenRequest camgenRequest = camgenRequestJpaRepository.findOne(Long.valueOf(snapshotId));
			camgenRequestJpaRepository.delete(camgenRequest);
		} catch (DataAccessException e) {
			LOGGER.error("Exception during deleting Snapshot {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : deleteSnapshot()");

	}

	/**
	 * Update snapshots.
	 *
	 * @param snapshots
	 *            the snapshots
	 */
	@Override
	public void updateSnapshots(SnapshotDetail snapshots) {
		try {
			CamgenRequest camgenRequest = camgenRequestJpaRepository.findOne(Long.valueOf(snapshots.getSnapshotId()));
			if (null == camgenRequest) {
				LOGGER.info(CamgenConstant.DATA_NOT_FOUND);
				throw new MintBaseException(CamgenConstant.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

			camgenRequestJpaRepository
					.save(camgenRunParameterMapper.mapCamgenRequestForUpdate(camgenRequest, snapshots));

			LOGGER.info(" << SnapshotRunDetailsRepositoryImpl : updateSnapshots()");
		} catch (DataAccessException e) {
			LOGGER.error("Exception during getting updateSnapshots {}", e);
			throw new MintBaseException(CamgenConstant.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
