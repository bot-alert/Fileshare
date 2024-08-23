package com.example.demo.repo;

import com.example.demo.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDatabaseRepository extends JpaRepository<FileData, Long> {

    FileData getFileByUuid(String id);
}

