package me.fred.utils;

public class MinecraftVersion {
    private String versionName;
    private String jarFileName;
    private String downloadUrl;

    public MinecraftVersion(String versionName, String downloadUrl) {
        this.versionName = versionName;
        this.jarFileName = "paper-" + versionName + ".jar";
        this.downloadUrl = downloadUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getJarFileName() {
        return jarFileName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}