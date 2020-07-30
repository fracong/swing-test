package com.fracong.myswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.fracong.config.ConfigProperties;
import com.fracong.util.CommonUtils;
import com.fracong.util.ComponentUtils;
import com.fracong.util.EnumUtils.FileType;
import com.fracong.util.EnumUtils.PathType;

public class ViewFrame extends JFrame{
	private static final long serialVersionUID = 5429149711335650629L;

	public ViewFrame(String title) throws Exception {
		super(title);
		this.checkInit();
		this.initFrame();
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

	private void initFrame() throws Exception {
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
		
		ComponentUtils.resetFrame(this);
	}
}
