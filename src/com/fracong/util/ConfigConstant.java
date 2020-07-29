package com.fracong.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alibaba.fastjson.JSONObject;
import com.fracong.util.EnumUtils.LangType;

public class ConfigConstant {
	public static final String SWING_TITLE = "SWING TEST";
	public static final String SLASH = "/";
	public static final String BIN_ = "bin/";
	public static final String EMPTY = "";
	public static final String COMMA = ".";
	public static final String UTF_8 = "UTF-8";
	public static final ConcurrentMap<String, JSONObject> INIT_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static final ConcurrentMap<String, JSONObject> ALL_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static String INIT_LANG = LangType.ZH_CN.getValue();
}
