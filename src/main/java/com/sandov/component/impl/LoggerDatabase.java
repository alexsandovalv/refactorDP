package com.sandov.component.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sandov.component.ILogger;
import com.sandov.domain.LoggerDomain;
import com.sandov.dto.LoggerDto;
import com.sandov.exception.RefactorException;
import com.sandov.service.LoggerService;

@Component
@Qualifier("databaseLogger")
public class LoggerDatabase implements ILogger {
	
	private final static Logger log = LoggerFactory.getLogger(LoggerDatabase.class);
	
	@Autowired
	private LoggerService loggerService;

	@Override
	public void logMessage(LoggerDto bLogger) {
		LoggerDomain domain = new LoggerDomain(bLogger);
		try {
			
			loggerService.saveLogger(domain);
			
			if(log.isInfoEnabled()) {
				log.info(StringUtils.repeat("*", 50));
				log.info("Start to info logger text into DataBase");
				log.info(domain.toString());
				log.info(StringUtils.repeat("*", 50));
			}
			
		} catch (RefactorException refactorException) {
			log.error("RefactorException, ", refactorException);
		}
	}
	
	public List<LoggerDto> loggerAll(){
		return loggerService.lookupLoggerAll().
				stream().
				map(p -> new LoggerDto(
									p.getMessage(), 
									p.getType().getLabel(), 
									p.getDate())).
				collect(Collectors.toList());
	}
	
	public LoggerDomain getLoggerById(Long id) throws RefactorException{
		return loggerService.lookupLoggerbyId(id);
	}

}
