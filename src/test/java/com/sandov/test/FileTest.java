package com.sandov.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
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
public class FileTest {
	
	@Autowired
	@Qualifier("factoryLog")
	private LoggerFactory factory;
	
	private ILogger database = null;
	
	@Before
	private void setUp() {
		database = factory.getLogger("database");
	}
	
	@Test
	public void registerLogWithDataBaseAndMessageTest() {
		LoggerDto bLogger = new LoggerDto("Dentro de la base de datos", "Message");
//		ILogger database = factory.getLogger("database");
		
		database.logMessage(bLogger);
		
		assertNotNull(database);
	}
	
	@Test
	public void sizeLogWithDataBaseAndMessageTest() {
//		ILogger database = factory.getLogger("database");
		
		
	}

}
