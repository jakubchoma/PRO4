package cz.spsmb.ctvrtak.c_spring.b_config2.resources

import cz.spsmb.ctvrtak.c_spring.b_config2.main.service.SearchEngineService
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentRepository
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;

beans {
	
	engine(cz.spsmb.ctvrtak.c_spring.b_config2.main.service.SearchEngineService){
		documentDAO = ref("documentDAO")
	}	
	
	documentDAO(cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentRepository){
		doc1 = ref("doc1")
		doc2 = ref("doc2")
		doc3 = ref("doc3")
		doc4 = ref("doc4")
	}
	
	doc1(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc){
		name = "Book Template"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Random/Book Template.pdf"
	}
	
	doc2(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc){
		name = "Sample Contract"
		type = ref("pdfType")
		location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
	}
	
	doc3(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc){
		name = "Clustering with RabbitMQ"
		type = ref("noteType")
		location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
	}
	
	doc4(cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc){
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