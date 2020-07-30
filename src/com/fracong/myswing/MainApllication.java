package com.fracong.myswing;

import com.fracong.thread.InitConfigThead;
import com.fracong.util.common.CommonConstants;
import com.fracong.util.config.ConfigEnumUtils.CommonConfigType;
import com.fracong.util.config.ConfigEnumUtils.InitConfigType;

public class MainApllication {

	public static void main(String[] args) throws Exception {
		new InitConfigThead(InitConfigType.ALL).start();
		new ViewFrame(CommonConstants.SWING_TITLE);
		new InitConfigThead(CommonConfigType.ALL).start();
	}
}
