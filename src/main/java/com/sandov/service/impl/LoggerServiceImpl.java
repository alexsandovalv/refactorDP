package com.sandov.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sandov.domain.LoggerDomain;
import com.sandov.domain.LoggerTypeEnum;
import com.sandov.exception.RefactorException;
import com.sandov.repository.LoggerRespository;
import com.sandov.service.LoggerService;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService{
	
	private final Logger log = LoggerFactory.getLogger(LoggerServiceImpl.class);
	
	private LoggerRespository repository;

	public LoggerServiceImpl(LoggerRespository repository) {
		this.repository = repository;
	}

	@Override
	public LoggerDomain saveLogger(LoggerDomain logValue) throws RefactorException{
		log.info("Request to save LoggerDomain : {}", logValue);
		return repository.save(logValue);
	}

	@Override
	public List<LoggerDomain> lookupLoggerAll() {
		log.info("Lookup all LoggerDomain");
		return repository.findAll();
	}

	@Override
	public LoggerDomain lookupLoggerbyId(Long id) throws RefactorException{
		log.info("Request to get LoggerDomain : {}", id);
		Optional<LoggerDomain> optional = repository.findById(id);
		log.info("LoggerDomain is: {}", optional.get());
		return optional.get();
	}

	@Override
	public void delete(Long id) throws RefactorException{
		log.info("Request to delete LoggerDomain : {}", id);
		repository.deleteById(id);
	}

	@Override
	public LoggerDomain saveLogger(String message, String type) throws RefactorException{
		log.info("Request to save LoggerDomain message {} and type {}", message, LoggerTypeEnum.findByLabel(type));
		return repository.save(new LoggerDomain(message, LoggerTypeEnum.findByLabel(type)));
	}
	
	

}
