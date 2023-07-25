package com.channel4.mint.automated.spot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.DemandSupplyRepository;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.service.DemandSupplyService;

/**
 * This class is used to perform get operation on DemandSupply.
 * 
 * @author HCL
 */
@Service
public class DemandSupplyServiceImpl implements DemandSupplyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemandSupplyServiceImpl.class);

	@Autowired
	private DemandSupplyRepository demandSupplyRepository;

	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId
	 *            the demand supply group id
	 * @return CriteriaLineNormalised
	 */
	@Override
	public List<CriteriaLineNormalised> getDemandSupplyGroupCriteriaLines(Integer demandSupplyGroupId) {
		LOGGER.info(">> DemandSupplyServiceImpl.getDemandSupplyGroupCriteriaLines()");
		return demandSupplyRepository.getDemandSupplyGroupCriteriaLines(demandSupplyGroupId);
	}

}
