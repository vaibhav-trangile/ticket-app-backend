package com.trangile.services.event.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trangile.db.entities.event.TicketEvents;
import com.trangile.db.repo.event.EventRepo;
import com.trangile.services.document.DocumentService;
import com.trangile.services.event.EventService;
import com.trangile.services.incident.TicketService;
import com.trangile.ui.req.dto.RequestDto;
import com.trangile.ui.req.dto.Ticket_Event_Req_Dto;
import com.trangile.ui.res.dto.Event;
import com.trangile.ui.res.dto.Ticket_Event_Res_Dto;
import com.trangile.util.AppConstants;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private DocumentService docService;
	
	@Autowired
	private TicketService tService;
	
	
	@Override
	public Optional<Ticket_Event_Res_Dto> saveEvents(Ticket_Event_Req_Dto dto, List<MultipartFile> files) {
		TicketEvents events = new TicketEvents();
		BeanUtils.copyProperties(dto, events);
		events.setEventTitle(AppConstants.getEventTitle(dto.getStatus(), dto.getEventTitle()));
		TicketEvents savedEvent = eventRepo.save(events);
		if (savedEvent.getEventId() != null) {
			saveAndUploadAttachments(files, savedEvent);
			return getAllEvents(savedEvent.getTicketId());
		}
		return Optional.empty();
	}

	private void saveAndUploadAttachments(List<MultipartFile> files, TicketEvents savedEvent) {
		if(files != null) {
			RequestDto requestDto = new RequestDto();
			requestDto.setTicketId(savedEvent.getTicketId());
			requestDto.setEventId(savedEvent.getEventId());
			requestDto.setCustomer(tService.getCustomer(savedEvent.getTicketId()));
			requestDto.setUploadedBy(savedEvent.getCreatedBy());
			docService.uploadFileToDrive(files, requestDto);
		}
	}

	@Override
	public Optional<Ticket_Event_Res_Dto> getAllEvents(String ticketId) {
		Ticket_Event_Res_Dto dto = new Ticket_Event_Res_Dto();
		dto.setStatus(String.valueOf(eventRepo.getMaxStatus(ticketId)));
		if (dto.getStatus() != null || dto.getStatus().isEmpty()) {
			dto.setEvents(getEventList(ticketId));
			return Optional.ofNullable(dto);
		}
		return Optional.empty();
	}

	private List<Event> getEventList(String ticketId) {
		List<TicketEvents> allByTicketId = eventRepo.findAllByTicketId(ticketId);
		List<Event> events = allByTicketId.stream().map(e -> {
			Event event = new Event();
			BeanUtils.copyProperties(e, event);
			event.setAttachments(docService.getAttachments(e.getEventId(), ticketId));
			return event;
		}).collect(Collectors.toList());
		return events;
	}

}
