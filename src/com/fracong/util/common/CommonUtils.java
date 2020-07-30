package com.fracong.util.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fracong.entity.PropertiesUtilEntity;
import com.fracong.util.common.CommonEnumUtils.FileType;
import com.fracong.util.common.CommonEnumUtils.PathType;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;

public class CommonUtils {
	public static String getPath(PathType type, String fileName, FileType fileType) {
		return  new Object() {
			public String getPath() {
				String path = this.getClass().getResource(CommonConstants.SLASH).getPath();
				path = path.replace(CommonConstants.BIN_, CommonConstants.EMPTY);
				path = path.concat(type.getName()).concat(CommonConstants.SLASH);
				path = path.concat(fileName).concat(CommonConstants.COMMA).concat(fileType.getName());
				return path;
			}
		}.getPath();
	}
	
	public static JSONObject getJsonObjectByUrl(String url){
        JSONObject jsonObject = new JSONObject();
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url), CommonConstants.UTF_8));
            String s = null;
            while((s = bufferedReader.readLine()) != null){
                result.append(s);
            }
            bufferedReader.close();
            jsonObject = JSONObject.parseObject(result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
	
	public static String readProperty(PropertiesUtilEntity utilEntity, String endKey){
		JSONObject jsonObject = readProperties(utilEntity);
		return jsonObject.getString(endKey);
	}
	
	public static JSONObject readProperties(PropertiesUtilEntity utilEntity){
		JSONObject jsonObject = utilEntity.getMap().get(utilEntity.getMapKey().getValue());
		if (utilEntity.getKeys() == null || utilEntity.getKeys().length == 0) return jsonObject;
		jsonObject = getJSONObjectFromJson(jsonObject, utilEntity.getKeys());
		return jsonObject;
	}
	
	private static JSONObject getJSONObjectFromJson(JSONObject jsonObject, ConfigKey... keys){
		JSONObject returnJson = (JSONObject) jsonObject.clone();
		for (ConfigKey key : keys) {
			String value = key.getValue();
			if (!checkJsonValid(returnJson.getString(value))) break;
			returnJson = returnJson.getJSONObject(value);
		}
		return returnJson;
	}
	
	public static boolean checkJsonValid(String text){
		try {
			JSON.parse(text);
			return true;
        } catch (JSONException e) {
            return false;
        }
	}
}
