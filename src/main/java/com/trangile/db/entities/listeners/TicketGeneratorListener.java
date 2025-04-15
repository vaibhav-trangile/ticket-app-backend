package com.trangile.db.entities.listeners;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trangile.db.entities.incident.Tickets;
import com.trangile.db.repo.incident.TicketRepo;

import jakarta.persistence.PrePersist;

@Component
public class TicketGeneratorListener {

    private static TicketRepo ticketRepository;
    
    @Autowired
    public void setRepository(TicketRepo repo) {
    	ticketRepository = repo;
    }

    

    @PrePersist
    public void generateId(Tickets ticket) {
    	LocalDate today = LocalDate.now();
        int year = today.getYear();
        String month = today.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        // Get count of records for the current year
        int count = ticketRepository.getYearlyRecordCount(year) + 1;
        String countStr = String.format("%06d", count); // Ensure 6-digit format (000001)\
        // Generate ID
        String generatedId = String.format("TSPL-%d-%s-%s", year, month, countStr);
        ticket.setTicketId(generatedId);
    }
}
