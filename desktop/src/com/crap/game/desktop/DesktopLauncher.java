package com.crap.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crap.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "C.R.A.P.";
        config.width=500;
        config.height=500;
		config.resizable = false;
		new LwjglApplication(new Main(), config);
	}
}
