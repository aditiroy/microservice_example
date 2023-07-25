package com.channel4.mint.automated.spot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRepository;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevel;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttribute;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeCondition;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;

@RunWith(SpringJUnit4ClassRunner.class)
public class CamgenServiceImplTest {

	@InjectMocks
	private CamgenServiceImpl camgenServiceImpl;

	@Mock
	private CamgenRepository camgenRepository;

	@Before
	public void init() {

		getDemandSupplyObjectAttributeConditionsList();
		getDemandSupplyLevelObjectAttributesList();
		getDemandSupplyLevelObjectsList();
		getDemandSupplyLevelObjectAttributes();
	}

	@Test
	public void getDemandSupplyLevelObjectAttributeConditionsSuccessTest() throws Exception {

		when(camgenRepository.getDemandSupplyLevelObjectAttributeConditions(Mockito.anyInt()))
				.thenReturn(getDemandSupplyObjectAttributeConditionsList());
		DemandSupplyObjectAttributeConditions response = camgenServiceImpl
				.getDemandSupplyLevelObjectAttributeConditions(1);
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionDesc(),
				getDemandSupplyObjectAttributeConditionsList().get(0).getDemandSupplyObjectAttributeConditionDesc());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionId(),
				getDemandSupplyObjectAttributeConditionsList().get(0).getDemandSupplyObjectAttributeConditionId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionName(),
				getDemandSupplyObjectAttributeConditionsList().get(0).getDemandSupplyObjectAttributeConditionName());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId(),
				getDemandSupplyObjectAttributeConditionsList().get(0).getDemandSupplyObjectAttributeId());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributesSuccessTest() throws Exception {

		when(camgenRepository.getDemandSupplyLevelObjectAttributes(Mockito.anyInt()))
				.thenReturn(getDemandSupplyLevelObjectAttributesList());
		DemandSupplyObjectAttributes response = camgenServiceImpl.getDemandSupplyLevelObjectAttributes(1);
		assertEquals(response.get(0).getDemandSupplyObjectAttributeDesc(),
				getDemandSupplyLevelObjectAttributesList().get(0).getDemandSupplyObjectAttributeDesc());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId(),
				getDemandSupplyLevelObjectAttributesList().get(0).getDemandSupplyObjectAttributeId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeName(),
				getDemandSupplyLevelObjectAttributesList().get(0).getDemandSupplyObjectAttributeName());
		assertEquals(response.get(0).getDemandSupplyObjectId(),
				getDemandSupplyLevelObjectAttributesList().get(0).getDemandSupplyObjectId());

	}

	@Test
	public void getDemandSupplyLevelObjectsSuccessTest() throws Exception {

		when(camgenRepository.getDemandSupplyLevelObjects(Mockito.anyInt()))
				.thenReturn(getDemandSupplyLevelObjectsList());
		DemandSupplyLevelObjects response = camgenServiceImpl.getDemandSupplyLevelObjects(1);
		assertEquals(response.get(0).getDemandSupplyLevelId(),
				getDemandSupplyLevelObjectsList().get(0).getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelObjectDesc(),
				getDemandSupplyLevelObjectsList().get(0).getDemandSupplyLevelObjectDesc());
		assertEquals(response.get(0).getDemandSupplyLevelObjectName(),
				getDemandSupplyLevelObjectsList().get(0).getDemandSupplyLevelObjectName());
		assertEquals(response.get(0).getDemandSupplyLevelObjectId(),
				getDemandSupplyLevelObjectsList().get(0).getDemandSupplyLevelObjectId());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributes_SuccessTest() throws Exception {

		when(camgenRepository.getDemandSupplyLevelObjectAttributes())
				.thenReturn(getDemandSupplyLevelObjectAttributes());
		DemandSupplyLevels response = camgenServiceImpl.getDemandSupplyLevelObjectAttributes();
		assertEquals(response.get(0).getDemandSupplyLevelDesc(),
				getDemandSupplyLevelObjectAttributes().get(0).getDemandSupplyLevelDesc());
		assertEquals(response.get(0).getDemandSupplyLevelId(),
				getDemandSupplyLevelObjectAttributes().get(0).getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelName(),
				getDemandSupplyLevelObjectAttributes().get(0).getDemandSupplyLevelName());
	}

	private DemandSupplyLevels getDemandSupplyLevelObjectAttributes() {

		DemandSupplyLevels demandSupplyLevels = new DemandSupplyLevels();
		DemandSupplyLevel demandSupplyLevel = new DemandSupplyLevel();
		demandSupplyLevel.setDemandSupplyLevelDesc("Desc");
		demandSupplyLevel.setDemandSupplyLevelId(1);
		demandSupplyLevel.setDemandSupplyLevelName("Name");
		demandSupplyLevels.add(demandSupplyLevel);
		return demandSupplyLevels;
	}

	private DemandSupplyObjectAttributes getDemandSupplyLevelObjectAttributesList() {

		DemandSupplyObjectAttributes demandSupplyObjectAttributes = new DemandSupplyObjectAttributes();
		DemandSupplyObjectAttribute demandSupplyObjectAttribute = new DemandSupplyObjectAttribute();
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeDesc("Desc");
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeId(1);
		demandSupplyObjectAttribute.setDemandSupplyObjectAttributeName("Name");
		demandSupplyObjectAttribute.setDemandSupplyObjectId(1);
		demandSupplyObjectAttributes.add(demandSupplyObjectAttribute);
		return demandSupplyObjectAttributes;
	}

	private DemandSupplyObjectAttributeConditions getDemandSupplyObjectAttributeConditionsList() {

		DemandSupplyObjectAttributeConditions demandSupplyObjectAttributeConditions = new DemandSupplyObjectAttributeConditions();
		DemandSupplyObjectAttributeCondition demandSupplyObjectAttributeCondition = new DemandSupplyObjectAttributeCondition();
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionId(1);
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionDesc("Desc");
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeConditionName("Name");
		demandSupplyObjectAttributeCondition.setDemandSupplyObjectAttributeId(1);
		demandSupplyObjectAttributeConditions.add(demandSupplyObjectAttributeCondition);
		return demandSupplyObjectAttributeConditions;
	}

	private DemandSupplyLevelObjects getDemandSupplyLevelObjectsList() {

		DemandSupplyLevelObjects demandSupplyLevelObjects = new DemandSupplyLevelObjects();
		DemandSupplyLevelObject demandSupplyLevelObject = new DemandSupplyLevelObject();
		demandSupplyLevelObject.setDemandSupplyLevelId(1);
		demandSupplyLevelObject.setDemandSupplyLevelObjectDesc("Desc");
		demandSupplyLevelObject.setDemandSupplyLevelObjectId(1);
		demandSupplyLevelObject.setDemandSupplyLevelObjectName("Name");
		demandSupplyLevelObjects.add(demandSupplyLevelObject);
		return demandSupplyLevelObjects;
	}
}