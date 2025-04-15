package com.trangile.ui.res.dto;

import java.util.Objects;

public class Attachment {
	
	private String fileName;
	private String fileUrl;
	
	public Attachment() {
		
	}

	public Attachment(String fileName, String fileUrl) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileName, fileUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attachment other = (Attachment) obj;
		return Objects.equals(fileName, other.fileName) && Objects.equals(fileUrl, other.fileUrl);
	}

	@Override
	public String toString() {
		return "Attachment [fileName=" + fileName + ", fileUrl=" + fileUrl + "]";
	}
}
