package me.fred.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class MinecraftServer {
    private MinecraftVersion version;
    private File serverDirectory;

    public MinecraftServer(MinecraftVersion version, File serverDirectory) {
        this.version = version;
        this.serverDirectory = serverDirectory;
    }

    public void startServer() {
        downloadJarFile();
        acceptEula();
        startServerProcess();
    }

    private void downloadJarFile() {
        try {
            URL downloadUrl = new URL(version.getDownloadUrl());
            URLConnection connection = downloadUrl.openConnection();
            InputStream inputStream = connection.getInputStream();

            File jarFile = new File(serverDirectory, version.getJarFileName());
            FileOutputStream outputStream = new FileOutputStream(jarFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptEula() {
        try {
            File eulaFile = new File(serverDirectory, "eula.txt");
            FileWriter writer = new FileWriter(eulaFile);
            writer.write("eula=true");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServerProcess() {
        try {
            File jarFile = new File(serverDirectory, version.getJarFileName());
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarFile.getAbsolutePath());
            processBuilder.directory(serverDirectory);
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}