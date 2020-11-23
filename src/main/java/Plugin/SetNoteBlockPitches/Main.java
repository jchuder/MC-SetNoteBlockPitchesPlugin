package Plugin.SetNoteBlockPitches;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public void onEnable() {
		setNoteBlock();
	}

	public void onDisable() {

	}

	public void setNoteBlock() {
		getCommand("setnoteblock").setExecutor((CommandExecutor) new Commands(this));
		getCommand("setpitch").setExecutor((CommandExecutor) new Commands(this));
	}

}
