package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Preferences;

public class AutoPreferences {
	
	public static int getLane() {
		return Preferences.getInstance().getInt("AutoLane", 0);
	}

	public static boolean doGear() {
		return Preferences.getInstance().getBoolean("DoGear", false);
	}
	
	public static boolean doShot() {
		return Preferences.getInstance().getBoolean("DoShot", false);
	}
	
	public static boolean doCross() {
		return Preferences.getInstance().getBoolean("DoCross", false);
	}
	
	public static boolean isRedAlliance() {
		return Preferences.getInstance().getBoolean("IsRedAlliance", false);
	}
	
	public static boolean doDebug() {
		return Preferences.getInstance().getBoolean("DoDebug", false);
	}
}
