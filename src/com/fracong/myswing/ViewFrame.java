package com.fracong.myswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.alibaba.fastjson.JSONObject;
import com.fracong.component.ComponentUtils;
import com.fracong.config.ConfigProperties;
import com.fracong.util.common.CommonEnumUtils.FileType;
import com.fracong.util.common.CommonEnumUtils.PathType;
import com.fracong.util.common.CommonUtils;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;

public class ViewFrame extends JFrame{
	private static final long serialVersionUID = 5429149711335650629L;

	public ViewFrame() throws Exception {
		this.checkInit();
		this.setTitle(ConfigProperties.FRAME_TITLE);
		this.initFrame();
		this.setVisible(true);
	}
	
	private void checkInit() {
		while (true) {
			JSONObject langJson = ConfigProperties.INIT_CONFIG.get(ConfigKey.LANG_CONFIG.getValue());
			if (langJson != null) {
				JSONObject titleJson = langJson.getJSONObject(ConfigKey.TITLE.getValue());
				if (titleJson != null) {
					ConfigProperties.FRAME_TITLE = titleJson.getString(ConfigKey.TITLE_FRAME.getValue());
				}
			}
			if (ConfigProperties.INIT_CONFIG.size() != 0 && ConfigProperties.FRAME_TITLE != null && !"".equals(ConfigProperties.FRAME_TITLE))  break;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void initFrame() throws Exception {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		if(dimension.getWidth() < 1400 && dimension.getHeight() < 800) {
			this.setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight()-70);
		} else {
			this.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 1000, 750);
		}
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image myimage=this.getToolkit().getImage(CommonUtils.getPath(PathType.IMG, ConfigKey.IMAGE.getValue(), FileType.PNG));
		this.setIconImage(myimage);
		this.setBackground(Color.RED);
		
		ComponentUtils.resetFrame(this);
	}
}
