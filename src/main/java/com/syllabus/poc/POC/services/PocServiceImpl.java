package com.syllabus.poc.POC.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mongodb.MongoBulkWriteException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PocServiceImpl implements PocService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	Browser browser;
	
	public PocServiceImpl(Browser browser) {
		this.browser = browser;
	}

	@Override
	public void extractDatas() {
          List<String> seedIds = List.of("D-GT5Z-5KXXK-11", "D-F-133-IUIU-78", "D-0CSJ-O1FKY-52");
          seedIds.forEach(this::extractData);
	}
	
	private void extractData(String seedId) {
		String seedJson = browser.getSeedAsJson(seedId);
		log.info("------ Seed JSON : {}", seedJson);
		if (seedJson.startsWith("{\"register\":")){
			//insert in mongo
			mongoTemplate.insert(Document.parse(seedJson),"seed");
			log.info("------ Seed JSON : {}", seedJson);

		}

	}

}
