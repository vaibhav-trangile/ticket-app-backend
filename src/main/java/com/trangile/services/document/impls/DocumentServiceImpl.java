package com.trangile.services.document.impls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trangile.db.entities.documents.IncidentAttachment;
import com.trangile.db.repo.documents.DocumentRepo;
import com.trangile.services.document.DocumentService;
import com.trangile.services.document.GoogleDriveService;
import com.trangile.ui.req.dto.RequestDto;
import com.trangile.ui.res.dto.Attachment;
import com.trangile.ui.res.dto.ResponseDto;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	private GoogleDriveService gService;
	
	@Autowired
	private DocumentRepo repo;
	

	@Override
	public ResponseDto uploadFileToDrive(List<MultipartFile> files, RequestDto dto) {
		List<IncidentAttachment> attachementList = files.stream().map(file -> {
			IncidentAttachment ta = new IncidentAttachment();
			BeanUtils.copyProperties(dto, ta);
			ta.setFileName(file.getOriginalFilename());
			ta.setContentType(file.getContentType());
			ta.setCustomer(dto.getCustomer());
			ta.setFileSize(String.valueOf(file.getSize()));
			ta.setFileUrl(uploadFileToDrive(file, dto));
			IncidentAttachment updatedAttchments = repo.save(ta);
			return updatedAttchments;
		}).collect(Collectors.toList());
		return storeToDB(attachementList);
	}


	private ResponseDto storeToDB(List<IncidentAttachment> attachementList) {
		List<Attachment> atchmntList = new ArrayList<>();
		for (IncidentAttachment ticketAttachments : attachementList) {
			Attachment atchmnt = new Attachment();
			BeanUtils.copyProperties(ticketAttachments, atchmnt);
			atchmntList.add(atchmnt);
		}
		ResponseDto dto = new ResponseDto(); 
		dto.setAttachmentList(atchmntList);
		return dto;
	}


	private String uploadFileToDrive(MultipartFile file, RequestDto dto) {
		try {
			return gService.uploadFile(file, dto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}


	@Override
	public List<Attachment> getAttachments(Long eventId, String ticketId) {
		List<IncidentAttachment> allAttachments = repo.findAllAttachments(eventId, ticketId);
		return allAttachments.stream().map(attachments -> {
			Attachment attachment = new Attachment();
			BeanUtils.copyProperties(attachments, attachment);
			return attachment;
		}).collect(Collectors.toList());
	}

}
