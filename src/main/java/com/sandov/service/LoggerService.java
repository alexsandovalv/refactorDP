package com.sandov.service;

import java.util.List;

import com.sandov.domain.LoggerDomain;
import com.sandov.exception.RefactorException;

public interface LoggerService {
	
	LoggerDomain saveLogger(String message, String type) throws RefactorException;
	
	LoggerDomain saveLogger(LoggerDomain logValue) throws RefactorException;
	
	List<LoggerDomain> lookupLoggerAll ();
	
	LoggerDomain lookupLoggerbyId(Long id) throws RefactorException;
	
	void delete(Long id) throws RefactorException;

}
