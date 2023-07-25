package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.BulkAmendServiceRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.baseexception.MintBaseException;

@Service
public class BulkAmendServiceRepositoryImpl implements BulkAmendServiceRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(BulkAmendServiceRepositoryImpl.class);

	@Autowired
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	public CamgenRequest getRequestById(Long id) {

		CamgenRequest camgenRequestResult = null;

		try {
			LOGGER.info(">> BulkAmendServiceRepositoryImpl.getRequestById(");
			camgenRequestResult = camgenRequestJpaRepository.findOne(id);

			if (null == camgenRequestResult) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException("Camgen Request Id Not Found : " + id, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during get camgen Request By id {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenRequestResult;

	}

	public Long updateStatus(CamgenRequest camgenRequest) {
		CamgenRequest camgenRequestResult = null;

		try {
			LOGGER.info(">> BulkAmendServiceRepositoryImpl.updateStatus(");
			camgenRequestResult = camgenRequestJpaRepository.save(camgenRequest);

			if (null == camgenRequestResult) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException("Camgen Request Id Not Found : ", HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException e) {
			LOGGER.error("Exception during update camgen Request {}", e);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenRequest.getRequestId();

	}

}
