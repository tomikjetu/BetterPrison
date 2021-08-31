package TGamingStudio.Prison;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
public class PrisonPlaceholders extends PlaceholderExpansion {

    Prison Prison;

    public PrisonPlaceholders(Prison instance) {
        Prison = instance;
    }

    @Override
    public String getIdentifier() {
        return "prison";
    }

    @Override
    public String getAuthor() {
        return "TGamingStudio";
    }

    @Override
    public String getVersion() {
        return Prison.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        return switch (params) {
            case "xp" -> String.valueOf(Prison.getProfileManager().getProfile(player.getUniqueId()).getXp());
            case "current_area" -> Prison.getAreaManager().StandingArea(player.getLocation()) != null ?
                    Prison.getAreaManager().StandingArea(player.getLocation()).getName() : Prison.getMessages().CURRENT_AREA_NONE;
            case "current_area_unlocked" -> Prison.getAreaManager().StandingArea(player.getLocation()) != null ?
                    Prison.getMessages().getAreaLocked(Prison.getAreaManager().
                            isUnlocked(Prison.getAreaManager().StandingArea(player.getLocation()), player)) : "";
            default -> null;
        };
    }
}