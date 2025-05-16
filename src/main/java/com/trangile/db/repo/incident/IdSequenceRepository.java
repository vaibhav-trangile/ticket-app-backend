package com.trangile.db.repo.incident;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trangile.db.entities.incident.IdSequence;

public interface IdSequenceRepository extends JpaRepository<IdSequence, String> {

}
