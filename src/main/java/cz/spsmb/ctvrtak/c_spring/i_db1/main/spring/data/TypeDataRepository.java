/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data;

import java.util.Map;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;


/**
 * @author Felipe Gutierrez
 *
 */
public class TypeDataRepository implements TypeDataDAO{
	private Map<String,Type> types = null;
	
	public Map<String, Type> getTypes() {
		return types;
	}

	public void setTypes(Map<String, Type> types) {
		this.types = types;
	}

	public Type findById(String id){
		Type type = types.get(id);
		return type;
	}

	public Type[] getAll() {		
		return types.values().toArray(new Type[types.values().size()]);
	}
}
