package com.ci.core;

import java.util.HashMap;
import java.util.Map;

/**
 * author: mzbedat
 * Type of used continues integration tool, has the name of the tool and the port that it uses it.
 */
public enum CIType {
	
	TEAMCITY("teamcity", "80"), 
	JENKINS("jenkins", "8080");
	
	/** The tool name. */
	private String toolName;
	
	/** The port. */
	private String port;
	
	/** The Constant map. */
	private static final Map<String, CIType> map;
	
	static{
		map = new HashMap<String, CIType>();
		for (CIType value : CIType.values()){
			map.put(value.toolName, value);
		}
	}
	
	/**
	 * Instantiates a new CI type.
	 *
	 * @param name the name
	 * @param port the port
	 */
	CIType(String name, String port){
		toolName = name;
		this.port = port;
	}
	
	/**
	 * Gets the tool name.
	 *
	 * @return the tool name
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * Sets the tool name.
	 *
	 * @param toolName the new tool name
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}

	
	
	/**
	 * Find by key.
	 *
	 * @param tool the tool
	 * @return the CI type
	 */
	public static CIType findByKey(String tool){
		return map.get(tool);
	}
}
