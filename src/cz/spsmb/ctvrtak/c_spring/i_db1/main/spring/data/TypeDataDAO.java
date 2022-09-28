/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public interface TypeDataDAO {
	public Type[] getAll();
	public Type findById(String id);
}
