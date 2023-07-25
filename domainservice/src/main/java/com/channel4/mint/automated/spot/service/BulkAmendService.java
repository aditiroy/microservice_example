package com.channel4.mint.automated.spot.service;

import java.util.List;

import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;

public interface BulkAmendService {

	List<Field> updateCancelStatus(List<Snapshots> snapshots);

	List<Field> updateQueueStatus(List<Snapshots> snapshots);

}
