package com.fracong.component.toolbar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.alibaba.fastjson.JSONObject;
import com.fracong.config.ConfigProperties;
import com.fracong.entity.PropertiesUtilEntity;
import com.fracong.util.common.CommonUtils;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;
import com.fracong.component.toolbar.ToolBarUtils.ToolActionType;

public class ToolBarComponent {
	private JPanel toolPanel;
	private JToolBar toolBar;
	private JButton openButton;
	private JButton saveButton;
	private JButton saveAsButton;
	private JButton helpButton;
	
	public ToolBarComponent(int frameWidth) throws Exception {
		this.createToolBar(frameWidth);
	}

	private void createToolBar(int frameWidth) throws Exception {
		toolPanel = new JPanel();
		toolPanel.setLayout(new BorderLayout());
		
		toolBar=new JToolBar();
		toolBar.setFloatable(false);
		toolPanel.add(toolBar, BorderLayout.PAGE_START);
		
		toolBar.addSeparator(new Dimension(0,10));
		
		ConfigKey[] imgKeys = new ConfigKey[]{ConfigKey.TOOL};
		PropertiesUtilEntity imgUtilEntity = new PropertiesUtilEntity(ConfigProperties.INIT_CONFIG, ConfigKey.IMG_PATH, imgKeys);
		JSONObject toolConfig = CommonUtils.readProperties(imgUtilEntity);
		String saveAs = toolConfig.getString(ConfigKey.SAVE_AS.getValue());
		String open = toolConfig.getString(ConfigKey.OPEN.getValue());
		String save = toolConfig.getString(ConfigKey.SAVE.getValue());
		String question = toolConfig.getString(ConfigKey.QUESTION.getValue());
		
		ConfigKey[] tipKeys = new ConfigKey[]{ConfigKey.TIPS, ConfigKey.TOOL};
		PropertiesUtilEntity tipUtilEntity = new PropertiesUtilEntity(ConfigProperties.INIT_CONFIG, ConfigKey.LANG_CONFIG, tipKeys);
		JSONObject tipToolConfig = CommonUtils.readProperties(tipUtilEntity);
		String saveAsTip = tipToolConfig.getString(ConfigKey.SAVE_AS.getValue());
		String openTip = tipToolConfig.getString(ConfigKey.OPEN.getValue());
		String saveTip = tipToolConfig.getString(ConfigKey.SAVE.getValue());
		String questionTip = tipToolConfig.getString(ConfigKey.QUESTION.getValue());
		
		openButton = ToolBarUtils.createButton(open, ToolActionType.OPEN, openTip);
		toolBar.add(openButton);
		toolBar.addSeparator(new Dimension(2,10));
		saveButton = ToolBarUtils.createButton(save, ToolActionType.SAVE, saveTip);
		toolBar.add(saveButton);
		toolBar.addSeparator(new Dimension(2,10));
		saveAsButton = ToolBarUtils.createButton(saveAs, ToolActionType.SAVE_AS, saveAsTip);
		toolBar.add(saveAsButton);
		toolBar.addSeparator(new Dimension(frameWidth - 115,10));
		helpButton = ToolBarUtils.createButton(question, ToolActionType.HELP, questionTip);
		toolBar.add(helpButton);
	}

	public JPanel getToolPanel() {
		return toolPanel;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public JButton getOpenButton() {
		return openButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getSaveAsButton() {
		return saveAsButton;
	}

	public JButton getHelpButton() {
		return helpButton;
	}
}
