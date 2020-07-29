package com.fracong.myswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.fracong.config.ConfigProperties;
import com.fracong.util.CommonUtils;
import com.fracong.util.EnumUtils.FileType;
import com.fracong.util.EnumUtils.PathType;
import com.fracong.util.EnumUtils.ToolActionType;

public class SwingTools {
	public static JButton createButton(String imageUrl,ToolActionType command,String tip){
		JButton button=new JButton();
		button.setActionCommand(command.toString());
		button.setToolTipText(tip);
		button.setIcon(new ImageIcon(CommonUtils.getPath(PathType.IMG, imageUrl, FileType.PNG)));
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String action =e.getActionCommand();
				System.out.println("执行命令："+action);
				System.out.println(ConfigProperties.INIT_CONFIG.toString());
				System.out.println(ConfigProperties.ALL_CONFIG.toString());
			}
		});
		return button;
	}
}
