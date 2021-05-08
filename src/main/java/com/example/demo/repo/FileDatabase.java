package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FileData;

@Repository
@Component("database")
public interface FileDatabase extends JpaRepository<FileData, Long>  {
	
	FileData getFileByUuid(String id);
}

