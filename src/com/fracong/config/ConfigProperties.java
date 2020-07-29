package com.fracong.config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alibaba.fastjson.JSONObject;
import com.fracong.util.EnumUtils.LangType;

public class ConfigProperties {
	public static final ConcurrentMap<String, JSONObject> INIT_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static final ConcurrentMap<String, JSONObject> ALL_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static String INIT_LANG = LangType.ZH_CN.getValue();
}
