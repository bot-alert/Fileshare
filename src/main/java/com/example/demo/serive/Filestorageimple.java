package com.example.demo.serive;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repo.FileDatabase;

@Service
@Component("filestorage")
public class Filestorageimple implements FileStorageService {
	@Autowired
	@Qualifier("database")
	FileDatabase fileDatabase;

	@Override
	public String save(MultipartFile file) {
		// TODO Auto-generated method stub
		FileData fileData = new FileData();
		try {
			fileData.setFile(file.getBytes());
			fileData.setFilename(file.getOriginalFilename());
			fileData.setFiletype(file.getContentType());
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			uuidAsString = uuidAsString.replaceAll("-", "");
			String newidString = "";
			for (int i = 0; i < 8; i++) {
				newidString = newidString + uuidAsString.charAt(i);
			}
			fileData.setUuid(newidString);
			fileDatabase.save(fileData);
			return newidString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "filenotsaved";
		}

	}

	@Override
	public FileData downloadFile(String id) {
		FileData fileData = fileDatabase.getFileByUuid(id);
		return fileData;
	}

}
