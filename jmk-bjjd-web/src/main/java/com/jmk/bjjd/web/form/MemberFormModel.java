package com.jmk.bjjd.web.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jmk.bjjd.models.MemberModel;

public class MemberFormModel extends MemberModel {

	
	public MemberFormModel(){
	}
	
	public MemberFormModel(String id){
		setId(id);
	}
	
	private String encodedImage;
	
	private CommonsMultipartFile fileUpload;
	
	public CommonsMultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(CommonsMultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	
	
	

}
