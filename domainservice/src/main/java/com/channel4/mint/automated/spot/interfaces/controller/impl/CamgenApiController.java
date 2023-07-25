/*
 * 
 */
package com.channel4.mint.automated.spot.interfaces.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.channel4.mint.automated.spot.interfaces.controller.CamgenApi;
import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration;
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
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;
import com.channel4.mint.automated.spot.service.BulkAmendService;
import com.channel4.mint.automated.spot.service.CamgenExclusionCategoryService;
import com.channel4.mint.automated.spot.service.CamgenParamAudGroupChannelsService;
import com.channel4.mint.automated.spot.service.CamgenParamEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParamRunEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParametersService;
import com.channel4.mint.automated.spot.service.CamgenService;
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
import com.channel4.mint.baseexception.MintBaseException;
import com.channel4.mint.httpexception.MintHttpException;

import io.swagger.annotations.ApiParam;

/**
 * This is controller class which implements CamgenApi for handle camgen related
 * operations.
 *
 */
@Controller
public class CamgenApiController implements CamgenApi {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenApiController.class);

	/** The run iteration service. */
	@Autowired
	private RunIterationService runIterationService;

	/** The snapshot run details service. */
	@Autowired
	private SnapshotRunDetailsService snapshotRunDetailsService;

	/** The station EI time bands service. */
	@Autowired
	private StationEITimeBandsService stationEITimeBandsService;

	/** The station time bands service. */
	@Autowired
	private StationTimeBandsService stationTimeBandsService;

	/** The camgen parameters service. */
	@Autowired
	private CamgenParametersService camgenParametersService;

	/** The camgen param aud group channels service. */
	@Autowired
	private CamgenParamAudGroupChannelsService camgenParamAudGroupChannelsService;

	/** The camgen param EI bands service. */
	@Autowired
	private CamgenParamRunEIBandsService camgenParamEIBandsService;

	/** The parameters service. */
	@Autowired
	private ExtractParametersService parametersService;

	/** The param extracts service. */
	@Autowired
	private ParamExtractsService paramExtractsService;

	/** The param station EI time bands service. */
	@Autowired
	private ParamStationEITimeBandsService paramStationEITimeBandsService;

	/** The param station time bands service. */
	@Autowired
	private ParamStationTimeBandsService paramStationTimeBandsService;

	/** The global parameters service. */
	@Autowired
	private GlobalParametersService globalParametersService;

	/** The camgen parm EI bands service. */
	@Autowired
	private CamgenParamEIBandsService camgenParmEIBandsService;

	/** The demand supply service. */
	@Autowired
	private DemandSupplyService demandSupplyService;

	/** The snapshot param channel set timebands. */
	@Autowired
	private SnapshotParamChannelSetTimebands snapshotParamChannelSetTimebands;

	/** The snapshot param batch tx levels. */
	@Autowired
	private SnapshotParamBatchTxLevelsService snapshotParamBatchTxLevels;

	@Autowired
	private PlanService planService;

	@Autowired
	private ChannelSetTimebandsService channelSetTimebandsService;

	@Autowired
	private CamgenService camgenService;

	@Autowired
	private CamgenExclusionCategoryService camgenExclusionCategoryService;

	@Autowired
	private BulkAmendService bulkAmendService;

	/**
	 * Creates the camgen param aud group channels.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Void> createCamgenParamAudGroupChannels(
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenParamAudGroupChannels body) {
		LOGGER.info(" >> CamgenApiController : createCamgenParamAudGroupChannels()");
		try {
			camgenParamAudGroupChannelsService.createCamgenParamAudGroupChannels(body);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while ceating CamgenParamAudGroupChannels {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenParamAudGroupChannels()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen param aud group channels.
	 * 
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenParamAudGroupChannels
	 */
	@Override
	public ResponseEntity<CamgenParamAudGroupChannels> getCamgenParameterAudienceGroupChannels() {
		LOGGER.info(" >> CamgenApiController : getCamgenParamAudGroupChannels()");
		CamgenParamAudGroupChannels camgenParamAudGroupChannels;
		try {
			camgenParamAudGroupChannels = camgenParamAudGroupChannelsService.getCamgenParamAudGroupChannels();
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting CamgenParamAudGroupChannels {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenParamAudGroupChannels()");
		return new ResponseEntity<>(camgenParamAudGroupChannels, HttpStatus.OK);
	}

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParameters
	 */
	@Override
	public ResponseEntity<CamgenRunParameters> getCamgenRunParameters(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(" >> CamgenApiController : getCamgenRunParameters()");
		CamgenRunParameters camgenRunParameters;
		try {
			camgenRunParameters = parametersService.getCamgenRunParameters(runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting CamgenRunParameters {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenRunParameters()");
		return new ResponseEntity<>(camgenRunParameters, HttpStatus.OK);
	}

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParameters(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParameters body) {
		LOGGER.info(" >> CamgenApiController : createCamgenRunParameters()");
		try {
			parametersService.createCamgenRunParameters(body, runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting createCamgenRunParameters {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenRunParameters()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParamExtracts the camgen run param extracts
	 */
	@Override
	public ResponseEntity<CamgenRunParamExtracts> getCamgenRunParamExtracts(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(" >> CamgenApiController : getCamgenRunParamExtracts()");
		CamgenRunParamExtracts camgenRunParamExtracts;
		try {
			camgenRunParamExtracts = paramExtractsService.getCamgenRunParamExtracts(runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting getCamgenRunParamExtracts {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenRunParamExtracts()");
		return new ResponseEntity<>(camgenRunParamExtracts, HttpStatus.OK);
	}

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParamExtracts(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParamExtracts body) {
		LOGGER.info(" >> CamgenApiController : createCamgenRunParamExtracts()");
		try {
			paramExtractsService.createCamgenRunParamExtracts(body, runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while creating createCamgenRunParamExtracts {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenRunParamExtracts()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParamStationEITimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParamStationEITimeBands body) {
		LOGGER.info(" >> CamgenApiController : createCamgenRunParamStationEITimeBands()");
		try {
			paramStationEITimeBandsService.createCamgenRunParamStationEITimeBands(body, runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while creating createCamgenRunParamStationEITimeBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenRunParamStationEITimeBands()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParamStationEITimeBands
	 */
	@Override
	public ResponseEntity<CamgenRunParamStationEITimeBands> getCamgenRunParamStationEITimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(" >> CamgenApiController : getCamgenRunParamStationEITimeBands()");
		CamgenRunParamStationEITimeBands camgenRunParamStationEITimeBands;
		try {
			camgenRunParamStationEITimeBands = paramStationEITimeBandsService
					.getCamgenRunParamStationEITimeBands(runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting getCamgenRunParamStationEITimeBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenRunParamStationEITimeBands()");
		return new ResponseEntity<>(camgenRunParamStationEITimeBands, HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param station time bands.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParamStationTimeBands
	 */
	@Override
	public ResponseEntity<CamgenRunParamStationTimeBands> getCamgenRunParamStationTimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(" >> CamgenApiController : getCamgenRunParamStationTimeBands()");
		CamgenRunParamStationTimeBands camgenRunParamStationTimeBands;
		try {
			camgenRunParamStationTimeBands = paramStationTimeBandsService.getCamgenRunParamStationEITimeBands(runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting getCamgenRunParamStationTimeBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenRunParamStationTimeBands()");
		return new ResponseEntity<>(camgenRunParamStationTimeBands, HttpStatus.OK);
	}

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParamStationTimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenRunParamStationTimeBands body) {
		LOGGER.info(" >> CamgenApiController : createCamgenRunParamStationTimeBands()");
		try {
			paramStationTimeBandsService.createCamgenRunParamStationTimeBands(body, runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while creating createCamgenRunParamStationTimeBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenRunParamStationTimeBands()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParamEIBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for EI Bands", required = true) @Valid @RequestBody CamgenRunParamEIBands body) {
		LOGGER.info(" >> CamgenApiController : createCamgenRunParamEIBands()");
		try {
			camgenParamEIBandsService.createCamgenRunParamEIBands(body, runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while creating createCamgenRunParamEIBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : createCamgenRunParamEIBands()");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParamEIBands
	 */
	@Override
	public ResponseEntity<CamgenRunParamEIBands> getCamgenRunParamEIBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(" >> CamgenApiController : getCamgenRunParamEIBands()");
		CamgenRunParamEIBands camgenRunParamEIBands;
		try {
			camgenRunParamEIBands = camgenParamEIBandsService.getCamgenRunParamEIBands(runId);
		} catch (MintBaseException e) {
			LOGGER.info("Exception while geting getCamgenRunParamEIBands {} ", e);
			throw new MintHttpException(e.getMessage(), e.getCode(), HttpStatus.valueOf(e.getCode()));
		}
		LOGGER.info(" << CamgenApiController : getCamgenRunParamEIBands()");
		return new ResponseEntity<>(camgenRunParamEIBands, HttpStatus.OK);
	}

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParamExtracts(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamExtracts body) {

		LOGGER.info(">> of createCamgenParamExtracts() of CamgenApiController.");
		try {
			parametersService.createCamgenParamExtracts(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Exception while geting createCamgenParamExtracts {} ", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParamExtracts() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/**
	 * method for create station eli time bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParamStationEITimeBands(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamStationEITimeBands body) {
		LOGGER.info(">> of createCamgenParamStationEITimeBands() of CamgenApiController.");
		try {
			stationEITimeBandsService.createCamgenParamStationEITimeBands(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception while geting createCamgenParamStationEITimeBands{}",
					mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParamStationEITimeBands() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * method for create station time bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParamStationTimeBands(
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenParamStationTimeBands body) {
		LOGGER.info(">> of createCamgenParamStationTimeBands() of CamgenApiController.");
		try {
			stationTimeBandsService.createCamgenParamStationTimeBands(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception while geting createCamgenParamStationTimeBands{}",
					mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParamStationTimeBands() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * method for create el bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParameters(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParameters body) {
		LOGGER.info(">> of createCamgenParameters() of CamgenApiController.");
		try {
			camgenParametersService.createCamgenParameters(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenParameters {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParameters() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * method for create el bands.
	 *
	 * @param camgenParamEIBandsRequest
	 *            the camgen param EI bands request
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParameters(
			@ApiParam(value = "Camgen Parameters for EI Bands", required = true) @Valid @RequestBody CamgenParamEIBands camgenParamEIBandsRequest) {
		LOGGER.info(">> of createCamgenParameters() of CamgenApiController.");
		try {
			camgenParmEIBandsService.createCamgenParameters(camgenParamEIBandsRequest);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenParameters{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParameters() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * method for create camgen run iterations.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<CamgenRunIteration> createCamgenRunIterations(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunIterations body) {
		LOGGER.info(">> of createCamgenRunIterations() of CamgenApiController.");
		try {
			runIterationService.createCamgenRunIterations(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenRunIterations {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenRunIterations() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenRunParamAudGroupChannels(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenRunParamAudGroupChannels body) {
		LOGGER.info(">> of createCamgenRunParamAudGroupChannels() of CamgenApiController.");
		try {
			snapshotRunDetailsService.createCamgenRunParamAudGroupChannels(body, runId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenRunParamAudGroupChannels{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenRunParamAudGroupChannels() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * method for create camgen snap shot run details.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<NewEntityCreated> createCamgenSnapshotRunDetails(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenSnapshotRunDetail body) {
		LOGGER.info(">> of createCamgenSnapshotRunDetails() of CampgenApiController.");
		NewEntityCreated newEntity;
		try {
			newEntity = snapshotRunDetailsService.createCamgenSnapshotRunDetails(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenSnapshotRunDetails{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenSnapshotRunDetails() of CampgenApiController.");
		return new ResponseEntity<>(newEntity, HttpStatus.OK);
	}

	public ResponseEntity<List<Field>> createSnapshot(
			@ApiParam(value = "") @Valid @RequestBody List<SnapshotDetail> snapshots) {
		LOGGER.info(">> of createSnapshot() of CampgenApiController.");
		List<Field> field = null;
		try {
			field = snapshotRunDetailsService.createSnapshot(snapshots);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createSnapshot{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createSnapshot() of CampgenApiController.");
		return new ResponseEntity<>(field, HttpStatus.OK);
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
	 * @throws MintHttpException
	 *             mint http exception
	 * @return SnapshotSummary
	 */
	@Override
	public ResponseEntity<SnapshotSummaryWithPagination> getSnapshotsList(
			@NotNull @ApiParam(value = "Page number, default value is 1", required = true) @Valid @RequestParam(value = "page", required = true) Integer page,
			@NotNull @ApiParam(value = "Number of rows per page, default value is 20", required = true) @Valid @RequestParam(value = "count", required = true) Long count,
			@ApiParam(value = "Sorting order ASC or DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
			@ApiParam(value = "Sort the results by field name") @Valid @RequestParam(value = "sortByField", required = false) String sortByField) {

		LOGGER.info(">> of getAllSnapshots() of CampgenApiController.");
		SnapshotSummaryWithPagination snapshotSummaryWithPagination = null;
		try {
			snapshotSummaryWithPagination = snapshotRunDetailsService.getAllSnapshots(page, count, sortOrder,
					sortByField);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getAllSnapshots{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getAllSnapshots() of CampgenApiController.");
		return new ResponseEntity<>(snapshotSummaryWithPagination, HttpStatus.OK);
	}

	/**
	 * method for get camgen parameters.
	 *
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenParamEIBands
	 */
	@Override
	public ResponseEntity<CamgenParamEIBands> getCamgenParamEIBands() {
		LOGGER.info(">> of getCamgenParamEIBands() of CampgenApiController.");
		CamgenParamEIBands camgenParamEIBands = null;
		try {
			camgenParamEIBands = camgenParmEIBandsService.getCamgenParamEIBands();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenParamEIBands{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParamEIBands() of CampgenApiController.");
		return new ResponseEntity<>(camgenParamEIBands, HttpStatus.OK);
	}

	/**
	 * Gets the camgen param extracts.
	 * 
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenParamExtracts
	 */
	@Override
	public ResponseEntity<CamgenParamExtracts> getCamgenParameterExtracts() {
		LOGGER.info(">> of getCamgenParameterExtracts() of CampgenApiController.");
		CamgenParamExtracts camgenParamExtracts = null;
		try {
			camgenParamExtracts = parametersService.getCamgenParamExtracts();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenParameterExtracts{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParameterExtracts() of CampgenApiController.");
		return new ResponseEntity<>(camgenParamExtracts, HttpStatus.OK);
	}

	/**
	 * method for get station eli time bands.
	 *
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenParamStationEITimeBands
	 */
	@Override
	public ResponseEntity<CamgenParamStationEITimeBands> getCamgenParamStationEITimeBands() {
		LOGGER.info(">> of getCamgenParamStationEITimeBands() of CamgenApiController.");
		CamgenParamStationEITimeBands camgenParamStationEITimeBands = null;
		try {
			camgenParamStationEITimeBands = stationEITimeBandsService.getCamgenParamStationEITimeBands();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenParamStationEITimeBands{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParamStationEITimeBands() of CamgenApiController.");
		return new ResponseEntity<>(camgenParamStationEITimeBands, HttpStatus.OK);
	}

	/**
	 * method for get station time bands.
	 *
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenParamStationTimeBands
	 */
	@Override
	public ResponseEntity<CamgenParamStationTimeBands> getCamgenParamStationTimeBands() {
		LOGGER.info(">> of getCamgenParamStationTimeBands() of CamgenApiController.");
		CamgenParamStationTimeBands camgenParamStationTimeBands = null;
		try {
			camgenParamStationTimeBands = stationTimeBandsService.getCamgenParamStationTimeBands();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenParamStationTimeBands{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParamStationTimeBands() of CamgenApiController.");
		return new ResponseEntity<>(camgenParamStationTimeBands, HttpStatus.OK);
	}

	/**
	 * Gets the camgen parameters.
	 * 
	 * @throws MintHttpException
	 *             mint http exception
	 *
	 * @return CamgenParameters
	 */
	@Override
	public ResponseEntity<CamgenParameters> getCamgenParameters() {
		LOGGER.info(">> of getCamgenParameters() of CamgenApiController.");
		CamgenParameters camgenParameters = null;
		try {
			camgenParameters = camgenParametersService.getCamgenParameters();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenParameters{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParameters() of CamgenApiController.");
		return new ResponseEntity<>(camgenParameters, HttpStatus.OK);
	}

	/**
	 * method for get run iterations.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunIterations
	 */
	@Override
	public ResponseEntity<CamgenRunIterations> getCamgenRunIterations(
			@ApiParam(value = "The ID of the snapshot to retrieve", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(">> of getCamgenRunIterations() of CamgenApiController.");
		CamgenRunIterations camgenRunIterations = null;
		try {
			camgenRunIterations = runIterationService.getCamgenRunIterations(runId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenRunIterations{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenRunIterations() of CamgenApiController.");
		return new ResponseEntity<>(camgenRunIterations, HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenRunParamAudGroupChannels
	 */
	@Override
	public ResponseEntity<CamgenRunParamAudGroupChannels> getCamgenRunParamAudGroupChannels(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId) {
		LOGGER.info(">> of getCamgenRunParamAudGroupChannels() of CamgenApiController.");
		CamgenRunParamAudGroupChannels camgenRunParamAudGroupChannels = new CamgenRunParamAudGroupChannels();
		try {
			camgenRunParamAudGroupChannels = snapshotRunDetailsService.getCamgenRunParamAudGroupChannels(runId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenRunParamAudGroupChannels{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenRunParamAudGroupChannels() of CamgenApiController.");
		return new ResponseEntity<>(camgenRunParamAudGroupChannels, HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return BatchTxLevels
	 */
	@Override
	public ResponseEntity<BatchTxLevels> getCamgenRunParamBatchTxLevels(
			@ApiParam(value = "snapshotId") @Valid @RequestParam(value = "snapshotId", required = false) Integer snapshotId) {
		LOGGER.info(">> of getCamgenRunParamBatchTxLevels() of CamgenApiController.");
		try {
			BatchTxLevels batchTxLevels = snapshotParamBatchTxLevels.getCamgenRunParamBatchTxLevels(snapshotId);
			LOGGER.info("<< of getCamgenRunParamBatchTxLevels() of CamgenApiController.");
			return new ResponseEntity<>(batchTxLevels, HttpStatus.OK);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Error in getCamgenRunParamBatchTxLevels method of CamgenApiController ", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
	}

	/**
	 * method for get camgen snap shot run details.
	 *
	 * @param runId
	 *            the run id
	 * @param scheduledDate
	 *            the scheduledDate         
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public ResponseEntity<List<CamgenSnapshotRunDetail>> getCamgenSnapshotRunDetails(
			@ApiParam(value = "The ID of the snapshot to retrieve", required = false) @Valid @RequestParam(value = "runId", required = false) Integer runId,
			@ApiParam(value = "scheduled date of a camgen request run") @Valid @RequestParam(value = "scheduledDate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")DateTime scheduledDate,
			@ApiParam(value = "status of camgen request") @Valid @RequestParam(value = "requestStatus", required = false)String requestStatus,
			@ApiParam(value = "status of camgen run") @Valid @RequestParam(value = "runStatus", required = false)String runStatus)
 {
		List<CamgenSnapshotRunDetail> camgenSnapshotRunDetail = null;
		try {
			camgenSnapshotRunDetail = snapshotRunDetailsService.getCamgenSnapshotRunDetails(runId, scheduledDate,requestStatus,runStatus);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenSnapshotRunDetails {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenSnapshotRunDetails() of CampgenApiController.");
		return new ResponseEntity<>(camgenSnapshotRunDetail, HttpStatus.OK);
	}

	/**
	 * Gets the camgen snapshot runs.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CamgenSnapshotRunDetails
	 */
	@Override
	public ResponseEntity<CamgenSnapshotRunDetails> getCamgenSnapshotRuns(
			@ApiParam(value = "The ID of the snapshot to retrieve the run details", required = true) @PathVariable("snapshotId") Integer snapshotId) {
		LOGGER.info(">> of getCamgenSnapshotRunDetails() of CampgenApiController.");
		CamgenSnapshotRunDetails camgenSnapshotRunDetails = null;
		try {
			camgenSnapshotRunDetails = snapshotRunDetailsService.getCamgenSnapshotRunDetailsBySnapshotId(snapshotId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getCamgenSnapshotRuns{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenSnapshotRunDetails() of CampgenApiController.");
		return new ResponseEntity<>(camgenSnapshotRunDetails, HttpStatus.OK);
	}

	/**
	 * Gets the snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return SnapshotPlanDetail
	 */
	@Override
	public ResponseEntity<List<SnapshotDetail>> getSnapshot(
			@NotNull @ApiParam(value = "The id of the snapshot to retrieve", required = false) @Valid @RequestParam(value = "snapshotId", required = false) Integer snapshotId,
			@ApiParam(value = "scheduled date of a camgen request") @Valid @RequestParam(value = "scheduledDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate scheduledDate,
			@ApiParam(value = "look for queued camgen requests scheduled for a time > scheduledStartTime") @Valid @RequestParam(value = "scheduledStartTime", required = false) String scheduledStartTime,
			@ApiParam(value = "look for queued camgen requests scheduled for a time <= scheduledEndTime") @Valid @RequestParam(value = "scheduledEndTime", required = false) String scheduledEndTime,
			@ApiParam(value = "status of plan") @Valid @RequestParam(value = "status", required = false) String status) {
		LOGGER.info(">> of getSnapshot() of CampgenApiController.");
		List<SnapshotDetail> snapshotDetailList = new ArrayList<>();
		try {
			snapshotDetailList = snapshotRunDetailsService.getSnapshot(snapshotId, scheduledDate, scheduledStartTime,
					scheduledEndTime, status);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getSnapshot{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getSnapshot() of CampgenApiController.");
		return new ResponseEntity<>(snapshotDetailList, HttpStatus.OK);

	}

	/**
	 * Update global parameters.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateGlobalParameters(
			@ApiParam(value = "Camgen parameters to update", required = true) @Valid @RequestBody CamgenGlobalParametersRequest body) {
		LOGGER.info(">> of updateGlobalParameters() of CampgenApiController.");
		try {
			globalParametersService.updateGlobalParameters(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for updateGlobalParameters{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateGlobalParameters() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update snapshots.
	 *
	 * @param snapshots
	 *            the snapshots
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateSnapshots(@ApiParam(value = "") @Valid @RequestBody SnapshotDetail snapshots) {
		LOGGER.info(">> of updateSnapshots() of CamgenApiController.");
		try {
			snapshotRunDetailsService.updateSnapshots(snapshots);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception fro updateSnapshots {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateSnapshots() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates the camgen parameters EI bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParametersEIBands(
			@ApiParam(value = "Camgen Parameters for EI Bands", required = true) @Valid @RequestBody CamgenParamEIBands body) {
		LOGGER.info(">> of createCamgenParametersEIBands() of CamgenApiController.");
		try {
			camgenParmEIBandsService.createCamgenParameters(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createCamgenParametersEIBands {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParametersEIBands() of CamgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates the plans.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createPlans(@ApiParam(value = "") @Valid @RequestBody PlansObject body) {
		LOGGER.info(">> of createPlans() of CampgenApiController.");
		try {
			planService.createPlans(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for createPlans{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createPlans() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Delete snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> deleteSnapshot(
			@ApiParam(value = "The id of the snapshot to delete", required = true) @PathVariable("snapshotId") Integer snapshotId) {
		LOGGER.info(">> of deleteSnapshot() of CampgenApiController.");
		try {
			snapshotRunDetailsService.deleteSnapshot(snapshotId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for deleteSnapshot{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of deleteSnapshot() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId
	 *            the demand supply group id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return CriteriaLineNormalised
	 */
	@Override
	public ResponseEntity<List<CriteriaLineNormalised>> getDemandSupplyGroupCriteriaLines(
			@ApiParam(value = "The id of the plan to retrieve", required = true) @PathVariable("demandSupplyGroupId") Integer demandSupplyGroupId) {
		LOGGER.info(">> of getDemandSupplyGroupCriteriaLines() of CamgenApiController.");

		List<CriteriaLineNormalised> criteriaLineNormalisedList = null;
		try {
			criteriaLineNormalisedList = demandSupplyService.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getDemandSupplyGroupCriteriaLines{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getDemandSupplyGroupCriteriaLines() of CamgenApiController.");
		return new ResponseEntity<>(criteriaLineNormalisedList, HttpStatus.OK);
	}

	/**
	 * Gets the plan.
	 *
	 * @param planId
	 *            the plan id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return PlansObject
	 */
	@Override
	public ResponseEntity<List<PlansObject>> getPlans(
			@ApiParam(value = "Date of Plan") @Valid @RequestParam(value = "planDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate planDate,
			@ApiParam(value = "Day Number corresponding to the requested date") @Valid @RequestParam(value = "dayNumber", required = false) String dayNumber,
			@ApiParam(value = "The id of the plan to retrieve") @Valid @RequestParam(value = "planId", required = false) Integer planId,
			@ApiParam(value = "indicates if this request should return DemandSupply details of the plan") @Valid @RequestParam(value = "includeDemandSupply", required = false) Boolean includeDemandSupply,
			@ApiParam(value = "indicates if this request should return exclussion details of the plan") @Valid @RequestParam(value = "includeExclussions", required = false) Boolean includeExclussions,
			@ApiParam(value = "status of plan") @Valid @RequestParam(value = "status", required = false) String status) {
		LOGGER.info(">> of getPlan() of CamgenApiController.");

		List<PlansObject> plansObjectList = null;
		try {
			plansObjectList = planService.getPlan(planDate, dayNumber, planId, includeDemandSupply, includeExclussions, status);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for getPlan{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getPlan() of CamgenApiController.");
		return new ResponseEntity<>(plansObjectList, HttpStatus.OK);
	}

	/**
	 * Gets the plans.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @throws MintHttpException
	 *             mint http exception
	 * @return PlanSummaryWithPagination
	 */
	@Override
	public ResponseEntity<PlanSummaryWithPagination> getPlansList(
			@NotNull @ApiParam(value = "Page number, default value is 1", required = true) @Valid @RequestParam(value = "page", required = true) Integer page,
			@NotNull @ApiParam(value = "Number of rows per page, default value is 20", required = true) @Valid @RequestParam(value = "count", required = true) Long count,
			@ApiParam(value = "Sorting order ASC or DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
			@ApiParam(value = "Sort the results by field name") @Valid @RequestParam(value = "sortByField", required = false) String sortByField) {
		LOGGER.info(">> of getPlans() of CampgenApiController.");
		PlanSummaryWithPagination planSummaryWithPagination = null;

		try {
			planSummaryWithPagination = planService.getPlans(page, count, sortOrder, sortByField);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception fro getPlans{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getPlans() of CampgenApiController.");
		return new ResponseEntity<>(planSummaryWithPagination, HttpStatus.OK);
	}

	/**
	 * Update camgen param extracts.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenParamExtracts(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamExtracts body) {
		LOGGER.info(">> of updateCamgenParamExtracts() of CampgenApiController.");
		try {
			parametersService.createCamgenParamExtracts(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception fro updateCamgenParamExtracts{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenParamExtracts() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update camgen param station EI time bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenParamStationEITimeBands(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamStationEITimeBands body) {
		LOGGER.info(">> of updateCamgenParamStationEITimeBands() of CampgenApiController.");
		try {
			stationEITimeBandsService.createCamgenParamStationEITimeBands(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for updateCamgenParamStationEITimeBands{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenParamStationEITimeBands() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update camgen param station time bands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenParamStationTimeBands(
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenParamStationTimeBands body) {
		LOGGER.info(">> of updateCamgenParamStationTimeBands() of CampgenApiController.");
		try {
			stationTimeBandsService.createCamgenParamStationTimeBands(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for updateCamgenParamStationTimeBands {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenParamStationTimeBands() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update camgen parameter aud group channels.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenParameterAudGroupChannels(
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenParamAudGroupChannels body) {
		LOGGER.info(">> of updateCamgenParameterAudGroupChannels() of CampgenApiController.");
		try {
			camgenParamAudGroupChannelsService.createCamgenParamAudGroupChannels(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for updateCamgenParameterAudGroupChannels {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenParameterAudGroupChannels() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update camgen parameters.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenParameters(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParameters body) {
		LOGGER.info(">> of updateCamgenParameters() of CampgenApiController.");
		try {
			camgenParametersService.createCamgenParameters(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception for updateCamgenParameters {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenParameters() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Update plans.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updatePlans(@ApiParam(value = "") @Valid @RequestBody PlansObject body) {
		LOGGER.info(">> of updatePlans() of CampgenApiController.");
		try {
			planService.updatePlans(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception in updatePlans{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updatePlans() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen plan exclusioj categories
	 *
	 * @throws MintHttpException
	 *             mint http exception
	 * @return ExclusionCategories
	 */
	public ResponseEntity<ExclusionCategories> getCamgenPlanExclusionCategiries() {
		ExclusionCategories exclusionCategories = null;
		LOGGER.info(">> of getCamgenPlanExclusionCategiries() of CampgenApiController.");
		try {
			exclusionCategories = camgenExclusionCategoryService.getCamgenExclusionCategoryService();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception in getCamgenPlanExclusionCategiries{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenPlanExclusionCategiries() of CampgenApiController.");
		return new ResponseEntity<>(exclusionCategories, HttpStatus.OK);
	}

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return ChannelSetTimeBands
	 */
	@Override
	public ResponseEntity<ChannelSetTimeBands> getCamgenRunParamChannelSetTimebands(
			@ApiParam(value = "snapshotId") @Valid @RequestParam(value = "snapshotId", required = false) Integer snapshotId) {
		LOGGER.info(">> of getCamgenRunParamChannelSetTimebands() of CampgenApiController.");
		ChannelSetTimeBands channelSetTimeBands = null;
		try {
			channelSetTimeBands = snapshotParamChannelSetTimebands.getCamgenRunParamChannelSetTimebands(snapshotId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception in getCamgenRunParamChannelSetTimebands{}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenRunParamChannelSetTimebands() of CampgenApiController.");
		return new ResponseEntity<>(channelSetTimeBands, HttpStatus.OK);
	}

	/**
	 * Update camgen snapshot run details.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> updateCamgenSnapshotRunDetails(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenSnapshotRunDetails body) {
		LOGGER.info(">> of updateCamgenSnapshotRunDetails() of CampgenApiController.");
		try {
			snapshotRunDetailsService.updateCamgenSnapshotRunDetails(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of updateCamgenSnapshotRunDetails() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @throws MintHttpException
	 *             mint http exception
	 * @return ChannelSetTimeBandResponse
	 */
	@Override
	public ResponseEntity<List<ChannelSetTimeBandResponse>> getCamgenParamChannelSetTimebands(
			@ApiParam(value = "The channel set ID for which to retrieve the time bands for", required = true) @PathVariable("channelSetID") Integer channelSetID) {
		LOGGER.info(">> of getCamgenParamChannelSetTimebands() of CampgenApiController.");
		List<ChannelSetTimeBandResponse> channelSetTimeBandResponseList = null;
		try {
			channelSetTimeBandResponseList = channelSetTimebandsService.getCamgenParamChannelSetTimebands(channelSetID);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of getCamgenParamChannelSetTimebands() of CampgenApiController.");
		return new ResponseEntity<>(channelSetTimeBandResponseList, HttpStatus.OK);
	}

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param body
	 *            the body
	 * @throws MintHttpException
	 *             mint http exception
	 */
	@Override
	public ResponseEntity<Void> createCamgenParamChannelSetTimebands(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<ChannelSetTimebandsBulkRequest> body) {
		LOGGER.info(">> of createCamgenParamChannelSetTimebands() of CampgenApiController.");
		try {
			channelSetTimebandsService.createCamgenParamChannelSetTimebands(body);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< of createCamgenParamChannelSetTimebands() of CampgenApiController.");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Method to get a list of conditions applicable for the selected Demand
	 * Supply Level Object Attribute.
	 * 
	 * @param attributeId
	 *            attribute Id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return DemandSupplyObjectAttributeConditions
	 */
	@Override
	public ResponseEntity<DemandSupplyObjectAttributeConditions> getDemandSupplyLevelObjectAttributeConditions(
			@ApiParam(value = "The id of the demand supply level object attribute to retrieve applicable conditions", required = true) @PathVariable("attributeId") Integer attributeId) {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributeConditions() of CampgenApiController.");
		DemandSupplyObjectAttributeConditions demandSupplyObjectAttributeConditions = null;
		try {
			demandSupplyObjectAttributeConditions = camgenService
					.getDemandSupplyLevelObjectAttributeConditions(attributeId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< getDemandSupplyLevelObjectAttributeConditions() of CampgenApiController.");
		return new ResponseEntity<>(demandSupplyObjectAttributeConditions, HttpStatus.OK);
	}

	/**
	 * Method to get a list of attributes corresponds to a demand supply level
	 * object.
	 * 
	 * @param objectId
	 *            object Id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return DemandSupplyObjectAttributes
	 */
	@Override
	public ResponseEntity<DemandSupplyObjectAttributes> getDemandSupplyLevelObjectAttributes(
			@ApiParam(value = "The id of the demand supply level Object to retrieve its attributes", required = true) @PathVariable("objectId") Integer objectId) {
		LOGGER.info(">> getDemandSupplyLevelObjectAttributes() of CampgenApiController.");
		DemandSupplyObjectAttributes demandSupplyObjectAttributes = null;
		try {
			demandSupplyObjectAttributes = camgenService.getDemandSupplyLevelObjectAttributes(objectId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< getDemandSupplyLevelObjectAttributes() of CampgenApiController.");
		return new ResponseEntity<>(demandSupplyObjectAttributes, HttpStatus.OK);
	}

	/**
	 * Method to get a list of objects corresponds to a demand supply level.
	 * 
	 * @param levelId
	 *            level Id
	 * @throws MintHttpException
	 *             mint http exception
	 * @return DemandSupplyLevelObjects
	 */
	@Override
	public ResponseEntity<DemandSupplyLevelObjects> getDemandSupplyLevelObjects(
			@ApiParam(value = "The id of the demand supply level to retrieve objects", required = true) @PathVariable("levelId") Integer levelId) {
		LOGGER.info(">>  getDemandSupplyLevelObjects() of CampgenApiController.");
		DemandSupplyLevelObjects demandSupplyLevelObjects = null;
		try {
			demandSupplyLevelObjects = camgenService.getDemandSupplyLevelObjects(levelId);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< getDemandSupplyLevelObjects() of CampgenApiController.");
		return new ResponseEntity<>(demandSupplyLevelObjects, HttpStatus.OK);
	}

	/**
	 * Method to get the list of levels for demand Supply setup.
	 * 
	 * @throws MintHttpException
	 *             mint http exception
	 * @return DemandSupplyLevels
	 */
	@Override
	public ResponseEntity<DemandSupplyLevels> getDemandSupplyLevels() {
		LOGGER.info(">> getDemandSupplyLevels() of CampgenApiController.");
		DemandSupplyLevels demandSupplyLevels = null;
		try {
			demandSupplyLevels = camgenService.getDemandSupplyLevelObjectAttributes();
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< getDemandSupplyLevels() of CampgenApiController.");
		return new ResponseEntity<>(demandSupplyLevels, HttpStatus.OK);
	}

	public ResponseEntity<List<Field>> bulkCancelCamgenRequests(
			@ApiParam(value = "") @Valid @RequestBody List<Snapshots> snapshots) {
		LOGGER.info(">> bulkCancelCamgenRequests() of CampgenApiController.");
		List<Field> fieldList = null;
		try {
			fieldList = bulkAmendService.updateCancelStatus(snapshots);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< bulkCancelCamgenRequests() of CampgenApiController.");
		return new ResponseEntity<>(fieldList, HttpStatus.OK);
	}

	public ResponseEntity<List<Field>> bulkReInstateCamgenRequests(
			@ApiParam(value = "") @Valid @RequestBody List<Snapshots> snapshots) {
		LOGGER.info(">> bulkReInstateCamgenRequests() of CampgenApiController.");
		List<Field> fieldList = null;
		try {
			fieldList = bulkAmendService.updateQueueStatus(snapshots);
		} catch (MintBaseException mintBaseException) {
			LOGGER.error("Caught following exception {}", mintBaseException);
			throw new MintHttpException(mintBaseException.getMessage(), mintBaseException.getCode(),
					HttpStatus.valueOf(mintBaseException.getCode()));
		}
		LOGGER.info("<< bulkReInstateCamgenRequests() of CampgenApiController.");
		return new ResponseEntity<>(fieldList, HttpStatus.OK);
	}

}
