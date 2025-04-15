package com.trangile.db.repo.event;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trangile.db.entities.event.TicketEvents;

public interface EventRepo extends JpaRepository<TicketEvents, Serializable>{
	
	@Query("SELECT MAX(CAST(t.status AS integer)) FROM TicketEvents t WHERE t.ticketId = :ticketId")
	Long getMaxStatus(String ticketId);
	
	
	List<TicketEvents> findAllByTicketId(String ticketId);
	
//	@Query("SELECT te.fileName FROM TicketEvents te WHERE te.eventId = :eventId AND te.ticketId = :ticketId")
//	List<Attachment> findAllAttachments(@Param("eventId") Long eventId, @Param("ticketId") String ticketId);


	List<TicketEvents> findAllEventsByTicketId(String ticketId); 
	
}
