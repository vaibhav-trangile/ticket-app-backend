package com.trangile.db.repo.documents;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trangile.db.entities.documents.IncidentAttachment;

public interface DocumentRepo extends JpaRepository<IncidentAttachment, Serializable> {
	
	@Query("SELECT ta FROM IncidentAttachment ta WHERE ta.eventId = :eventId AND ta.ticketId = :ticketId")
	List<IncidentAttachment> findAllAttachments(@Param("eventId") Long eventId, @Param("ticketId") String ticketId);


}
