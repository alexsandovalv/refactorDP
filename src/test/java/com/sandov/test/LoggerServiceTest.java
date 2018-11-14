package com.sandov.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sandov.domain.LoggerDomain;
import com.sandov.domain.LoggerTypeEnum;
import com.sandov.exception.RefactorException;
import com.sandov.repository.LoggerRespository;
import com.sandov.service.impl.LoggerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoggerServiceTest {
	
	@Mock
	private LoggerRespository repository;
	
	@InjectMocks
	private LoggerServiceImpl loggerService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLoggerAllTest(){
		
		List<LoggerDomain> loggers = Arrays.asList(
				new LoggerDomain("Loggger 1", "message"),
				new LoggerDomain("Loggger 2", "warn"),
				new LoggerDomain("Loggger 3", "error")
				);
		
		when(repository.findAll()).thenReturn(loggers);
		
		List<LoggerDomain> loggersDB = loggerService.lookupLoggerAll();
		
		assertEquals(3, loggersDB.size());
		
	}
	
	@Test
	public void testLoggerByIdTest() throws RefactorException{
		LoggerDomain domain = new LoggerDomain("Logger 1", "message");
		domain.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(domain));
		
		LoggerDomain result = loggerService.lookupLoggerbyId(1L);
		
		assertEquals(1, result.getId().longValue());
		assertEquals("Logger 1", result.getMessage());
		assertEquals(LoggerTypeEnum.MESSAGE.getLabel(), result.getType().getLabel());
	}
	
	@Test
	public void saveLoggerTest() throws RefactorException{
		LoggerDomain loggerDomain = new LoggerDomain("Logger 8", "warning");
		loggerDomain.setId(4L);
		when(repository.save(loggerDomain)).thenReturn(loggerDomain);
		
		LoggerDomain result = loggerService.saveLogger(loggerDomain);
		assertEquals(4, result.getId().longValue());
		assertEquals("Logger 8", result.getMessage());
		assertEquals(LoggerTypeEnum.WARNING.getLabel(), result.getType().getLabel());
	}
	

}
