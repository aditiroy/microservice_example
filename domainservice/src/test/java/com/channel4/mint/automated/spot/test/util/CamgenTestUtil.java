package com.channel4.mint.automated.spot.test.util;

import java.util.ArrayList;
import java.util.List;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttrCond;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
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

public class CamgenTestUtil {

	public List<CamgenDemandSupplyLevel> getCamgenDemandSupplyLevels() {
		List<CamgenDemandSupplyLevel> camgenDemandSupplyLevelList = new ArrayList<>();
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("Name");
		camgenDemandSupplyLevelList.add(camgenDemandSupplyLevel);
		return camgenDemandSupplyLevelList;
	}

	public DemandSupplyLevels getDemandSupplyLevels() {
		DemandSupplyLevels demandSupplyLevels = new DemandSupplyLevels();
		DemandSupplyLevel demandSupplyLevel = new DemandSupplyLevel();
		demandSupplyLevel.setDemandSupplyLevelDesc("Desc");
		demandSupplyLevel.setDemandSupplyLevelId(1);
		demandSupplyLevel.setDemandSupplyLevelName("Name");
		demandSupplyLevels.add(demandSupplyLevel);
		return demandSupplyLevels;
	}

	public CamgenDemandSupplyObject getCamgenDemandSupplyObject() {

		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyObject.setDemandSupplyObjectName("Name");
		camgenDemandSupplyObject.setDemandSupplyObjectCode("1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("1");
		camgenDemandSupplyObject.setCamgenDemandSupplyLevel(camgenDemandSupplyLevel);
		camgenDemandSupplyObject.setCamgenDemandSupplyAttributes(getCamgenDemandSupplyAttributeList());
		return camgenDemandSupplyObject;
	}

	public List<com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute> getCamgenDemandSupplyAttributeList() {
		List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributesList = new ArrayList<>();
		camgenDemandSupplyAttributesList.add(getCamgenDemandSupplyAttribute());
		return camgenDemandSupplyAttributesList;
	}

	public List<CamgenDemandSupplyAttrCond> getCamgenDemandSupplyAttrCond() {
		List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrCondList = new ArrayList<>();
		CamgenDemandSupplyAttrCond camgenDemandSupplyAttrCond = new CamgenDemandSupplyAttrCond();
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);
		camgenDemandSupplyAttribute.setDemandSupplyAttributeName("Name");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("1");
		camgenDemandSupplyAttrCond.setDemandSupplyAttrCondId(1l);
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyCondition(getCamgenDemandSupplyCondition());
		camgenDemandSupplyAttrCond.setCamgenDemandSupplyAttribute(camgenDemandSupplyAttribute);
		camgenDemandSupplyAttrCondList.add(camgenDemandSupplyAttrCond);
		return camgenDemandSupplyAttrCondList;
	}

	public CamgenDemandSupplyCondition getCamgenDemandSupplyCondition() {
		CamgenDemandSupplyCondition camgenDemandSupplyCondition = new CamgenDemandSupplyCondition();
		camgenDemandSupplyCondition.setDemandSupplyConditionDesc("Desc");
		camgenDemandSupplyCondition.setDemandSupplyConditionId(1l);
		camgenDemandSupplyCondition.setDemandSupplyConditionCode("1");
		return camgenDemandSupplyCondition;
	}

	public CamgenDemandSupplyAttribute getCamgenDemandSupplyAttribute() {
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		camgenDemandSupplyAttribute.setDemandSupplyAttributeId(1l);
		camgenDemandSupplyAttribute.setDemandSupplyAttributeName("Name");
		camgenDemandSupplyAttribute.setDemandSupplyAttributeCode("1");
		camgenDemandSupplyObject.setDemandSupplyObjectId(1l);
		camgenDemandSupplyAttribute.setCamgenDemandSupplyObject(camgenDemandSupplyObject);
		camgenDemandSupplyAttribute.setCamgenDemandSupplyAttrConds(getCamgenDemandSupplyAttrCond());
		return camgenDemandSupplyAttribute;
	}

	public CamgenDemandSupplyLevel getCamgenDemandSupplyLevel() {
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevel.setDemandSupplyLevelCode("1");
		camgenDemandSupplyLevel.setDemandSupplyLevelId(1l);
		camgenDemandSupplyLevel.setDemandSupplyLevelName("Name");
		camgenDemandSupplyLevel.setCamgenDemandSupplyObjects(getCamgenDemandSupplyObjectList());
		return camgenDemandSupplyLevel;
	}

	public List<CamgenDemandSupplyObject> getCamgenDemandSupplyObjectList() {
		List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList = new ArrayList<>();
		camgenDemandSupplyObjectList.add(getCamgenDemandSupplyObject());
		return camgenDemandSupplyObjectList;
	}

	public DemandSupplyLevelObjects getDemandSupplyLevelObjects() {
		DemandSupplyLevelObjects demandSupplyLevelObjects = new DemandSupplyLevelObjects();
		DemandSupplyLevelObject demandSupplyLevelObject = new DemandSupplyLevelObject();
		demandSupplyLevelObject.setDemandSupplyLevelId(1);
		demandSupplyLevelObject.setDemandSupplyLevelObjectDesc("Desc");
		demandSupplyLevelObject.setDemandSupplyLevelObjectId(1);
		demandSupplyLevelObject.setDemandSupplyLevelObjectName("Name");
		demandSupplyLevelObjects.add(demandSupplyLevelObject);
		return demandSupplyLevelObjects;
	}

	public DemandSupplyObjectAttributes getDemandSupplyObjectAttributes() {
		DemandSupplyObjectAttributes demandSupplyObjectAttributes = new DemandSupplyObjectAttributes();
		DemandSupplyObjectAttribute demandSupplyObjectAttribute = new DemandSupplyObjectAttribute();
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeDesc("Desc");
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeId(1);
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeName("Name");
		demandSupplyObjectAttribute.setDemandSupplyObjectId(1);
		demandSupplyObjectAttributes.add(demandSupplyObjectAttribute);
		return demandSupplyObjectAttributes;
	}

	public DemandSupplyObjectAttributeConditions getDemandSupplyObjectAttributeConditions() {
		DemandSupplyObjectAttributeConditions demandSupplyObjectAttributeConditions = new DemandSupplyObjectAttributeConditions();
		DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeCondition = new DemandSupplyObjectAttributeCondition();
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionDesc("Desc");
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionId(1);
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeId(1);
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionId(1);
		demandSupplyObjectAttributeConditions.add(demandSupplyObjectAttributeCondition);
		return demandSupplyObjectAttributeConditions;
	}

	public List<CamgenDemandSupplyCondition> getCamgenDemandSupplyConditionList() {
		List<CamgenDemandSupplyCondition> camgenDemandSupplyConditionList = new ArrayList<>();
		camgenDemandSupplyConditionList.add(getCamgenDemandSupplyCondition());
		return camgenDemandSupplyConditionList;
	}

}
