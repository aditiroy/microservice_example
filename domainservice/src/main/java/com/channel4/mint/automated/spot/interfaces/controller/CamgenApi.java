package com.channel4.mint.automated.spot.interfaces.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.channel4.mint.automated.spot.interfaces.dto.BatchTxLevels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenGlobalParametersRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIteration;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunIterations;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamAudGroupChannels;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamEIBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamExtracts;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationEITimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParamStationTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenRunParameters;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetail;
import com.channel4.mint.automated.spot.interfaces.dto.CamgenSnapshotRunDetails;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBandResponse;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimeBands;
import com.channel4.mint.automated.spot.interfaces.dto.ChannelSetTimebandsBulkRequest;
import com.channel4.mint.automated.spot.interfaces.dto.CriteriaLineNormalised;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevelObjects;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyLevels;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributeConditions;
import com.channel4.mint.automated.spot.interfaces.dto.DemandSupplyObjectAttributes;
import com.channel4.mint.automated.spot.interfaces.dto.ExclusionCategories;
import com.channel4.mint.automated.spot.interfaces.dto.Field;
import com.channel4.mint.automated.spot.interfaces.dto.NewEntityCreated;
import com.channel4.mint.automated.spot.interfaces.dto.PlanSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.PlansObject;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotDetail;
import com.channel4.mint.automated.spot.interfaces.dto.SnapshotSummaryWithPagination;
import com.channel4.mint.automated.spot.interfaces.dto.Snapshots;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Interface CamgenApi handling camgen.
 * 
 * @author HCL
 */



/**
 * @RestController---- @Controller + @ResponseBody
 * 
 * ResponseEntity is meant to represent the entire HTTP response. You can control anything that goes into it: status code, headers, and body.

 * @ResponseBody is a marker for the HTTP response body and @ResponseStatus declares the status code of the HTTP response.

 * @ResponseStatus isn't very flexible. It marks the entire method so you have to be sure that your handler method will always behave the same way. And you still can't set the headers. You'd need the HttpServletResponse or a HttpHeaders parameter.

 * Basically, ResponseEntity lets you do more.
 * 
 * 
 * */

@Api(value = "camgen", description = "the camgen API")
public interface CamgenApi {

