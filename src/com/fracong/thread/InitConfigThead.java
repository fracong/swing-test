package com.fracong.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.fracong.config.ConfigProperties;
import com.fracong.util.common.CommonUtils;
import com.fracong.util.config.ConfigEnumUtils.CommonConfigType;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;
import com.fracong.util.config.ConfigEnumUtils.ConfigType;
import com.fracong.util.config.ConfigEnumUtils.InitConfigType;
import com.fracong.util.common.CommonEnumUtils.FileType;
import com.fracong.util.common.CommonEnumUtils.LangType;
import com.fracong.util.common.CommonEnumUtils.PathType;

public class InitConfigThead extends Thread{
	private ConfigType type;
	private InitConfigType initType;
	private CommonConfigType commonType;
	private static final List<InitConfigType> excludeInitConfigTypeList = new ArrayList<InitConfigType>();
	{
		excludeInitConfigTypeList.add(InitConfigType.ALL);
		excludeInitConfigTypeList.add(InitConfigType.COMMON);
		excludeInitConfigTypeList.add(InitConfigType.CN_LANG);
		excludeInitConfigTypeList.add(InitConfigType.EN_LANG);
	}
	
	public InitConfigThead(){
		this.type = ConfigType.ALL;
	}
	
	public InitConfigThead(InitConfigType initType){
		this.type = ConfigType.INIT;
		this.initType = initType;
	}
	
	public InitConfigThead(CommonConfigType commonType){
		this.type = ConfigType.COMMON;
		this.commonType = commonType;
	}
	
	@Override
	public void run() {
		if (ConfigType.ALL.equals(type)) {
			for (ConfigType configType : ConfigType.values()) {
				if (ConfigType.ALL.equals(configType)) continue;
				if (ConfigType.INIT.equals(configType)) {
					this.setInitConfig();
				} else if (ConfigType.COMMON.equals(configType)) {
					this.setCommonConfig();
				}
			}
		} else if (ConfigType.INIT.equals(type)) {
			this.setInitConfig();
		} else if (ConfigType.COMMON.equals(type)) {
			this.setCommonConfig();
		}
	}
	
	private void setInitConfig() {
		if(InitConfigType.ALL.equals(initType)) {
			this.setOneInitConfig(InitConfigType.COMMON);
			for (InitConfigType initType : InitConfigType.values()) {
				if (excludeInitConfigTypeList.contains(initType)) continue;
				this.setOneInitConfig(initType);
			}
		} else {
			this.setOneInitConfig(initType);
		}
	}
	
	private void setOneInitConfig(InitConfigType initType){
		String path = CommonUtils.getPath(PathType.CONF, initType.getName(), FileType.JSON);
		JSONObject json = CommonUtils.getJsonObjectByUrl(path);
		Set<String> keySet = json.keySet();
		for (String key : keySet) {
			if(InitConfigType.COMMON.equals(initType) && ConfigKey.LANG.getValue().equals(key)){
				ConfigProperties.INIT_LANG = json.getString(key);
				this.initLangConfig();
				continue;
			}
			ConfigProperties.INIT_CONFIG.put(key, json.getJSONObject(key));
		}
	}
	
	private void initLangConfig(){
		String path = "";
		if(LangType.EN.getValue().equals(ConfigProperties.INIT_LANG)) {
			path = CommonUtils.getPath(PathType.CONF, InitConfigType.EN_LANG.getName(), FileType.JSON);
		} else {
			path = CommonUtils.getPath(PathType.CONF, InitConfigType.CN_LANG.getName(), FileType.JSON);
		}
		JSONObject json = CommonUtils.getJsonObjectByUrl(path);
		ConfigProperties.INIT_CONFIG.put(ConfigKey.LANG_CONFIG.getValue(), json);
	}
	
	private void setCommonConfig() {
		if(CommonConfigType.ALL.equals(commonType)) {
			
		} else {
			
		}
	}
}
