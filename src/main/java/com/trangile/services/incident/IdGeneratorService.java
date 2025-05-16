package com.trangile.services.incident;


import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trangile.db.entities.incident.IdSequence;
import com.trangile.db.repo.incident.IdSequenceRepository;

@Service
public class IdGeneratorService {

    @Autowired
    private IdSequenceRepository sequenceRepository;

    @Transactional
    public String generateId() {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear());
        String monthName = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., May
        
        // Fetch or initialize sequence
        IdSequence idSeq = sequenceRepository.findById(year).orElse(new IdSequence(year, 0));
        int newSeq = idSeq.getSequence() + 1;

        idSeq.setSequence(newSeq);
        sequenceRepository.save(idSeq);

        // Format: TSPL-2025-May-000001
        return String.format("TSPL-%s-%s-%06d", year, monthName, newSeq);
    }
}
