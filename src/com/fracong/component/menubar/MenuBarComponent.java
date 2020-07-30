package com.fracong.component.menubar;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarComponent {
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu aboutMenu;
	private JMenuItem newMenuItem;
	private JMenuItem openMenuItem;
	private JMenuItem exitMenuItem;
	
	public MenuBarComponent() {
		this.createMenuBar();
	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("文件");
        editMenu = new JMenu("编辑");
        viewMenu = new JMenu("视图");
        aboutMenu = new JMenu("关于");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);
        newMenuItem = new JMenuItem("新建");
        openMenuItem = new JMenuItem("打开");
        exitMenuItem = new JMenuItem("退出");
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
