package com.fracong.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSONObject;
import com.fracong.util.EnumUtils.FileType;
import com.fracong.util.EnumUtils.PathType;

public class CommonUtils {
	public static String getPath(PathType type, String fileName, FileType fileType) {
		return  new Object() {
			public String getPath() {
				String path = this.getClass().getResource(ConfigConstant.SLASH).getPath();
				path = path.replace(ConfigConstant.BIN_, ConfigConstant.EMPTY);
				path = path.concat(type.getName()+ConfigConstant.SLASH);
				path = path.concat(fileName).concat(ConfigConstant.COMMA).concat(fileType.getName());
				return path;
			}
		}.getPath();
	}
	
	public static JSONObject getJsonObjectBy(String url){
        JSONObject jsonObject = new JSONObject();
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(url), ConfigConstant.UTF_8));
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
}
