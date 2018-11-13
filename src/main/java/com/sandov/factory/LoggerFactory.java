package com.sandov.factory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sandov.component.ILogger;

@Component("factoryLog")
public class LoggerFactory {
	
	@Autowired
	@Qualifier("consoleLogger")
	private ILogger consoleLogger;
	
	@Autowired
	@Qualifier("fileLogger")
	private ILogger fileLogger;
	
	@Autowired
	@Qualifier("databaseLogger")
	private ILogger databaseLogger;
	
	
	public ILogger getLogger(String resource) {
		ILogger iLogger = null;
		if(StringUtils.isEmpty(resource))
			return null;
		
		switch (resource.trim().toLowerCase()) {
			case "console":
				iLogger = consoleLogger;
				break;
			case "file":
				iLogger = fileLogger;
				break;
			case "database":
				iLogger = databaseLogger;
				break;
		}
		
//		if(StringUtils.equalsIgnoreCase(resource, "console"))
//			return consoleLogger;
		return iLogger;
	}

}
