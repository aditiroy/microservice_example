package com.channel4.mint.automated.spot.infrastructure.persistence.repository;

import com.channel4.mint.automated.spot.infrastructure.persistence.repository.model.CamgenRequest;

public interface BulkAmendServiceRepository {

	CamgenRequest getRequestById(Long id);

	Long updateStatus(CamgenRequest camgenRequest);

}
