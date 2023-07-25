package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channel4.mint.automated.spot.application.util.JpaToDtoMapper;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyAttributeJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyConditionJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyLevelJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenDemandSupplyObjectJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyAttribute;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyCondition;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyLevel;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenDemandSupplyObject;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.automated.spot.test.util.CamgenTestUtil;
import com.channel4.mint.baseexception.MintBaseException;

@RunWith(SpringJUnit4ClassRunner.class)
public class CamgenRepositoryImplTest {

	@InjectMocks
	private CamgenRepositoryImpl camgenRepositoryImpl;

	@Mock
	private CamgenDemandSupplyLevelJpaRepository camgenDemandSupplyLevelJpaRepository;

	@Mock
	private CamgenDemandSupplyAttributeJpaRepository camgenDemandSupplyAttributeJpaRepository;

	@Mock
	private CamgenDemandSupplyConditionJpaRepository camgenDemandSupplyConditionJpaRepository;

	@Mock
	private CamgenDemandSupplyObjectJpaRepository camgenDemandSupplyObjectJpaRepository;

	@Mock
	private JpaToDtoMapper jpaToDtoMapper;

	private CamgenTestUtil camgenTestUtil = new CamgenTestUtil();

	List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels = null;
	DemandSupplyLevels demandSupplyLevels = null;
	CamgenDemandSupplyLevel camgenDemandSupplyLevel = null;
	DemandSupplyLevelObjects demandSupplyLevelObjects = null;
	DemandSupplyObjectAttributes demandSupplyObjectAttributes = null;
	CamgenDemandSupplyObject camgenDemandSupplyObject = null;
	DemandSupplyObjectAttributeConditions demandSupplyObjectAttributeConditions = null;
	CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = null;
	List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeList = null;
	List<CamgenDemandSupplyCondition> camgenDemandSupplyConditionList = null;
	List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList = null;

	@Before
	public void init() {

		demandSupplyObjectAttributes = new DemandSupplyObjectAttributes();
		demandSupplyLevelObjects = new DemandSupplyLevelObjects();
		camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		camgenDemandSupplyLevels = new ArrayList<>();
		demandSupplyLevels = new DemandSupplyLevels();
		camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		demandSupplyObjectAttributeConditions = new DemandSupplyObjectAttributeConditions();
		camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		camgenDemandSupplyAttributeList = new ArrayList<>();
		camgenDemandSupplyConditionList = new ArrayList<>();
		camgenDemandSupplyObjectList = new ArrayList<>();

		camgenDemandSupplyObjectList = camgenTestUtil.getCamgenDemandSupplyObjectList();
		camgenDemandSupplyAttribute = camgenTestUtil.getCamgenDemandSupplyAttribute();
		camgenDemandSupplyAttributeList = camgenTestUtil.getCamgenDemandSupplyAttributeList();
		demandSupplyObjectAttributeConditions = camgenTestUtil.getDemandSupplyObjectAttributeConditions();
		camgenDemandSupplyObject = camgenTestUtil.getCamgenDemandSupplyObject();
		demandSupplyObjectAttributes = camgenTestUtil.getDemandSupplyObjectAttributes();
		demandSupplyLevelObjects = camgenTestUtil.getDemandSupplyLevelObjects();
		camgenDemandSupplyLevels = camgenTestUtil.getCamgenDemandSupplyLevels();
		demandSupplyLevels = camgenTestUtil.getDemandSupplyLevels();
		camgenDemandSupplyLevel = camgenTestUtil.getCamgenDemandSupplyLevel();
		camgenDemandSupplyConditionList = camgenTestUtil.getCamgenDemandSupplyConditionList();
	}

