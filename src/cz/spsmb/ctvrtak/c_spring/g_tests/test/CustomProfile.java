/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.test;

import org.springframework.test.annotation.ProfileValueSource;

/**
 * @author Felipe Gutierrez
 *
 */
public class CustomProfile implements ProfileValueSource {
	
	public String get(String key) {
		if(key.equals("environment"))
			return "dev";
		else if (key.equals("os.name"))
			return "Unix";
		return null;
	}

}
