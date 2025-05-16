package com.trangile.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface AppConstants {
	String CORS_URI = "http://localhost:4000";
	String BASE_URI = "/trangile/api/support/v1";
	String API_URI = "/incidents";
	String DASHBORAD_URI = "/dashboard";
	String BACKEND_API_URI = "/custservice";
	String CREATE_INCIDENT_URI = "/create";
	String GET_INCIDENT_URI = "/incident";
	String ALL_INCIDENT_URI = "/all";
	String ALL_NEW_INCIDENT_URI = "/new";
	String ALL_PENDING_INCIDENT_URI = "/pending";
	String ALL_RESOLVED_INCIDENT_URI = "/resolved";
	String ALL_CLOSED_INCIDENT_URI = "/closed";
	String ROLE_STRING = "ROLE_";
	String ASSIGNEE_URI = "assign";
	String RESPONSE_MESSAGE = "Data retrieved successfully.";
	String EVENT_URI = "/events";
	Long EXPIRATION_TIME = 1800000L;
	String INCIDENT_ASSIGN_EVENT = "Incident Assigned.";
	String INCIDENT_CREATE_EVENT = "Incident Reported.";
	String INCIDENT_CLOSE_EVENT = "Incident Closed.";
	String INCIDENT_RESOLVE_EVENT = "Incident Resolved.";
	String INCIDENT_UPDATE_EVENT = "Incident Updated.";
	
	public static String getMonYear(LocalDateTime now) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");
	        // Format the date
	        String formattedDate = now.format(formatter);
	        // Print the result (e.g., "MAR-2025")
	        System.out.println(formattedDate);
	        // For uppercase month abbreviation
	        formatter = DateTimeFormatter.ofPattern("MMM-yyyy").withLocale(java.util.Locale.ENGLISH);
	        formattedDate = now.format(formatter).toUpperCase();
	        return formattedDate;
	}
	
	public static String getEventTitle(String status, String title) {
		if (status.equals("0") && title.isEmpty())
			return INCIDENT_CREATE_EVENT;
		if (status.equals("5") && title.isEmpty())
			return INCIDENT_ASSIGN_EVENT;
		if (status.equals("8") && title.isEmpty())
			return INCIDENT_RESOLVE_EVENT;
		if (status.equals("9") && title.isEmpty())
			return INCIDENT_CLOSE_EVENT;
		else
			return INCIDENT_UPDATE_EVENT;
		
	}
}