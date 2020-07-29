package com.fracong.myswing;

import com.fracong.thread.InitConfigThead;
import com.fracong.util.CommonConstants;
import com.fracong.util.EnumUtils.ConfigType;

public class MainApllication {

	public static void main(String[] args) {
		new InitConfigThead(ConfigType.INIT).start();
		new ViewFrame(CommonConstants.SWING_TITLE);
		new InitConfigThead(ConfigType.ALL).start();
	}
}
