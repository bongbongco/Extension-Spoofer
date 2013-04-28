package com.redpois0n;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class Spoofer {
	
	public static void spoof(File in, String extension, boolean backup) {
		try {	
			if (backup) {
				FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(new File(in.getAbsolutePath().replace(in.getName().substring(in.getName().lastIndexOf("."), in.getName().length()), ".bak")));
				byte[] array = new byte[1024];
				
				while (fis.read(array) != -1) {
					fos.write(array);
				}
				
				fos.close();
				fis.close();
			}
			
			String path = in.getAbsolutePath();
			String name = in.getName();
			
			File ne = new File(path.substring(0, path.lastIndexOf(name)) + name.substring(0, name.lastIndexOf(".")) + Main.REVERSE_CHAR + reverse(extension) + name.substring(name.lastIndexOf(".")));
			in.renameTo(ne);
			JOptionPane.showMessageDialog(null, "File extension spoofed to " + extension + " successfully", Main.getTitle(), JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed spoof extension: " + ex.getClass().getSimpleName() + ": " + ex.getMessage(), Main.getTitle(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static String reverse(String str) {
		return new StringBuffer(str).reverse().toString();
	}
}
