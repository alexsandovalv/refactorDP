package com.sandov.component.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sandov.component.ILogger;
import com.sandov.dto.LoggerDto;

@Component
@Qualifier("consoleLogger")
public class LoggerConsole implements ILogger {
	
	private final static Logger log = LoggerFactory.getLogger(LoggerConsole.class);
	
	@Override
	public void logMessage(LoggerDto bLogger) {
		System.out.println("adentro del console ");
		if(log.isDebugEnabled()) {
			log.debug(StringUtils.repeat("*", 50));
			log.debug("Start to debug logger text into Console");
			log.debug(bLogger.toString());
			log.debug(StringUtils.repeat("*", 20));
		}
		if(log.isInfoEnabled()) {
			log.info(StringUtils.repeat("*", 50));
			log.info("Start to info logger text into Console");
			log.info(bLogger.toString());
			log.info(StringUtils.repeat("*", 20));
		}
	}

}
