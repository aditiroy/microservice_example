package com.channel4.mint.automated.spot.application.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttrCond;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevel;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttribute;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeCondition;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;

@Component
public class JpaToDtoMapper {

	public DemandSupplyObjectAttributeConditions mapCamgenJpaToDemandDto(
			List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrCondList) {
		DemandSupplyObjectAttributeConditions demandSupplyObjectAttributeConditions = new DemandSupplyObjectAttributeConditions();

		for (CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond : camgenDemandSupplyAttrCondList) {
			DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeCondition = new DemandSupplyObjectAttributeCondition();

			demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionId(
					Integer.parseInt(Long.valueOf(camgenDemandSupplyAttrCond.getDemandSupplyAttrCondId()).toString()));
			demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionName(
					camgenDemandSupplyAttrCond.getCamgenDemandSupplyCondition().getDemandSupplyConditionCode());
			demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionDesc(
					camgenDemandSupplyAttrCond.getCamgenDemandSupplyCondition().getDemandSupplyConditionDesc());
			demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeId(Integer.parseInt(Long
					.valueOf(camgenDemandSupplyAttrCond.getCamgenDemandSupplyAttribute().getDemandSupplyAttributeId())
					.toString()));
			demandSupplyObjectAttributeConditions.add(demandSupplyObjectAttributeCondition);
		}
		return demandSupplyObjectAttributeConditions;
	}

	public DemandSupplyLevels mapCamgenLevelToDemandSupplyLevels(
			List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels) {
		DemandSupplyLevels demandSupplyLevels = new DemandSupplyLevels();
		for (CamgenDemandSupplyLevel camgenDemandSupplyLevel : camgenDemandSupplyLevels) {
			DemandSupplyLevel demandSupplyLevel = new DemandSupplyLevel();
			demandSupplyLevel.setDemandSupplyLevelId(
					Integer.parseInt(Long.valueOf(camgenDemandSupplyLevel.getDemandSupplyLevelId()).toString()));
			demandSupplyLevel.setDemandSupplyLevelName(camgenDemandSupplyLevel.getDemandSupplyLevelName());
			demandSupplyLevel.setDemandSupplyLevelDesc(camgenDemandSupplyLevel.getDemandSupplyLevelCode());
			demandSupplyLevels.add(demandSupplyLevel);
		}
		return demandSupplyLevels;
	}

	public DemandSupplyLevelObjects mapCamgenToDemandSupplyObjects(
			List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList) {
		DemandSupplyLevelObjects demandSupplyLevelObjects = new DemandSupplyLevelObjects();

		for (CamgenDemandSupplyObject camgenDemandSupplyObject : camgenDemandSupplyObjectList) {
			DemandSupplyLevelObject demandSupplyLevelObject = new DemandSupplyLevelObject();
			demandSupplyLevelObject.setDemandSupplyLevelId(Integer.parseInt(
					Long.valueOf(camgenDemandSupplyObject.getCamgenDemandSupplyLevel().getDemandSupplyLevelId())
							.toString()));
			demandSupplyLevelObject.setDemandSupplyLevelObjectId(
					Integer.parseInt(Long.valueOf(camgenDemandSupplyObject.getDemandSupplyObjectId()).toString()));
			demandSupplyLevelObject
					.setDemandSupplyLevelObjectName(camgenDemandSupplyObject.getDemandSupplyObjectName());
			demandSupplyLevelObject
					.setDemandSupplyLevelObjectDesc(camgenDemandSupplyObject.getDemandSupplyObjectCode());
			demandSupplyLevelObjects.add(demandSupplyLevelObject);
		}
		return demandSupplyLevelObjects;
	}

	public DemandSupplyObjectAttributes mapCamgenToDemandObjectAttributes(
			List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeList) {
		DemandSupplyObjectAttributes demandSupplyObjectAttributes = new DemandSupplyObjectAttributes();

		for (CamgenDemandSupplyAttribute camgenDemandSupplyAttribute : camgenDemandSupplyAttributeList) {
			DemandSupplyObjectAttribute demandSupplyObjectAttribute = new DemandSupplyObjectAttribute();
			demandSupplyObjectAttribute.setDemandSupplyObjectId(Integer.parseInt(
					Long.valueOf(camgenDemandSupplyAttribute.getCamgenDemandSupplyObject().getDemandSupplyObjectId())
							.toString()));
			demandSupplyObjectAttribute.setDemandSupplyObjectAttributeId(Integer
					.parseInt(Long.valueOf(camgenDemandSupplyAttribute.getDemandSupplyAttributeId()).toString()));
			demandSupplyObjectAttribute
					.setDemandSupplyObjectAttributeName(camgenDemandSupplyAttribute.getDemandSupplyAttributeName());
			demandSupplyObjectAttribute
					.setDemandSupplyObjectAttributeDesc(camgenDemandSupplyAttribute.getDemandSupplyAttributeCode());
			demandSupplyObjectAttributes.add(demandSupplyObjectAttribute);
		}
		return demandSupplyObjectAttributes;
	}
}
