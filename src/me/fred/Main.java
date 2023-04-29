package me.fred;

import me.fred.utils.MinecraftServer;
import me.fred.utils.MinecraftVersion;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinecraftVersion[] versions = {
                new MinecraftVersion("1.19.4", "https://papermc.io/api/v2/projects/paper/versions/1.19.4/builds/521/downloads/paper-1.19.4-521.jar"),
                new MinecraftVersion("1.18.1", "https://papermc.io/api/v2/projects/paper/versions/1.18.1/builds/216/downloads/paper-1.18.1-216.jar"),
                new MinecraftVersion("1.17.1", "https://papermc.io/api/v2/projects/paper/versions/1.17.1/builds/326/downloads/paper-1.17.1-326.jar"),
                new MinecraftVersion("1.16.5", "https://papermc.io/api/v2/projects/paper/versions/1.16.5/builds/738/downloads/paper-1.16.5-738.jar"),
                new MinecraftVersion("1.15.2", "https://papermc.io/api/v2/projects/paper/versions/1.15.2/builds/393/downloads/paper-1.15.2-393.jar"),
                new MinecraftVersion("1.14.4", "https://papermc.io/api/v2/projects/paper/versions/1.14.4/builds/244/downloads/paper-1.14.4-244.jar"),
                new MinecraftVersion("1.13.2", "https://papermc.io/api/v2/projects/paper/versions/1.13.2/builds/657/downloads/paper-1.13.2-657.jar"),
                new MinecraftVersion("1.12.2", "https://papermc.io/api/v2/projects/paper/versions/1.12.2/builds/1618/downloads/paper-1.12.2-1618.jar"),
                new MinecraftVersion("1.11.2", "https://papermc.io/api/v2/projects/paper/versions/1.11.2/builds/1106/downloads/paper-1.11.2-1106.jar"),
                new MinecraftVersion("1.10.2", "https://papermc.io/api/v2/projects/paper/versions/1.10.2/builds/916/downloads/paper-1.10.2-916.jar"),
                new MinecraftVersion("1.9.4", "https://papermc.io/api/v2/projects/paper/versions/1.9.4/builds/775/downloads/paper-1.9.4-775.jar"),
                new MinecraftVersion("1.8.8", "https://papermc.io/api/v2/projects/paper/versions/1.8.8/builds/445/downloads/paper-1.8.8-445.jar")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte wählen Sie eine Minecraft-Version aus:");
        for (int i = 0; i < versions.length; i++) {
            System.out.println(i + ": " + versions[i].getVersionName());
        }
        int selectedIndex = scanner.nextInt();
        MinecraftVersion selectedVersion = versions[selectedIndex];
        System.out.println("Die ausgewählte Version ist: " + selectedVersion.getVersionName());

        File serverDirectory = new File("Minecraft-Server");
        if (!serverDirectory.exists()) {
            serverDirectory.mkdir();
        }

        MinecraftServer server = new MinecraftServer(selectedVersion, serverDirectory);
        server.startServer();
    }
}
