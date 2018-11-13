package com.sandov.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sandov.RefactorFactoryApplication;
import com.sandov.component.ILogger;
import com.sandov.dto.LoggerDto;
import com.sandov.factory.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RefactorFactoryApplication.class)
public class ConsoleTest {
	
	@Autowired
	@Qualifier("factoryLog")
	private LoggerFactory factory;
	
	@Test
	public void registerLogWithConsoleAndInfoTest() {
		LoggerDto bLogger = new LoggerDto("Texto en consola ", "Info");
		ILogger console = factory.getLogger("console");
		
		console.logMessage(bLogger);
		
		assertNotNull(console);
		
	}

}
