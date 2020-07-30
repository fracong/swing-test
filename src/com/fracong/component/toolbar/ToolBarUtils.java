package com.fracong.component.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.fracong.util.common.CommonUtils;
import com.fracong.util.common.CommonEnumUtils.FileType;
import com.fracong.util.common.CommonEnumUtils.PathType;

public class ToolBarUtils {
	public static enum ToolActionType{
		OPEN, SAVE, SAVE_AS, HELP;
	}

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
			}
		});
		return button;
	}
}
