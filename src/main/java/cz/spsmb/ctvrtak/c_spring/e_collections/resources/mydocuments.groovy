package cz.spsmb.ctvrtak.c_spring.e_collections.resources

import cz.spsmb.ctvrtak.c_spring.e_collections.main.service.SearchEngineService
import cz.spsmb.ctvrtak.c_spring.e_collections.main.data.DocumentRepository
import cz.spsmb.ctvrtak.c_spring.e_collections.main.data.TypeDataRepository
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc

beans {
	
	engine(SearchEngineService){ 
		documentDAO = ref("documentDAO")
	}	
	
	documentDAO(DocumentRepository){ 
		documents = [ref("doc1"), ref("doc2"), ref("doc3"), ref("doc4")]
	}
	
	typeDAO(TypeDataRepository){
		types = [pdfType:ref("pdfType"), webType:ref("webType"), noteType: ref("noteType") ]
	}
	
	doc1(Doc){
		name = "Book Template"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Random/Book Template.pdf"
	}
	
	doc2(Doc){
		name = "Sample Contract"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
	}
	
	doc3(Doc){
		name = "Clustering with RabbitMQ"
		type = ref("noteType")
		location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
	}
	
	doc4(Doc){
		name = "Pro Spring Security Book"
		type = ref("webType")
		location = "http://www.apress.com/9781430248187"
	}
	
	webType(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type){
		name = "WEB"
		desc = "Web Link"
		extension = ".url"
	}
	
	pdfType(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type){
		name = "PDF"
		desc = "Portable Document Format"
		extension = ".url"
	}
	
	noteType(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type){
		name = "NOTE"
		desc = "Text Notes"
		extension = ".txt"
	}
}