package com.trangile.ui.res.dto;

import java.util.Objects;

public class TicketDashboardResponse {
	
	private Long totalCount;
	private Long newCount;
	private Long pendingCount;
	private Long ClosedCount;
	
	
	public TicketDashboardResponse() {
	
	}


	public TicketDashboardResponse(Long totalCount, Long newCount, Long pendingCount, Long ClosedCount) {
		this.totalCount = totalCount;
		this.newCount = newCount;
		this.pendingCount = pendingCount;
		this.ClosedCount = ClosedCount;
	}


	public Long getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}


	public Long getNewCount() {
		return newCount;
	}


	public void setNewCount(Long newCount) {
		this.newCount = newCount;
	}


	public Long getPendingCount() {
		return pendingCount;
	}


	public void setPendingCount(Long pendingCount) {
		this.pendingCount = pendingCount;
	}


	public Long getClosedCount() {
		return ClosedCount;
	}


	public void setClosedCount(Long closedCount) {
		ClosedCount = closedCount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ClosedCount, newCount, pendingCount, totalCount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketDashboardResponse other = (TicketDashboardResponse) obj;
		return Objects.equals(ClosedCount, other.ClosedCount) && Objects.equals(newCount, other.newCount)
				&& Objects.equals(pendingCount, other.pendingCount) && Objects.equals(totalCount, other.totalCount);
	}


	@Override
	public String toString() {
		return "TicketDashboardResponse [totalCount=" + totalCount + ", newCount=" + newCount + ", pendingCount="
				+ pendingCount + ", ClosedCount=" + ClosedCount + "]";
	}
}
