package com.example.entities;

import java.util.List;

public class ResponseObject {
	private String statusCode = "000";
	private String statusMessage = "";
	private List<BookEntity> listObj;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<BookEntity> getListObj() {
		return listObj;
	}

	public void setListObj(List<BookEntity> listObj) {
		this.listObj = listObj;
	}

}
