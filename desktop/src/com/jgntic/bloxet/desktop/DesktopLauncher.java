package com.jgntic.bloxet.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jgntic.bloxet.Bloxet;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width=320;
        config.height=480;
		new LwjglApplication(new Bloxet(), config);
	}
}
