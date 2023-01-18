package com;

public class MVCBEAN {
	private String username , userpassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean validate() {
		if(this.userpassword.equals("MIZ")) 
			return true;
		
		return false;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}
