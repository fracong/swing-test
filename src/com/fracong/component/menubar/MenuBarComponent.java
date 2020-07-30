package com.fracong.component.menubar;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.alibaba.fastjson.JSONObject;
import com.fracong.config.ConfigProperties;
import com.fracong.entity.PropertiesUtilEntity;
import com.fracong.util.common.CommonUtils;
import com.fracong.util.config.ConfigEnumUtils.ConfigKey;

public class MenuBarComponent {
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu aboutMenu;
	private JMenuItem newMenuItem;
	private JMenuItem openMenuItem;
	private JMenuItem exitMenuItem;
	
	public MenuBarComponent() throws Exception {
		this.createMenuBar();
	}

	public void createMenuBar() throws Exception {
		ConfigKey[] langKeys = new ConfigKey[]{ConfigKey.TITLE,ConfigKey.MENU};
		PropertiesUtilEntity menuUtilEntity = new PropertiesUtilEntity(ConfigProperties.INIT_CONFIG, ConfigKey.LANG_CONFIG, langKeys);
		JSONObject menuConfig = CommonUtils.readProperties(menuUtilEntity);
		menuBar = new JMenuBar();
		fileMenu = new JMenu(menuConfig.getString(ConfigKey.MENU_FILE.getValue()));
        editMenu = new JMenu(menuConfig.getString(ConfigKey.MENU_EDIT.getValue()));
        viewMenu = new JMenu(menuConfig.getString(ConfigKey.MENU_VIEW.getValue()));
        aboutMenu = new JMenu(menuConfig.getString(ConfigKey.MENU_ABOUT.getValue()));
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);
        newMenuItem = new JMenuItem(menuConfig.getString(ConfigKey.MENU_FILE_CREATE.getValue()));
        openMenuItem = new JMenuItem(menuConfig.getString(ConfigKey.MENU_FILE_OPEN.getValue()));
        exitMenuItem = new JMenuItem(menuConfig.getString(ConfigKey.MENU_FILE_EXIT.getValue()));
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.setBackground(Color.GRAY);
        menuBar.setForeground(Color.WHITE);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public JMenu getEditMenu() {
		return editMenu;
	}

	public JMenu getViewMenu() {
		return viewMenu;
	}

	public JMenu getAboutMenu() {
		return aboutMenu;
	}

	public JMenuItem getNewMenuItem() {
		return newMenuItem;
	}

	public JMenuItem getOpenMenuItem() {
		return openMenuItem;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}
}
