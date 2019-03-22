/*
 * Copyright (c) 2019 Ashley Thew
 */

package me.dablakbandit.core.plugin;

import org.bukkit.plugin.Plugin;

import me.dablakbandit.core.commands.AbstractCommand;
import me.dablakbandit.core.players.CorePlayerManager;
import me.dablakbandit.core.players.listener.CorePlayersListener;
import me.dablakbandit.core.updater.PluginUpdater;

public class CoreHandler{
	
	public void checkUpdate(Plugin plugin, String id){
		PluginUpdater.getInstance().checkUpdate(plugin, id);
	}
	
	public void removeCommands(Plugin plugin){
		AbstractCommand.removePluginCommands(plugin);
	}
	
	public void addCorePlayerListener(CorePlayersListener listener){
		CorePlayerManager.getInstance().addListener(listener);
	}
	
	public void removeCorePlayerListener(CorePlayersListener listener){
		CorePlayerManager.getInstance().removeListener(listener);
	}
}
