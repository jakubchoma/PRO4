/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.e_collections.main.data;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public interface TypeDataDAO {
	public Type[] getAll();
	public Type findById(String id);
}
