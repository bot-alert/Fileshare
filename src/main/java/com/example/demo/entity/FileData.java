package com.example.demo.entity;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "filedata",schema = "file")
public class FileData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "uuid")
	private String uuid;
	@Column(name = "filename")
	private String filename;
	@Column(name = "filedata")
	private byte[] file;
	@Column(name ="filetype" )
	private String filetype;

	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public FileData() {
		super();
	}
	public FileData(String uuid, String filename, byte[] file,String filetype){
		super();
		this.uuid = uuid;
		this.filename = filename;
		this.file = file;
		this.filetype = filetype;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "FileData [id=" + id + ", uuid=" + uuid + ", filename=" + filename + ", file=" + Arrays.toString(file)
				+ ", filetype=" + filetype + "]";
	}


}
