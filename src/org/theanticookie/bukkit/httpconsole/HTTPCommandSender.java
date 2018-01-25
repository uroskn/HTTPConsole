package org.theanticookie.bukkit.httpconsole;

import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
//import org.bukkit.craftbukkit.v1_7_R1.command.CraftConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class HTTPCommandSender extends Handler implements ConsoleCommandSender {
	
	public StringBuilder sb = new StringBuilder();
	
	public void sendMessage(String message){
		//super.sendMessage(message);
		this.sendRawMessage(message);
	}
	
	public void sendMessage(String[] arg0){
		//super.sendMessage(arg0);
		for (String line : arg0) this.sendMessage(line);
	}

	public String getOutput() {
		return sb.toString();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Server getServer() {
		// TODO Auto-generated method stub
		return this.getServer();
	}

	public PermissionAttachment addAttachment(Plugin arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1,
			boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1,
			boolean arg2, int arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasPermission(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasPermission(Permission arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isPermissionSet(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isPermissionSet(Permission arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public void recalculatePermissions() {
		// TODO Auto-generated method stub
		
	}

	public void removeAttachment(PermissionAttachment arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean isOp() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setOp(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	public void abandonConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		
	}

	public void abandonConversation(Conversation arg0,
			ConversationAbandonedEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	public void acceptConversationInput(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean beginConversation(Conversation arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isConversing() {
		// TODO Auto-generated method stub
		return false;
	}

	public void sendRawMessage(String arg0) {
		// TODO Auto-generated method stub
		sb.append(ChatColor.stripColor(arg0) + "\r\n");
	}

	public void close() throws SecurityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publish(LogRecord arg0) {
		this.sendRawMessage(arg0.getMessage());
	}

	public Spigot spigot() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
