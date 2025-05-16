package com.trangile.db.entities.incident;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class IdSequence {
	
	@Id
    private String year;

    private int sequence;

	public IdSequence() {
		
	}

	public IdSequence(String year, int sequence) {
		this.year = year;
		this.sequence = sequence;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sequence, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdSequence other = (IdSequence) obj;
		return sequence == other.sequence && Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "IdSequence [year=" + year + ", sequence=" + sequence + "]";
	}
}
