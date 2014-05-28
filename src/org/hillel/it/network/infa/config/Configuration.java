package org.hillel.it.network.infa.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;

public class Configuration {
	private List<String> configParams =null;
	
	public Configuration () {
		InputStream stream =Configuration.class.getClassLoader().getResourceAsStream("application.properties");
		
		try {
			configParams = IOUtils.readLines(stream, Charset.defaultCharset());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "I/O Error", JOptionPane.ERROR_MESSAGE);

		} finally {
			IOUtils.closeQuietly(stream);
		}
	}
	
	public String getPath () {
		for (int i=0; i<configParams.size(); i++) {
			if (configParams.get(i).contains("file.path=")) {
				return configParams.get(i).split("file.path=")[1];
			}
		}
		return null;
	}
	
	public String getDbUrl () {
		for (int i=0; i<configParams.size(); i++) {
			if (configParams.get(i).contains("DB.url=")) {
				return configParams.get(i).split("DB.url=")[1];
			}
		}
		return null;
	}
	public int getMaxConnections () {
		for (int i=0; i<configParams.size(); i++) {
			if (configParams.get(i).contains("max.connections=")) {
				return 10;//(configParams.get(i).split("max.connections=")[1]);
			}
		}
		return 0;
	}

}
