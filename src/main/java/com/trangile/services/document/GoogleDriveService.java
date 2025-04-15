package com.trangile.services.document;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.trangile.ui.req.dto.RequestDto;

@Service
public class GoogleDriveService {

    private final Drive driveService;

    @Value("${google.drive.folder.id:}")
    private String rootFolderId;
    
    @Value("${google.drive.uploadedfiles.root:}")
    private String uploadedFileRootFolder;

    public GoogleDriveService(@Value("${google.drive.credentials.path}") String credentialsPath)
            throws IOException, GeneralSecurityException {
        System.out.println("Looking for credentials at: " + credentialsPath);
        Resource resource = new ClassPathResource(credentialsPath.replace("classpath:", ""));
        if (!resource.exists()) {
            throw new FileNotFoundException("Google Drive credentials file NOT found: " + credentialsPath);
        }
        try (InputStream inputStream = resource.getInputStream()) {
            System.out.println("Google Drive credentials file loaded successfully.");
            ServiceAccountCredentials credentials = (ServiceAccountCredentials) ServiceAccountCredentials.fromStream(inputStream)
                    .createScoped(Collections.singletonList("https://www.googleapis.com/auth/drive"));

            this.driveService = new Drive.Builder(
                    new NetHttpTransport(),
                    JacksonFactory.getDefaultInstance(),
                    new HttpCredentialsAdapter(credentials)
            ).setApplicationName("GoogleDriveUploader").build();
        }
    }

    // ✅ UPLOAD FILE (Ensuring Nested Folder Exists)
    public String uploadFile(MultipartFile file, RequestDto req) throws IOException {
        // Ensure the nested folders exist
        String dateFolderId = getOrCreateNestedFolders(req);
        // File Metadata
        File fileMetadata = new File();
        fileMetadata.setName(file.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(dateFolderId));
        // Convert MultipartFile to java.io.File
        java.io.File tempFile = java.io.File.createTempFile("upload", file.getOriginalFilename());
        file.transferTo(tempFile);
        FileContent mediaContent = new FileContent(file.getContentType(), tempFile);
        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id, webViewLink")
                .execute();
        return uploadedFile.getWebViewLink(); // Returns the Google Drive file link
    }

    // ✅ CHECK & CREATE NESTED FOLDERS
    private String getOrCreateNestedFolders(RequestDto req) throws IOException {
        String rootUploadedFolderId = getOrCreateFolder(uploadedFileRootFolder, rootFolderId);
    	String customerName = req.getCustomer();
        String dateStr = LocalDate.now().toString();
        // Step 1: Ensure Customer Folder Exists
        String customerFolderId = getOrCreateFolder(customerName, rootUploadedFolderId);
        // Step 2: Ensure Date Folder Exists Inside Customer Folder
        return getOrCreateFolder(dateStr, customerFolderId);
    }

    // ✅ CHECK IF A FOLDER EXISTS OR CREATE IT
    private String getOrCreateFolder(String folderName, String parentFolderId) throws IOException {
        // Query Google Drive to check if the folder exists
        String query = String.format("name='%s' and mimeType='application/vnd.google-apps.folder' and '%s' in parents and trashed=false", 
                                     folderName, parentFolderId);
        FileList result = driveService.files().list().setQ(query).setFields("files(id)").execute();
        List<File> files = result.getFiles();
        if (!files.isEmpty()) {
            return files.get(0).getId(); // Folder exists, return its ID
        }
        // Folder does not exist, create it
        return createFolder(folderName, parentFolderId);
    }

    // ✅ CREATE A NEW FOLDER INSIDE A PARENT FOLDER
    private String createFolder(String folderName, String parentFolderId) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");
        fileMetadata.setParents(Collections.singletonList(parentFolderId));
        File folder = driveService.files().create(fileMetadata)
                .setFields("id")
                .execute();
        return folder.getId();
    }
}