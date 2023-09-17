package com.file.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.server.entity.FileEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<FileEntity, Long>{

	FileEntity findByFileName(String fileName);

}


