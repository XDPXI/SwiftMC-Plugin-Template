package com.yourname.yourplugin;

import dev.xdpxi.swiftmc.plugin.Plugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;

public class YourPlugin extends Plugin {

    @Override
    public void onLoad() {
        // Called when the plugin is loaded (before enabling)
        logInfo("Plugin is being loaded...");

        // Save default config if it doesn't exist
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Called when the plugin is enabled
        logInfo("Plugin has been enabled!");

        // Register a command
        registerCommand(new HelloCommand());

        logInfo("Commands and events registered successfully!");
    }

    @Override
    public void onDisable() {
        // Called when the plugin is disabled
        logInfo("Plugin has been disabled. Goodbye!");
    }

    // Custom command
    private class HelloCommand extends Command {
        public HelloCommand() {
            super("hello");

            setDefaultExecutor((sender, context) -> {
                if (sender instanceof Player player) {
                    player.sendMessage(Component.text("Hello from ExamplePlugin!", NamedTextColor.GREEN));
                    player.sendMessage(Component.text("Author: " + getAuthor(), NamedTextColor.GRAY));
                } else {
                    sender.sendMessage(Component.text("Only players can use this command!"));
                }
            });
        }
    }
}