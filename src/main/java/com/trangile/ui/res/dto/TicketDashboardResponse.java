package com.trangile.ui.res.dto;

import java.util.Objects;

public class TicketDashboardResponse {
	
	private Long totalCount;
	private Long newCount;
	private Long pendingCount;
	private Long resolvedCount;
	private Long closedCount;
		
	public TicketDashboardResponse() {
	
	}

	public TicketDashboardResponse(Long totalCount, Long newCount, Long pendingCount, Long resolvedCount,
			Long closedCount) {
		this.totalCount = totalCount;
		this.newCount = newCount;
		this.pendingCount = pendingCount;
		this.resolvedCount = resolvedCount;
		this.closedCount = closedCount;
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

	public Long getResolvedCount() {
		return resolvedCount;
	}

	public void setResolvedCount(Long resolvedCount) {
		this.resolvedCount = resolvedCount;
	}

	public Long getClosedCount() {
		return closedCount;
	}

	public void setClosedCount(Long closedCount) {
		this.closedCount = closedCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(closedCount, newCount, pendingCount, resolvedCount, totalCount);
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
		return Objects.equals(closedCount, other.closedCount) && Objects.equals(newCount, other.newCount)
				&& Objects.equals(pendingCount, other.pendingCount)
				&& Objects.equals(resolvedCount, other.resolvedCount) && Objects.equals(totalCount, other.totalCount);
	}

	@Override
	public String toString() {
		return "TicketDashboardResponse [totalCount=" + totalCount + ", newCount=" + newCount + ", pendingCount="
				+ pendingCount + ", resolvedCount=" + resolvedCount + ", closedCount=" + closedCount + "]";
	}
}
