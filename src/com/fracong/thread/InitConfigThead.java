package com.fracong.thread;

import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.fracong.config.ConfigProperties;
import com.fracong.util.CommonUtils;
import com.fracong.util.EnumUtils.ConfigKey;
import com.fracong.util.EnumUtils.ConfigType;
import com.fracong.util.EnumUtils.FileType;
import com.fracong.util.EnumUtils.PathType;

public class InitConfigThead extends Thread{
	private ConfigType type;
	
	public InitConfigThead(ConfigType type){
		this.type = type;
	}
	
	@Override
	public void run() {
		if (ConfigType.ALL.equals(type)) {
			for (ConfigType configType : ConfigType.values()) {
				if (ConfigType.ALL.equals(configType) || ConfigType.INIT.equals(configType)) continue;
				String path = CommonUtils.getPath(PathType.CONF, configType.getName(), FileType.JSON);
				JSONObject json = CommonUtils.getJsonObjectByUrl(path);
				ConfigProperties.ALL_CONFIG.put(configType.getName(), json);
			}
		} else if (ConfigType.INIT.equals(type)) {
			this.setInitConfig();
		} else {
			JSONObject json = CommonUtils.getJsonObjectByUrl(CommonUtils.getPath(PathType.CONF, type.getName(), FileType.JSON));
			ConfigProperties.ALL_CONFIG.put(type.getName(), json);
		}
	}

	private void setInitConfig() {
		String path = CommonUtils.getPath(PathType.CONF, type.getName(), FileType.JSON);
		JSONObject json = CommonUtils.getJsonObjectByUrl(path);
		Set<String> keySet = json.keySet();
		for (String key : keySet) {
			if(ConfigKey.LANG.getValue().equals(key)){
				ConfigProperties.INIT_LANG = json.getString(key);
				continue;
			}
			ConfigProperties.INIT_CONFIG.put(key, json.getJSONObject(key));
		}
	}

}
