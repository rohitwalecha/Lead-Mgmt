package org.codejudge.sb.error;

public class ApiError {

	private String status; 
	
	private String explanation;
	 
	public ApiError(String status, String explanation) {
		this.status = status;
	    this.explanation = explanation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	
}
