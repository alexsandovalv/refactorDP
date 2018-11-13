package com.sandov.component.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sandov.component.ILogger;
import com.sandov.domain.LoggerDomain;
import com.sandov.dto.LoggerDto;
import com.sandov.repository.LoggerRespository;

@Component
@Qualifier("databaseLogger")
public class LoggerDatabase implements ILogger {
	
	private final static Logger log = LoggerFactory.getLogger(LoggerDatabase.class);
	
	@Autowired
	private LoggerRespository repository;

	@Override
	public void logMessage(LoggerDto bLogger) {
		LoggerDomain domain = new LoggerDomain(bLogger);
		repository.save(domain);
		
		if(log.isInfoEnabled()) {
			log.info(StringUtils.repeat("*", 50));
			log.info("Start to info logger text into DataBase");
			log.info(domain.toString());
			log.info(StringUtils.repeat("*", 50));
		}
	}

}
