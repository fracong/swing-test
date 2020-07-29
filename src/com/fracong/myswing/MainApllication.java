package com.fracong.myswing;

import com.fracong.util.ConfigConstant;
import com.fracong.util.EnumUtils.ConfigType;

public class MainApllication {

	public static void main(String[] args) {
		new InitConfigThead(ConfigType.INIT).start();
		new ViewFrame(ConfigConstant.SWING_TITLE);
		new InitConfigThead(ConfigType.ALL).start();
	}
}
