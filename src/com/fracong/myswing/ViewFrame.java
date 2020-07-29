package com.fracong.myswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.alibaba.fastjson.JSONObject;
import com.fracong.config.ConfigProperties;
import com.fracong.util.CommonUtils;
import com.fracong.util.EnumUtils.ConfigKey;
import com.fracong.util.EnumUtils.FileType;
import com.fracong.util.EnumUtils.PathType;
import com.fracong.util.EnumUtils.ToolActionType;

public class ViewFrame extends JFrame{
	private static final long serialVersionUID = 5429149711335650629L;

	public ViewFrame(String title) {
		super(title);
		this.checkInit();
		this.initFrame();
		this.addMenuBar();
		this.addToolBar();
		this.setVisible(true);
	}
	
	private void checkInit() {
		while (true) {
			if(ConfigProperties.INIT_CONFIG.size() != 0)  break;
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void initFrame(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		if(dimension.getWidth() < 1400 && dimension.getHeight() < 800) {
			this.setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight()-70);
		} else {
			this.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 1000, 750);
		}
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image myimage=this.getToolkit().getImage(CommonUtils.getPath(PathType.IMG, "image", FileType.PNG));
		this.setIconImage(myimage);
		this.setBackground(Color.RED);
	}
	
	public void addToolBar(){
		JPanel toolPanel=new JPanel();
		toolPanel.setLayout(new BorderLayout());
		
		JToolBar toolBar=new JToolBar();
		toolBar.setFloatable(false);
		toolPanel.add(toolBar, BorderLayout.PAGE_START);
		
		toolBar.addSeparator(new Dimension(0,10));
		
		JSONObject imgsPath = ConfigProperties.INIT_CONFIG.get(ConfigKey.IMG_PATH.getValue());
		JSONObject toolConfig = imgsPath.getJSONObject(ConfigKey.TOOL.getValue());
		String saveAs = toolConfig.getString(ConfigKey.SAVE_AS.getValue());
		String open = toolConfig.getString(ConfigKey.OPEN.getValue());
		String save = toolConfig.getString(ConfigKey.SAVE.getValue());
		String question = toolConfig.getString(ConfigKey.QUESTION.getValue());
		
		JSONObject tips = ConfigProperties.INIT_CONFIG.get(ConfigKey.TIPS.getValue());
		JSONObject tipLangConfig = tips.getJSONObject(ConfigProperties.INIT_LANG);
		JSONObject tipToolConfig = tipLangConfig.getJSONObject(ConfigKey.TOOL.getValue());
		String saveAsTip = tipToolConfig.getString(ConfigKey.SAVE_AS.getValue());
		String openTip = tipToolConfig.getString(ConfigKey.OPEN.getValue());
		String saveTip = tipToolConfig.getString(ConfigKey.SAVE.getValue());
		String questionTip = tipToolConfig.getString(ConfigKey.QUESTION.getValue());
		
		toolBar.add(SwingTools.createButton(open, ToolActionType.OPEN, saveTip));
		toolBar.addSeparator(new Dimension(2,10));
		toolBar.add(SwingTools.createButton(save, ToolActionType.SAVE, openTip));
		toolBar.addSeparator(new Dimension(2,10));
		toolBar.add(SwingTools.createButton(saveAs,ToolActionType.SAVE_AS, saveAsTip));
		int width = this.getWidth();
		toolBar.addSeparator(new Dimension(width - 115,10));
		toolBar.add(SwingTools.createButton(question, ToolActionType.HELP, questionTip));
		this.setContentPane(toolPanel);
	}

	public void addMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("文件");
        JMenu editMenu = new JMenu("编辑");
        JMenu viewMenu = new JMenu("视图");
        JMenu aboutMenu = new JMenu("关于");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);
        JMenuItem newMenuItem = new JMenuItem("新建");
        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem exitMenuItem = new JMenuItem("退出");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.setBackground(Color.GRAY);
        menuBar.setForeground(Color.WHITE);
        this.setJMenuBar(menuBar);
	}

}
