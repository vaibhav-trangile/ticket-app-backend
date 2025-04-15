package com.trangile.services.incident;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.trangile.db.entities.incident.Tickets;
import com.trangile.ui.req.dto.TicketRequest;
import com.trangile.ui.req.dto.TicketStatusChangeDto;
import com.trangile.ui.res.dto.TicketDashboardResponse;
import com.trangile.ui.res.dto.TicketResponse;

public interface TicketService {

	Optional<TicketDashboardResponse> getDashboardData(String project);

	Optional<Tickets> save(TicketRequest req, List<MultipartFile> files);

	Optional<List <Tickets>> getTickets(String project);

	Optional<List<Tickets>> getNewTickets(String project);

	Optional<List<Tickets>> getPendingTickets(String project);

	Optional<List<Tickets>> getClosedTickets(String project);

	Optional<TicketResponse> get(String ticketId);

	Optional<TicketResponse> update(TicketStatusChangeDto dto);
	
	String getCustomer(String ticketId);

}
