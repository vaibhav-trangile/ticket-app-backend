package com.trangile.db.repo.incident;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trangile.db.entities.incident.Tickets;

public interface TicketRepo extends JpaRepository<Tickets, Serializable>{	
	
	
//    @Query("SELECT COUNT(e) FROM Tickets e WHERE e.createdOn = :today")
//    int getTodayRecordCount(LocalDate today);
    
//    @Query("SELECT COUNT(e) FROM Tickets e WHERE e.createdOn >= :startOfDay AND e.createdOn < :endOfDay")
//    int getTodayRecordCount(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);

    @Query("SELECT COUNT(t) FROM Tickets t WHERE YEAR(t.createdOn) = :year")
    int getYearlyRecordCount(@Param("year") int year);
    
    @Query("SELECT t FROM Tickets t WHERE t.status = :status")
	public List<Tickets> findAllByStatus(String status);
	
	List<Tickets> findByStatusInOrderByCreatedOnDesc(String[] statuses);
	List<Tickets> findByProjectOrderByCreatedOnDesc(String project);
	List<Tickets> findByProjectAndStatusOrderByCreatedOnDesc(String project, String status);
	List<Tickets> findByProjectAndStatusInOrderByCreatedOnDesc(String project, String[] statuses);
	
	
	long countByProject(String project);
    long countByProjectAndStatus(String project, String status);
    long countByProjectAndStatusIn(String project, String[] statuses);
    
    long count();
    long countByStatus(String status);
    long countByStatusIn(String[] statuses);

    @Query("SELECT t.project FROM Tickets t WHERE t.ticketId = :ticketId")
	String getCustomer(String ticketId);
	
    
}
