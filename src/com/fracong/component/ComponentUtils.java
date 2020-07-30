package com.fracong.component;

import javax.swing.JFrame;

import com.fracong.component.menubar.MenuBarComponent;
import com.fracong.component.toolbar.ToolBarComponent;
import com.fracong.config.ConfigProperties;

public class ComponentUtils {
	
	public static void resetFrame(JFrame frame) throws Exception {
		ComponentUtils.resetToolBar(frame);
		ComponentUtils.resetMenuBar(frame);
	}
	
	public static void resetToolBar(JFrame frame) throws Exception{
		ComponentUtils.addToolBar(frame.getWidth());
		frame.setContentPane(ConfigProperties.toolBarComponent.getToolPanel());
	}
	
	public static void resetMenuBar(JFrame frame) throws Exception{
		ComponentUtils.addMenuBar();
		frame.setJMenuBar(ConfigProperties.menuBarComponent.getMenuBar());
	}
	
	public static void addToolBar(int frameWidth) throws Exception {
		ToolBarComponent toolBar = new ToolBarComponent(frameWidth);
		ConfigProperties.toolBarComponent = toolBar;
	}

	public static void addMenuBar() throws Exception {
		MenuBarComponent menuBar = new MenuBarComponent();
        ConfigProperties.menuBarComponent = menuBar;
	}
}
