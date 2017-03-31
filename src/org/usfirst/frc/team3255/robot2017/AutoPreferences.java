package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Joystick;

public class AutoPreferences {
	
	private static Joystick preferencesStick = new Joystick(RobotMap.JOYSTICK_PREFERENCES);
	
	public static int getLane() {
		int lane = 0;
		
		if(preferencesStick.getRawButton(1)) {
			lane = 1;
		}
		else if(preferencesStick.getRawButton(2)) {
			lane = 2;
		}
		else if(preferencesStick.getRawButton(3)) {
			lane = 3;
		}
		
		return lane;
	}

	public static boolean doGear() {
		return preferencesStick.getRawButton(6);
	}
	
	public static boolean doShot() {
		return preferencesStick.getRawButton(7);
	}
	
	public static boolean doCross() {
		return preferencesStick.getRawButton(8);
	}
	
	public static boolean isRedAlliance() {
		return preferencesStick.getRawButton(4);
	}
	
	public static boolean isDebug() {
		return preferencesStick.getRawButton(5);
	}
	
	public static boolean isReset() {
		return preferencesStick.getRawButton(10);
	}

	public static boolean doTwoGear() {
		return preferencesStick.getRawButton(9);
	}
}
