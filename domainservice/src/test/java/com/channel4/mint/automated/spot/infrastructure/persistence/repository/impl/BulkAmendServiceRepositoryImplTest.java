package com.channel4.mint.automated.spot.infrastructure.persistence.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.CamgenRequestJpaRepository;
import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;
import com.channel4.mint.automated.spot.test.util.TestUtil;
import com.channel4.mint.baseexception.MintBaseException;

public class BulkAmendServiceRepositoryImplTest {

	@InjectMocks
	BulkAmendServiceRepositoryImpl bulkAmendServiceRepositoryImpl;

	@Mock
	private CamgenRequestJpaRepository camgenRequestJpaRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	TestUtil testUtil = new TestUtil();
	CamgenRequest camgenRequest;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		camgenRequest= testUtil.getCamgenRequest();
	
	}
	
	@Test
	public void getRequestByIdSuccessTest() throws Exception {
		when(camgenRequestJpaRepository.findOne(1L)).thenReturn(camgenRequest);
		CamgenRequest response = bulkAmendServiceRepositoryImpl.getRequestById(1L);
		assertEquals(response.getChannelSetId(), camgenRequest.getChannelSetId());
		assertEquals(response.getRequestId(), camgenRequest.getRequestId());
		assertEquals(response.getCreatedBy(), camgenRequest.getCreatedBy());
	}

	@Test
	public void getRequestByIdExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRequestJpaRepository.findOne(1L)).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			bulkAmendServiceRepositoryImpl.getRequestById(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void getRequestByIdDataNotFoundExceptionTest() throws Exception {
		when(camgenRequestJpaRepository.findOne(1L)).thenReturn(null);
		int exceptionCode = 0;
		try {
			bulkAmendServiceRepositoryImpl.getRequestById(1L);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
	

	@Test
	public void updateStatusSuccessTest() throws Exception {
		when(camgenRequestJpaRepository.save(camgenRequest)).thenReturn(camgenRequest);
		Long response = bulkAmendServiceRepositoryImpl.updateStatus(camgenRequest);
		assertEquals(response,Long.valueOf(camgenRequest.getRequestId()));
	}

	@Test
	public void updateStatusExceptionTest() throws Exception {
		DataRetrievalFailureException dataRetrievalFailureException = new DataRetrievalFailureException(
				"DataRetrivalFailureException");
		when(camgenRequestJpaRepository.save(camgenRequest)).thenThrow(dataRetrievalFailureException);
		int exceptionCode = 0;
		try {
			bulkAmendServiceRepositoryImpl.updateStatus(camgenRequest);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionCode);
	}
	
	@Test
	public void updateStatusDataNotFoundExceptionTest() throws Exception {
		when(camgenRequestJpaRepository.save(camgenRequest)).thenReturn(null);
		int exceptionCode = 0;
		try {
			bulkAmendServiceRepositoryImpl.updateStatus(camgenRequest);
		} catch (MintBaseException mintBaseException) {
			exceptionCode = mintBaseException.getCode();
		}
		assertEquals(HttpStatus.NOT_FOUND.value(), exceptionCode);
	}
}
