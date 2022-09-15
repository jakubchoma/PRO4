/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.data;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;

/**
 * @author Felipe Gutierrez
 * DAO - Data Access Object - objekt pro přístup k datům
 */
public interface DocumentDAO {
	public Doc[] getAll();
}
