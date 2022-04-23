package com.company;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.Scanner;

public class GlobalListenerEx implements NativeKeyListener {
    Scanner in = new Scanner(System.in);
    String input;
    public void nativeKeyPressed(NativeKeyEvent e) {
        String key = NativeKeyEvent.getKeyText(e.getKeyCode());
        switch (key){
            case ("H"): {
                System.out.println("Hello World!");
                break;
            }
            case("Q"): {
                System.out.println("True or False?");
                input = in.nextLine();
                if(input.equalsIgnoreCase("true")|input.equals("1")){
                    System.out.println("True!");
                }
                else{
                    System.out.println("False!");
                }
                break;
            }
            case("+"):{
                System.out.println("Введите число");
                try {
                    int j = in.nextInt();
                    for (int i = 1; i <= j; i++) {
                        System.out.println(i);
                    }
                } catch (Exception ex) {
                    System.out.println("Норм с головой?");
                }
            }
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }
}