	@Test
	public void getDemandSupplyLevelObjectAttributesSuccessTest() throws Exception {

		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenReturn(camgenDemandSupplyLevels);
		when(jpaToDtoMapper.mapCamgenLevelToDemandSupplyLevels(Mockito.anyList())).thenReturn(demandSupplyLevels);
		DemandSupplyLevels response = camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes();
		assertEquals(response.get(0).getDemandSupplyLevelId(), demandSupplyLevels.get(0).getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelDesc(), demandSupplyLevels.get(0).getDemandSupplyLevelDesc());
		assertEquals(response.get(0).getDemandSupplyLevelName(), demandSupplyLevels.get(0).getDemandSupplyLevelName());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributesEmptyCheckTest() throws Exception {

		int ex = 0;
		List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels = new ArrayList<>();
		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenReturn(camgenDemandSupplyLevels);
		when(jpaToDtoMapper.mapCamgenLevelToDemandSupplyLevels(Mockito.anyList())).thenReturn(demandSupplyLevels);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributesExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalException");
		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getDemandSupplyLevelObjectsSuccessTest() throws Exception {

		when(jpaToDtoMapper.mapCamgenToDemandSupplyObjects(Mockito.anyList())).thenReturn(demandSupplyLevelObjects);
		when(camgenDemandSupplyLevelJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenDemandSupplyLevel);
		DemandSupplyLevelObjects response = camgenRepositoryImpl.getDemandSupplyLevelObjects(1);
		assertEquals(response.get(0).getDemandSupplyLevelId(),
				demandSupplyLevelObjects.get(0).getDemandSupplyLevelId());
		assertEquals(response.get(0).getDemandSupplyLevelObjectName(),
				demandSupplyLevelObjects.get(0).getDemandSupplyLevelObjectName());
		assertEquals(response.get(0).getDemandSupplyLevelObjectId(),
				demandSupplyLevelObjects.get(0).getDemandSupplyLevelObjectId());
		assertEquals(response.get(0).getDemandSupplyLevelObjectDesc(),
				demandSupplyLevelObjects.get(0).getDemandSupplyLevelObjectDesc());
	}

	@Test
	public void getDemandSupplyLevelObjectsNullCheckTest() throws Exception {

		int ex = 0;
		CamgenDemandSupplyLevel camgenDemandSupplyLevel = new CamgenDemandSupplyLevel();
		when(jpaToDtoMapper.mapCamgenToDemandSupplyObjects(Mockito.anyList())).thenReturn(demandSupplyLevelObjects);
		when(camgenDemandSupplyLevelJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenDemandSupplyLevel);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjects(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjects_NullCheckTest() throws Exception {

		int ex = 0;
		when(jpaToDtoMapper.mapCamgenToDemandSupplyObjects(Mockito.anyList())).thenReturn(demandSupplyLevelObjects);
		when(camgenDemandSupplyLevelJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjects(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectsExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyLevelJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjects(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributes_SuccessTest() throws Exception {

		when(camgenDemandSupplyObjectJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenDemandSupplyObject);
		when(jpaToDtoMapper.mapCamgenToDemandObjectAttributes(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributes);
		DemandSupplyObjectAttributes response = camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes(1);
		assertEquals(response.get(0).getDemandSupplyObjectAttributeDesc(),
				demandSupplyObjectAttributes.get(0).getDemandSupplyObjectAttributeDesc());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId(),
				demandSupplyObjectAttributes.get(0).getDemandSupplyObjectAttributeId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeName(),
				demandSupplyObjectAttributes.get(0).getDemandSupplyObjectAttributeName());
		assertEquals(response.get(0).getDemandSupplyObjectId(),
				demandSupplyObjectAttributes.get(0).getDemandSupplyObjectId());

	}

	@Test
	public void getDemandSupplyLevelObjectAttributes_NullCheckTest() throws Exception {

		int ex = 0;
		CamgenDemandSupplyObject camgenDemandSupplyObject = new CamgenDemandSupplyObject();
		when(camgenDemandSupplyObjectJpaRepository.findOne(Mockito.anyLong())).thenReturn(camgenDemandSupplyObject);
		when(jpaToDtoMapper.mapCamgenToDemandObjectAttributes(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributes);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributes_NullCheck_Test() throws Exception {

		int ex = 0;
		when(camgenDemandSupplyObjectJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		when(jpaToDtoMapper.mapCamgenToDemandObjectAttributes(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributes);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributes_ExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyObjectJpaRepository.findOne(Mockito.anyLong())).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributes(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributeConditionsSuccessTest() throws Exception {

		when(camgenDemandSupplyAttributeJpaRepository.findOne(Mockito.anyLong()))
				.thenReturn(camgenDemandSupplyAttribute);
		when(jpaToDtoMapper.mapCamgenJpaToDemandDto(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributeConditions);
		DemandSupplyObjectAttributeConditions response = camgenRepositoryImpl
				.getDemandSupplyLevelObjectAttributeConditions(1);
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionDesc(),
				demandSupplyObjectAttributeConditions.get(0).getDemandSupplyObjectAttributeConditionDesc());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionId(),
				demandSupplyObjectAttributeConditions.get(0).getDemandSupplyObjectAttributeConditionId());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeConditionName(),
				demandSupplyObjectAttributeConditions.get(0).getDemandSupplyObjectAttributeConditionName());
		assertEquals(response.get(0).getDemandSupplyObjectAttributeId(),
				demandSupplyObjectAttributeConditions.get(0).getDemandSupplyObjectAttributeId());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributeConditionsNullCheckTest() throws Exception {

		int ex = 0;
		when(camgenDemandSupplyAttributeJpaRepository.findOne(Mockito.anyLong())).thenReturn(null);
		when(jpaToDtoMapper.mapCamgenJpaToDemandDto(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributeConditions);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributeConditions(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributeConditionsEmptyCheckTest() throws Exception {

		int ex = 0;
		CamgenDemandSupplyAttribute camgenDemandSupplyAttribute = new CamgenDemandSupplyAttribute();
		when(camgenDemandSupplyAttributeJpaRepository.findOne(Mockito.anyLong()))
				.thenReturn(camgenDemandSupplyAttribute);
		when(jpaToDtoMapper.mapCamgenJpaToDemandDto(Mockito.anyList()))
				.thenReturn(demandSupplyObjectAttributeConditions);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributeConditions(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getDemandSupplyLevelObjectAttributeConditionsExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyAttributeJpaRepository.findOne(Mockito.anyLong()))
				.thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getDemandSupplyLevelObjectAttributeConditions(1);
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getAllCamgenDemandSupplyLevelMapSuccessTest() throws Exception {

		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenReturn(camgenDemandSupplyLevels);
		Map<Long, CamgenDemandSupplyLevel> response = camgenRepositoryImpl.getAllCamgenDemandSupplyLevelMap();
		assertEquals(response.get(1L).getDemandSupplyLevelCode(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelCode());
		assertEquals(response.get(1L).getDemandSupplyLevelId(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelId());
		assertEquals(response.get(1L).getDemandSupplyLevelName(),
				camgenDemandSupplyLevels.get(0).getDemandSupplyLevelName());
	}

	@Test
	public void getAllCamgenDemandSupplyLevelMapEmptyCheckTest() throws Exception {

		int ex = 0;
		List<CamgenDemandSupplyLevel> camgenDemandSupplyLevels = new ArrayList<>();
		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenReturn(camgenDemandSupplyLevels);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyLevelMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getAllCamgenDemandSupplyLevelMapExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyLevelJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyLevelMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getAllCamgenDemandSupplyAttributeMapSuccessTest() throws Exception {

		when(camgenDemandSupplyAttributeJpaRepository.findAll()).thenReturn(camgenDemandSupplyAttributeList);
		Map<Long, CamgenDemandSupplyAttribute> response = camgenRepositoryImpl.getAllCamgenDemandSupplyAttributeMap();
		assertEquals(response.get(1L).getDemandSupplyAttributeCode(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeCode());
		assertEquals(response.get(1L).getDemandSupplyAttributeId(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeId());
		assertEquals(response.get(1L).getDemandSupplyAttributeName(),
				camgenDemandSupplyAttributeList.get(0).getDemandSupplyAttributeName());
		assertEquals(response.get(1L).getCamgenDemandSupplyAttrConds().get(0).getDemandSupplyAttrCondId(),
				camgenDemandSupplyAttributeList.get(0).getCamgenDemandSupplyAttrConds().get(0)
						.getDemandSupplyAttrCondId());
	}

	@Test
	public void getAllCamgenDemandSupplyAttributeMapEmptyCheckTest() throws Exception {

		int ex = 0;
		List<CamgenDemandSupplyAttribute> camgenDemandSupplyAttributeList = new ArrayList<>();
		when(camgenDemandSupplyAttributeJpaRepository.findAll()).thenReturn(camgenDemandSupplyAttributeList);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyAttributeMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getAllCamgenDemandSupplyAttributeMapExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyAttributeJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyAttributeMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getAllCamgenDemandSupplyConditionMapSuccessTest() throws Exception {

		when(camgenDemandSupplyConditionJpaRepository.findAll()).thenReturn(camgenDemandSupplyConditionList);
		Map<Long, CamgenDemandSupplyCondition> response = camgenRepositoryImpl.getAllCamgenDemandSupplyConditionMap();
		assertEquals(response.get(1L).getDemandSupplyConditionCode(),
				camgenDemandSupplyConditionList.get(0).getDemandSupplyConditionCode());
		assertEquals(response.get(1L).getDemandSupplyConditionDesc(),
				camgenDemandSupplyConditionList.get(0).getDemandSupplyConditionDesc());
		assertEquals(response.get(1L).getDemandSupplyConditionId(),
				camgenDemandSupplyConditionList.get(0).getDemandSupplyConditionId());
	}

	@Test
	public void getAllCamgenDemandSupplyConditionMapEmptyCheckTest() throws Exception {

		int ex = 0;
		List<CamgenDemandSupplyCondition> camgenDemandSupplyConditionList = new ArrayList<>();
		when(camgenDemandSupplyConditionJpaRepository.findAll()).thenReturn(camgenDemandSupplyConditionList);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyConditionMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getAllCamgenDemandSupplyConditionMapExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyConditionJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyConditionMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void getAllCamgenDemandSupplyObjectMapSuccessTest() throws Exception {

		when(camgenDemandSupplyObjectJpaRepository.findAll()).thenReturn(camgenDemandSupplyObjectList);
		Map<Long, CamgenDemandSupplyObject> response = camgenRepositoryImpl.getAllCamgenDemandSupplyObjectMap();
		assertEquals(response.get(1L).getDemandSupplyObjectId(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectId());
		assertEquals(response.get(1L).getDemandSupplyObjectCode(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectCode());
		assertEquals(response.get(1L).getDemandSupplyObjectName(),
				camgenDemandSupplyObjectList.get(0).getDemandSupplyObjectName());
		assertEquals(response.get(1L).getCamgenDemandSupplyLevel().getDemandSupplyLevelId(),
				camgenDemandSupplyObjectList.get(0).getCamgenDemandSupplyLevel().getDemandSupplyLevelId());
	}

	@Test
	public void getAllCamgenDemandSupplyObjectMapEmptyCheckTest() throws Exception {

		int ex = 0;
		List<CamgenDemandSupplyObject> camgenDemandSupplyObjectList = new ArrayList<>();
		when(camgenDemandSupplyObjectJpaRepository.findAll()).thenReturn(camgenDemandSupplyObjectList);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyObjectMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getAllCamgenDemandSupplyObjectMapExceptionTest() throws Exception {

		int ex = 0;
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrievalFailureException");
		when(camgenDemandSupplyObjectJpaRepository.findAll()).thenThrow(dataRetrievalFailureException);
		try {
			camgenRepositoryImpl.getAllCamgenDemandSupplyObjectMap();
		} catch (MintBaseException e) {
			ex = e.getCode();
		}
		assertEquals(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
