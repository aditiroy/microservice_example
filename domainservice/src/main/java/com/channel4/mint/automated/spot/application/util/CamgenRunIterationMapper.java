/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunIterationRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;

// TODO: Auto-generated Javadoc
/**
 * The Class CamgenRunIterationMapper.
 */
@Component
public class CamgenRunIterationMapper {

	/** The date time utility. */
	@Autowired
	private DateTimeUtility dateTimeUtility;

	/** The run iteration repository. */
	@Autowired
	private RunIterationRepository runIterationRepository;

	/**
	 * Map camgen run iterations.
	 *
	 * @param camgenRunIterations the camgen run iterations
	 * @return CamgenRunIteration
	 */
	public List<CamgenRunIteration> mapCamgenRunIterations(CamgenRunIterations camgenRunIterations) {

		List<CamgenRunIteration> camgenRunIterationList = new ArrayList<>();

		for (com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIterationDto : camgenRunIterations) {
			CamgenRunIteration camgenRunIteration = new CamgenRunIteration();

			if (null != camgenRunIterationDto.getIterationNumber()) {
				camgenRunIteration.setIterationNumber(new BigDecimal(camgenRunIterationDto.getIterationNumber()));
			}
			camgenRunIteration.setStartDateTime(new LocalDate(camgenRunIterationDto.getStartTime()).toDate());
			camgenRunIteration.setEndDateTime(new LocalDate(camgenRunIterationDto.getEndTime()).toDate());
			
			camgenRunIteration.setIterationSolutionFileName(camgenRunIterationDto.getSolutionFileName());
			camgenRunIteration.setCreatedBy(camgenRunIterationDto.getCreatedBy());
			camgenRunIteration.setCreatedOn(dateTimeUtility.getCurrentTimeStamp());

			CamgenRun camgenRun = runIterationRepository.findCamgenRun(camgenRunIterationDto);
			camgenRunIteration.setCamgenRun(camgenRun);

			
			camgenRunIterationList.add(camgenRunIteration);
		}

		return camgenRunIterationList;
	}

	/**
	 * Gets the camgen run.
	 *
	 * @param camgenRun the camgen run
	 * @return CamgenRunIterations
	 */
	public com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations getCamgenRun(CamgenRun camgenRun) {
		com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations camgenRunIterations = new CamgenRunIterations();

		for (CamgenRunIteration camgenRunIterationDomain : camgenRun.getCamgenRunIterations()) {
			com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIteration = new com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration();

			camgenRunIteration.setCamgenRunIterationId(camgenRunIterationDomain.getIterationId());
			getCamgenRunIteration(camgenRunIterationDomain, camgenRunIteration);
			camgenRunIteration.setSolutionFileName(camgenRunIterationDomain.getIterationSolutionFileName());
			camgenRunIteration.setCreatedBy(camgenRunIterationDomain.getCreatedBy());

			if (null != camgenRun.getCamgenRequest()) {
				camgenRunIteration.setSnapShotId((int) camgenRun.getCamgenRequest().getRequestId());
			}
			camgenRunIteration.setRunId((int) camgenRun.getRunId());
			camgenRunIterations.add(camgenRunIteration);
		}
		return camgenRunIterations;
	}

	/**
	 * Gets the camgen run iteration.
	 *
	 * @param camgenRunIterationDomain the camgen run iteration domain
	 * @param camgenRunIteration the camgen run iteration
	 * @return the camgen run iteration
	 */
	private void getCamgenRunIteration(CamgenRunIteration camgenRunIterationDomain,
			com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIteration) {
		if (null != camgenRunIterationDomain.getIterationNumber()) {
			camgenRunIteration.setIterationNumber(camgenRunIterationDomain.getIterationNumber().intValue());
		}
		if (null != camgenRunIterationDomain.getStartDateTime()) {
			camgenRunIteration.setStartTime(camgenRunIterationDomain.getStartDateTime().toString());
		}
		if (null != camgenRunIterationDomain.getEndDateTime()) {
			camgenRunIteration.setEndTime(camgenRunIterationDomain.getEndDateTime().toString());
		}
	}

}
