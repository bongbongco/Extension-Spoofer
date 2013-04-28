package com.redpois0n;

import javax.swing.UIManager;

public class Main {
	
	public static final String REVERSE_CHAR = "\u202E";

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		Frame frame = new Frame();
		frame.setVisible(true);
	}
	
	public static final String getTitle() {
		return "Spoofer " + getVersion();
	}
	
	public static final String getVersion() {
		return "1.0";
	}
}