	/**
	 * Creates the camgen param aud group channels.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global Audience Group Channel parameters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/audienceGroupChannels", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParamAudGroupChannels(
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenParamAudGroupChannels body);

	/**
	 * Creates the camgen param extracts.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global Extract parameters", notes = " This endpoint creates new set of camgen global Extract paramters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/extracts", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParamExtracts(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamExtracts body);

	/**
	 * Creates the camgen param station EI time bands.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global paramters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/paramStationEITimeBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParamStationEITimeBands(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamStationEITimeBands body);

	/**
	 * Creates the camgen param station time bands.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters for Station Time Bands", notes = " This endpoint creates a set of camgen global paramters for Station Time Bands ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/stationTimeBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParamStationTimeBands(
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenParamStationTimeBands body);

	/**
	 * Creates the camgen parameters.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global paramters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameters", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParameters(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParameters body);

	/**
	 * Creates the camgen parameters.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters for EI Band", notes = " This endpoint creates new set of camgen global EI Band parameters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/EIBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> createCamgenParameters(
			@ApiParam(value = "updateCamgenParametersEIBands", required = true) @Valid @RequestBody CamgenParamEIBands body);

	/**
	 * Creates the camgen parameters EI bands.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters for EI Band", notes = " This endpoint creates new set of camgen global EI Band parameters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/EIBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParametersEIBands(
			@ApiParam(value = "Camgen Parameters for EI Bands", required = true) @Valid @RequestBody CamgenParamEIBands body);

	/**
	 * Creates the camgen run iterations.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new run Iterations", nickname = "createCamgenRunIterations", notes = " This endpoint creates new set of camgen Run Solutions as received and processed by  Camgen Slotting - Receive Solution (Message Listener) - https://newwiki.channel4.com/pages/viewpage.action?pageId=37152866 This endpoint after successful saving is expected to return the object only if the slot flag associated with this run is 'Auto' The column is CAMGEN_PLAN.IS_SLOT ", response = CamgenRunIteration.class, tags={ "Camgen Run Iterations", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Run Iterations created successfully", response = CamgenRunIteration.class),
        @ApiResponse(code = 404, message = "Could not find records", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
        @ApiResponse(code = 200, message = "Error", response = Error.class) })
    @RequestMapping(value = "/camgen/run/solutions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CamgenRunIteration> createCamgenRunIterations(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CamgenRunIterations body);


	/**
	 * Creates the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global Audience Group Channel parameters ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/audienceGroupChannels", produces = {
			"application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParamAudGroupChannels(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenRunParamAudGroupChannels body);

	/**
	 * Creates the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters for EI Band", notes = " This endpoint creates new set of camgen global EI Band parameters ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/eIBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParamEIBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for EI Bands", required = true) @Valid @RequestBody CamgenRunParamEIBands body);

	/**
	 * Creates the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global Extract parameters", notes = " This endpoint creates new set of camgen global Extract paramters ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/extracts", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParamExtracts(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParamExtracts body);

	/**
	 * Creates the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global paramters ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameter/stationEITimeBands", produces = {
			"application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParamStationEITimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParamStationEITimeBands body);

	/**
	 * Creates the camgen run param station time bands.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters for Station Time Bands", notes = " This endpoint creates a set of camgen global paramters for Station Time Bands ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameter/stationTimeBands", produces = {
			"application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParamStationTimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenRunParamStationTimeBands body);

	/**
	 * Creates the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint creates new set of camgen global paramters ", response = Void.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters created successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenRunParameters(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId,
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenRunParameters body);

	/**
	 * Creates the camgen snapshot run details.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new camgen snapshot run details", nickname = "createCamgenSnapshotRunDetails", notes = " This endpoint creates new snapshot run details ", response = NewEntityCreated.class, tags={ "Camgen Snapshot Run Details", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Run details created successfully", response = NewEntityCreated.class),
        @ApiResponse(code = 404, message = "Could not find records", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
        @ApiResponse(code = 200, message = "Error", response = Error.class) })
    @RequestMapping(value = "/camgen/snapshot/runs",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<NewEntityCreated> createCamgenSnapshotRunDetails(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CamgenSnapshotRunDetail body);

	/**
	 * Creates the plans.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "creates new snapshot plans", notes = " This endpoint creates new snapshot plans <br/> This endpoint calls the following external endpoint:          | Call Type |   Endpoint                        | Service                       |     | -------   | --------                          |--------                       |     |        |                    |  | ", response = Void.class, tags = {
			"Plan", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/plans", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createPlans(@ApiParam(value = "") @Valid @RequestBody PlansObject body);

	@ApiOperation(value = "Create camgen request. Supports manual and automatic use cases", nickname = "createSnapshot", notes = "This endpoint creates new camgen requests ", response = Field.class, tags = {
			"snapshot", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Snapshot created Successfully. Returns the ID of the created snapshot", response = Field.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/snapshots", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<List<Field>> createSnapshot(@ApiParam(value = "") @Valid @RequestBody List<SnapshotDetail> snapshots);

	/**
	 * Delete snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return Void
	 */
	@ApiOperation(value = "deletes a snapshot", notes = " This endpoint delete a snapshot based on given {id} ", response = Void.class, tags = {
			"snapshot", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/snapshots/{snapshotId}", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteSnapshot(
			@ApiParam(value = "The id of the snapshot to delete", required = true) @PathVariable("snapshotId") Integer snapshotId);

	/**
	 * Gets the all snapshots.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return SnapshotSummaryWithPagination
	 */
	@ApiOperation(value = "returns a list of all snapshots", nickname = "getSnapshotsList", notes = " This endpoint returns a list of all snapshots stored in the database ", response = SnapshotSummaryWithPagination.class, tags = {
			"snapshot", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = SnapshotSummaryWithPagination.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
	@RequestMapping(value = "/camgen/snapshots/list", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<SnapshotSummaryWithPagination> getSnapshotsList(
			@NotNull @ApiParam(value = "Page number, default value is 1", required = true) @Valid @RequestParam(value = "page", required = true) Integer page,
			@NotNull @ApiParam(value = "Number of rows per page, default value is 20", required = true) @Valid @RequestParam(value = "count", required = true) Long count,
			@ApiParam(value = "Sorting order ASC or DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
			@ApiParam(value = "Sort the results by field name") @Valid @RequestParam(value = "sortByField", required = false) String sortByField);

	/**
	 * Gets the camgen param EI bands.
	 *
	 * @return CamgenParamEIBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for EI Bands", notes = " This endpoint retrieves Camgen Global paramters list for EI Bands ", response = CamgenParamEIBands.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CamgenParamEIBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/EIBands", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParamEIBands> getCamgenParamEIBands();

	/**
	 * Gets the camgen param station EI time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for EI Time Bands", notes = " This endpoint retrieves Camgen Global paramters list for EI Time Bands ", response = CamgenParamStationEITimeBands.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenParamStationEITimeBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/paramStationEITimeBands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParamStationEITimeBands> getCamgenParamStationEITimeBands();

	/**
	 * Gets the camgen param station time bands.
	 *
	 * @return CamgenParamStationEITimeBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for Station Time Bands", notes = " This endpoint retrieves Camgen Global paramters list ", response = CamgenParamStationTimeBands.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenParamStationTimeBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/stationTimeBands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParamStationTimeBands> getCamgenParamStationTimeBands();

	/**
	 * Gets the camgen parameter audience group channels.
	 *
	 * @return CamgenParamAudGroupChannels
	 */
	@ApiOperation(value = "retrieve a list of camgen global Audience Group Channel parameters", notes = " This endpoint gets a list of camgen global Audience Group Channel parameters ", response = CamgenParamAudGroupChannels.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenParamAudGroupChannels.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/audienceGroupChannels", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParamAudGroupChannels> getCamgenParameterAudienceGroupChannels();

	/**
	 * Gets the camgen parameter extracts.
	 *
	 * @return CamgenParamExtracts
	 */
	@ApiOperation(value = "retrieve a list of Camgen Extract parameters", notes = " This endpoint retrieves Camgen Global Extract paramters list ", response = CamgenParamExtracts.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CamgenParamExtracts.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/extracts", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParamExtracts> getCamgenParameterExtracts();

	/**
	 * Gets the camgen parameters.
	 *
	 * @return CamgenParameters
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters", notes = " This endpoint retrieves Camgen Global paramters list ", response = CamgenParameters.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenParameters.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameters", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenParameters> getCamgenParameters();

	/**
	 * Gets the camgen run iterations.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunIterations
	 */
	 @ApiOperation(value = "retrieve a list of Camgen Run Iterations", nickname = "getCamgenRunIterations", notes = " This endpoint retrieves Camgen Run Iterations ", response = CamgenRunIterations.class, tags={ "Camgen Run Iterations", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenRunIterations.class),
	        @ApiResponse(code = 404, message = "Could not find records", response = Error.class),
	        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
	        @ApiResponse(code = 200, message = "Error", response = Error.class) })
	    @RequestMapping(value = "/camgen/run/{runId}/solutions",
	        produces = { "application/json" }, 
	        method = RequestMethod.GET)
	    ResponseEntity<CamgenRunIterations> getCamgenRunIterations(@ApiParam(value = "The ID of the snapshot to retrieve",required=true) @PathVariable("runId") Integer runId);


	/**
	 * Gets the camgen run param aud group channels.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamAudGroupChannels
	 */
	@ApiOperation(value = "retrieve a list of camgen global Audience Group Channel parameters", notes = " This endpoint gets a list of camgen global Audience Group Channel parameters ", response = CamgenRunParamAudGroupChannels.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenRunParamAudGroupChannels.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/audienceGroupChannels", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParamAudGroupChannels> getCamgenRunParamAudGroupChannels(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen run param batch tx levels.
	 *
	 * @param snapShotId
	 *            the snap shot id
	 * @return BatchTxLevels
	 */
	@ApiOperation(value = "retrieve a list of camgen Batch Tx Levels parameters", notes = " This endpoint gets a list of camgen Batch Tx Levels parameters ", response = BatchTxLevels.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BatchTxLevels.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/snapshot/parameters/batchTxLevels", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<BatchTxLevels> getCamgenRunParamBatchTxLevels(
			@ApiParam(value = "snapshotId") @Valid @RequestParam(value = "snapshotId", required = false) Integer snapshotId);

	/**
	 * Gets the camgen run param EI bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamEIBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for EI Bands", notes = " This endpoint retrieves Camgen Global paramters list for EI Bands ", response = CamgenRunParamEIBands.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenRunParamEIBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/eIBands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParamEIBands> getCamgenRunParamEIBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen run param extracts.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamExtracts
	 */
	@ApiOperation(value = "retrieve a list of Camgen Extract parameters", notes = " This endpoint retrieves Camgen Global Extract paramters list ", response = CamgenRunParamExtracts.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CamgenRunParamExtracts.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters/extracts", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParamExtracts> getCamgenRunParamExtracts(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen run param station EI time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationEITimeBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for EI Time Bands", notes = " This endpoint retrieves Camgen Global paramters list for EI Time Bands ", response = CamgenRunParamStationEITimeBands.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenRunParamStationEITimeBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameter/stationEITimeBands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParamStationEITimeBands> getCamgenRunParamStationEITimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen run param station time bands.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParamStationTimeBands
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters for Station Time Bands", notes = " This endpoint retrieves Camgen Global paramters list ", response = CamgenRunParamStationTimeBands.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = CamgenRunParamStationTimeBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameter/stationTimeBands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParamStationTimeBands> getCamgenRunParamStationTimeBands(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen run parameters.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenRunParameters
	 */
	@ApiOperation(value = "retrieve a list of Camgen parameters", notes = " This endpoint retrieves Camgen Global paramters list ", response = CamgenRunParameters.class, tags = {
			"Camgen Run Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CamgenRunParameters.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/run/{runId}/parameters", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenRunParameters> getCamgenRunParameters(
			@ApiParam(value = "", required = true) @PathVariable("runId") Integer runId);

	/**
	 * Gets the camgen snapshot run details.
	 *
	 * @param runId
	 *            the run id
	 * @return CamgenSnapshotRunDetails
	 */
	@ApiOperation(value = "retrieve Run details for a given run Id", nickname = "getCamgenSnapshotRunDetails", notes = " This endpoint retrieves Run details for a given run id ", response = CamgenSnapshotRunDetail.class, tags = {
			"Camgen Snapshot Run Details", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenSnapshotRunDetail.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/snapshot/runs", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<CamgenSnapshotRunDetail>> getCamgenSnapshotRunDetails(
			@ApiParam(value = "The ID of the snapshot to retrieve", required = false) @Valid @RequestParam(value = "runId", required = false) Integer runId,
			@ApiParam(value = "scheduled date of a camgen request run") @Valid @RequestParam(value = "scheduledDate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")DateTime scheduledDate,
			@ApiParam(value = "status of camgen request") @Valid @RequestParam(value = "requestStatus", required = false)String requestStatus,
			@ApiParam(value = "status of camgen run") @Valid @RequestParam(value = "runStatus", required = false)String runStatus);
	
	/**
	 * Gets the camgen snapshot runs.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return CamgenSnapshotRunDetails
	 */
	@ApiOperation(value = "retrieve list of runs for a given snapshot Id", nickname = "getCamgenSnapshotRuns", notes = " This endpoint retrieves list of runs for a given snapshot id ", response = CamgenSnapshotRunDetails.class, tags = {
			"Camgen Snapshot Run Details", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Total number of 'totalNoOfParameters' returned successfully.", response = CamgenSnapshotRunDetails.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/snapshot/{snapshotId}/runs", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<CamgenSnapshotRunDetails> getCamgenSnapshotRuns(
			@ApiParam(value = "The ID of the snapshot to retrieve the run details", required = true) @PathVariable("snapshotId") Integer snapshotId);

	/**
	 * Gets the demand supply group criteria lines.
	 *
	 * @param demandSupplyGroupId
	 *            the demand supply group id
	 * @return CriteriaLineNormalised
	 */
	@ApiOperation(value = "returns a list of criteria lines", notes = " This endpoint returns a list of criteria lines based on given demand supply group {id} <br/> This endpoint calls the following external endpoint:          | Call Type |   Endpoint                        | Service                       |     | -------   | --------                          |--------                       |     |        |            |  | ", response = CriteriaLineNormalised.class, responseContainer = "List", tags = {
			"Criteria", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = CriteriaLineNormalised.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/demandSupplyGroup/criteriaLines/{demandSupplyGroupId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<CriteriaLineNormalised>> getDemandSupplyGroupCriteriaLines(
			@ApiParam(value = "The id of the plan to retrieve", required = true) @PathVariable("demandSupplyGroupId") Integer demandSupplyGroupId);

	/**
	 * Gets the plan.
	 *
	 * @param planId
	 *            the plan id
	 * @return PlansObject
	 */
	@ApiOperation(value = "returns camgen plans based on the query parameters", nickname = "getPlans", notes = " This endpoint returns a list snapshot plans <br/> This endpoint calls the following external endpoint:          | Call Type |   Endpoint                        | Service                       |     | -------   | --------                          |--------                       |     |      |                     |  | ", response = PlansObject.class, responseContainer = "List", tags = {
			"Plan", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = PlansObject.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/plans", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<PlansObject>> getPlans(
			@ApiParam(value = "Date of Plan") @Valid @RequestParam(value = "planDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate planDate,
			@ApiParam(value = "Day Number corresponding to the requested date") @Valid @RequestParam(value = "dayNumber", required = false) String dayNumber,
			@ApiParam(value = "The id of the plan to retrieve") @Valid @RequestParam(value = "planId", required = false) Integer planId,
			@ApiParam(value = "indicates if this request should return DemandSupply details of the plan") @Valid @RequestParam(value = "includeDemandSupply", required = false) Boolean includeDemandSupply,
			@ApiParam(value = "indicates if this request should return exclussion details of the plan") @Valid @RequestParam(value = "includeExclussions", required = false) Boolean includeExclussions,
			@ApiParam(value = "status of plan") @Valid @RequestParam(value = "status", required = false) String status);

	/**
	 * Gets the plans.
	 *
	 * @param page
	 *            the page
	 * @param count
	 *            the count
	 * @param sortOrder
	 *            the sort order
	 * @param sortByField
	 *            the sort by field
	 * @return PlanSummaryWithPagination
	 */
	@ApiOperation(value = "returns a list of snapshot plans", nickname = "getPlansList", notes = " This endpoint returns a list snapshot plans <br/> This endpoint calls the following external endpoint:          | Call Type |   Endpoint                        | Service                       |     | -------   | --------                          |--------                       |     |      |                     |  | ", response = PlanSummaryWithPagination.class, tags = {
			"Plan", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PlanSummaryWithPagination.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/plans/list", produces = { "application/json" },  method = RequestMethod.GET)
	ResponseEntity<PlanSummaryWithPagination> getPlansList(
			@NotNull @ApiParam(value = "Page number, default value is 1", required = true) @Valid @RequestParam(value = "page", required = true) Integer page,
			@NotNull @ApiParam(value = "Number of rows per page, default value is 20", required = true) @Valid @RequestParam(value = "count", required = true) Long count,
			@ApiParam(value = "Sorting order ASC or DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
			@ApiParam(value = "Sort the results by field name") @Valid @RequestParam(value = "sortByField", required = false) String sortByField);

	/**
	 * Gets the snapshot.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return SnapshotPlanDetail
	 */
	@ApiOperation(value = "returns a snapshot", nickname = "getSnapshot", notes = "This endpoint returns a snapshot based on query parameters ", response = SnapshotDetail.class, responseContainer = "List", tags = {
			"snapshot", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Queued camgen requests details which are valid for execution at the moment", response = SnapshotDetail.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/snapshots", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SnapshotDetail>> getSnapshot(
			@NotNull @ApiParam(value = "The id of the snapshot to retrieve", required = true) @Valid @RequestParam(value = "snapshotId", required = true) Integer snapshotId,
			@ApiParam(value = "scheduled date of a camgen request") @Valid @RequestParam(value = "scheduledDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate scheduledDate,
			@ApiParam(value = "look for queued camgen requests scheduled for a time > scheduledStartTime") @Valid @RequestParam(value = "scheduledStartTime", required = false)  String scheduledStartTime,
			@ApiParam(value = "look for queued camgen requests scheduled for a time <= scheduledEndTime") @Valid @RequestParam(value = "scheduledEndTime", required = false) String scheduledEndTime,
			@ApiParam(value = "status of plan") @Valid @RequestParam(value = "status", required = false) String status);

	/**
	 * Update camgen param extracts.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "Updates camgen global Extract parameters", notes = " This endpoint updates camgen global Extract paramters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/extracts", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenParamExtracts(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamExtracts body);

	/**
	 * Update camgen param station EI time bands.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "Updates camgen global parameters Station EI Time bands", notes = " This endpoint updates camgen global paramters Station EI Time bands ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/paramStationEITimeBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenParamStationEITimeBands(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParamStationEITimeBands body);

	/**
	 * Update camgen param station time bands.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "updates global parameters for Time Bands", notes = " This endpoint creates a set of camgen global paramters for Station Time Bands ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/stationTimeBands", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenParamStationTimeBands(
			@ApiParam(value = "Camgen Parameters for Station Time Bands", required = true) @Valid @RequestBody CamgenParamStationTimeBands body);

	/**
	 * Update camgen parameter aud group channels.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new set of camgen global parameters", notes = " This endpoint updates camgen global Audience Group Channel parameters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/audienceGroupChannels", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenParameterAudGroupChannels(
			@ApiParam(value = "Camgen Parameters for Audience Group Channels", required = true) @Valid @RequestBody CamgenParamAudGroupChannels body);

	/**
	 * Update camgen parameters.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "update camgen global parameters", notes = " This endpoint updates camgen global paramters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameters", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenParameters(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenParameters body);

	/**
	 * Update global parameters.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "Updates the global parameters", notes = " Updates Camgen global parameters ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Parameters updated successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameter/global", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateGlobalParameters(
			@ApiParam(value = "Camgen parameters to update", required = true) @Valid @RequestBody CamgenGlobalParametersRequest body);

	/**
	 * Update plans.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "updates a snapshot plans", notes = " This endpoint updates snapshot plans <br/> This endpoint calls the following external endpoint:          | Call Type |   Endpoint                        | Service                       |     | -------   | --------                          |--------                       |     |       |                   |  | ", response = Void.class, tags = {
			"Plan", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/plans", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updatePlans(@ApiParam(value = "") @Valid @RequestBody PlansObject body);

	@ApiOperation(value = "returns a list of Exclusion Categories", nickname = "getCamgenPlanExclusionCategiries", notes = "this endpoint returns a list of Exclusion Categories", response = ExclusionCategories.class, tags = {
			"Plan", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ExclusionCategories.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
			@ApiResponse(code = 200, message = "Error", response = Error.class) })
	@RequestMapping(value = "/camgen/plans/exclusionCategories", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<ExclusionCategories> getCamgenPlanExclusionCategiries();

	/**
	 * Update snapshots.
	 *
	 * @param snapshots
	 *            the snapshots
	 * @return Void
	 */
	@ApiOperation(value = "Update snapshots based on their ID", notes = " This endpoint returns a list of all snapshots stored in the database ", response = Void.class, tags = {
			"snapshot", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Snapshot {id} updated successfully", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/snapshots", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateSnapshots(@ApiParam(value = "") @Valid @RequestBody SnapshotDetail snapshots);

	/**
	 * Gets the camgen run param channel set timebands.
	 *
	 * @param snapshotId
	 *            the snapshot id
	 * @return ChannelSetTimeBands
	 */
	@ApiOperation(value = "retrieve a list of camgen Channel Set Timebands parameters", notes = " This endpoint gets a list of camgen Channel set Timebands parameters ", response = ChannelSetTimeBands.class, tags = {
			"snapshot", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success.", response = ChannelSetTimeBands.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/snapshot/parameters/channelSetTimebands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<ChannelSetTimeBands> getCamgenRunParamChannelSetTimebands(
	@ApiParam(value = "snapshotId") @Valid @RequestParam(value = "snapshotId", required = false) Integer snapshotId);

	/**
	 * Update camgen snapshot run details.
	 *
	 * @param body
	 *            the body
	 * @return Void
	 */
	@ApiOperation(value = "ceates new camgen snapshot run details", notes = " This endpoint creates new snapshot run details <br />     This endpoint calls the following external endpoint:              | Call Type |   Endpoint                                  | Service                       |         | -------   | --------                                    |--------                       |         | PUT       | /camgen/snapshot/run                        | Automated Spot Domain Service | ", response = Void.class, tags = {
			"Camgen Snapshot Run", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Could not find records", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/snapshot/runs", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> updateCamgenSnapshotRunDetails(
			@ApiParam(value = "", required = true) @Valid @RequestBody CamgenSnapshotRunDetails body);

	/**
	 * Gets the camgen param channel set timebands.
	 *
	 * @param channelSetID
	 *            the channel set ID
	 * @return ChannelSetTimeBandResponse
	 */
	@ApiOperation(value = "retrieve a list of camgen Channel Set Timebands parameters", notes = " This endpoint gets a list of camgen Channel set Timebands parameters <br />     This endpoint calls the following external endpoint:              | Call Type |   Endpoint                                  | Service                       |         | -------   | --------                                    |--------                       |         |        |   |  | ", response = ChannelSetTimeBandResponse.class, responseContainer = "List", tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ChannelSetTimeBandResponse.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameters/channelSet/{channelSetID}/timebands", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<ChannelSetTimeBandResponse>> getCamgenParamChannelSetTimebands(
			@ApiParam(value = "The channel set ID for which to retrieve the time bands for", required = true) @PathVariable("channelSetID") Integer channelSetID);

	/**
	 * Creates the camgen param channel set timebands.
	 *
	 * @param body
	 *            the body
	 * @return void
	 */
	@ApiOperation(value = "creates camgen Channel Set Timebands parameters", notes = " This endpoint creates camgen Channel set Time bands parameters <br />     This endpoint calls the following external endpoint:              | Call Type |   Endpoint                                  | Service                       |         | -------   | --------                                    |--------                       |         |       |   |  | ", response = Void.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Void.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })

	@RequestMapping(value = "/camgen/parameters/timebands/bulkamend", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> createCamgenParamChannelSetTimebands(
			@ApiParam(value = "", required = true) @Valid @RequestBody List<ChannelSetTimebandsBulkRequest> body);

	/**
	 * Method to get a list of conditions applicable for the selected Demand
	 * Supply Level Object Attribute.
	 * 
	 * @param attributeId
	 *            attribute Id
	 * @return DemandSupplyObjectAttributeConditions
	 */
	@ApiOperation(value = "Retrieves a list of conditions applicable for the selected Demand Supply Level Object Attribute", nickname = "getDemandSupplyLevelObjectAttributeConditions", notes = " Retrieves a list of conditions applicable for the selected Demand Supply Level Object Attribute ", response = DemandSupplyObjectAttributeConditions.class, responseContainer = "List", tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = DemandSupplyObjectAttributeConditions.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/camgen/parameters/demandSupply/levels/objects/attributes/{attributeId}/conditions", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<DemandSupplyObjectAttributeConditions> getDemandSupplyLevelObjectAttributeConditions(
			@ApiParam(value = "The id of the demand supply level object attribute to retrieve applicable conditions", required = true) @PathVariable("attributeId") Integer attributeId);

	/**
	 * Method to get a list of attributes corresponds to a demand supply level
	 * object.
	 * 
	 * @param objectId
	 *            object Id
	 * @return DemandSupplyObjectAttributes
	 */
	@ApiOperation(value = "Retrieves a list of attributes corresponds to a demand supply level object", nickname = "getDemandSupplyLevelObjectAttributes", notes = " Retrieves a list of attributes corresponds to a demand supply level object ", response = DemandSupplyObjectAttributes.class, responseContainer = "List", tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = DemandSupplyObjectAttributes.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/camgen/parameters/demandSupply/levels/objects/{objectId}/attributes", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<DemandSupplyObjectAttributes> getDemandSupplyLevelObjectAttributes(
			@ApiParam(value = "The id of the demand supply level Object to retrieve its attributes", required = true) @PathVariable("objectId") Integer objectId);

	/**
	 * Method to get a list of objects corresponds to a demand supply level.
	 * 
	 * @param levelId
	 *            level Id
	 * @return DemandSupplyLevelObjects
	 */
	@ApiOperation(value = "Retrieves a list of objects corresponds to a demand supply level", nickname = "getDemandSupplyLevelObjects", notes = " Retrieves a list of objects corresponds to a demand supply level ", response = DemandSupplyLevelObjects.class, responseContainer = "List", tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = DemandSupplyLevelObjects.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/camgen/parameters/demandSupply/levels/{levelId}/objects", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<DemandSupplyLevelObjects> getDemandSupplyLevelObjects(
			@ApiParam(value = "The id of the demand supply level to retrieve objects", required = true) @PathVariable("levelId") Integer levelId);

	/**
	 * Method to get the list of levels for demand Supply setup.
	 * 
	 * @return DemandSupplyLevels
	 */
	@ApiOperation(value = "Gets the list of levels for demand Supply setup", nickname = "getDemandSupplyLevels", notes = "This endpoint retrieves the list of demand supply levels ", response = DemandSupplyLevels.class, tags = {
			"Camgen Global Parameters", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DemandSupplyLevels.class),
			@ApiResponse(code = 404, message = "Resource not available", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@RequestMapping(value = "/camgen/parameters/demandSupply/levels", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<DemandSupplyLevels> getDemandSupplyLevels();
	
	@ApiOperation(value = "Bulk Cancel Camgen Requests", nickname = "bulkCancelCamgenRequests", notes = "This endpoint bulk cancels camgen requests ", response = Field.class, tags={ "Snapshot (Camgen Request)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Camgen Requests cancelled successfully.", response = Field.class),
        @ApiResponse(code = 404, message = "Resource not available", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
        @ApiResponse(code = 200, message = "Error", response = Error.class) })
    @RequestMapping(value = "/camgen/snapshots/bulkCancel",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<List<Field>> bulkCancelCamgenRequests(@ApiParam(value = ""  )  @Valid @RequestBody List<Snapshots> snapshots);
	
	@ApiOperation(value = "Bulk ReInstate Camgen Requests", nickname = "bulkReInstateCamgenRequests", notes = "This endpoint bulk ReInstate camgen requests ", response = Field.class, tags={ "Snapshot (Camgen Request)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Camgen Requests Re-Instated successfully.", response = Field.class),
        @ApiResponse(code = 404, message = "Resource not available", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class),
        @ApiResponse(code = 200, message = "Error", response = Error.class) })
    @RequestMapping(value = "/camgen/snapshots/bulkReInstate",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<List<Field>> bulkReInstateCamgenRequests(@ApiParam(value = ""  )  @Valid @RequestBody List<Snapshots> snapshots);
}
