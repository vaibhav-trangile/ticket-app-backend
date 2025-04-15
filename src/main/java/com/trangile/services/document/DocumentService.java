package com.trangile.services.document;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.trangile.ui.req.dto.RequestDto;
import com.trangile.ui.res.dto.Attachment;
import com.trangile.ui.res.dto.ResponseDto;

public interface DocumentService {
	
	ResponseDto uploadFileToDrive(List<MultipartFile> files, RequestDto dto);
	
	List<Attachment> getAttachments(Long eventId, String ticketId);

}
