package com.fracong.config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.alibaba.fastjson.JSONObject;
import com.fracong.component.menubar.MenuBarComponent;
import com.fracong.component.toolbar.ToolBarComponent;
import com.fracong.util.common.CommonEnumUtils.LangType;

public class ConfigProperties {
	public static String FRAME_TITLE;
	public static final ConcurrentMap<String, JSONObject> INIT_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static final ConcurrentMap<String, JSONObject> ALL_CONFIG = new ConcurrentHashMap<String, JSONObject>();
	public static String INIT_LANG = LangType.ZH_CN.getValue();
	public static MenuBarComponent menuBarComponent;
	public static ToolBarComponent toolBarComponent;
}
