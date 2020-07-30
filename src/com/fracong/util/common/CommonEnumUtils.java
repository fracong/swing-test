package com.fracong.util.common;

public class CommonEnumUtils {
	public static enum PathType{
		IMG("imgs"),
		CONF("config");
		
		private String name;
		private PathType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	public static enum FileType{
		JSON("json"),
		PNG("png");
		
		private String name;
		private FileType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	public static enum LangType{
		ZH_CN("cn"),
		EN("en")
		;
		
		private String value;
		private LangType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
