package com.sandov.test;

import static org.junit.Assert.assertNotNull;

import java.text.MessageFormat;

import org.apache.logging.log4j.message.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sandov.RefactorFactoryApplication;
import com.sandov.component.ILogger;
import com.sandov.dto.LoggerDto;
import com.sandov.factory.LoggerFactory;
import com.sandov.util.DatesUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RefactorFactoryApplication.class)
public class ConsoleTest {
	
	@Autowired
	@Qualifier("factoryLog")
	private LoggerFactory factory;
	
	private ILogger console;
	
	@Value("${messages.format}")
	private String messageFormat;
	
	@Before
	public void setUp() {
		console = factory.getLogger("console");
	}
	
	@Test
	public void registerLogWithConsoleAndInfoTest() {
		LoggerDto bLogger = new LoggerDto("Texto en consola ", "Info");
		
		String mensaje = MessageFormat.format(messageFormat, bLogger.getType(), 
								DatesUtil.formaterDateTime_toString(bLogger.getDate()), 
								bLogger.getMessage());
		
		console.logMessage(bLogger);
		
		assertNotNull(console);
		
	}

}
