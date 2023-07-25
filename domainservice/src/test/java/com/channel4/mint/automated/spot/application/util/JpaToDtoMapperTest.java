package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttrCond;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.automated.spot.test.util.CamgenTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class JpaToDtoMapperTest {

	@InjectMocks
	private JpaToDtoMapper jpaToDtoMapper;

	CamgenTestUtil camgenTestUtil = new CamgenTestUtil();

	List<CamgenDemandSupplyAttrCond> camgenDemandSupplyAttrCondList = null;
	List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels = null;
	List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList = null;
	List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeList = null;

	@Before
	public void init() {

		camgenDemandSupplyAttrCondList = new ArrayList<>();
		camgenDemandSupplyLevels = new ArrayList<>();
		camgenDemandSupplyObjectList = new ArrayList<>();
		camgenDemandSupplyAttributeList = new ArrayList<>();

		camgenDemandSupplyObjectList = camgenTestUtil.getCamgenDemandSupplyObjectList();
		camgenDemandSupplyLevels = camgenTestUtil.getCamgenDemandSupplyLevels();
		camgenDemandSupplyAttrCondList = camgenTestUtil.getCamgenDemandSupplyAttrCond();
		camgenDemandSupplyAttributeList = camgenTestUtil.getCamgenDemandSupplyAttributeList();
	}

	@Test
	public void mapCamgenJpaToDemandDto_Test() throws Exception {

		DemandSupplyObjectAttributeConditions response = jpaToDtoMapper
				.mapCamgenJpaToDemandDto(camgenDemandSupplyAttrCondList);
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionDesc(),
				camgenDemandSupplyAttrCondList.get(0).getCamgenDemandSupplyCondition().getDemandSupplyConditionDesc());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionId().longValue(),
				camgenDemandSupplyAttrCondList.get(0).getCamgenDemandSupplyCondition().getDemandSupplyConditionId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionName(),
				camgenDemandSupplyAttrCondList.get(0).getCamgenDemandSupplyCondition().getDemandSupplyConditionCode());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId().longValue(),
				camgenDemandSupplyAttrCondList.get(0).getDemandSupplyAttrCondId());
	}

	@Test
	public void mapCamgenLevelToDemandSupplyLevels_Test() throws Exception {

		DemandSupplyLevels response = jpaToDtoMapper.mapCamgenLevelToDemandSupplyLevels(camgenDemandSupplyLevels);
		assertEquals(response.get(0).getDemandSupplyLevelDesc(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelCode());
		assertEquals(response.get(0).getDemandSupplyLevelId().longValue(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelName(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelName());
	}

	@Test
	public void mapCamgenToDemandSupplyObjects_Test() throws Exception {

		DemandSupplyLevelObjects response = jpaToDtoMapper.mapCamgenToDemandSupplyObjects(camgenDemandSupplyObjectList);
		assertEquals(response.get(0).getDemandSupplyLevelId().longValue(),
				camgenDemandSupplyObjectList.get(0).getCamgenDemandSupplyLevel().getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelObjectDesc(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectCode());
		assertEquals(response.get(0).getDemandSupplyLevelObjectId().longValue(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectId());
		assertEquals(response.get(0).getDemandSupplyLevelObjectName(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectName());

	}

	@Test
	public void mapCamgenToDemandObjectAttributes_Test() throws Exception {

		DemandSupplyObjectAttributes response = jpaToDtoMapper
				.mapCamgenToDemandObjectAttributes(camgenDemandSupplyAttributeList);
		assertEquals(response.get(0).getDemandSupplyObjectId().longValue(),
				camgenDemandSupplyAttributeList.get(0).getCamgenDemandSupplyObject().getDemandSupplyObjectId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeDesc(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeCode());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId().longValue(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeName(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeName());

	}
}
