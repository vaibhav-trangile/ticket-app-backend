package com.trangile.ui.controller.incident;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trangile.db.entities.incident.Tickets;
import com.trangile.services.incident.TicketService;
import com.trangile.ui.req.dto.TicketRequest;
import com.trangile.ui.req.dto.TicketStatusChangeDto;
import com.trangile.ui.res.dto.ApiResponse;
import com.trangile.ui.res.dto.TicketDashboardResponse;
import com.trangile.ui.res.dto.TicketResponse;
import com.trangile.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BASE_URI + AppConstants.API_URI)
@CrossOrigin(origins = "http://localhost:4000")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(AppConstants.DASHBORAD_URI)
	public ResponseEntity<ApiResponse<Object>> getDashboardData(@RequestParam(name = "project", required = false) String project) {
		Optional<TicketDashboardResponse> ticket= ticketService.getDashboardData(project);
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK.value(), true, "Data retrieved successfully", ticket.get(), null);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@PutMapping(AppConstants.ASSIGNEE_URI + "/{id}")
	public ResponseEntity<ApiResponse<Object>> updateTicketData(@RequestParam(name = "project", required = false) String project, @RequestBody TicketStatusChangeDto dto) {
		System.out.println("Calling updateTicketData() recieved at: "+ LocalDateTime.now()+"\nData: " +dto);
		Optional<TicketResponse> ticket= ticketService.update(dto);
		 if(ticket.isPresent()) {
			 ApiResponse< Object> response = new ApiResponse<>();
			 response.setData(ticket.get());
			 return new ResponseEntity<>(response, HttpStatus.CREATED);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	
	
	@PostMapping(value = AppConstants.CREATE_INCIDENT_URI, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ApiResponse<Object>> createIncident(@RequestPart(value = "files", required = false) List <MultipartFile> files,
    		@RequestPart(value = "ticket", required = false) @JsonProperty("ticket") TicketRequest req) {
//		System.out.println(req);
		System.out.println("CreateIncident() recieved  at: "+ LocalDateTime.now()+"\nData: " +req);
		Optional<Tickets> ticket= ticketService.save(req, files);
		 if(ticket.isPresent()) {
			 ApiResponse< Object> response = new ApiResponse<>();
			 response.setData(ticket.get());
			 return new ResponseEntity<>(response, HttpStatus.CREATED);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@GetMapping(AppConstants.GET_INCIDENT_URI + "/{id}")
	public ResponseEntity<ApiResponse<Object>> getIncident(@PathVariable ("id") String ticketId) {
		System.out.println("Inside getIncident with :: " + ticketId);
		Optional<TicketResponse> ticket= ticketService.get(ticketId);
		 if(ticket.isPresent()) {
			 ApiResponse< Object> response = new ApiResponse<>();
			 response.setData(ticket.get());
			 return new ResponseEntity<>(response, HttpStatus.CREATED);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	
	@GetMapping(AppConstants.ALL_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> getAllIncidents(@RequestParam(name = "project", required = false) String project) {
		Optional<List <Tickets>> ticket= ticketService.getTickets(project);
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<Object>();
			 response.setData(ticket);
			 return new ResponseEntity<ApiResponse<Object>> (response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@GetMapping(AppConstants.ALL_NEW_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> getAllNewIncidents(@RequestParam(name = "project", required = false) String project) {
		Optional<List <Tickets>> ticket= ticketService.getTicketsWithParameter(project, "0");
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<Object>();
			 response.setData(ticket);
			 return new ResponseEntity<ApiResponse<Object>> (response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@GetMapping(AppConstants.ALL_PENDING_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> getAllPendingIncidents(@RequestParam(name = "project", required = false) String project) {
//		Optional<List <Tickets>> ticket= ticketService.getPendingTickets(project);
		Optional<List <Tickets>> ticket= ticketService.getTicketsWithParameter(project, "5");
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<Object>();
			 response.setData(ticket);
			 return new ResponseEntity<ApiResponse<Object>> (response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@GetMapping(AppConstants.ALL_RESOLVED_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> getAllResolvedIncidents(@RequestParam(name = "project", required = false) String project) {
//		Optional<List <Tickets>> ticket= ticketService.getPendingTickets(project);
		Optional<List <Tickets>> ticket= ticketService.getTicketsWithParameter(project, "8");
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<Object>();
			 response.setData(ticket);
			 return new ResponseEntity<ApiResponse<Object>> (response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}
	
	@GetMapping(AppConstants.ALL_CLOSED_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> getAllClosedIncidents(@RequestParam(name = "project", required = false) String project) {
//		Optional<List <Tickets>> ticket= ticketService.getClosedTickets(project);
		Optional<List <Tickets>> ticket= ticketService.getTicketsWithParameter(project, "9");
		 if(ticket.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<Object>();
			 response.setData(ticket);
			 return new ResponseEntity<ApiResponse<Object>> (response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}

}
