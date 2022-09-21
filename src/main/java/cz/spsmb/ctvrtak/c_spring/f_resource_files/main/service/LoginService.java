/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.f_resource_files.main.service;

/**
 * @author Felipe Gutierrez
 *
 */
public class LoginService implements Login {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAuthorized(String email, String pass){
		if(username.equals(email) && password.equals(pass))
			return true;
		return false;
	}

}
