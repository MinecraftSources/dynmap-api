package org.dynmap;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * Custom bukkit event, corresponding to the receiving of a web-chat message from a web UI user
 */
public class DynmapWebChatEvent extends Event implements Cancellable {
    public static final String CUSTOM_TYPE = "org.dynmap.DynmapWebChatEvent";
    private String source;
    private String name;
    private String message;
    private boolean cancelled;
    private boolean isprocessed;
    
    public DynmapWebChatEvent(String source, String name, String message) {
        super(CUSTOM_TYPE);
        this.source = source;
        this.name = name;
        this.message = message;
        this.cancelled = false;
        this.isprocessed = false;
    }
    public boolean isCancelled() { return cancelled; }
    
    public void setCancelled(boolean cancel) { cancelled = cancel; }

    public String getSource() { return source; }
    
    public String getName() { return name; }
    
    public String getMessage() { return message; }
    
    /* Processed flag is used to mark message as handled by listener - if set, dynmap will not send it using broadcastMessage() */
    public boolean isProcessed() { return isprocessed; }
    
    public void setProcessed() { isprocessed = true; }
}
