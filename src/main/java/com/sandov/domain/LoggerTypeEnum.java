package com.sandov.domain;

public enum LoggerTypeEnum {
	
	MESSAGE("message"), WARNING("warning"), ERROR("error");
	
	private String label;
	
	private LoggerTypeEnum(String label) {
        this.label = label.toUpperCase();
    }
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static LoggerTypeEnum findByLabel(String byLabel) {
		if(null==byLabel || "".equalsIgnoreCase(byLabel)) return null;
		if(byLabel.equalsIgnoreCase("null")) return null;
        for(LoggerTypeEnum type:LoggerTypeEnum.values()) {
            if (type.label.equalsIgnoreCase(byLabel))
                return type;
        }
        return null;
    }

}
