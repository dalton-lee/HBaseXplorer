package org.buddy.javatools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolConfig {

	public static String noDisplayQualifier = "";
	public static String onlyDisplayQualifier = "";
	public static Boolean loadAllRow = Boolean.valueOf(false);
	public static Long maxLoadRow = Long.valueOf(1000L);
	public static Long maxPrintableDetectCnt = Long.valueOf(1000L);

	public ToolConfig() {
		try {
			init();
		} catch (IOException ex) {
			Logger.getLogger(ToolConfig.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void init() throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("./conf/config.ini"));

		noDisplayQualifier = p.getProperty("noDisplayQualifier", "");
		onlyDisplayQualifier = p.getProperty("onlyDisplayQualifier", "");

		loadAllRow = Boolean.valueOf(p.getProperty("loadAllRow", "false"));
		maxLoadRow = Long.valueOf(p.getProperty("maxLoadRow", "1000"));
		maxPrintableDetectCnt = Long.valueOf(p.getProperty("maxPrintableDetectCnt", "1000"));
	}
}