package org.codejudge.sb.success;

public class MarkLeadSuccess {

	private String status; 
	
	private String communication;
	 
	public MarkLeadSuccess(String status, String communication) {
		this.status = status;
	    this.communication = communication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExplanation() {
		return communication;
	}

	public void setExplanation(String communication) {
		this.communication = communication;
	}
	
}
