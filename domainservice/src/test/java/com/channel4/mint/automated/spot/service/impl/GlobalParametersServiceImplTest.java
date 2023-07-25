package com.channel4.mint.automated.spot.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParam;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannel;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtract;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBand;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.service.CamgenParamAudGroupChannelsService;
import com.channel4.mint.automated.spot.service.CamgenParamEIBandsService;
import com.channel4.mint.automated.spot.service.CamgenParametersService;
import com.channel4.mint.automated.spot.service.ExtractParametersService;
import com.channel4.mint.automated.spot.service.StationEITimeBandsService;
import com.channel4.mint.automated.spot.service.StationTimeBandsService;

public class GlobalParametersServiceImplTest {

	@InjectMocks
	private GlobalParametersServiceImpl globalParametersServiceImpl;
	
	@Mock
	private StationTimeBandsService stationTimeBandsService;

	@Mock
	private CamgenParamAudGroupChannelsService camgenParamAudGroupChannelsService;

	@Mock
	private CamgenParametersService camgenParametersService;

	@Mock
	private ExtractParametersService extractParametersService;

	@Mock
	private CamgenParamEIBandsService camgenParamEIBandsService;
	
	@Mock
	private StationEITimeBandsService stationEITimeBandsService;
    @Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testUpdateGlobalParameters() {
		//Mockito.doNothing().when(camgenParamAudGroupChannelsService).createCamgenParamAudGroupChannels(Mockito.any(CamgenParamAudGroupChannels.class));
		/*Mockito.doNothing().when(stationTimeBandsService).createCamgenParamStationTimeBands(Mockito.any(CamgenParamStationTimeBands.class));
		CamgenParameters zxc;
		Mockito.doNothing().when(camgenParametersService).createCamgenParameters(Mockito.any(CamgenParameters.class));
		CamgenParamExtracts sdg;
		Mockito.doNothing().when(extractParametersService).createCamgenParamExtracts(Mockito.any(CamgenParamExtracts.class));
		
		CamgenParamEIBands sdffh;
		Mockito.doNothing().when(camgenParamEIBandsService).createCamgenParameters(Mockito.any(CamgenParamEIBands.class));
		
		Mockito.doNothing().when(stationEITimeBandsService).createCamgenParamStationEITimeBands(Mockito.any(CamgenParamStationEITimeBands.class));*/
		 
		CamgenGlobalParametersRequest camgenGlobalParametersRequest=new CamgenGlobalParametersRequest();
		CamgenParamAudGroupChannels camgenParamAudGroupChannels=new CamgenParamAudGroupChannels();
		
		CamgenParamAudGroupChannel e=new CamgenParamAudGroupChannel();
		e.setChannelId(1);
		camgenParamAudGroupChannels.add(e);
		camgenGlobalParametersRequest.setCamgenParamAudGroupChannels(camgenParamAudGroupChannels);
	
		CamgenParamEIBands camgenParamEIBands=new CamgenParamEIBands();
		CamgenParamEIBand camgenParamEIBand=new CamgenParamEIBand();camgenParamEIBand.setEiBand(1);
		camgenParamEIBands.add(camgenParamEIBand);
		camgenGlobalParametersRequest.setCamgenParamEIBands(camgenParamEIBands);
		
		CamgenParameters camgenParameters=new CamgenParameters();
		CamgenParam camParam=new CamgenParam();camParam.setId(1L);
		camgenParameters.add(camParam);
		camgenGlobalParametersRequest.setCamgenParameters(camgenParameters);
		
		CamgenParamExtracts camgenParamExtracts=new CamgenParamExtracts();
		CamgenParamExtract camParExt=new CamgenParamExtract();camParExt.setId(1L);
		camgenParamExtracts.add(camParExt);
		camgenGlobalParametersRequest.setCamgenParamExtracts(camgenParamExtracts);
		
		CamgenParamStationEITimeBands camgenParamStationEITimeBands=new CamgenParamStationEITimeBands();
		CamgenParamStationEITimeBand capEiBand=new CamgenParamStationEITimeBand();capEiBand.setId(1L);
		camgenParamStationEITimeBands.add(capEiBand);
		camgenGlobalParametersRequest.setCamgenParamStationEITimeBands(camgenParamStationEITimeBands);
		
		CamgenParamStationTimeBands camgenParamStationTimeBands=new CamgenParamStationTimeBands();
		CamgenParamStationTimeBand timeBand=new CamgenParamStationTimeBand();timeBand.setChannelId(1);
		camgenParamStationTimeBands.add(timeBand);
		camgenGlobalParametersRequest.setCamgenParamStationTimeBands(camgenParamStationTimeBands);
		globalParametersServiceImpl.updateGlobalParameters(camgenGlobalParametersRequest);
	}

}
