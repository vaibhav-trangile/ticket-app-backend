package com.trangile.ui.res.dto;

import java.util.List;
import java.util.Objects;

public class Ticket_Event_Res_Dto {
	
	private String status;
	List<Event> events;
	
	
	public Ticket_Event_Res_Dto() {
		// TODO Auto-generated constructor stub
	}


	public Ticket_Event_Res_Dto(String status, List<Event> events) {
		this.status = status;
		this.events = events;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	@Override
	public int hashCode() {
		return Objects.hash(events, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket_Event_Res_Dto other = (Ticket_Event_Res_Dto) obj;
		return Objects.equals(events, other.events) && Objects.equals(status, other.status);
	}


	@Override
	public String toString() {
		return "Ticket_Event_Res_Dto [status=" + status + ", events=" + events + "]";
	}
}
