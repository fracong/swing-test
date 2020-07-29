package com.fracong.util;

public class EnumUtils {
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
	
	public static enum ConfigType{
		ALL("ALL"),
		MENU_TOOL("menu_tool_config"),
		INIT("init_config");
		
		private String name;
		private ConfigType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	public static enum ConfigKey{
		LANG("lang"),
		IMG_PATH("imgs_path"),
		TOOL("tool_config"),
		SAVE_AS("saveAs"),
		SAVE("save"),
		OPEN("open"),
		QUESTION("question"),
		TIPS("tips"),
		;
		
		private String value;
		private ConfigKey(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	public static enum ToolActionType{
		OPEN, SAVE, SAVE_AS, HELP;
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
