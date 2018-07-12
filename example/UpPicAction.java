package com.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

public class UpPicAction extends ActionSupport {
	private File upPic;
	private String upPicFileName;
	private String upPicContentType;
	private String savePath;
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws Exception{
		String RealPath=savePath+"\\"+upPicFileName;
		File saveFile = new File(RealPath);
		System.out.println(saveFile.getAbsolutePath());
		FileUtils.copyFile(upPic, saveFile);
		return SUCCESS;
	}

	public File getUpPic() {
		return upPic;
	}

	public void setUpPic(File upPic) {
		this.upPic = upPic;
	}

	public String getUpPicFileName() {
		return upPicFileName;
	}

	public void setUpPicFileName(String upPicFileName) {
		this.upPicFileName = upPicFileName;
	}

	public String getUpPicContentType() {
		return upPicContentType;
	}

	public void setUpPicContentType(String upPicContentType) {
		this.upPicContentType = upPicContentType;
	}
}
