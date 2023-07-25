/*
 * 
 */
package com.channel4.mint.automated.spot.application.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenExtractParameter;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;

// TODO: Auto-generated Javadoc
/**
 * The Class Camgen Extract Mapper Class.
 */
@Component
public class CamgenExtractMapper {

	/**
	 * Map camgen parameter mapper.
	 *
	 * @param camgenParamExtract the camgen param extract
	 * @param camgenExtractParameter the camgen extract parameter
	 * @return CamgenExtractParameter
	 */
	public CamgenExtractParameter mapCamgenExtractMapper(CamgenParamExtract camgenParamExtract,
			CamgenExtractParameter camgenExtractParameter) {

		camgenExtractParameter.setExtractParameterName(camgenParamExtract.getParameter());
		camgenExtractParameter.setValue(camgenParamExtract.getValue());

		return camgenExtractParameter;
	}

	/**
	 * Map camgen param extracts.
	 *
	 * @param camgenExtractParameterList the camgen extract parameter list
	 * @return camgenParamExtracts
	 */
	public CamgenParamExtracts mapCamgenParamExtracts(List<CamgenExtractParameter> camgenExtractParameterList) {
		CamgenParamExtracts camgenParamExtracts = new CamgenParamExtracts();

		for (CamgenExtractParameter camgenExtractParameter : camgenExtractParameterList) {
			CamgenParamExtract camgenParamExtract = new CamgenParamExtract();
			camgenParamExtract.setId(camgenExtractParameter.getExtractParameterId());
			camgenParamExtract.setParameter(camgenExtractParameter.getExtractParameterName());
			camgenParamExtract.setCreatedBy(camgenExtractParameter.getCreatedBy());
			camgenParamExtract.setValue(camgenExtractParameter.getValue());
			camgenParamExtracts.add(camgenParamExtract);
		}
		return camgenParamExtracts;
	}

}
