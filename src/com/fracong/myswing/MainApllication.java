package com.fracong.myswing;

import com.fracong.thread.InitConfigThead;
import com.fracong.util.config.ConfigEnumUtils.CommonConfigType;
import com.fracong.util.config.ConfigEnumUtils.InitConfigType;

public class MainApllication {

	public static void main(String[] args) throws Exception {
		new InitConfigThead(InitConfigType.ALL).start();
		new ViewFrame();
		new InitConfigThead(CommonConfigType.ALL).start();
	}
}
