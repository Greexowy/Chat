package Poland.Greexowy.Chat;
import Poland.Greexowy.Chat.Commands.ChatCommand;
import Poland.Greexowy.Chat.Events.ChatGuiClickEvent;
import Poland.Greexowy.Chat.Events.ChatSendMessageWhileBlocked;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("chat").setExecutor(new ChatCommand());
        getServer().getPluginManager().registerEvents(new ChatGuiClickEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatSendMessageWhileBlocked(), this);
    }
    @Override
    public void onDisable() {
    }
}
