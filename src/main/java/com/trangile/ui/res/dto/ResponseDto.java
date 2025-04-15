package com.trangile.ui.res.dto;

import java.util.List;
import java.util.Objects;

public class ResponseDto {
	
	List<Attachment> attachmentList;

	public ResponseDto() {
		
	}

	public ResponseDto(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachmentList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		return Objects.equals(attachmentList, other.attachmentList);
	}

	@Override
	public String toString() {
		return "ResponseDto [attachmentList=" + attachmentList + "]";
	}
}
