package com.syllabus.poc.POC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PocServiceImpl implements PocService {
	
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
	}


}
