package com.onarandombox.MultiVerseSignPortals;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;

import com.onarandombox.MultiVerseCore.MultiVerseCore;
import com.onarandombox.utils.UpdateChecker;

public class MultiVerseSignPortals extends JavaPlugin {

	public static final Logger log = Logger.getLogger("Minecraft");
	public static final String logPrefix = "[MultiVerse-SignPortals] ";
		
	protected MultiVerseCore core;
	protected MVSPPlayerListener playerListener;
	
	public UpdateChecker updateCheck;
	
	public void onEnable() {
		
	    core = (MultiVerseCore) getServer().getPluginManager().getPlugin("MultiVerse-Core"); 
		
		if (core == null) {
		    log.info(logPrefix + "MultiVerse-Core not found, will keep looking.");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		playerListener = new MVSPPlayerListener(this);
		
		getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
		
		log.info(logPrefix + "- Version " + this.getDescription().getVersion() + " Enabled");
		
		updateCheck = new UpdateChecker(this.getDescription().getName(),this.getDescription().getVersion());
	}
	
	public void onDisable() {
	    log.info(logPrefix + "- Disabled");
	}
	
}
