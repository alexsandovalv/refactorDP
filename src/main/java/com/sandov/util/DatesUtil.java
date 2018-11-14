package com.sandov.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

public class DatesUtil {
	
	private static DatesUtil instance;
	
	private static final String FORMATER_DATETIME_DEFAULT = "dd/MM/yyyy HH:mm:ss";
	
	private static DateTimeFormatter dateTimeFormatter;
	
	public static DatesUtil getInstance() {
		if(instance == null) {
			return new DatesUtil();
		}
		return instance;
	}
	
	public static DateTimeFormatter setDateTimeFormat(String formater) {
		if(StringUtils.isBlank(formater)) {
			formater = FORMATER_DATETIME_DEFAULT;
		}
		dateTimeFormatter = DateTimeFormatter.ofPattern(formater).withZone(ZoneId.of("UTC"));
		return dateTimeFormatter;
	}
	
	public static String formaterDateTime_toString(String fomater, Instant snapDate) {
		if(StringUtils.isBlank(fomater))
			fomater = FORMATER_DATETIME_DEFAULT;
		if(ObjectUtils.isEmpty(dateTimeFormatter))
			setDateTimeFormat(fomater);
		
		return dateTimeFormatter.format(snapDate);
	}
	
	public static String formaterDateTime_toString(Instant snapDate) {
		return formaterDateTime_toString(null, snapDate);
	}
	
	public static String formaterDateTime_toString(String fomater) {
		return formaterDateTime_toString(fomater, Instant.now());
	}

}
