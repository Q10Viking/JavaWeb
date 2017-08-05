package com.q10viking.DataSourceUtils;

public class User {
	private String CID;
	private String CNAME;
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	@Override
	public String toString() {
		return "User [CID=" + CID + ", CNAME=" + CNAME + "]";
	}
	
}
