package com.fracong.util.config;

public class ConfigEnumUtils {
	
	public enum ConfigType{
		ALL,INIT,COMMON;
	}
	
	public enum InitConfigType{
		ALL("ALL"),
		COMMON("init_config"),
		CN_LANG("init_cn_lang"),
		EN_LANG("init_en_lang");
		
		private String name;
		private InitConfigType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	public enum CommonConfigType{
		ALL("ALL"),
		MENU_TOOL("menu_tool_config");
		
		private String name;
		private CommonConfigType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	public enum ConfigKey{
		LANG("lang"),
		LANG_CONFIG("lang_config"),
		IMG_PATH("imgs_path"),
		IMAGE("image"),
		TOOL("tool_config"),
		SAVE_AS("saveAs"),
		SAVE("save"),
		OPEN("open"),
		QUESTION("question"),
		TIPS("tips"),
		TITLE("title"),
		TITLE_FRAME("frame"),
		MENU("menu_config"),
		MENU_FILE("fileMenu"),
		MENU_EDIT("editMenu"),
		MENU_VIEW("viewMenu"),
		MENU_ABOUT("aboutMenu"),
		MENU_FILE_CREATE("fileCreate"),
		MENU_FILE_OPEN("fileOpen"),
		MENU_FILE_EXIT("fileExit"),
		;
		
		private String value;
		private ConfigKey(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
