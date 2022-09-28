/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.data;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;

/**
 * @author Felipe Gutierrez
 *
 */
public class DocumentRepository implements DocumentDAO {
	
	private Doc doc1;
	private Doc doc2;
	private Doc doc3;
	private Doc doc4;

	public Doc getDoc1() {
		return doc1;
	}

	public void setDoc1(Doc doc1) {
		this.doc1 = doc1;
	}

	public Doc getDoc2() {
		return doc2;
	}

	public void setDoc2(Doc doc2) {
		this.doc2 = doc2;
	}

	public Doc getDoc3() {
		return doc3;
	}

	public void setDoc3(Doc doc3) {
		this.doc3 = doc3;
	}

	public Doc getDoc4() {
		return doc4;
	}

	public void setDoc4(Doc doc4) {
		this.doc4 = doc4;
	}

	public Doc[] getAll() {
		return new Doc[] { doc1, doc2, doc3, doc4 };
	}

}
