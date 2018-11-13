package com.sandov.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandov.component.ILogger;
import com.sandov.component.impl.LoggerConsole;
import com.sandov.component.impl.LoggerDatabase;
import com.sandov.component.impl.LoggerFile;

//@Configuration
public class LoggerConfig {
	
	//@Bean
	public ILogger consoleLogger() {
		return new LoggerConsole();
	}
	
	//@Bean
	public ILogger fileLogger() {
		return new LoggerFile();
	}
	
	//@Bean
	public ILogger databaseLogger() {
		return new LoggerDatabase();
	}

}
