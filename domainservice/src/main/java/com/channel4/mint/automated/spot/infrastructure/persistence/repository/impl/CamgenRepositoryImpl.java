package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.channel4.mint.automated.spot.application.util.AutomatedSpotConstants;
import com.channel4.mint.automated.spot.application.util.JpaToDtoMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyAttributeJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyConditionJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyObjectJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.baseexception.MintBaseException;

/**
 * The CamgenRepositoryImpl service is used to get camgen demand supply.
 * 
 * @author HCL
 *
 */
@Repository
public class CamgenRepositoryImpl implements CamgenRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CamgenRepositoryImpl.class);

	@Autowired
	private CamgenDemandSupplyLevelJpaRepository camgenDemandSupplyLevelJpaRepository;

	@Autowired
	private CamgenDemandSupplyAttributeJpaRepository camgenDemandSupplyAttributeJpaRepository;

	@Autowired
	private CamgenDemandSupplyConditionJpaRepository camgenDemandSupplyConditionJpaRepository;

	@Autowired
	private CamgenDemandSupplyObjectJpaRepository camgenDemandSupplyObjectJpaRepository;

	@Autowired
	private JpaToDtoMapper jpaToDtoMapper;

	/**
	 * Method to get all camgen demand supply object map.
	 * 
	 * @throws MintBaseException
	 *             mint base exception
	 * @return Map
	 * 
	 */
	public Map<Long, CamgenDemandSupplyObject> getAllCamgenDemandSupplyObjectMap() {
		List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList = null;

		try {
			LOGGER.info(">>CamgenRepositoryImpl.getAllCamgenDemandSupplyObjectMap()");
			camgenDemandSupplyObjectList = camgenDemandSupplyObjectJpaRepository.findAll();

			if (CollectionUtils.isEmpty(camgenDemandSupplyObjectList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenDemandSupplyObjectList.stream()
				.collect(Collectors.toMap(CamgenDemandSupplyObject::getDemandSupplyObjectId, Function.identity()));
	}

	/**
	 * Method to get all camgen demand supply condition map.
	 * 
	 * @throws MintBaseException
	 *             mint base exception
	 * @return Map
	 */
	@Override
	public Map<Long, CamgenDemandSupplyCondition> getAllCamgenDemandSupplyConditionMap() {
		List<CamgenDemandSupplyCondition> camgenDemandSupplyConditionList = null;

		try {
			LOGGER.info(">>CamgenRepositoryImpl.getAllCamgenDemandSupplyConditionMap()");
			camgenDemandSupplyConditionList = camgenDemandSupplyConditionJpaRepository.findAll();

			if (CollectionUtils.isEmpty(camgenDemandSupplyConditionList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenDemandSupplyConditionList.stream().collect(
				Collectors.toMap(CamgenDemandSupplyCondition::getDemandSupplyConditionId, Function.identity()));
	}

	/**
	 * Method to get all camgen demand supply attribute map.
	 * 
	 * @throws MintBaseException
	 *             mint base exception
	 * @return Map
	 * 
	 */
	@Override
	public Map<Long, CamgenDemandSupplyAttribute> getAllCamgenDemandSupplyAttributeMap() {
		List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeList = null;

		try {
			LOGGER.info(">>CamgenRepositoryImpl.getAllCamgenDemandSupplyAttributeMap()");
			camgenDemandSupplyAttributeList = camgenDemandSupplyAttributeJpaRepository.findAll();

			if (CollectionUtils.isEmpty(camgenDemandSupplyAttributeList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenDemandSupplyAttributeList.stream().collect(
				Collectors.toMap(CamgenDemandSupplyAttribute::getDemandSupplyAttributeId, Function.identity()));
	}

	/**
	 * Method to get all camgen demand supply level map.
	 * 
	 * @throws MintBaseException
	 *             mint base exception
	 * @return Map
	 **/
	@Override
	public Map<Long, CamgenDemandSupplyLevel> getAllCamgenDemandSupplyLevelMap() {
		List<CamgenDemandSupplyLevel> camgenDemandSupplyLevelList = null;

		try {
			LOGGER.info(">>CamgenRepositoryImpl.getAllCamgenDemandSupplyLevel()");
			camgenDemandSupplyLevelList = camgenDemandSupplyLevelJpaRepository.findAll();

			if (CollectionUtils.isEmpty(camgenDemandSupplyLevelList)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return camgenDemandSupplyLevelList.stream()
				.collect(Collectors.toMap(CamgenDemandSupplyLevel::getDemandSupplyLevelId, Function.identity()));
	}

	/**
	 * Method to get demand supply level object attribute conditions.
	 * 
	 * @param attributeId
	 *            attribute id
	 * @throws MintBaseException
	 *             mint base exception
	 * @return DemandSupplyObjectAttributeConditions
	 */
	@Override
	public DemandSupplyObjectAttributeConditions getDemandSupplyLevelObjectAttributeConditions(Integer attributeId) {
		LOGGER.info(">>  CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributeConditions()");
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = null;
		try {
			camgenDemandSupplyAttribute = camgenDemandSupplyAttributeJpaRepository.findOne(attributeId.longValue());
			if (null == camgenDemandSupplyAttribute
					|| CollectionUtils.isEmpty(camgenDemandSupplyAttribute.getCamgenDemandSupplyAttrConds())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<<  CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributeConditions()");
		return jpaToDtoMapper.mapCamgenJpaToDemandDto(camgenDemandSupplyAttribute.getCamgenDemandSupplyAttrConds());
	}

	/**
	 * Method to get demand supply level object attributes.
	 * 
	 * @param objectId
	 *            object id
	 * @throws MintBaseException
	 *             mint base exception
	 * @return DemandSupplyObjectAttributes
	 */
	@Override
	public DemandSupplyObjectAttributes getDemandSupplyLevelObjectAttributes(Integer objectId) {
		LOGGER.info(">> CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributes()");
		CamgenDemandSupplyObject camgenDemandSupplyObject = null;
		try {
			camgenDemandSupplyObject = camgenDemandSupplyObjectJpaRepository.findOne(objectId.longValue());
			if (null == camgenDemandSupplyObject
					|| CollectionUtils.isEmpty(camgenDemandSupplyObject.getCamgenDemandSupplyAttributes())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributes()");
		return jpaToDtoMapper
				.mapCamgenToDemandObjectAttributes(camgenDemandSupplyObject.getCamgenDemandSupplyAttributes());
	}

	/**
	 * Method to get demand supply level objects.
	 * 
	 * @param levelId
	 *            level id
	 * @throws MintBaseException
	 *             mint base exception
	 * @return DemandSupplyLevelObjects
	 */
	@Override
	public DemandSupplyLevelObjects getDemandSupplyLevelObjects(Integer levelId) {
		LOGGER.info(">> CamgenRepositoryImpl : getDemandSupplyLevelObjects()");
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = null;
		try {
			camgenDemandSupplyLevel = camgenDemandSupplyLevelJpaRepository.findOne(levelId.longValue());

			if (null == camgenDemandSupplyLevel
					|| CollectionUtils.isEmpty(camgenDemandSupplyLevel.getCamgenDemandSupplyObjects())) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}
		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< CamgenRepositoryImpl : getDemandSupplyLevelObjects()");
		return jpaToDtoMapper.mapCamgenToDemandSupplyObjects(camgenDemandSupplyLevel.getCamgenDemandSupplyObjects());
	}

	/**
	 * Method to get demand supply level object attributes.
	 * 
	 * 
	 * @throws MintBaseException
	 *             mint base exception
	 * @return DemandSupplyLevels
	 */
	@Override
	public DemandSupplyLevels getDemandSupplyLevelObjectAttributes() {
		LOGGER.info(">> CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributes()");
		List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels = null;

		try {
			camgenDemandSupplyLevels = camgenDemandSupplyLevelJpaRepository.findAll();
			if (CollectionUtils.isEmpty(camgenDemandSupplyLevels)) {
				LOGGER.error(AutomatedSpotConstants.DATA_NOT_FOUND);
				throw new MintBaseException(AutomatedSpotConstants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND.value());
			}

		} catch (DataAccessException dae) {
			LOGGER.error(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE, dae);
			throw new MintBaseException(AutomatedSpotConstants.EXCEPTION_FROM_DATABASE,
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		LOGGER.info("<< CamgenRepositoryImpl : getDemandSupplyLevelObjectAttributes()");
		return jpaToDtoMapper.mapCamgenLevelToDemandSupplyLevels(camgenDemandSupplyLevels);
	}

}
