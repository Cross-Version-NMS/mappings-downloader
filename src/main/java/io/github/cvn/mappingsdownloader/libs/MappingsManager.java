package io.github.cvn.mappingsdownloader.libs;

import io.github.cvn.mappingsdownloader.MappingsDownloader;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappingsManager {
    public MappingsDownloader plugin;
    private final String minecraftVersion;
    public FileConfiguration config;

    public MappingsManager(MappingsDownloader plugin, FileConfiguration config, String minecraftVersion) {
        this.plugin = plugin;
        this.config = config;
        this.minecraftVersion = minecraftVersion;
    }

    public void downloadCorrectMapping() throws IOException {
        plugin.getLogger().info("Downloading mappings for " + minecraftVersion + "...");

        String fileName = minecraftVersion + ".tiny";
        URL downloadUrl = new URL("https://raw.githubusercontent.com/Cross-Version-NMS/CVN-mappings/main/mappings/" + fileName);

        String folderPath = plugin.getDataFolder().getAbsolutePath() + "/mappings";

        Files.createDirectories(Paths.get(folderPath));

        Downloader.download(downloadUrl, folderPath + "/" + fileName);

        plugin.getLogger().info("Finished downloading mappings for " + minecraftVersion + " !");
    }
}
