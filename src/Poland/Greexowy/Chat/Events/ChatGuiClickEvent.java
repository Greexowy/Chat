package Poland.Greexowy.Chat.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static Poland.Greexowy.Chat.Events.ChatSendMessageWhileBlocked.chat;

public class ChatGuiClickEvent implements Listener {

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getInventory().getTitle().equals(ChatColor.RED + "Chat " + ChatColor.GRAY + "- " + ChatColor.YELLOW + "Opcje")) {
            if(e.getCurrentItem().getItemMeta() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
                        e.setCancelled(true);
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Wyczysc")) {
                        e.setCancelled(true);
                        player.closeInventory();
                        for(int i = 0; i < 100; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        Bukkit.broadcastMessage(" ");
                        Bukkit.broadcastMessage(ChatColor.GRAY + "Chat zostal wyczyszczony!");
                        Bukkit.broadcastMessage(" ");
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Odblokuj")) {
                        e.setCancelled(true);
                        player.closeInventory();
                        if(!chat) {
                            chat = true;
                            player.sendMessage(ChatColor.GRAY + "Chat zostal " + ChatColor.DARK_GREEN + ChatColor.ITALIC + "odblokowany" + ChatColor.RESET + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.GRAY + "Przeciez chat jest juz " + ChatColor.DARK_GREEN + ChatColor.ITALIC + "odblokowany" + ChatColor.RESET + ChatColor.GRAY + "!");
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Zablokuj")) {
                        e.setCancelled(true);
                        player.closeInventory();
                        if(chat) {
                            chat = false;
                            player.sendMessage(ChatColor.GRAY + "Chat zostal " + ChatColor.RED + ChatColor.ITALIC + "zablokowany" + ChatColor.RESET + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.GRAY + "Przeciez chat jest juz " + ChatColor.RED + ChatColor.ITALIC + "zablokowany" + ChatColor.RESET + ChatColor.GRAY + "!");
                        }
                    }
                }
            }
        }
    }
}
