package com.trangile.services.incident.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trangile.db.entities.incident.Tickets;
import com.trangile.db.repo.incident.TicketRepo;
import com.trangile.services.event.EventService;
import com.trangile.services.incident.TicketService;
import com.trangile.ui.req.dto.TicketRequest;
import com.trangile.ui.req.dto.TicketStatusChangeDto;
import com.trangile.ui.req.dto.Ticket_Event_Req_Dto;
import com.trangile.ui.res.dto.TicketDashboardResponse;
import com.trangile.ui.res.dto.TicketResponse;
import com.trangile.ui.res.dto.Ticket_Event_Res_Dto;
import com.trangile.util.AppConstants;


@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private EventService eventService;

	@Override
	public Optional<TicketDashboardResponse> getDashboardData(String project) {
		TicketDashboardResponse trd;
		if (project != null && !project.isEmpty()) {
			long totalCount = ticketRepo.countByProject(project);
            long newCount = ticketRepo.countByProjectAndStatus(project, "0");
            long pendingCount = ticketRepo.countByProjectAndStatusIn(project, new String[]{"5", "7"});
            long closedCount = ticketRepo.countByProjectAndStatus(project, "9");
            trd = new TicketDashboardResponse(totalCount, newCount, pendingCount, closedCount);
		} else {
			long totalCount = ticketRepo.count();
            long newCount = ticketRepo.countByStatus("0");
            long pendingCount = ticketRepo.countByStatusIn(new String[]{"5", "7"});
            long closedCount = ticketRepo.countByStatus("9");
            trd = new TicketDashboardResponse(totalCount, newCount, pendingCount, closedCount);
		}
		return Optional.ofNullable(trd);
	}

	@Override
	public Optional<Tickets> save(TicketRequest req, List<MultipartFile> files) {
		Tickets ticket = new Tickets();
		BeanUtils.copyProperties(req, ticket);
		ticket.setStatus(String.valueOf(req.getStatus()));
		LocalDateTime ticketDate = LocalDateTime.now();
		ticket.setIssueRaisedOn(ticketDate);
		ticket.setMonthYear(AppConstants.getMonYear(ticketDate));
		Tickets savedTicket = ticketRepo.save(ticket);
		generateEvent(getEventRequest(savedTicket, ""), files);
		return Optional.ofNullable(savedTicket);
	}
	

	private Ticket_Event_Req_Dto getEventRequest(Tickets savedTicket, String title) {
		System.out.println("Inside: getEventRequest() at " + LocalDateTime.now() +"\n with Data: " + savedTicket +"\n With Title: " + title);
		Ticket_Event_Req_Dto eventReqDto = new Ticket_Event_Req_Dto();
		eventReqDto.setTicketId(savedTicket.getTicketId());
		eventReqDto.setEventTitle(title);
		eventReqDto.setShortDescription(savedTicket.getSummary());
		eventReqDto.setLongDescription(getLongDesc(savedTicket));
		eventReqDto.setAssignedTo(savedTicket.getAssignedTo());
		eventReqDto.setStatus(savedTicket.getStatus());
//		We need to add file uploading function.
		eventReqDto.setCreatedBy(savedTicket.getCreatedBy());
		eventReqDto.setUpdatedBy(savedTicket.getUpdatedBy());
		return eventReqDto;
	}



	private String getLongDesc(Tickets savedTicket) {
		if ("8".equalsIgnoreCase(savedTicket.getStatus()) || "9".equalsIgnoreCase(savedTicket.getStatus())) {
			return savedTicket.getRemarks();
		}  
		return savedTicket.getDescription();
	}

	@Override
	public Optional<List <Tickets>> getTickets(String project) {
		List<Tickets> allTickets;
		if (project != null && !project.isEmpty()) {
			allTickets = ticketRepo.findByProjectOrderByCreatedOnDesc(project);
		} else {
			allTickets = ticketRepo.findAll();
		}
		if (allTickets.size() > 0) {
			return Optional.ofNullable(allTickets);
		}
		return Optional.empty();
	}

	
	@Override
	public Optional<List<Tickets>> getNewTickets(String project) {
		List<Tickets> newTickets;
		if(project != null && !project.isEmpty()) {
			newTickets = ticketRepo.findByProjectAndStatusOrderByCreatedOnDesc(project, "0");
		} else {
			newTickets = ticketRepo.findByStatus("0");
		}
		if (newTickets.size() > 0) {
			return Optional.ofNullable(newTickets);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Tickets>> getPendingTickets(String project) {
		List<Tickets> pendingTickets;
		if(project != null && !project.isEmpty()) {
			pendingTickets = ticketRepo.findByProjectAndStatusInOrderByCreatedOnDesc(project, new String[] {"5", "7"});
		} else {
			pendingTickets = ticketRepo.findByStatusInOrderByCreatedOnDesc(new String[] {"5", "7"});
		}
		if (pendingTickets.size() > 0) {
			return Optional.ofNullable(pendingTickets);
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Tickets>> getClosedTickets(String project) {
		List<Tickets> closedTickets;
		if (project != null && !project.isEmpty()) {
			closedTickets = ticketRepo.findByProjectAndStatusOrderByCreatedOnDesc(project, "9");
		} else {
			closedTickets = ticketRepo.findByStatus("9");
		}
		if (closedTickets.size() > 0) {
			return Optional.ofNullable(closedTickets);
		}
		return Optional.empty();
	}

	@Override
	public Optional<TicketResponse> get(String ticketId) {
		Optional<Tickets> dbTicket = ticketRepo.findById(ticketId);
		if (dbTicket.isPresent()) {
			TicketResponse response = new TicketResponse();
			BeanUtils.copyProperties(dbTicket.get(), response);
			return Optional.ofNullable(response);
		}
		return Optional.empty();
	}

	@Override
	public Optional<TicketResponse> update(TicketStatusChangeDto dto) {
		Tickets newUpdateticket = getTicketEntity(dto);
//		newUpdateticket.setStatus(dto.getStatus());
		Tickets updatedTicket = ticketRepo.save(newUpdateticket);
		TicketResponse res = new TicketResponse();
		BeanUtils.copyProperties(updatedTicket, res);
		generateEvent(getEventRequest(updatedTicket, ""), null);  
		return Optional.ofNullable(res);
	}

	private Tickets getTicketEntity(TicketStatusChangeDto dto) {
		Tickets newUpdateticket = null;
//		BeanUtils.copyProperties(dto, newUpdateticket);
		Optional<Tickets> previousTicketOpt = ticketRepo.findById(dto.getTicketId());
		if (previousTicketOpt.isPresent()) {
			newUpdateticket = previousTicketOpt.get();
//			newUpdateticket.setStatus(dto.getStatus());
			if ("0".equals(newUpdateticket.getStatus()) && "5".equals(dto.getStatus())) {
				BeanUtils.copyProperties(dto, newUpdateticket);
//				newUpdateticket.setAssignedOn(dto.getAssignedOn());
				newUpdateticket.setAssignedTimeTakenInMin(getTimeDiffrenceInMins(newUpdateticket.getIssueRaisedOn()));
			}
			if ("5".equals(newUpdateticket.getStatus()) && "8".equals(dto.getStatus())) {
				BeanUtils.copyProperties(dto, newUpdateticket);
				newUpdateticket.setResolutionTimeTakenInMin(getTimeDiffrenceInMins(newUpdateticket.getIssueRaisedOn()));
			}
			if ("8".equals(newUpdateticket.getStatus()) && "9".equals(dto.getStatus())) {
				BeanUtils.copyProperties(dto, newUpdateticket);
				newUpdateticket.setResolutionTimeTakenInMin(getTimeDiffrenceInMins(newUpdateticket.getIssueRaisedOn()));
			}
		}
		return newUpdateticket;
	}

	private Long getTimeDiffrenceInMins(LocalDateTime issueRaisedOn) {
		LocalDateTime today = LocalDateTime.now();
		Duration d = Duration.between(issueRaisedOn, today);
		return d.toMinutes();
	}

	private Ticket_Event_Res_Dto generateEvent(Ticket_Event_Req_Dto dto, List<MultipartFile> files) {
		Optional<Ticket_Event_Res_Dto> saveEvents = eventService.saveEvents(dto, files);
		if (saveEvents.isPresent()) {
			 return saveEvents.get();
		}
		return null;
	}

	@Override
	public String getCustomer(String ticketId) {
		String customerOps = ticketRepo.getCustomer(ticketId);
		if(customerOps != null) {
			return customerOps;
		}
		return "";
	}
}
