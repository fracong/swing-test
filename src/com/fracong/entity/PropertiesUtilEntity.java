package com.fracong.entity;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;

public class PropertiesUtilEntity {
	private Map<String, JSONObject> map;
	private ConfigKey mapKey;
	private ConfigKey[] keys;
	
	public PropertiesUtilEntity(Map<String, JSONObject> map, ConfigKey mapKey, ConfigKey[] keys) throws Exception {
		if(map == null ||  mapKey == null || keys == null) throw new Exception();
		this.map = map;
		this.mapKey = mapKey;
		this.keys = keys;
	}
	
	public Map<String, JSONObject> getMap() {
		return map;
	}
	public void setMap(Map<String, JSONObject> map) {
		this.map = map;
	}
	public ConfigKey getMapKey() {
		return mapKey;
	}
	public void setMapKey(ConfigKey mapKey) {
		this.mapKey = mapKey;
	}
	public ConfigKey[] getKeys() {
		return keys;
	}
	public void setKeys(ConfigKey[] keys) {
		this.keys = keys;
	}
}
