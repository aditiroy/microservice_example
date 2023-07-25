package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.CamgenRunIterationMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunIterationJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRunJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunIterationRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * Class for handle run iteration db operations.
 * 
 * @author HCL
 */
@Service
public class RunIterationRepositoryImpl implements RunIterationRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunIterationRepositoryImpl.class);

	@Autowired
	private CamgenRunIterationJpaRepository camgenRunIterationJpaRepository;

	@Autowired
	private CamgenRunIterationMapper camgenRunIterationMapper;

	@Autowired
	private CamgenRunJpaRepository camgenRunJpaRepository;

	/**
	 * method for create new run iteration.
	 *
	 * @param camgenRunIterations
	 *            the camgen run iterations
	 */
	@Transactional
	@Override
	public void createCamgenRunIterations(CamgenRunIterations camgenRunIterations) {

		try {
			LOGGER.info(">> RunIterationRepositoryImpl.createCamgenRunIterations()");
			List<CamgenRunIteration> camgenRunIterationRequest = camgenRunIterationMapper
					.mapCamgenRunIterations(camgenRunIterations);
			camgenRunIterationJpaRepository.save(camgenRunIterationRequest);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Find camgen run.
	 *
	 * @param camgenRunIterations
	 *            the camgen run iterations
	 * @return CamgenRun
	 */
	public CamgenRun findCamgenRun(
			com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIterations) {
		CamgenRun camgenRun = null;
		try {
			LOGGER.info(">> RunIterationRepositoryImpl.findCamgenRun()");
			camgenRun = camgenRunJpaRepository.findOne(camgenRunIterations.getRunId().longValue());
			if (null == camgenRun) {
				LOGGER.info("Camgen Run not found ");
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			LOGGER.info("<< RunIterationRepositoryImpl.findCamgenRun()");
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenRun;

	}

	/**
	 * method for get camgen run iteration based on run id.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunIterations
	 */
	@Override
	public CamgenRunIterations getCamgenRunIterations(Integer runId) {
		try {
			LOGGER.info(">> RunIterationRepositoryImpl.getCamgenRunIterations()");
			CamgenRun camgenRun = camgenRunJpaRepository.findOne(runId.longValue());

			if (null == camgenRun || CollectionUtils.isEmpty(camgenRun.getCamgenRunIterations())) {
				LOGGER.info("Camgen Run or camgenRun.getCamgenRunIterations() not found ");
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
			return camgenRunIterationMapper.getCamgenRun(camgenRun);
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
