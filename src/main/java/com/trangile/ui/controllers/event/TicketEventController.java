package com.trangile.ui.controllers.event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trangile.services.event.EventService;
import com.trangile.ui.req.dto.Ticket_Event_Req_Dto;
import com.trangile.ui.res.dto.ApiResponse;
import com.trangile.ui.res.dto.Ticket_Event_Res_Dto;
import com.trangile.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BASE_URI + AppConstants.API_URI + AppConstants.EVENT_URI)
@CrossOrigin(origins = "http://localhost:4000")
public class TicketEventController {
	
	@Autowired
	private EventService eventService;
	
	
	@PostMapping(AppConstants.CREATE_INCIDENT_URI)
	public ResponseEntity<ApiResponse<Object>> saveEventData(@RequestPart(value = "files", required = false) List <MultipartFile> files,
    		@RequestPart(value = "event", required = false) @JsonProperty("event") Ticket_Event_Req_Dto req) {
		System.out.println("Calling saveEventData() recieved at: "+ LocalDateTime.now()+"\nData: " +req);
		Optional<Ticket_Event_Res_Dto> createdEvent= eventService.saveEvents(req, files);
		 if(createdEvent.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK.value(), true, LocalDateTime.now(), "Data retrieved successfully", createdEvent.get(), null);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}

	
	@GetMapping("/{ticketId}")
	public ResponseEntity<ApiResponse<Object>> getEvents(@PathVariable String ticketId) {
		Optional<Ticket_Event_Res_Dto> event= eventService.getAllEvents(ticketId);
		 if(event.isPresent()) {
			 ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK.value(), true, LocalDateTime.now(),"Data retrieved successfully", event.get(), null);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		 }
		 return new ResponseEntity<>(null, HttpStatus. BAD_REQUEST);
	}

	

}
