package com.example.demo.entity;

import com.example.demo.enums.FileFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "filedata")
@Getter
@Setter
@ToString
public class FileData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "uuid")
	private String uuid;
	@Column(name = "file_name")
	private String filename;
	@Column(name = "file_format")
	@Enumerated(EnumType.STRING)
	private FileFormat fileFormat;
	@Column(name = "file_type")
	private String fileType;
}
