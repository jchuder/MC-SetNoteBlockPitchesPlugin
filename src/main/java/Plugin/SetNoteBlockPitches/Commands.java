package Plugin.SetNoteBlockPitches;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	public Commands(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0 || args.length != 4) {
			if (command.getName().equalsIgnoreCase("setnoteblock")) {
				sender.sendMessage("§6**正確指令為:/setnoteblock 座標x y z 音調(0-24)");
				return true;
			} else if (command.getName().equalsIgnoreCase("setpitch")) {
				sender.sendMessage("§6**正確指令為:/setpitch 座標x y z 音調(0-24)");
				return true;
			}
		} else if (args.length == 4) {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int z = Integer.parseInt(args[2]);
			int pitch = Integer.parseInt(args[3]);
			if (pitch > 24 || pitch < 0) {
				sender.sendMessage("§6**音調範圍為0-24");
				return true;
			} else {
				if (command.getName().equalsIgnoreCase("setnoteblock")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setblock " + x + " " + y + " " + z + " noteblock");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "blockdata " + x + " " + y + " " + z + " {note:" + pitch + "}");
					return true;
				} else if (command.getName().equalsIgnoreCase("setpitch")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "blockdata " + x + " " + y + " " + z + " {note:" + pitch + "}");
					return true;
				}
			}
			return true;
		}
		return false;
	}

}
