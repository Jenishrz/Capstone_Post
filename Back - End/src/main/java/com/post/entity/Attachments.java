package com.post.entity;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_attachment")
public class Attachments {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="file_id")
//	private long fileId;
//	
//	@Column(name="file_name")
//	private String fileName;
//	
//	@Column(name="file_type")
//	private String fileType;
//	@Lob
//	@Column(name="file_data")
//	private byte[] fileData;
//	@Column(name="file_size")
//	private String fileSize;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileId;
	
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_nype")
	private String fileType;
	
	@Lob
	private byte[] fdata;
	
	
	public Attachments() {
		super();

	}


	public Attachments( String fileName, String fileType, byte[] fdata) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fdata = fdata;
	}


	public long getFileId() {
		return fileId;
	}


	public void setFileId(long fileId) {
		this.fileId = fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public byte[] getFdata() {
		return fdata;
	}


	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	

}
