package com.trangile.services.event;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.trangile.ui.req.dto.Ticket_Event_Req_Dto;
import com.trangile.ui.res.dto.Ticket_Event_Res_Dto;

public interface EventService {

	Optional<Ticket_Event_Res_Dto> saveEvents(Ticket_Event_Req_Dto dto, List<MultipartFile> files);

	Optional<Ticket_Event_Res_Dto> getAllEvents(String ticketId);
	
	

}
