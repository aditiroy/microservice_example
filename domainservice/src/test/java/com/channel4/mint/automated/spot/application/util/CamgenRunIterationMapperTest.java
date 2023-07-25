package com.channel4.mint.automated.spot.application.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.RunIterationRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRun;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.test.util.TestUtil;

public class CamgenRunIterationMapperTest {

	@InjectMocks
	CamgenRunIterationMapper camgenRunIterationMapper;

	@Mock
	private DateTimeUtility dateTimeUtility;

	@Mock
	private RunIterationRepository runIterationRepository;

	List<CamgenRunIteration> camgenRunIterationList = new ArrayList<>();
	CamgenRunIteration camgenRunIteration = new CamgenRunIteration();
	com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration camgenRunIterationDto = new com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration();
	CamgenRunIterations camgenRunIterations;
	CamgenRun camgenRun;
	TestUtil testUtil = new TestUtil();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		camgenRunIterations = testUtil.getCamgenRunIterations();
		camgenRunIterationList.add(camgenRunIteration);

		camgenRun = testUtil.getCamgenRun();
		camgenRunIterationDto = testUtil.getCamgenRunIteration();
	}

	@Test
	public void mapCamgenRunIterationsSuccessTest() throws Exception {

		List<CamgenRunIteration> response = camgenRunIterationMapper.mapCamgenRunIterations(camgenRunIterations);
		assertEquals(response.get(0).getCreatedBy(), camgenRunIterations.get(0).getCreatedBy());
		assertEquals(response.get(0).getIterationNumber().intValue(), camgenRunIterations.get(0).getIterationNumber().intValue());
		assertEquals(response.get(0).getIterationSolutionFileName(), camgenRunIterations.get(0).getSolutionFileName());
	}

	@Test
	public void getCamgenRunSuccessTest() throws Exception {

		com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations response = camgenRunIterationMapper
				.getCamgenRun(camgenRun);
		assertEquals(response.get(0).getRunId().intValue(), camgenRun.getRunId());
		assertEquals(response.get(0).getSnapShotId().intValue(), camgenRun.getCamgenRequest().getRequestId());
	}

}
