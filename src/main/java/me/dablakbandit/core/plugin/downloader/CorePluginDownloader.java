/*
 * Copyright (c) 2019 Ashley Thew
 */

package me.dablakbandit.core.plugin.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.bukkit.Bukkit;

public class CorePluginDownloader{
	
	private static String	url			= "https://github.com/Dablakbandit/Core/raw/master/output/core-latest.jar";
	private static String	filename	= "plugins/core-latest.jar";
	
	public static boolean ensureCorePlugin(){
		if(Bukkit.getPluginManager().getPlugin("Core") == null){
			File file = new File(filename);
			if(!file.exists()){
				try{
					ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(url).openStream());
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					FileChannel fileChannel = fileOutputStream.getChannel();
					fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
					Bukkit.shutdown();
					return false;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
