package Poland.Greexowy.Chat.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatSendMessageWhileBlocked implements Listener {
    public static boolean chat = true;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = (Player) e.getPlayer();
        if(!(player.hasPermission("Chat.bypass"))) {
            if(!chat) {
                player.sendMessage(ChatColor.GRAY + "Chat jest obecnie " + ChatColor.ITALIC + ChatColor.RED + "zablokowany" + ChatColor.RESET + ChatColor.GRAY + "!");
                e.setCancelled(true);
            }
        }
    }
}
